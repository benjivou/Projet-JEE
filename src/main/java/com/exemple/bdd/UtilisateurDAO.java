package com.exemple.bdd;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;


import com.exemple.beans.Utilisateur;

import javax.naming.Context;

public class UtilisateurDAO extends DAOContext {
    /**
     *
     * @param login Login You want to check ( here it's the user email )
     * @param password password of the session
     * @return true : the user already exist false it doesn't exist
     */
    public static Boolean isValidLogin(String login, String password ) {
        try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ) {
            // String strSql = "SELECT * FROM T_Users WHERE login='" + login +
            // "' AND password='" + password + "'";
            String strSql = "SELECT * FROM Utilisateur WHERE email=? AND mot_de_passe=?";
            try ( PreparedStatement statement = connection.prepareStatement( strSql ) ) {
                statement.setString( 1, login );
                statement.setString( 2, password );
                try ( ResultSet resultSet = statement.executeQuery() ) {
                    if ( resultSet.next() && resultSet.getString(2).equals(login)) {

                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } catch ( Exception exception ) {
            throw new RuntimeException( exception );
        }
    }


    /**
     *
     * @param login
     * @return true : the login is used, false : not used
     */
    public static Boolean isValidEmail( String login ) {
        try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ) {

            String strSql = "SELECT * FROM Utilisateur WHERE email=?";
            try ( PreparedStatement statement = connection.prepareStatement( strSql ) ) {
                statement.setString( 1, login );
                ResultSet resultSet = statement.executeQuery();
                    if ( resultSet.next() ) {
                        return true;
                    } else {
                        return false;
                    }

            }
        } catch ( Exception exception ) {
            throw new RuntimeException( exception );
        }
    }






}
