import java.util.*;

public class Test{
    
    static class Animal{
    void sound() {
        System.out.println("Animal makes sound");
    }
}

    static class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

    public static void main(String args[]){
       Dog d = new Dog();
       d.sound();
       System.out.println("");
    }
}