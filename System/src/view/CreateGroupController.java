package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import viewmodel.CreateGroupViewModel;

public class CreateGroupController extends ViewController{
    private CreateGroupViewModel createGroupViewModel;

    @FXML
    public Label usernameLabel;
    @FXML public TextField groupName;


    @Override
    protected void init() {
        this.createGroupViewModel=getViewModelFactory().getCreateGroupViewModel();
        update();
    }

    public void update(){
        this.usernameLabel.textProperty().bind(createGroupViewModel.getUsernameLabelProperty());
        this.groupName.textProperty().bindBidirectional(createGroupViewModel.getGroupNameProperty());
    }

    @FXML public void createGroup(){
        System.out.println(groupName.getText());
        if(groupName.getText()!=null)
            this.createGroupViewModel.createGroup();
        getViewHandler().openView("chats");
    }
    @FXML public void onBack(){
        getViewHandler().openView("chats");
    }
}
