package ssf.miniproject.allnews.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssf.miniproject.allnews.models.User;
import ssf.miniproject.allnews.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;

    public void save(User user) {

        userRepo.save(user);

	}

	public Optional<String> get(String email) {

		return userRepo.get(email);
	}

}
