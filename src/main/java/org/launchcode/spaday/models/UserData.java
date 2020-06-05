package org.launchcode.spaday.models;

import java.util.HashMap;
import java.util.Map;

public class UserData {

    public static Map<Integer, User> users =
            new HashMap<>();

    public static void addUser(User user){
        users.put(user.getId(), user);
    }

    public static Map<Integer, User> getAllUsers (){
        return users;
    }

    public static User getUserById(int id){
        return users.get(id);
    }
}
