package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;

public class LogInViewModel {
    private final Model model;
    private final StringProperty usernameProperty,passwordProperty;


    public LogInViewModel(Model model){
        this.model=model;
        this.usernameProperty = new SimpleStringProperty();
        this.passwordProperty = new SimpleStringProperty();
    }


    public StringProperty getPasswordProperty() {
        return passwordProperty;
    }

    public StringProperty getUsernameProperty() {
        return usernameProperty;
    }

    public void logIn(){
        try {
            ViewState.getInstance().setUser(this.model.logIn(getUsernameProperty().get(),getPasswordProperty().get()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}