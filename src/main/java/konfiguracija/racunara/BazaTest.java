package konfiguracija.racunara;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BazaTest {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BazaTest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void testConnection() {
        try {
            String result = jdbcTemplate.queryForObject("SELECT 1", String.class);
            System.out.println("Database Connection Test Successful: " + result);
        } catch (Exception e) {
            System.err.println("Database Connection Test Failed: " + e.getMessage());
        }
    }
}
