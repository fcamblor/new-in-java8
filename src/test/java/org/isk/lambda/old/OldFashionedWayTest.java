package org.isk.lambda.old;

import java.util.List;
import org.isk.lambda.beans.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Yohan Beschi
 */
public class OldFashionedWayTest {

    /**
     * Test {@link OldList#getSubList}
     */
    @Test
    public void getSublist() {
        final List<Person> list = OldPersonsDB.PERSONS.getSubList(14, 25);

        Assert.assertEquals(3, list.size());
        Assert.assertTrue(list.contains(new Person("Carson", "Busses", 25)));
        Assert.assertTrue(list.contains(new Person("Anne", "Derri ", 14)));
        Assert.assertTrue(list.contains(new Person("Howie", "Kisses", 23)));
    }
}
