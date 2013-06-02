package org.isk.lambda.functions;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Yohan Beschi
 */
public class FunctionsTest {
    /**
     * Test {@link FunctionsList#map}
     */
    @Test
    public void map() {
        final List<Integer> list = FunctionPersonsDB.PERSONS.map((person) -> person.getAge());
        
        Assert.assertTrue(list.contains(new Integer(25)));
        Assert.assertTrue(list.contains(new Integer(72)));
        Assert.assertTrue(list.contains(new Integer(14)));
        Assert.assertTrue(list.contains(new Integer(47)));
        Assert.assertTrue(list.contains(new Integer(50)));
        Assert.assertTrue(list.contains(new Integer(38)));
        Assert.assertTrue(list.contains(new Integer(36)));
        Assert.assertTrue(list.contains(new Integer(2)));
        Assert.assertTrue(list.contains(new Integer(23)));
        Assert.assertTrue(list.contains(new Integer(63)));
    }
    
    /**
     * Test {@link FunctionsList#foreach}
     */
    @Test
    public void foreach() {
        final AtomicInteger accumulatedAges = new AtomicInteger();
        FunctionPersonsDB.PERSONS.foreach((person) -> accumulatedAges.addAndGet(person.getAge()));
        
        Assert.assertEquals(370, accumulatedAges.get());
    }
    
    /**
     * Test {@link FunctionsList#reduce}
     */
    @Test
    public void reduce() {
        final int accumulatedAges = 
                FunctionPersonsDB.PERSONS
                    .map((person) -> person.getAge())
                    .reduce(0, (x, y) -> x + y);
        
        Assert.assertEquals(370, accumulatedAges);
    }
}