package org.isk.lambda.sams;

import org.isk.lambda.beans.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test {@link SamsList}
 * @author Yohan Beschi
 */
public class SamsTest {
    /**
     * Test {@link SamsList#getSubList}
     * <br>Filtering by age
     */
    @Test
     public void getSublistWithAnonymousClass1() {
        final SamsList list = SamsPersonsDB.PERSONS.getSubList(new SamPredicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getAge() >= 14 && person.getAge() <= 25;
            }
        });

       this.testBetween15and25(list);
    }
    
    /**
     * Test {@link SamsList#getSubList}
     * <br>Filtering by name
     */
    @Test
     public void getSublistWithAnonymousClass2() {
        final SamsList list = SamsPersonsDB.PERSONS.getSubList(new SamPredicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getLastname().startsWith("D");
            }
        });

        this.testLastnameStartsWidthD(list);
    }

    /**
     * Test {@link SamsList#getSubList}
     * <br>Filtering by age
     */
    @Test
    public void getSublistWithLambda1() {
        final SamsList list = SamsPersonsDB.PERSONS.getSubList((person) -> person.getAge() >= 14 && person.getAge() <= 25);

        this.testBetween15and25(list);
    }
    
    /**
     * Test {@link SamsList#getSubList}
     * <br>Filtering by name
     */
    @Test
    public void getSublistWithLambda2() {
        final SamsList list = SamsPersonsDB.PERSONS.getSubList((person) -> person.getLastname().startsWith("D"));

        this.testLastnameStartsWidthD(list);
    }
    
    private void testBetween15and25(final SamsList list) {
        Assert.assertEquals(3, list.size());
        Assert.assertTrue(list.contains(new Person("Carson", "Busses", 25)));
        Assert.assertTrue(list.contains(new Person("Anne", "Derri ", 14)));
        Assert.assertTrue(list.contains(new Person("Howie", "Kisses", 23)));
    }
    
    private void testLastnameStartsWidthD(final SamsList list) {
        Assert.assertEquals(4, list.size());
        Assert.assertTrue(list.contains(new Person("Anne", "Derri ", 14)));
        Assert.assertTrue(list.contains(new Person("Moe", "Dess", 47)));
        Assert.assertTrue(list.contains(new Person("Leda", "Doggslife", 50)));
        Assert.assertTrue(list.contains(new Person("Dan", "Druff", 38)));
    }
}
