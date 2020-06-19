package study;

import java.io.*;
import java.util.*;

public class temp {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String temp1[] = {"a","b","c"};
        list.add(temp1[0]);
        list.add(temp1[0]);
        list.add(temp1[0]);

        String result[] = list.toArray(new String[list.size()]);

        for(String i : result) {
            System.out.println(i);
        }
    }
}
