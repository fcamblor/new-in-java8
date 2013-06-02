package org.isk.lambda.sams;

/**
 * Custom Functional Interface. 
 * @see java.util.function.Predicate
 * @author Yohan Beschi
 */
@FunctionalInterface
public interface SamPredicate<E> {
    /**
     * @see java.util.function.Predicate#test
     * @param e
     * @return 
     */
    boolean test(E e);
}
