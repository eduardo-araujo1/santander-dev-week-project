package santanderdevweekproject.santanderdevweek.service;

import santanderdevweekproject.santanderdevweek.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create (User userToCreate);
}
