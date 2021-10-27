package model;

public class Friendship {
    private final String username;
    private final boolean closeFriend;

    public Friendship(String username,boolean closeFriend) {
        this.username=username;
        this.closeFriend=closeFriend;
    }

    public String getUsername() {
        return username;
    }

    public boolean isCloseFriend() {
        return closeFriend;
    }
}
