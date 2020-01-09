package hello;

import javassist.tools.web.BadHttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class Controller {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public Iterable<User> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{username}")
    public User find(@PathVariable("username") String username) {
        return repository.findById(username).get();
    }

    @PostMapping(consumes = "application/json")
    public User create(@RequestBody User user) {
        return repository.save(user);
    }

    @DeleteMapping(path = "/{username}")
    public void delete(@PathVariable("username") String username) {
        repository.deleteById(username);
    }

    @PutMapping(path = "/{username}")
    public User updateUsername(@PathVariable("username") String username, @RequestBody User user) throws BadHttpRequest {
        if (repository.existsById(username)) {
            user.setUsername(username);
            return repository.save(user);
        } else {
            throw new BadHttpRequest();
        }
    }
}