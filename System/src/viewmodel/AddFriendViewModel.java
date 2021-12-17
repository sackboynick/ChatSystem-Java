package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Model;
import model.User;

public class AddFriendViewModel {
    private StringProperty usernameLabelProperty, username;
    private ObservableList<User> users;
    private final Model model;

    public AddFriendViewModel(Model model) {
        this.model = model;
        this.users= FXCollections.observableArrayList();
        this.username=new SimpleStringProperty();
        this.usernameLabelProperty=new SimpleStringProperty();
        update();
    }

    public void update(){
            if (ViewState.getInstance().getUser()!=null)
            this.usernameLabelProperty.set(ViewState.getInstance().getUser().getUsername());

    }

    public StringProperty getUsername() {
        return username;
    }

    public ObservableList<User> getUsers() {
        return users;
    }

    public StringProperty getUsernameLabelProperty() {
        return usernameLabelProperty;
    }

    public void setUsernameLabelProperty(String usernameLabelProperty) {
        this.usernameLabelProperty.set(usernameLabelProperty);
    }
    public void searchUserByUsername(){
        User user;
        try {
            this.users=FXCollections.observableArrayList();
            user=this.model.getUser(username.get());
            if(user!=null)
            this.users.add(user);
            else
                username.set("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public void addFriend(String username){
        try {
            this.model.addFriendship(ViewState.getInstance().getUser().getId(),this.model.getUser(username).getId(),false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
