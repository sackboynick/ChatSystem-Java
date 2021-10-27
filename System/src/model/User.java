package model;

import java.util.ArrayList;

public class User {
    private final String username, firstName, lastName, password;
    private final ArrayList<Friendship> friends;
    private final ArrayList<Chat> chats;

    public User(String username,String firstName,String lastName,String password,ArrayList<Friendship> friends,ArrayList<Chat> chats){
        this.username=username;
        this.firstName=firstName;
        this.lastName=lastName;
        this.password=password;
        this.friends=friends;
        this.chats=chats;
    }

    public User(String username,String firstName,String lastName,String password){
        this.username=username;
        this.firstName=firstName;
        this.lastName=lastName;
        this.password=password;
        this.friends=new ArrayList<>();
        this.chats=new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    protected ArrayList<Friendship> getFriends(){
        return friends;
    }

    public void addFriend(String username,boolean closeFriend){
        this.friends.add(new Friendship(username, closeFriend));
        this.chats.add(new PrivateChat(this.username,username));
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof User))
            return false;
        return username.equals(((User) obj).username);
    }

    @Override
    public String toString() {
        return "Username: "+username;
    }

    public String toStringFullName(){
        return toString()+"\nFirst name: "+firstName+"\nLast name: "+lastName;
    }
}
