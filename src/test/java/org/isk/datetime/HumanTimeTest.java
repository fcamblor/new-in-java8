package org.isk.datetime;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.zone.ZoneRules;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yohan Beschi
 */
public class HumanTimeTest {
    @Test
    public void constants() {
        //---- LocalDate
        // LocalDate.MIN & LocalDate.MAX 
        Assert.assertEquals("-999999999-01-01", LocalDate.MIN.toString());
        Assert.assertEquals("+999999999-12-31", LocalDate.MAX.toString());
        
        //---- LocalTime
        // LocalTime.MIN & LocalTime.MAX 
        Assert.assertEquals("00:00", LocalTime.MIN.toString());
        Assert.assertEquals("23:59:59.999999999", LocalTime.MAX.toString());
        
        // LocalTime.NOON & LocalTime.MIDNIGHT
        // There is no mention of AM and PM
        Assert.assertEquals("12:00", LocalTime.NOON.toString());
        Assert.assertEquals("00:00", LocalTime.MIDNIGHT.toString());
        
        //---- LocalDateTime
        // LocalDateTime.MIN & LocalDateTime.MAX 
        Assert.assertEquals("-999999999-01-01T00:00", LocalDateTime.MIN.toString());
        Assert.assertEquals("+999999999-12-31T23:59:59.999999999", LocalDateTime.MAX.toString());
    }
    
    @Test
    public void now() {
        //---- LocalDate
        // Current System Date
        // e.g. 2013-05-26
        System.out.println("LocalDate.now(): " + LocalDate.now());
        
        // Current UTC System Date
        // e.g. 2013-05-26
        System.out.println("LocalDate.now(Clock.systemUTC()): " + LocalDate.now(Clock.systemUTC()));
        
        //---- LocalTime
        // Current System Time
        //e.g. 21:35:45.977
        System.out.println("LocalTime.now(): " + LocalTime.now());
        
        // Current UTC System Time
        //e.g. 19:35:45.977
        System.out.println("LocalTime.now(Clock.systemUTC()): " + LocalTime.now(Clock.systemUTC()));
        
        //---- LocalDateTime
        // Current System Date and Time
        //e.g. 2013-05-26T21:35:45.977
        System.out.println("LocalDateTime.now(): " + LocalDateTime.now());
        
        // Current UTC System Date and Time
        //e.g. 2013-05-26T19:35:45.977
        System.out.println("LocalDateTime.now(Clock.systemUTC()): " + LocalDateTime.now(Clock.systemUTC()));
    } 
            
    @Test
    public void localDateStaticMethods() {
        // LocalDate from a string
        final LocalDate localDateStr = LocalDate.parse("2013-05-23");
        Assert.assertEquals("2013-05-23", localDateStr.toString());
        
        // LocalDate from 3 integers (year, month, day)
        final LocalDate localDate = LocalDate.of(2013, 05, 26);
        Assert.assertEquals("2013-05-26", localDate.toString());
        
        // LocalDate with an offset from epoch
        final LocalDate oneHundredDaysBeforeEpoch = LocalDate.ofEpochDay(-1000);
        Assert.assertEquals("1967-04-07", oneHundredDaysBeforeEpoch.toString());
        
        // Copy of a LocalDate
        final LocalDate copyLocalDate = LocalDate.from(localDate);
        Assert.assertEquals("2013-05-26", copyLocalDate.toString());
    }
    
    @Test
    public void localTimeStaticMethods() {
        // LocalTime from a string
        final LocalTime timeStr1 = LocalTime.parse("12:35");
        Assert.assertEquals("12:35", timeStr1.toString());
        
        final LocalTime timeStr2 = LocalTime.parse("12:35:32.978");
        Assert.assertEquals("12:35:32.978", timeStr2.toString());
        
        // LocalDate from 3 integers (hour, minute, second)
        // But can be 2 (hour, minute)
        // or 4 (hour, minute, second, nanoseconds)
        final LocalTime timeAsInts = LocalTime.of(10, 22, 17);
        Assert.assertEquals("10:22:17", timeAsInts.toString());
        
        // LocalTime from a number of seconds after midnight
        final LocalTime oneHourAfterMidnight = LocalTime.ofSecondOfDay(3600);
        Assert.assertEquals("01:00", oneHourAfterMidnight.toString());
        
        // Copy of a LocalTime
        final LocalTime copyLocalTime = LocalTime.from(timeAsInts);
        Assert.assertEquals("10:22:17", copyLocalTime.toString());
    }
    
    @Test
    public void localDateTimeStaticMethods() {
        // LocalDateTime from a string
        final LocalDateTime localDateTimeStr = LocalDateTime.parse("2013-05-26T10:22:17");
        Assert.assertEquals("2013-05-26T10:22:17", localDateTimeStr.toString());
        
        // LocalDate from 5 parameters (year, month, day, hour, minute, second)
        // But range from 5 to 7.
        // Note : Month is an enum.
        final LocalDateTime localDateTime = LocalDateTime.of(2013, Month.MAY, 26, 12, 05);
        Assert.assertEquals("2013-05-26T12:05", localDateTime.toString());
        
        // LocalDateTime from a LocalDate and a LocalTime
        final LocalDate localDate = LocalDate.of(2013, 05, 26);
        final LocalTime localTime = LocalTime.of(12, 35);
        final LocalDateTime localDateTimeOfDateAndTime = LocalDateTime.of(localDate, localTime);
        Assert.assertEquals("2013-05-26T12:35", localDateTimeOfDateAndTime.toString());
        
        // Copy of a LocalDateTime
        final LocalDateTime copyLocalDateTime = LocalDateTime.from(localDateTime);
        Assert.assertEquals("2013-05-26T12:05", copyLocalDateTime.toString());
    }
    
