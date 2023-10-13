package ba.edu.ibu.webengineeringproject.core.repository;

import ba.edu.ibu.webengineeringproject.core.model.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users;

    public UserRepository() {
        this.users = Arrays.asList(
                new User(1, "Hamza", "Bakaran", "hamza.bakaran@ibu.edu.ba"),
                new User(2, "Harun", "Bakaran", "harun.bakaran@ibu.edu.ba")
        );
    }

    public List<User> findAll() {
        return users;
    }
    // Function to find a user by ID
    public User findById(int userId) {
        for (User user : users) {
            if (user.getId() == userId) {
                return user; // Return the user if the ID matches
            }
        }
        return null; // Return null if no matching user is found
    }
}
