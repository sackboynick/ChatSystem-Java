package mediator;

import model.User;

import java.net.MalformedURLException;

public interface IUserValidator {
    void registerUser(User user) throws Exception;
    User logIn(String username,String password) throws Exception;
}
