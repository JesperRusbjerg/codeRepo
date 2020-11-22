package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        SetImpl<Integer> SetImpl = new SetImpl<>(new HashSet<>(Arrays.asList(1, 2, 18, 19, 21, 22)));
        
        Set<Integer> setB;

        //Find out if a member is present in a set
        System.out.println("------------------------------------");
        System.out.println("Member");
        System.out.println(SetImpl.member(2));
        System.out.println("------------------------------------");

        setB = new HashSet<>(Arrays.asList(1, 2, 18, 22, 49, 33));

        // Set A + Set B
        System.out.println("Union");
        System.out.println(SetImpl.union(setB));
        System.out.println("------------------------------------");


        setB = new HashSet<>(Arrays.asList(1, 2, 18, 22, 266, 333));
        // What is in A AND B
        System.out.println("Intersection");
        System.out.println(SetImpl.intersection(setB));
        System.out.println("------------------------------------");

        setB = new HashSet<>(Arrays.asList(1, 2, 18, 24));

        // A - B
        System.out.println("Diffrence");
        System.out.println(SetImpl.diffrence(setB));
        System.out.println("------------------------------------");

        Set<Integer> universe = new HashSet<>(Arrays.asList(1, 2, 18, 66, 44, 33, 63465, 1243124, 343, 3123, 55, 6666));

        System.out.println("Complement");
        System.out.println(SetImpl.complement(universe));
        System.out.println("------------------------------------");

        setB = new HashSet<>(Arrays.asList(1, 2, 18, 19, 22, 21));
        System.out.println("------------------------------------");

        System.out.println("SubsetOrEquality");
        System.out.println(SetImpl.subsetOrEquality(setB));
        System.out.println("------------------------------------");


    }
}
