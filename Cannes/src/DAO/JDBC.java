/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classes.Personne;
import classes.Film;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.time.*;


public class JDBC {

    private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_CONNECTION = "jdbc:oracle:thin:@iutdoua-oracle.univ-lyon1.fr:1521:orcl";
    private static final String DB_USER = "p1623009";
    private static final String DB_PASSWORD = "288070";

//    public static void main(String[] argv) {
//
//        try {
//
//            selectFilmFromDB();
//
//        } catch (SQLException e) {
//
//            System.out.println(e.getMessage());
//
//        }
//
//    }
//    
//    
    public static ArrayList selectFilmFromDB() throws SQLException {

        ArrayList<Film> listFilm = new ArrayList<>();
        Connection dbConnection = null;
        Statement statement = null;

        String selectTableSQL = "SELECT * from FILM";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            System.out.println(selectTableSQL);

//             execute select SQL stetement
            ResultSet rs = statement.executeQuery(selectTableSQL);

            while (rs.next()) {

                int filmid = Integer.parseInt(rs.getString("ID"));
                String filmname = rs.getString("NOM");
                String type = rs.getString("TYPE");
                String duree = rs.getString("DUREE");
                String realisateur = rs.getString("REALISATEUR");

                String[] parts = duree.split(":");
                Duration duree2 = Duration.ZERO;
                switch (parts.length) {
                    case 3: {
                        int hours = Integer.parseInt(parts[0]);
                        int minutes = Integer.parseInt(parts[1]);
                        int seconds = Integer.parseInt(parts[2]);
                        duree2 = duree2.plusHours(hours).plusMinutes(minutes).plusSeconds(seconds);
                        break;
                    }
                    case 2: {
                        int hours = Integer.parseInt(parts[0]);
                        int minutes = Integer.parseInt(parts[1]);
                        duree2 = duree2.plusHours(hours).plusMinutes(minutes);
                        break;
                    }
                    default:
                        System.out.println("ERROR - Unexpected input.");
                        break;
                }

                Film film = new Film(filmid, filmname, realisateur, type, duree2);

                listFilm.add(film);

//                System.out.println("FilmID : " + filmid + " " + filmname + " " + type + " " + duree2);
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }

        return listFilm;

    }

    public static ArrayList selectStaffFromDB() throws SQLException {

        ArrayList<Personne> listStaff = new ArrayList<>();
        Connection dbConnection = null;
        Statement statement = null;

        String selectTableSQL = "SELECT ID,NOM,PRENOM,MDP from PERSONNE P, STAFF S WHERE P.ID = S.ID_STAFF";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            System.out.println(selectTableSQL);

//             execute select SQL stetement
            ResultSet rs = statement.executeQuery(selectTableSQL);

            while (rs.next()) {

                int staffID = Integer.parseInt(rs.getString("ID"));
                String staffName = rs.getString("NOM");
                String staffSurname = rs.getString("PRENOM");
                String mdp = rs.getString("MDP");

                Personne staff = new Personne(staffID, staffName, staffSurname, "Staff", mdp);

                listStaff.add(staff);

//                System.out.println("FilmID : " + filmid + " " + filmname + " " + duree2);
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }

        return listStaff;

    }

    private static Connection getDBConnection() {

        Connection dbConnection = null;

        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
                    DB_PASSWORD);
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }

}
