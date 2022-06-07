package fr.tradflex.ressource;

import fr.tradflex.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class UserRessource {

    private static final AtomicInteger ID = new AtomicInteger(1);

    private static final List<User> USERS = new ArrayList<>();

    static {
        USERS.add(new User(Integer.toString(ID.getAndIncrement()), "John"));
        USERS.add(new User(Integer.toString(ID.getAndIncrement()), "Rambo"));
        USERS.add(new User(Integer.toString(ID.getAndIncrement()), "Rick"));
        USERS.add(new User(Integer.toString(ID.getAndIncrement()), "Morty"));
    }

    @GetMapping(path = "/user/{id}")
    public User getUser(@PathVariable(name = "id") String id) {
        return USERS.stream()
                .filter(user -> id.equals(user.id()))
                .findFirst()
                .orElseThrow(ProjectRessource.ResourceNotFoundException::new);
    }

    @GetMapping(path = "/user")
    public List<Object> getUsers() {
        return Collections.singletonList(USERS.stream().map(UserAsId::new).toList());
    }

    @PostMapping("/user")
    public User createUser(@RequestBody UserRessource.UserWhenCreating user) {
        var newUser = new User(Integer.toString(ID.getAndIncrement()), user.pseudo());
        USERS.add(newUser);
        return newUser;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public static class ResourceNotFoundException extends RuntimeException {}

    private record UserWhenCreating(String pseudo) {}

    private record UserAsId(String id, String url) {
        UserAsId(User user) {
            this(user.id(), "localhost:8080/user/"+user.id());
        }
    }
}
