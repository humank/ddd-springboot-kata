package solid.humank.dddpatterns.baseclasses;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class Enumeration implements Comparable<Enumeration> {

    @Setter(AccessLevel.PRIVATE)
    @Getter(AccessLevel.PUBLIC)
    private String name;

    @Setter(AccessLevel.PRIVATE)
    @Getter(AccessLevel.PUBLIC)
    private int id;

    protected Enumeration(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enumeration that = (Enumeration) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public int compareTo(Enumeration o) {
        return Integer.compare(this.id, o.id);
    }
}

