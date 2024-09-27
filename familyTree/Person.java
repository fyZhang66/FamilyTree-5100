package familyTree;

import java.util.LinkedList;

public class Person {
    private String name;
    LinkedList<Person> children;

    public Person(String name) {
        this.name = name;
        this.children = new LinkedList<Person>();
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
