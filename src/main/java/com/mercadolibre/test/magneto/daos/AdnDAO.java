package com.mercadolibre.test.magneto.daos;

import com.mercadolibre.test.magneto.models.Stats;
import com.mercadolibre.test.magneto.settings.Database;
import com.mercadolibre.test.magneto.utils.ConnectionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Repository;

@Repository("AdnDAO")
public class AdnDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private Database database;

    /**
     * Metodo que consulta la informacion de las estadisticas en la DB
     *
     * @return Un objeto Stats con los datos de la estadistica
     * @throws Exception
     */
    public Stats get() throws Exception {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(database.getConsult());
            return this.jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Stats.class)).get(0);
        } finally {
            ConnectionManager.closeJdbc(jdbcTemplate);
        }
    }

    /**
     * Metodo que inserta la informacion de una secuencia de ADN en la DB
     *
     * @param dna - Cadena de ADN
     * @param isMutan - Indica si es mutante (true) o humano (false)
     * @throws Exception
     */
    public void insert(String dna, boolean isMutan) throws Exception {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(database.getInsert());
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("dna", dna);
            params.addValue("isMutan", isMutan);
            jdbcTemplate.update(sql.toString(), params);
        } finally {
            ConnectionManager.closeJdbc(jdbcTemplate);
        }
    }

}
