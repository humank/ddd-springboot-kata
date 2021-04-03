package solid.humank.dddspringbootkata.applications;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import solid.humank.dddspringbootkata.infra.persistent.TutorialRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TutorialApplication {
    private final TutorialRepository tutorialRepository;

    public TutorialApplication(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    public List<TutorialDto> getAllTutorials(String title) {
        List<Tutorial> tutorials = new ArrayList<>();
        List<TutorialDto> tutorialDtoList;
        if (title == null)
            tutorials.addAll(tutorialRepository.findAll());
        else
            tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);

        return tutorials.stream().
                map(t -> new TutorialDto(
                        t.getId(),
                        t.getTitle(),
                        t.isPublished(),
                        t.getDescription(),
                        t.getStatus())).collect(Collectors.toList());

    }


    public Tutorial save(Tutorial tutorial) {
        return tutorialRepository
                .save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
    }
}
