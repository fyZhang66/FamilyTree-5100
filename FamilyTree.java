import java.util.*;

public class FamilyTree {
    // Map to store parent to children relationships
    private Map<String, List<String>> parentToChildren;
    // Map to store child to parents relationships (for easy lookup)
    private Map<String, List<String>> childToParents;

    public FamilyTree() {
        parentToChildren = new HashMap<>();
        childToParents = new HashMap<>();
    }

    // Method to add a parent-child relationship
    public void addParentChild(String parent, String child) {
        parentToChildren.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);
        childToParents.computeIfAbsent(child, k -> new ArrayList<>()).add(parent);
    }

    // Method to check if 'ancestor' is an ancestor of 'descendant'
    public boolean isAncestor(String ancestor, String descendant) {
        if (!parentToChildren.containsKey(ancestor)) {
            return false;
        }
        for (String child : parentToChildren.get(ancestor)) {
            if (child.equals(descendant)) {
                return true;
            }
            if (isAncestor(child, descendant)) {
                return true;
            }
        }
        return false;
    }

    // Method to check if 'grandparent' is a grandparent of 'grandchild'
    public boolean isGrandparent(String grandparent, String grandchild) {
        if (!parentToChildren.containsKey(grandparent)) {
            return false;
        }
        for (String child : parentToChildren.get(grandparent)) {
            if (parentToChildren.containsKey(child)) {
                if (parentToChildren.get(child).contains(grandchild)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Method to check if two persons are siblings
    public boolean isSibling(String person1, String person2) {
        if (!childToParents.containsKey(person1) || !childToParents.containsKey(person2)) {
            return false;
        }
        List<String> parents1 = childToParents.get(person1);
        List<String> parents2 = childToParents.get(person2);
        for (String parent : parents1) {
            if (parents2.contains(parent) && !person1.equals(person2)) {
                return true;
            }
        }
        return false;
    }

    // Method to check if two persons are cousins
    public boolean isCousin(String person1, String person2) {
        if (!childToParents.containsKey(person1) || !childToParents.containsKey(person2)) {
            return false;
        }

        List<String> parents1 = childToParents.get(person1);
        List<String> parents2 = childToParents.get(person2);

        for (String parent1 : parents1) {
            for (String parent2 : parents2) {
                if (isSibling(parent1, parent2)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        FamilyTree family = new FamilyTree();

        // 添加父母关系
        family.addParentChild("John", "Mary");
        family.addParentChild("Mary", "Alice");
        family.addParentChild("Alice", "James");
        family.addParentChild("James", "Olivia");
        family.addParentChild("John", "Peter");
        family.addParentChild("Peter", "Sarah");


        // test cases

        // Grandparent(John, Olivia)
        // Parent(John, Mary) and Parent(Mary, Alice) and Parent(Alice, James) and Parent(James, Olivia)
        // Thus, John is great-grandparent of Olivia, not grandparent
        System.out.println("Is John a grandparent of Olivia? " + family.isGrandparent("John", "Olivia")); // false

        // Ancestor(John, Olivia)
        System.out.println("Is John an ancestor of Olivia? " + family.isAncestor("John", "Olivia")); // true

        // Cousin(Olivia, Sarah)
        // Olivia's parent: James
        // Sarah's parent: Peter
        // James and Peter are not siblings (parents of James: Alice; parents of Peter: John)
        System.out.println("Are Olivia and Sarah cousins? " + family.isCousin("Olivia", "Sarah")); // false

        // Sibling(Alice, Peter)
        // According to facts:
        // Parent(Mary, Alice) and Parent(John, Peter)
        // Unless Mary and John are the same, which they are not
        // Thus, they are not siblings
        System.out.println("Are Alice and Peter siblings? " + family.isSibling("Alice", "Peter")); // false

        // 更多测试
        System.out.println("Is Mary an ancestor of James? " + family.isAncestor("Mary", "James")); // true
        System.out.println("Is Alice an ancestor of Olivia? " + family.isAncestor("Alice", "Olivia")); // true
        System.out.println("Is Peter an ancestor of Olivia? " + family.isAncestor("Peter", "Olivia")); // false

    }
}
