package solid.humank.tutorials.infra.persistent;

public class TutorialNotCompletedException extends Exception {
    public TutorialNotCompletedException(String title, boolean published) {
        super(title + "is not completed");
    }
}
