package kmitl.sci.cs.entp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kmitl.sci.cs.entp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserId(long id);
	void deleteByUserId(long id);
	User findByFirstName(String firstName);
}
