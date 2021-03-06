package hello;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;


@RestResource(exported = false)
public interface UserRepository extends JpaRepository<User, String> {
}
