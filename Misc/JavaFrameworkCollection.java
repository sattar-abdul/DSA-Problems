package Misc;

import java.util.LinkedList; // JFC

public class JavaFrameworkCollection {
    public static void main(String[] args){

        //create
        LinkedList<Integer> list = new LinkedList<>();

        //add
        list.add(10);
        list.add(20);
        list.addLast(30);

        //access
        System.out.println(list);

        //remove
        list.remove(1);
        System.out.println(list);

    }
    
}
