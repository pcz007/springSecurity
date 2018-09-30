package pl.piotrekcz.security;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;

    public UserService(UserRepository userRepository,
                       UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    public void addUser(String login, String password) {

        User user = new User();
        user.setLogin(login);
        user.setPassword("{noop}" + password);

        userRepository.save(user);

        UserRole role = new UserRole();
        role.setLogin(login);
        role.setRole("USER_ROLE");

        userRoleRepository.save(role);
    }
}
