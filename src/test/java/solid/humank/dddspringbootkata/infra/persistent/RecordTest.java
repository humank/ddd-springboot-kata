package solid.humank.dddspringbootkata.infra.persistent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecordTest {

    @Test
    void recordTest() {
        var person = new Person("Kim", 40);
        assertEquals(person.age(),40);
        assertEquals(person.name(), "Kim");
    }
}

record Person(String name, int age) {
    public Person {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

}