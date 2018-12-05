package com.codecool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    static List <Integer> select_numbers(int min, int max) {
        List<Integer> smallArray = new ArrayList<>();
        while(smallArray.size()< 5) {
            Integer number = (ThreadLocalRandom.current().nextInt(min, max));
            if(!smallArray.contains(number)) {
                smallArray.add(number);
            }
        }
        return smallArray;
    }


    static String[] getCard() {
        List<String> myList = new ArrayList<>();
        List<Integer> numbers;
        String myArr[] = {"B", "I", "N", "G", "O"};
        int min = 1;
        int max = 16;
        for(int i = 0 ; i < 5; i++) {
            numbers = select_numbers(min, max);
            min += 15;
            max += 15;
            for(int j = 0; j < 5; j++) {
                if(!(i == 2 & j == 2)) {
                    myList.add(myArr[i] + numbers.get(j));
                }
            }

            numbers.clear();

        }
        return myList.toArray(new String[0]);


    }
    public static void main(String[] args) {
        for(String s : getCard()){
            System.out.println(s);
        }

    }
}
