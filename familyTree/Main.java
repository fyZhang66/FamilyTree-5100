package familyTree;

public class Main {
    public static void main(String[] args) {
        FamilyTree ft = new FamilyTree();
        ft.initFamilyTree();
        Person[] parents = ft.getParents();
        RelationshipTester tester = new RelationshipTester(parents);

        System.out.println("----Testing if John is grandParent of Alice----");
        System.out.println(tester.GrandParent(ft.getFamilyMembers("John"), ft.getFamilyMembers("Alice")));
        System.out.println("----Testing if Mary is Sibling of Peter----");
        System.out.println(tester.Sibling(ft.getFamilyMembers("Mary"), ft.getFamilyMembers("Peter")));
        System.out.println("----Testing if Alice is Cousin of Sarah----");
        System.out.println(tester.Cousin(ft.getFamilyMembers("Alice"), ft.getFamilyMembers("Sarah")));
        System.out.println("----Testing if John is Ancestor of Sarah----");
        System.out.println(tester.Ancestor(ft.getFamilyMembers("John"), ft.getFamilyMembers("Sarah")));
    }
}
