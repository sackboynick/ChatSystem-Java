package model;

public class Friendship {
    private int id;
    private final int userId,friendUserId;
    private final boolean closeFriend;

    public Friendship(int userId,int friendUserId,boolean closeFriend){
        this.id=0;
        this.userId=userId;
        this.friendUserId=friendUserId;
        this.closeFriend=closeFriend;
    }

    public int getFriendUserId() {
        return friendUserId;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public boolean isCloseFriend() {
        return closeFriend;
    }

    public void setId(int id) {
        this.id = id;
    }

}
