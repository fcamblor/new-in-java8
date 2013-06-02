package org.isk.lambda.streams;

import java.util.ArrayList;
import java.util.List;
import org.isk.lambda.beans.Person;

/**
 * Simulates a Database containing a list of {@link Person}.
 * <br>
 * {@link Person} are contained in a {@link List}
 * @author Yohan Beschi
 */
public class StreamPersonsDB {
    public final static List<Person> PERSONS;
    
    static {
        PERSONS = new ArrayList<>();
        PERSONS.add(new Person("Carson", "Busses", 25));
        PERSONS.add(new Person("Patty", "Cake", 72));
        PERSONS.add(new Person("Anne", "Derri ", 14));
        PERSONS.add(new Person("Moe", "Dess", 47));
        PERSONS.add(new Person("Leda", "Doggslife", 50));
        PERSONS.add(new Person("Dan", "Druff", 38));
        PERSONS.add(new Person("Al", "Fresco", 36));
        PERSONS.add(new Person("Ido", "Hoe", 2));
        PERSONS.add(new Person("Howie", "Kisses", 23));
        PERSONS.add(new Person("Len", "Lease", 63));
    }

    private StreamPersonsDB() {}
}
