package databasemodel.models;

import databasemodel.*;
import databasemodel.modelinterfaces.UserInterface;
import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserModel implements UserInterface {

    /**
     * The method adds a message to the database Message schema.
     *
     * @return Makes the connection to the database
     */
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://" + DatabaseVariables.HOST + ":"
                        + DatabaseVariables.PORT + "/" + DatabaseVariables.NAME + "?"
                        + "currentSchema=" + DatabaseVariables.SCHEMA_NAME,
                DatabaseVariables.NAME, DatabaseVariables.PASSWORD);
    }

    /**
     * The method adds a User object to the database User schema.
     *
     * @param user The user to be added.
     */
    @Override
    public void createUser(User user) throws SQLException {

    }

    @Override
    public String getUserFromUsernameAndPassword(String username, String password) throws SQLException {
        return null;
    }
}
