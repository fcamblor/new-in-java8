package org.isk.lambda.sams;

import org.isk.lambda.beans.Person;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * List defining a method using a custom Functional Interface.
 * @author Yohan Beschi
 */
public class SamsList extends ArrayList<Person> {

    /**
     * @see Stream#filter
     * @param samPredicate
     * @return 
     */
    public SamsList getSubList(final SamPredicate<Person> samPredicate) {
        final SamsList list = new SamsList();

        for (Person p : this) {
            if (samPredicate.test(p)) {
                list.add(p);
            }
        }

        return list;
    }
}
