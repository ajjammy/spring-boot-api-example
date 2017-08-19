package in.jay.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Usercontroller {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<?> sample(){
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.getUsers());
    }

    @RequestMapping(value = "/users",  method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody User user){
        userRepository.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
