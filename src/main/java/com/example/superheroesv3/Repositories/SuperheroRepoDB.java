package com.example.superheroesv3.Repositories;

import com.example.superheroesv3.Model.Superpower;
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
                superheroes.add(new SuperheroDTO(resultset.getInt("superheroid"),
                        resultset.getString("superheroName"),
                        resultset.getString("realName"),
                        resultset.getString("dateCreated")));
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
                    superheroByName = new SuperheroDTO(resultSet.getInt(("superheroid")),
                            resultSet.getString("superheroName"),
                            resultSet.getString("realName"),
                            resultSet.getString("dateCreated"));
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
                    superheroes.add(new SuperheroSuperpowerCountDTO(resultset.getInt("superheroid"),
                            resultset.getString("superheroName"),
                            resultset.getString("realName"),
                            resultset.getInt("count")));
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
                    superheroByName = new SuperheroSuperpowerCountDTO(resultSet.getInt("superheroid"),
                            resultSet.getString("superheroName"),
                            resultSet.getString("realName"),
                            resultSet.getInt("count"));
                }
                return superheroByName;
            } catch (SQLException e) {
                throw new RuntimeException();
            }

        }

        @Override
        public List<SuperheroStrengthsDTO> getSuperheroWithStrengths () {
            List<SuperheroStrengthsDTO> superheroes = new ArrayList<>();

            try (Connection con = connectionSQL()) {
                String SQL = "SELECT superheroes.superheroid, superheroName, realName, superpowers.superpower FROM superheroes \n" +
                        "JOIN superhero_superpower on superheroes.superheroid = superhero_superpower.superheroid\n" +
                        "JOIN superpowers ON superhero_superpower.superpowerid = superpowers.superpowerid;";
                PreparedStatement preparedStatement = con.prepareStatement(SQL);
                ResultSet resultSet = preparedStatement.executeQuery();

                String currentHeroName = "";
                SuperheroStrengthsDTO currentDto = null;

                while(resultSet.next()) {
                    int id = resultSet.getInt("superheroid");
                    String superheroName = resultSet.getString("superheroName");
                    String realName = resultSet.getString("realName");
                    Superpower superpower = new Superpower(resultSet.getString("superpower"));
                    if (superheroName.equals(currentHeroName)) {
                        currentDto.addPower(superpower);
                    } else {
                        currentDto = new SuperheroStrengthsDTO(id, superheroName, realName, new ArrayList<>(List.of(superpower)));
                        currentHeroName = superheroName;
                    }
                    if (!superheroes.contains(currentDto)) {
                        superheroes.add(currentDto);
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return superheroes;
        }

        @Override
        public List<SuperheroStrengthsDTO> getSuperheroByNameAndWithStrengths (String superheroName){
            List <SuperheroStrengthsDTO> superheroes = new ArrayList<>();

            try (Connection con = connectionSQL()) {
                String SQL = "SELECT superheroes.superheroid, superheroName, realName, superpowers.superpower FROM superheroes \n" +
                        "JOIN superhero_superpower on superheroes.superheroid = superhero_superpower.superheroid\n" +
                        "JOIN superpowers ON superhero_superpower.superpowerid = superpowers.superpowerid\n" +
                        "WHERE superheroName = ?;";

                PreparedStatement preparedStatement = con.prepareStatement(SQL);
                preparedStatement.setString(1,superheroName);
                ResultSet resultSet = preparedStatement.executeQuery();

                String currentHeroName = "";
                SuperheroStrengthsDTO currentDto = null;

                while(resultSet.next()) {
                    int id = resultSet.getInt("superheroid");
                    String superheroNameColumn = resultSet.getString("superheroName");
                    String realName = resultSet.getString("realName");
                    Superpower superpower = new Superpower(resultSet.getString("superpower"));
                    if (superheroNameColumn.equals(currentHeroName)) {
                        currentDto.addPower(superpower);
                    } else {
                        currentDto = new SuperheroStrengthsDTO(id, superheroNameColumn, realName, new ArrayList<>(List.of(superpower)));
                        currentHeroName = superheroNameColumn;
                    }
                    if (!superheroes.contains(currentDto)) {
                        superheroes.add(currentDto);
                    }
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return superheroes;
    }


        @Override
        public List<SuperheroCityDTO> getSuperheroAndCity () {
            List <SuperheroCityDTO> superheroCityDTOS = new ArrayList<>();

            try (Connection con = connectionSQL()) {
                String SQL = "SELECT city, superheroName, realname, datecreated from superheroes\n" +
                        "INNER JOIN cities ON superheroes.cityid = cities.cityid;";
                PreparedStatement preparedStatement = con.prepareStatement(SQL);
                ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()) {
                    SuperheroCityDTO superheroCityDTO = new SuperheroCityDTO(resultSet.getString("city"),
                            resultSet.getString("superheroName"),
                            resultSet.getString("realName"),
                            resultSet.getString("dateCreated"));
                    superheroCityDTOS.add(superheroCityDTO);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return superheroCityDTOS;
        }

        @Override
        public SuperheroCityDTO getSuperheroAndCityByName(String name) {
            SuperheroCityDTO superheroCityDTO = null;

            try (Connection con = connectionSQL()) {
                String SQL = "SELECT city, superheroName, realname, datecreated from superheroes\n" +
                        "INNER JOIN cities ON superheroes.cityid = cities.cityid\n" +
                        "WHERE city = ?;";

                PreparedStatement preparedStatement = con.prepareStatement(SQL);
                preparedStatement.setString(1,name);
                ResultSet resultSet = preparedStatement.executeQuery();


                if (resultSet.next()) {
                    superheroCityDTO = new SuperheroCityDTO(resultSet.getString("city"),
                            resultSet.getString("superheroName"),
                            resultSet.getString("realName"),
                            resultSet.getString("dateCreated"));

                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
            return superheroCityDTO;
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

