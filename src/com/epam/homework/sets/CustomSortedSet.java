package com.epam.homework.sets;

/**
 * Custom set that contains no duplicate elements. Elements inside set are sorted
 * and if they don't have natural ordering they must implement <tt>Comparable</tt>
 * interface.
 * <p>Some implementations prohibit null elements and have type restrictions.
 * Attempting to add an ineligible element throws an unchecked exception, typically
 * <tt>IllegalArgumentException</tt>, <tt>ClassCastException</tt> or <tt>NullPointerException</tt>.
 *
 * @param <T> the type of elements maintained by this set
 *
 * @author  Narek Malkhasyan
 * @see CustomSortedSet
 */

public interface CustomSortedSet<T extends Comparable<T>> {


    /**
     * Returns <tt>true</tt> if this custom set does not contain the
     * specified element and element is added.
     *
     * @param item element that should be add to set
     * @return <tt>true</tt> if this set contains the specified element
     * @throws ClassCastException if the type of the specified element
     *         is incompatible with this set
     * @throws IllegalArgumentException if the specified element is null
     */
    boolean add(T item);

    /**
     * Returns <tt>true</tt> if this custom set contains the specified element.
     *
     * @param item element that should be deleted from set
     * @return <tt>true</tt> if this set contains the specified element
     * @throws ClassCastException if the type of the specified element
     *         is incompatible with this set
     * @throws IllegalArgumentException if the specified element is null
     */
    boolean remove(T item);

    /**
     * Returns <tt>true</tt> if this custom set contains the specified element.
     *
     * @param item element whose presence in this set is to be tested
     * @return <tt>true</tt> if this set contains the specified element
     * @throws ClassCastException if the type of the specified element
     *         is incompatible with this set
     * @throws IllegalArgumentException if the specified element is null
     */
    boolean contains(T item);

    /**
     * @return the number of elements in this set
     */
    int getSize();
}
