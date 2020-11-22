package com.company;

import java.util.Set;

public interface ISet<T> {

    boolean member(T member);

    Set<T> union(Set<T> unionSetTwo);

    Set<T> intersection( Set<T> interSetTwo);

    Set<T> diffrence(Set<T> diffSetTwo);

    Set<T> complement(Set<T> complementOf);

    int subsetOrEquality(Set<T> compareTo);


}
