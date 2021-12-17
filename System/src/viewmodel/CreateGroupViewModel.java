package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;

public class CreateGroupViewModel {
    private final Model model;
    private StringProperty usernameLabelProperty;
    private final StringProperty groupNameProperty;


    public CreateGroupViewModel(Model model){
        this.model=model;
        this.usernameLabelProperty=new SimpleStringProperty();
        this.groupNameProperty=new SimpleStringProperty();
        update();
    }

    public void update(){
        if(ViewState.getInstance().getUser()!=null)
        this.usernameLabelProperty=new SimpleStringProperty(ViewState.getInstance().getUser().getUsername());
    }

    public StringProperty getGroupNameProperty() {
        return groupNameProperty;
    }

    public void createGroup(){
        try {
            this.model.createGroup(groupNameProperty.get(), ViewState.getInstance().getUser().getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public StringProperty getUsernameLabelProperty() {
        return usernameLabelProperty;
    }
}
