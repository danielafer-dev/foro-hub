package api.hub.domain.course;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findByNameContainsIgnoreCase(String name);
}