    @Test
    public void localDateInstanceMethods() {
        final LocalDate localDate = LocalDate.of(2013, 05, 26);

        // Year
        Assert.assertEquals(2013, localDate.getYear());
        
        // Month
        Assert.assertEquals(Month.MAY, localDate.getMonth());
        Assert.assertEquals(5, localDate.getMonthValue());
        
        // Day
        Assert.assertEquals(26, localDate.getDayOfMonth());
        Assert.assertEquals(DayOfWeek.SUNDAY, localDate.getDayOfWeek());
        Assert.assertEquals(146, localDate.getDayOfYear());
        
        // Leap Year
        Assert.assertFalse(localDate.isLeapYear());
        Assert.assertTrue(LocalDate.of(2004, 05, 26).isLeapYear());
                 
        //---- Operations
        final LocalDate localDate2 = LocalDate.of(2013, 04, 26);
        
        // Before, After, Equal, equals
        Assert.assertTrue(localDate.isAfter(localDate2));
        Assert.assertFalse(localDate.isBefore(localDate2));
        Assert.assertTrue(localDate.isEqual(LocalDate.of(2013, 05, 26)));
        Assert.assertTrue(localDate.equals(LocalDate.of(2013, 05, 26)));
        
        // plus & minus
        Assert.assertEquals("2013-04-26", localDate.minusMonths(1).toString());
        Assert.assertEquals("2013-06-05", localDate.plusDays(10).toString());
        
        // Adjusters
        Assert.assertEquals("2013-05-01", localDate.with(TemporalAdjuster.firstDayOfMonth()).toString());
        Assert.assertEquals("2013-05-10", localDate.withDayOfMonth(10).toString());
    }
    
    @Test
    public void localTimeInstanceMethods() {
        final LocalTime localTime = LocalTime.of(12, 35, 25, 452_367_943);
        
        // Hour, Minute, Second, Nanosecond
        Assert.assertEquals(12, localTime.getHour());
        Assert.assertEquals(35, localTime.getMinute());
        Assert.assertEquals(25, localTime.getSecond());
        Assert.assertEquals(452_367_943, localTime.getNano());
        
        //---- Operations
        // Before, After, Equal, equals
        final LocalTime localTime2 = LocalTime.of(12, 35, 25, 452_367_942);
        Assert.assertTrue(localTime.isAfter(localTime2));
        Assert.assertFalse(localTime.isBefore(localTime2));
        Assert.assertTrue(localTime.equals(LocalTime.of(12, 35, 25, 452_367_943)));
        
        /// plus & minus
        Assert.assertEquals("12:25:25.452367943", localTime.minusMinutes(10).toString());
        Assert.assertEquals("17:35:25.452367943", localTime.plusHours(5).toString());
        
        // Adjusters
        Assert.assertEquals("05:35:25.452367943", localTime.withHour(5).toString());
    }

    @Test
    public void localDateTimeInstanceMethods() {
        final LocalDate localDate = LocalDate.of(2013, 05, 26);
        final LocalTime localTime = LocalTime.of(12, 35, 25, 452_367_943);
        final LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        
        // As LocalDate & LocalTime
        Assert.assertEquals("2013-05-26", localDateTime.toLocalDate().toString());
        Assert.assertEquals("12:35:25.452367943", localDateTime.toLocalTime().toString());
        
        // Other methods are the same as for LocalDate and LocalTime
    }

    @Test
    public void zoneId() {
        final ZoneId zoneId = ZoneId.systemDefault();
        final ZoneRules zoneRules = zoneId.getRules();
        Assert.assertEquals("Europe/Paris", zoneId.toString());
        Assert.assertEquals("ZoneRules[currentStandardOffset=+01:00]", zoneRules.toString());
        
        // DST in effect
        Assert.assertTrue(zoneRules.isDaylightSavings(Instant.parse("2013-05-26T23:10:40Z")));
        Assert.assertFalse(zoneRules.isDaylightSavings(Instant.parse("2013-01-26T23:10:40Z")));
    }
    
    @Test
    public void zoneOffset() {
        final ZoneOffset zoneOffset = ZoneOffset.of("+06:00");
        Assert.assertEquals("+06:00", zoneOffset.toString());
        Assert.assertEquals(21600, zoneOffset.getTotalSeconds());
    }  
    
    @Test
    public void zonedDateTime() {
        final LocalDateTime localDateTime = LocalDateTime.parse("2013-05-26T10:22:17");
        final ZoneId zoneId = ZoneId.of("Europe/Paris");
        final ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
        Assert.assertEquals("2013-05-26T10:22:17+02:00[Europe/Paris]", zonedDateTime.toString());
        
        final ZoneOffset zoneOffset = ZoneOffset.from(zonedDateTime);
        Assert.assertEquals("+02:00", zoneOffset.toString());
    }
    
    @Test
    public void offsetDateTime() {
        final LocalDateTime localDateTime = LocalDateTime.parse("2013-05-26T10:22:17");
        final ZoneOffset zoneOffset = ZoneOffset.of("+02:00");
        final OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);
        Assert.assertEquals("2013-05-26T10:22:17+02:00", offsetDateTime.toString());
    }
}
