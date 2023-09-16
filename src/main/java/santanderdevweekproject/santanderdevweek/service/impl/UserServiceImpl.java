package santanderdevweekproject.santanderdevweek.service.impl;

import org.springframework.stereotype.Service;
import santanderdevweekproject.santanderdevweek.domain.model.User;
import santanderdevweekproject.santanderdevweek.domain.repository.UserRepository;
import santanderdevweekproject.santanderdevweek.service.UserService;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This account number already exists");
        }
        return userRepository.save(userToCreate);
    }


}
