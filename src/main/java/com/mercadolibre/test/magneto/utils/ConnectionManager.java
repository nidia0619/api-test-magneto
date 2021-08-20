package com.mercadolibre.test.magneto.utils;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;

public class ConnectionManager {

    public static void closeJdbc(NamedParameterJdbcTemplate jdbcTemplate) {
        try {
            DataSourceUtils.getConnection(jdbcTemplate.getJdbcTemplate().getDataSource()).close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
