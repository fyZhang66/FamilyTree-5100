package familyTree;

import java.util.HashMap;

public class FamilyTree {
    private Person[] parents;
    private static HashMap<String, Person> familyMembers;

    public void initFamilyTree() {
        familyMembers = new HashMap<>();
        Person John = new Person("John");
        Person Mary = new Person("Mary");
        Person Alice = new Person("Alice");
        Person James = new Person("James");
        Person Olivia = new Person("Olivia");
        Person Peter = new Person("Peter");
        Person Sarah = new Person("Sarah");
        John.addChild(Mary);
        Mary.addChild(Alice);
        Alice.addChild(James);
        James.addChild(Olivia);
        John.addChild(Peter);
        Peter.addChild(Sarah);

        familyMembers.put("John", John);
        familyMembers.put("Mary", Mary);
        familyMembers.put("Alice", Alice);
        familyMembers.put("James", James);
        familyMembers.put("Olivia", Olivia);
        familyMembers.put("Peter", Peter);
        familyMembers.put("Sarah", Sarah);

        parents = new Person[]{John, Mary, Alice, James, Peter};
    }

    public Person[] getParents() {
        return parents;
    }
    public Person getFamilyMembers(String familyName) {
        return familyMembers.get(familyName);
    }
}
