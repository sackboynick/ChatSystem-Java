package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;
import model.User;

public class RegisterViewModel {
    private final Model model;
    private final StringProperty username,firstname,lastname,password;


    public RegisterViewModel(Model model){
        this.model=model;
        this.username=new SimpleStringProperty();
        this.firstname=new SimpleStringProperty();
        this.lastname=new SimpleStringProperty();
        this.password=new SimpleStringProperty();
    }

    public StringProperty getUsername() {
        return username;
    }

    public StringProperty getFirstname() {
        return firstname;
    }

    public StringProperty getLastname() {
        return lastname;
    }

    public StringProperty getPassword() {
        return password;
    }

    public void registerUser(){
        try {
            this.model.registerUser(new User(getUsername().get(),getFirstname().get(),getLastname().get(),getPassword().get()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
