package kmitl.sci.cs.entp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kmitl.sci.cs.entp.model.PatchUserRequest;
import kmitl.sci.cs.entp.model.User;
import kmitl.sci.cs.entp.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repository;

	@Override
	public List<User> getUsers() {
		return repository.findAll();
	}

	@Override
	public User getUser(long userId) {
		return repository.findByUserId(userId);
	}

	@Override
	public void create(User user) {
		repository.save(user);
	}

	@Override
	public void update(User user, PatchUserRequest request) {
		updateUser(user, request);
		repository.save(user);
	}

	public void updateUser(User user, PatchUserRequest request) {
		if (request.getFirstName() != null) {
			user.setFirstName(request.getFirstName());
		}
		if (request.getLastName() != null) {
			user.setLastName(request.getLastName());
		}
	}

	@Override
	public void delete(long userId) {
		repository.deleteByUserId(userId);
	}

	@Override
	public User getUserByFirstName(String firstName) {
		return repository.findByFirstName(firstName);
	}

}
