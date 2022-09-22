package ssf.miniproject.allnews.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import ssf.miniproject.allnews.models.User;


@Repository
public class UserRepository {

    @Autowired
    @Qualifier("redislab")
	private RedisTemplate<String, String> redisTemplate;

	public void save(User user) {

        String email = user.getEmail();

        ValueOperations<String, String> valueOp = redisTemplate.opsForValue();
        // System.out.println("User repo: " + user.toJson(user).toString());
		valueOp.set(email, user.toJson(user).toString());

	}

	public Optional<String> get(String email) {

		if (!redisTemplate.hasKey(email))
			return Optional.empty();
        
        ValueOperations<String, String> valueOp = redisTemplate.opsForValue();
        
		String userString = valueOp.get(email);

		return Optional.of(userString);
	}
}
