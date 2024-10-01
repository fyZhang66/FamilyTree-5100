package familyTree;

import java.util.ArrayList;


public class Person {
    private String name;
    ArrayList<Person> children;

    public Person(String name) {
        this.name = name;
        this.children = new ArrayList<Person>();
    }

    public void addChild(Person child) {
        children.add(child);
    }

    // Override the toString method to print the person's name
    @Override
    public String toString() {
        return "Person{name='" + name + "'}";
    }
}
