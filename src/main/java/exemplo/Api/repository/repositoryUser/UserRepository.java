package exemplo.Api.repository.repositoryUser;


import exemplo.Api.model.modelUser.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByLogin(String Login);
}
