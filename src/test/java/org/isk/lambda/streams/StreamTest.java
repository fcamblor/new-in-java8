package org.isk.lambda.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.isk.lambda.beans.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test {@link Stream}
 * @author Yohan Beschi
 */
public class StreamTest {
    /**
     * Test {@link Stream#filter}, {@link Stream#map} and {@link Stream#reduce}
     * <br>Filtering by age
     */
    @Test
    public void filterMapReduce() {
        final int accumulatedAges = 
                StreamPersonsDB.PERSONS.stream()
                    .filter((person) -> person.getLastname().startsWith("D"))
                    .map((person) -> person.getAge())
                    .reduce(0, (x, y) -> x + y);
        
        Assert.assertEquals(149, accumulatedAges);
    }
    
    /**
     * Test {@link Stream#filter} and {@link Stream#collect}
     * <br>Filtering by age
     */
    @Test
    public void filter() {
        final List<Person> list = 
                StreamPersonsDB.PERSONS.stream()
                    .filter((person) -> person.getLastname().startsWith("D"))
                    .collect(Collectors.toList());

        Assert.assertEquals(4, list.size());
        Assert.assertTrue(list.contains(new Person("Anne", "Derri ", 14)));
        Assert.assertTrue(list.contains(new Person("Moe", "Dess", 47)));
        Assert.assertTrue(list.contains(new Person("Leda", "Doggslife", 50)));
        Assert.assertTrue(list.contains(new Person("Dan", "Druff", 38)));
    }
}
