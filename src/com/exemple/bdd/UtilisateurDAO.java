package com.exemple.bdd;

import java.sql.*;
import java.util.ArrayList;

import com.exemple.beans.Utilisateur;

public class UtilisateurDAO extends DAOContext {
    public static Boolean isValidLogin( String login, String password ) {
        try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ) {
            // String strSql = "SELECT * FROM T_Users WHERE login='" + login +
            // "' AND password='" + password + "'";
            String strSql = "SELECT * FROM Utilisateur WHERE email=? AND mot_de_passe=?";
            try ( PreparedStatement statement = connection.prepareStatement( strSql ) ) {
                statement.setString( 1, login );
                statement.setString( 2, password );
                try ( ResultSet resultSet = statement.executeQuery() ) {
                    if ( resultSet.next() ) {
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

    public static void creerUtilisateur( Utilisateur utilisateur ) {
        try ( Connection connection = DriverManager.getConnection( dbURL,
                dbLogin, dbPassword ) ) {

            String strSql = "INSERT INTO Utilisateur (email, mot_de_passe, nom,  isadmin,date_inscription) VALUES (?, ?, ?, ?, NOW())";
            try ( PreparedStatement statement = connection.prepareStatement(
                    strSql ) ) {
                statement.setString( 1, utilisateur.getEmail() );
                statement.setString( 2, utilisateur.getMotDePasse() );
                statement.setString( 3, utilisateur.getNom() );
                statement.setBoolean( 4, utilisateur.getAdmin() );
                statement.executeUpdate();
            }
        } catch ( Exception exception ) {
            throw new RuntimeException( exception );
        }
    }

    /***
     * Get all user no admin
     * @return
     */
    public static ArrayList<Utilisateur> getLambdaUserAll(){
        ArrayList<Utilisateur > allUser = new ArrayList<>();
        try ( Connection connection = DriverManager.getConnection( dbURL,
                dbLogin, dbPassword ) ) {

            String strSql = "SELECT id,email,mot_de_passe,nom,isadmin,date_inscription FROM Utilisateur WHERE isadmin = 0;";// TO-do
            PreparedStatement statement = connection.prepareStatement( strSql );
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()){
                    Utilisateur utilisateur = new Utilisateur();
                    utilisateur.setAdmin(resultSet.getBoolean("isadmin"));
                    utilisateur.setId(resultSet.getLong("id"));
                    utilisateur.setEmail(resultSet.getString("email"));
                    utilisateur.setMotDePasse(resultSet.getString("mot_de_passe"));
                    utilisateur.setDateInscription(new Timestamp(resultSet.getLong("date_inscription")));
                    utilisateur.setNom(resultSet.getString("nom"));

                    allUser.add(
                        utilisateur
                    );
                }

        } catch ( Exception exception ) {
            throw new RuntimeException( exception );
        }
        return allUser;
    }


    public static void removeUser(Utilisateur user){
        try{
            Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ;
            String query = "DELETE FROM Utilisateur WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement( query );
            statement.setLong(1,user.getId());
            statement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
