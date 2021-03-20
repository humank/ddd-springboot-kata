package solid.humank.dddspringbootkata.infra.persistent;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class TutorialTest {

    @Test
    void should_be_not_publishable_when_not_completed() throws TutorialNotCompletedException {
        Tutorial sut = new Tutorial();
        sut.setTitle("Kim's cloud journey");
        assertThrows(TutorialNotCompletedException.class, sut::publish);
    }

    @Test
    void should_be_publishable() throws TutorialNotCompletedException {
        String completed = "COMPLETED";
        Tutorial sut = new Tutorial();
        sut.setTitle("another test");
        sut.setStatus(completed);
        assertDoesNotThrow(sut::publish);
    }
}