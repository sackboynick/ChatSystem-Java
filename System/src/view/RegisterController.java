package view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import viewmodel.RegisterViewModel;

public class RegisterController extends ViewController{
    private RegisterViewModel registerViewModel;

    @FXML
    private TextField username,firstname,lastname,password;

    @Override
    protected void init() {
        this.registerViewModel = getViewModelFactory().getRegisterViewModel();
        reset();
    }

    public void reset(){
        this.username.textProperty().bindBidirectional(registerViewModel.getUsername());
        this.firstname.textProperty().bindBidirectional(registerViewModel.getFirstname());
        this.lastname.textProperty().bindBidirectional(registerViewModel.getLastname());
        this.password.textProperty().bindBidirectional(registerViewModel.getPassword());
    }

    @FXML public void registerUser(){
        this.registerViewModel.registerUser();
        getViewHandler().openView("logIn");
    }
}
