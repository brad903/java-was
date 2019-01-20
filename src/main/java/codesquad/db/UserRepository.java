package codesquad.db;

import java.util.Collection;
import java.util.Map;

import com.google.common.collect.Maps;

import codesquad.model.User;

public class UserRepository {

    private static Map<String, User> users = Maps.newHashMap();

    public static void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public static User findUserById(String userId) {
        return users.get(userId);
    }

    public static Collection<User> findAll() {
        return users.values();
    }

    static {
        // test data
        users.put("brad903", new User("brad903", "1234", "brad", "brad903@naver.com"));
    }
}
