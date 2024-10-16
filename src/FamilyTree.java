import java.util.ArrayList;
import java.util.List;

class Person{

    private int age;
    private String firstName, lastName, gen;
    private Person mom, dad;
    private ArrayList<Person> children;

    public Person(String name, String surname, String gender, int years){
        firstName = name;
        lastName = surname;
        gen = gender;
        age = years;
    }

    public Person(String name, String surname, String gender){
        this(name, surname, gender, 25);
    }

    public Person(String name, String surname){
        this(name, surname, "male");
    }



    public String getFullName(){
        return lastName + " " + firstName;
    }

    public String getName(){
        return firstName;
    }

    public String getSurname(){
        return lastName;
    }

    public int getAge(){
        return age;
    }

    public ArrayList<Person> getChildren(){
        return children;
    }

    public Person getMother(){
        return mom;
    }
    
    public Person getFather(){
        return dad;
    }



    public void setParent(Person person){
        if (person.getGender() == "female") mom = person;
        else if (person.getGender() == "male") dad = person;
        else System.out.println("ошибка, у родителя введён неккоректный пол");
    }

    public void addChild(Person child){
        children.add(child);
    }

    public void addChildren(List<Person> persons){
        children.addAll(persons);
    }

    

    @Override
    public String toString() {
        return "Person: " + lastName + " " + firstName + ", age: " + age + ", Mother: " + mom.getFullName() + ", Father: " + dad.getFullName() + getStringChildren();
    }



    private String getGender(){
        return gen;
    }

    private String getStringChildren(){ 
        StringBuilder sons = new StringBuilder(); 
        StringBuilder daughters = new StringBuilder();

        for (Person child : children) {
            if (gen == "male") sons.append(child.getFullName()).append(", ");
            if (gen == "female") daughters.append(child.getFullName()).append(", ");
        }

        return "sons: " + sons.delete(sons.length()-3, sons.length()-1).toString() + ", daughters: " + daughters.delete(daughters.length()-3, daughters.length()-1).toString();
    }
}

public class FamilyTree {
    private ArrayList<Person> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }



    public void addPerson(Person person){
        this.people.add(person);
    }

    public List<Person> getChildren(Person parent){
        return parent.getChildren();
    }

    public Person getMother(Person child){
        return child.getMother();
    }

    public Person getFather(Person child){
        return child.getFather();
    }

    public ArrayList<Person> getGrandparents(Person grandchild){
        ArrayList<Person> result = new ArrayList<>();
        result.add(grandchild.getFather().getFather());
        result.add(grandchild.getFather().getMother());
        result.add(grandchild.getMother().getFather());
        result.add(grandchild.getMother().getMother());
        return result;
    }

    public ArrayList<Person> getPersons(){
        return people;
    }



    public Person findPersonByName(String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public ArrayList<Person> findPersonsBySurname(String surname){
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (person.getSurname().equals(surname)){
                result.add(person);
            }
        }
        return result;
    }
    
    public boolean isBrotherOrSister (Person person1, Person person2){
        if (person1.getFather() == person2.getFather() || person1.getMother() == person2.getMother()) return true;
        return false;
    }

    public ArrayList<Person> findBrotherOrSister(Person person){
        ArrayList<Person> result = new ArrayList<>();
        for (Person human : people) {
            if(isBrotherOrSister(person, human)) result.add(human);
        } 
        return result;
    }


}
