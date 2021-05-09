package com.krydb.persistance;

import com.krydb.converter.UrlConverter;
import com.krydb.model.UrlPO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.List;

public class UrlPersister {
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/krydb?characterEncoding=utf8";
    public static final String JDBC_USERNAME = "root";
    public static final String JDBC_PASSWORD = "Wisenska9405!!";
    public static final String FETCH_ALL_URL = "select * from url";
    public static final String UPDATE_URL_STATUS_AND_UPDATED_BY_IDENT = "UPDATE `krydb`.`url` SET `status` = '%s', `updated` = '%s'  WHERE (`ident_url` = '%d');\n";

    private UrlPersister() {
        // Utility class not called
    }

    public static List<UrlPO> fetchAllUrls() throws Exception {
        Class.forName(JDBC_DRIVER);
        var con = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        var stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(FETCH_ALL_URL);
        List<UrlPO> urls = UrlConverter.convertToUrls(rs);
        con.close();

        return urls;
    }

    public static void updateURLStatusByIdent(long ident, String status) throws Exception {
        Class.forName(JDBC_DRIVER);
        var con = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        var stmt = con.createStatement();
        var query = String.format(UPDATE_URL_STATUS_AND_UPDATED_BY_IDENT, status, LocalDateTime.now(), ident);
        stmt.executeUpdate(query);
        con.close();
    }
}
