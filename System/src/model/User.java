package model;

import java.util.ArrayList;
import java.util.Collection;

public class User {
    private int id;
    private final String username, firstname, lastname, password;
    private final Collection<Friendship> friends;

    public User(String username,String firstName,String lastName,String password,ArrayList<Friendship> friends){
        this.username=username;
        this.firstname=firstName;
        this.lastname =lastName;
        this.password=password;
        this.friends=friends;

    }

    public User(int id,String username,String firstName,String lastName,String password){
        this.id=id;
        this.username=username;
        this.firstname=firstName;
        this.lastname=lastName;
        this.password=password;
        this.friends=new ArrayList<>();
    }
    public User(String username,String firstName,String lastName,String password){
        this.username=username;
        this.firstname=firstName;
        this.lastname =lastName;
        this.password=password;
        this.friends=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public Collection<Friendship> getFriends(){
        return friends;
    }

    public void addFriend(int friendUserId,boolean closeFriend){
        this.friends.add(new Friendship(this.getId(),friendUserId, closeFriend));
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
        return toString()+"\nFirst name: "+firstname+"\nLast name: "+ lastname;
    }
}
