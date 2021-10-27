package databasemodel.modelinterfaces;

import model.User;

import java.sql.SQLException;

public interface UserInterface {
    void createUser(User user) throws SQLException;
    String getUserFromUsernameAndPassword(String username,String password) throws SQLException;
}
