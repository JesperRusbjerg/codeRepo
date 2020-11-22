package com.company;

import java.util.*;

public class SetImpl<T extends Comparable<T>> implements ISet<T> {

    private Set<T> set;

    public SetImpl(Set<T> set) {
        this.set = set;
    }

    @Override
    public boolean member(T member) {
        return set.contains(member);
    }

    @Override
    public Set<T> union(Set<T> setB) {

        Iterator<T> itrset = set.iterator();
        Iterator<T> itrSetB = setB.iterator();

        Set<T> res = new HashSet<>();

        do {
            if (itrset.hasNext()) {
                res.add(itrset.next());
            }
            if (itrSetB.hasNext()) {
                res.add(itrSetB.next());
            }
        } while (itrset.hasNext() || itrSetB.hasNext());

        return res;

    }

    @Override
    public Set<T> intersection(Set<T> setB) {

        Iterator<T> itrOne = set.iterator();
        Set<T> res = new HashSet<>();

        while (itrOne.hasNext()) {
            T next = itrOne.next();
            if (setB.contains(next)) {
                res.add(next);
            }
        }
        return res;
    }

    @Override
    //Its A-B, so we want everything thats in set A but not be
    public Set<T> diffrence(Set<T> setB) {

        Iterator<T> itrset = set.iterator();
        Set<T> res = new HashSet<>();

        while (itrset.hasNext()) {
            T itemA = itrset.next();
            if (!setB.contains(itemA)) {
                res.add(itemA);
            }
        }
        return res;
    }

    @Override
    //The universe is the outer part, everything in A has to be removed from the universe
    public Set<T> complement(Set<T> universe) {

        for (T t : set) {
            universe.remove(t);
        }

        return universe;
    }

    @Override
    //Checking if A is subset of B, or if B is a subset of A
    //Checking to see if they are equal
    //And also if its a infinite set, which makes it undeterminable
    public int subsetOrEquality(Set<T> setB) {

        boolean aSubsetofB = true;
        boolean bSubsetofA = true;


        Iterator<T> itrA = set.iterator();
        Iterator<T> itrB = setB.iterator();

        while (true) {

            T itemA = itrA.next();
            T itemB = itrB.next();

            if (!set.contains(itemB)) {
                bSubsetofA = false;
            }
            if (!setB.contains(itemA)) {
                aSubsetofB = false;
            }

            if (!itrA.hasNext() || !itrB.hasNext()) {
                if (!itrA.hasNext() && !itrB.hasNext() && aSubsetofB && bSubsetofA) {
                    return 0;
                }
                if (itrA.hasNext()) {
                    aSubsetofB = false;
                } else if (itrB.hasNext()) {
                    bSubsetofA = false;
                }
                break;
            }

        }

        if (!aSubsetofB && !bSubsetofA) return -2;

        if (aSubsetofB) return -1;
        if (bSubsetofA) return 1;

        return 2;
    }

}
