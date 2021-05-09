package com.krydb.converter;

import com.krydb.model.UrlPO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UrlConverterTest {
    @Mock
    private ResultSet resultSet;

    private final int IDENT = 99;
    private final String ADDRESS_GOOGLE = "www.google.se";
    private final String DATETIME_NOW = LocalDateTime.now().toString();
    private final String STATUS_GOOD = "GOOD";

    @Test
    void givenResultSetConvertsToUrlPOs() throws Exception {

        when(resultSet.getInt(1)).thenReturn(IDENT);
        when(resultSet.getString(2)).thenReturn(ADDRESS_GOOGLE);
        when(resultSet.getString(3)).thenReturn(DATETIME_NOW);
        when(resultSet.getString(4)).thenReturn(STATUS_GOOD);
        when(resultSet.getString(5)).thenReturn(DATETIME_NOW);
        when(resultSet.next()).thenReturn(true, false);

        List<UrlPO> urls = UrlConverter.convertToUrls(resultSet);
        UrlPO url = urls.get(0);
        assertEquals(IDENT, url.getIdent());
        assertEquals(ADDRESS_GOOGLE, url.getAddress());
        assertEquals(DATETIME_NOW, url.getCreated());
        assertEquals(STATUS_GOOD, url.getStatus());
        assertEquals(DATETIME_NOW, url.getCreated());
    }

    @Test
    void givenListOfUrlPOs_convertsThemToString() {
        UrlPO url = new UrlPO(IDENT, ADDRESS_GOOGLE, DATETIME_NOW, STATUS_GOOD, DATETIME_NOW);
        List<UrlPO> list = new ArrayList<>();
        list.add(url);
        list.add(url);

        String result = UrlConverter.convertListUrlPOToString(list);
        String urlToString = String.format("%d,%s,%s,%s,%s", IDENT, ADDRESS_GOOGLE, DATETIME_NOW, STATUS_GOOD, DATETIME_NOW);

        assertEquals(urlToString + ";" + urlToString, result);

    }


}
