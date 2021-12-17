package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

public class ChatsViewModel {
    private final Model model;
    private ObservableList<PrivateChat> privateChats;
    private ObservableList<GroupChat> groupChats;
    private StringProperty usernameLabelProperty;

    public ChatsViewModel(Model model){
        this.model=model;
        this.usernameLabelProperty=new SimpleStringProperty();
        update();
    }

    public void update(){
        this.privateChats= FXCollections.observableArrayList();
        this.groupChats=FXCollections.observableArrayList();
        if(ViewState.getInstance().getUser()!=null) {
            try {
                this.privateChats.addAll(model.getUserPrivateChats(ViewState.getInstance().getUser().getId()));
                this.groupChats.addAll(model.getUserGroupChats(ViewState.getInstance().getUser().getId()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.usernameLabelProperty = new SimpleStringProperty(ViewState.getInstance().getUser().getUsername());
        }
    }

    public ObservableList<GroupChat> getGroupChats() {
        return groupChats;
    }

    public ObservableList<PrivateChat> getPrivateChats() {
        return privateChats;
    }

    public StringProperty getUsernameLabelProperty() {
        return usernameLabelProperty;
    }
}
