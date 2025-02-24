import java.lang.reflect.Field;

class Persons {
    private int age;

    public Persons(int age) {
        this.age = age;
    }
}

public class AccessPrivateField{
    public static void main(String[] args) throws Exception {
        Persons person = new Persons(25);

        Class<?> cls = person.getClass();
        Field ageField = cls.getDeclaredField("age");
        ageField.setAccessible(true);

        System.out.println("Initial Age: " + ageField.get(person));

        ageField.set(person, 30);

        System.out.println("Updated Age: " + ageField.get(person));
    }
}