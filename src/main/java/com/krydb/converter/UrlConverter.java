package com.krydb.converter;

import com.krydb.model.UrlPO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UrlConverter {

    private UrlConverter() {
        //Utility class not called
    }

    public static List<UrlPO> convertToUrls(ResultSet rs) throws Exception {
        List<UrlPO> urls = new ArrayList<>();
        while (rs.next()) {
            var ident = rs.getInt(1);
            var address = rs.getString(2);
            var created = rs.getString(3);
            var status = rs.getString(4);
            var updated = rs.getString(5);

            var newUrl = new UrlPO(ident, address, created, status, updated);
            urls.add(newUrl);
        }

        return urls;
    }

    public static String convertListUrlPOToString(List<UrlPO> urls) {
        var str = new StringBuilder();
        for (UrlPO url : urls) {
            str.append(url.getString()).append(";");
        }
        return str.substring(0, str.length() - 1);
    }
}
