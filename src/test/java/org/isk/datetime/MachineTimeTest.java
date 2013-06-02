package org.isk.datetime;

import java.time.Instant;
import java.time.Duration;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yohan Beschi
 */
public class MachineTimeTest {
    @Test
    public void instant() {
        //---- Instant.EPOCH
        Assert.assertEquals("1970-01-01T00:00:00Z", Instant.EPOCH.toString());
        Assert.assertEquals(Instant.parse("1970-01-01T00:00:00Z"), Instant.EPOCH);
        Assert.assertEquals(Instant.ofEpochSecond(0), Instant.EPOCH);
        
        //---- Instant.MIN
        Assert.assertEquals(Instant.parse("-1000000000-01-01T00:00:00Z"), Instant.MIN);
        
        //---- Instant.MAX
        Assert.assertEquals(Instant.parse("+1000000000-12-31T23:59:59.999999999Z"), Instant.MAX);
        
        //---- Few instance methods
        final Instant instant = Instant.now();
        
        // prints the current time
        // e.g. 2013-05-26T21:37Z (Coordinated Universal Time)
        System.out.println("Instant.now() : " + instant);
        // print the number of nano seconds
        System.out.println("Instant.now().getNano() : " + instant.getNano());
        
        //-- Working with 2 instants
        // 2013-05-26T23:10:40Z & 1530-05-26T23:10:40Z
        final Instant instant20130526_231040 = Instant.parse("2013-05-26T23:10:40Z");
        final Instant instant15300526_231040 = Instant.parse("1530-05-26T23:10:40Z");
        
        // 2013-05-26T23:10:40Z is After 1530-05-26T23:10:40Z
        Assert.assertTrue(instant20130526_231040.isAfter(instant15300526_231040));
        
        // 2013-05-26T23:10:40Z is NOT Before 1530-05-26T23:10:40Z
        Assert.assertFalse(instant20130526_231040.isBefore(instant15300526_231040));
        
        // 2013-05-26T23:10:40Z minus 1 hour (3600s)
        Assert.assertEquals(Instant.parse("2013-05-26T22:10:40Z"), 
                            instant20130526_231040.minusSeconds(3600));
    }
    
    @Test
    public void duration() {
        //---- Duration.ZERO
        Assert.assertEquals(Duration.parse("PT0S"), Duration.ZERO);
        Assert.assertEquals("PT0S", Duration.ZERO.toString());
        
        //---- 2h 5min 30s 345ms = 7_530_345ms
        final Duration duration = Duration.ofMillis(7_530_345);
        Assert.assertEquals("PT2H5M30.345S", duration.toString());
        Assert.assertEquals(7530, duration.getSeconds());
        Assert.assertEquals(345000000, duration.getNano());
    }
}
