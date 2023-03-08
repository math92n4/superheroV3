package com.example.superheroesv3.Repositories;

import com.example.superheroesv3.Model.Superhero;
import com.example.superheroesv3.dto.SuperheroCityDTO;
import com.example.superheroesv3.dto.SuperheroDTO;
import com.example.superheroesv3.dto.SuperheroStrengthsDTO;
import com.example.superheroesv3.dto.SuperheroSuperpowerCountDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperheroRepoDB implements IRepository {

    @Value("${spring.datasource.url}")
    private String db_url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    private Connection connectionSQL() throws SQLException {
        return DriverManager.getConnection(db_url, username, password);
    }

    @Override
    public List<SuperheroDTO> getSuperheroes() {
        List<SuperheroDTO> superheroes = new ArrayList<>();
        try (Connection con = connectionSQL()) {
            String SQL = "SELECT * FROM superheroes;";
            Statement statement = con.createStatement();
            ResultSet resultset = statement.executeQuery(SQL);
            while (resultset.next()) {
                int id = resultset.getInt("superheroid");
                String superheroName = resultset.getString("superheroName");
                String realName = resultset.getString("realName");
                String dateCreated = resultset.getString("dateCreated");
                superheroes.add(new SuperheroDTO(id, superheroName, realName, dateCreated));
            }
            return superheroes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        @Override
        public SuperheroDTO getSuperheroByName(String superheroName){
            SuperheroDTO superheroByName = null;
            try (Connection con = connectionSQL()) {
                String SQL = "SELECT * FROM superheroes WHERE superheroName = ?;";
                PreparedStatement preparedStatement = con.prepareStatement(SQL);
                preparedStatement.setString(1,superheroName);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    int id = resultSet.getInt("superheroid");
                    String superheroNameColumn = resultSet.getString("superheroName");
                    String realName = resultSet.getString("realName");
                    String dateCreated = resultSet.getString("dateCreated");
                    superheroByName = new SuperheroDTO(id, superheroNameColumn, realName, dateCreated);
                }
                return superheroByName;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public List<SuperheroSuperpowerCountDTO> getSuperheroesPowerCount () {

            List<SuperheroSuperpowerCountDTO> superheroes = new ArrayList<>();
            try (Connection con = connectionSQL()) {
                String SQL = "SELECT superheroes.superheroid, superheroName, realName, COUNT(superhero_superpower.superpowerid) AS count\n" +
                        "FROM superheroes\n" +
                        "LEFT JOIN superhero_superpower ON superheroes.superheroid = superhero_superpower.superheroid\n" +
                        "GROUP BY superheroes.superheroid;";
                Statement statement = con.createStatement();
                ResultSet resultset = statement.executeQuery(SQL);
                while (resultset.next()) {
                    int id = resultset.getInt("superheroid");
                    String superheroName = resultset.getString("superheroName");
                    String realName = resultset.getString("realName");
                    int superpowerCount = resultset.getInt("count");
                    superheroes.add(new SuperheroSuperpowerCountDTO(id,superheroName,realName,superpowerCount));
                }
                return superheroes;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public SuperheroSuperpowerCountDTO getSuperheroByNameAndPowerCount(String superheroName) {
            SuperheroSuperpowerCountDTO superheroByName = null;
            try (Connection con = connectionSQL()){
                String SQL = "SELECT superheroes.superheroid, superheroName, realName, COUNT(superhero_superpower.superpowerid) AS count\n" +
                        "FROM superheroes\n" +
                        "LEFT JOIN superhero_superpower ON superheroes.superheroid = superhero_superpower.superheroid\n" +
                        "WHERE superheroName = ? \n" +
                        "GROUP BY superheroes.superheroid;";
                PreparedStatement preparedStatement = con.prepareStatement(SQL);
                preparedStatement.setString(1,superheroName);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int id = resultSet.getInt("superheroid");
                    String superheroNameColumn = resultSet.getString("superheroName");
                    String realName = resultSet.getString("realName");
                    int superpowerCount = resultSet.getInt("count");
                    superheroByName = new SuperheroSuperpowerCountDTO(id, superheroNameColumn,realName,superpowerCount);
                }
                return superheroByName;
            } catch (SQLException e) {
                throw new RuntimeException();
            }

        }

        @Override
        public List<SuperheroStrengthsDTO> getSuperheroWithStrengths () {
            return null;
        }

        @Override
        public List<SuperheroStrengthsDTO> getSuperheroByNameAndWithStrengths (String superheroName){
            return null;
        }

        @Override
        public List<SuperheroCityDTO> getSuperheroAndCity () {
            return null;
        }







    /*public List<Superhero> getSuperheroes() {
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
    }*/

    }

