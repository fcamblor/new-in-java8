package org.isk.lambda.functions;

import java.util.ArrayList;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * List defining methods using Functional Interfaces, 
 *  - from java.util.function package - as arguments.
 * @author Yohan Beschi
 */
public class FunctionsList<E> extends ArrayList<E> {
    /**
     * @see ArrayList#forEach
     * @param consumer 
     */
    public void foreach(final Consumer<E> consumer) {
        for(E e : this) {
            consumer.accept(e);
        }
    }
    
    /**
     * @see Stream#filter
     * @param predicate
     * @return 
     */
    public FunctionsList<E> filter(final Predicate<E> predicate) {
        final FunctionsList<E> list = new FunctionsList<>();
        
        for(E e : this) {
            if (predicate.test(e)) {
                list.add(e);
            }
        }
        
        return list;
    }
    
    /**
     * @see Stream#map
     * @param <R>
     * @param function
     * @return 
     */
    public <R> FunctionsList<R> map(final Function<E, R> function) {
        final FunctionsList<R> list = new FunctionsList<>();
        
        for(E e : this) {
            list.add(function.apply(e));
        }
        
        return list;
    }
    
    /**
     * @see Stream#reduce
     * @param identity
     * @param binaryOperator
     * @return 
     */
    public E reduce(final E identity, final BinaryOperator<E> binaryOperator) {
        E result = identity;
        for(E e : this) {
            result = binaryOperator.apply(result, e);
        }
        
        return result;
    }
}
