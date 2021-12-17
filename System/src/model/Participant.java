package model;

public class Participant {
    private int id;
    private boolean admin;
    private String user;
    private int groupChatId;

    public Participant(String user,boolean admin,int groupChatId){
        this.user=user;
        this.admin=admin;
        this.groupChatId=groupChatId;
    }

    public int getId() {
        return id;
    }

    public boolean isAdmin() {
        return admin;
    }

    public int getGroupChatId() {
        return groupChatId;
    }

    public String getUser() {
        return user;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setGroupChatId(int groupChatId) {
        this.groupChatId = groupChatId;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
