package ru.netology.daolayer.repositories;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class DaoRepository {

    private final NamedParameterJdbcTemplate template;
    private final String script = read("script.sql");

    public DaoRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<String> getProductName(String name) {
        List<String> result = template.queryForList(script, Map.of("name", name), String.class);
        return result;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
