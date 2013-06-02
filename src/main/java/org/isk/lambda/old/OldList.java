package org.isk.lambda.old;

import java.util.ArrayList;
import org.isk.lambda.beans.Person;

/**
 * List defining a method doing a specific - non-generic - computation, to get a sublist.
 * @author Yohan Beschi
 */
public class OldList extends ArrayList<Person> {
    
    /**
     * Get a sublist, where {@link Person#age} ranges from minAge to maxAge, both included.
     * @param minAge
     * @param maxAge
     * @return 
     */
    public OldList getSubList(final int minAge, final int maxAge) {
        final OldList list = new OldList();
        
        for (Person p : this) {
            if (p.getAge() >= minAge && p.getAge() <= maxAge) {
                list.add(p);
            }
        }
        
        return list;
    }
}
