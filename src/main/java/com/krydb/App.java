package com.krydb;

import com.krydb.converter.UrlConverter;
import com.krydb.model.UrlPO;
import com.krydb.persistance.UrlPersister;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

import java.util.List;

import static com.krydb.poller.Poller.pollAndUpdateUrls;

public class App extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        pollAndUpdateUrls();

        List<UrlPO> urlList = UrlPersister.fetchAllUrls();
        var urlString = UrlConverter.convertListUrlPOToString(urlList);

        var router = Router.router(vertx);
        var messageRoute = router.get("/poller");
        messageRoute.handler(rc -> {
            rc.response().end(urlString);
        });

        router.get().handler(StaticHandler.create());

        vertx.createHttpServer()
                .requestHandler(router::accept)
                .listen(8091);
    }

    public static void main(String[] args) {
        var vertx = Vertx.vertx();
        vertx.deployVerticle(new App());
    }

}
