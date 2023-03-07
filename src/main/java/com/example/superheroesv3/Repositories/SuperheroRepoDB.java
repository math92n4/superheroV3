package com.example.superheroesv3.Repositories;

import com.example.superheroesv3.Model.Superhero;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperheroRepoDB {

    @Value("${spring.datasource.url}")
    private String db_url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    private Connection connectionSQL() throws SQLException {
        return DriverManager.getConnection(db_url,username,password);
    }

    public List<Superhero> getSuperheroes() {
        List<Superhero> superheroes = new ArrayList<>();
        try (Connection con = connectionSQL()) {
            String SQL = "SELECT * FROM superheroes;";
            Statement statement = con.createStatement();
            ResultSet resultset = statement.executeQuery(SQL);
            while (resultset.next()) {
                int id = resultset.getInt("id");
                String superheroName = resultset.getString("superheroName");
                String realName = resultset.getString("realName");
                String dateCreated = resultset.getString("dateCreated");
                String isHuman = resultset.getString("isHuman");
                double strength = resultset.getDouble("strength");
                superheroes.add(new Superhero(id,superheroName,realName,dateCreated,isHuman,strength));
            }
            return superheroes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
