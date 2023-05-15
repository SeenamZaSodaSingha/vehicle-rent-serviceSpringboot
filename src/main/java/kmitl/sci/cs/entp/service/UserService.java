package kmitl.sci.cs.entp.service;

import java.util.List;

import kmitl.sci.cs.entp.model.PatchUserRequest;
import kmitl.sci.cs.entp.model.User;

public interface UserService {
	public List<User> getUsers();
	public User getUser(long userId);
	public void create(User user);
	public void delete(long userId);
	public void update(User user, PatchUserRequest request);
	public User getUserByFirstName(String firstName);
}
