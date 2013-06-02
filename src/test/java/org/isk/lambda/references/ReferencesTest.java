package org.isk.lambda.references;

import java.util.Collections;
import java.util.List;
import org.isk.lambda.beans.Person;
import org.isk.lambda.sams.SamsPersonsDB;
import org.junit.Assert;
import org.junit.Test;

/**
 * Static method reference example.
 * @author Yohan Beschi
 */
public class ReferencesTest {
    /**
     * Test sorting with a static method reference.
     */
    @Test
    public void sortByAge() {
        final List<Person> list = SamsPersonsDB.PERSONS.getSubList((person) -> person.getLastname().startsWith("D"));
        Collections.sort(list, Person::sortByAge);

        Assert.assertTrue(list.get(0).equals(new Person("Anne", "Derri ", 14)));
        Assert.assertTrue(list.get(1).equals(new Person("Dan", "Druff", 38)));
        Assert.assertTrue(list.get(2).equals(new Person("Moe", "Dess", 47)));
        Assert.assertTrue(list.get(3).equals(new Person("Leda", "Doggslife", 50)));
    }
}
