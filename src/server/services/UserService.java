package server.services;

import server.entities.User;
import server.mappers.UserMapper;

/**
 * Created by Paul on 09/05/2015.
 */
public class UserService {
    UserMapper uM;

    public UserService(UserMapper uM) {
        this.uM = uM;
    }

    public User login(User user) {
        User logger = uM.find(user);
        return  logger;
    }
}
