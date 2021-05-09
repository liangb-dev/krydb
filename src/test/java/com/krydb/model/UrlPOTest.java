package com.krydb.model;

import com.krydb.converter.UrlConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UrlPOTest {

    @Test
    void givenUrlPO_generatesCorrectString() {
        final int IDENT = 99;
        final String ADDRESS_GOOGLE = "www.google.se";
        final String DATETIME_NOW = LocalDateTime.now().toString();
        final String STATUS_GOOD = "GOOD";

        UrlPO url = new UrlPO(IDENT, ADDRESS_GOOGLE, DATETIME_NOW, STATUS_GOOD, DATETIME_NOW);
        String result = url.getString();
        String urlToString = String.format("%d,%s,%s,%s,%s", IDENT, ADDRESS_GOOGLE, DATETIME_NOW, STATUS_GOOD, DATETIME_NOW);

        assertEquals(urlToString, result);
    }
}
