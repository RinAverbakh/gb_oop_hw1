public class Main {
    public static void main(String[] args) {
        FamilyTree ft = new FamilyTree();

        Person p1 = new Person("Ivan", "Ivanov", "male", 20);
        Person p2 = new Person("Olga", "Ivanova", "female", 40);
        Person p3 = new Person("Maxim", "Ivanov", "male", 18);
        Person p4 = new Person("Marina", "Ivanova", "female", 1);

        p1.setParent(p2);
        p3.setParent(p2);
        p4.setParent(p1);
        p1.addChild(p4);

        ft.addPerson(p1);
        ft.addPerson(p2);
        ft.addPerson(p3);
        ft.addPerson(p4);

        for (Person p : ft.getPersons()) {
            System.out.println(p.toString());
        }

        
    }
}
