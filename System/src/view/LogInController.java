package view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import viewmodel.LogInViewModel;

public class LogInController extends ViewController{
    private LogInViewModel logInViewModel;

    @FXML
    private TextField username,password;

    @Override
    protected void init() {
        logInViewModel=getViewModelFactory().getLogInViewModel();
        reset();
    }

    public void reset(){
        this.username.textProperty().bindBidirectional(logInViewModel.getUsernameProperty());
        this.password.textProperty().bindBidirectional(logInViewModel.getPasswordProperty());

    }

    @FXML public void logIn(){
        logInViewModel.logIn();
        getViewHandler().openView("chats");
    }

    @FXML public void openRegisterPage(){
        getViewHandler().openView("register");
    }
}
