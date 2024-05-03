package br.com.senai.controllers;
import br.com.senai.models.Coffee;
import br.com.senai.models.User;
import br.com.senai.repositores.UserRepositore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepositore userRepository;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @PostMapping(value = "/createUser",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public User crateUser(@RequestBody User user) {
        //Cria um novo objeto coffee
        User newUser = new User();
        //Seta as prioridades do coffee
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        //Chama o método save para salvar  objeto no banco de dados
        return userRepository.save(newUser);
    }
    @PutMapping(value = "/updateUser",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@RequestBody User user){
        User getUser = userRepository.findById(user.getId())
                .orElseThrow();
        User updateUser=new User();
        updateUser.setId(user.getId());
        updateUser.setUsername(user.getUsername());
        updateUser.setPassword(user.getPassword());

        return userRepository.save(updateUser);
    }
    @DeleteMapping(value = "/deleteUser/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User deleteUser(@PathVariable Long id) {
        User getUser = userRepository.findById(id).orElseThrow();
        userRepository.delete(getUser);
        return getUser;
    }
}
