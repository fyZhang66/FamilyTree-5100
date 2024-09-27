package familyTree;

import java.util.ArrayList;

public class RelationshipTester {
    private static Person[] parents;

    public RelationshipTester(Person[] parents) {
        this.parents = parents;
    }
    // Test Ancestor
    public boolean Ancestor(Person ancestor, Person descendant) {
        if (ancestor.children.contains(descendant)) {
            return true;
        }
        for (Person child : ancestor.children) {
            if (Ancestor(child, descendant)) return true;
        }
        return false;
    }
    // Test GrandParent relationship
    public boolean GrandParent(Person p1, Person p2) {
        for (Person p : p1.children) {
            if (p.children.contains(p2)) return true;
        }
        return false;
    }
    // Test Sibling relationship
    public boolean Sibling(Person p1, Person p2) {
        for (Person p : parents) {
            if (p.children.contains(p2) && p.children.contains(p1)) return true;
        }
        return false;
    }
    // Test Cousin relationship
    public boolean Cousin(Person p1, Person p2) {
        // collect p1 and p2's parents.
        ArrayList<Person> p1Parent = new ArrayList<>();
        ArrayList<Person> p2Parent = new ArrayList<>();
        for (Person parent : parents) {
            if (parent.children.contains(p1)) {
                p1Parent.add(parent);
            }
            if (parent.children.contains(p2)) {
                p2Parent.add(parent);
            }
        }
        // if their parent are Sibling then they are Cousin
        for (Person parent : p1Parent) {
            for (Person parent2 : p2Parent) {
                if (Sibling(parent, parent2)) return true;
            }
        }
        return false;
    }


}
