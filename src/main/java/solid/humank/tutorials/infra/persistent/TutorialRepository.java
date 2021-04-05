package solid.humank.tutorials.infra.persistent;

import org.springframework.data.jpa.repository.JpaRepository;
import solid.humank.tutorials.applications.Tutorial;

import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(boolean published);

    List<Tutorial> findByTitleContaining(String title);
}
