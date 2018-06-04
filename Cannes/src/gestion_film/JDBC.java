/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_film;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBC {

	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@iutdoua-oracle.univ-lyon1.fr:1521:orcl";
	private static final String DB_USER = "p1623009";
	private static final String DB_PASSWORD = "288070";

	public static void main(String[] argv) {

		try {

			selectFilmFromDB();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

	}

	public static void selectFilmFromDB() throws SQLException {

		Connection dbConnection = null;
		Statement statement = null;

		String selectTableSQL = "SELECT * from FILM";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println(selectTableSQL);

			// execute select SQL stetement
			ResultSet rs = statement.executeQuery(selectTableSQL);

			while (rs.next()) {

				int filmid =  Integer.parseInt(rs.getString("ID"));
				String filmname = rs.getString("NOM");
                                String type = rs.getString("TYPE");
                                String duree = rs.getString("DUREE");
                                String realisateur = rs.getString("REALISATEUR");
                                
                                
				System.out.println("FilmID : " + filmid + " " + filmname);

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
