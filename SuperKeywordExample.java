class Parent {
    int value = 10;

    void display() {
        System.out.println("Value in Parent: " + value);
    }
}

class Child extends Parent {
    int value = 20;

    void display() {
        System.out.println("Value in Child: " + value);
        System.out.println("Value in Parent using super: " + super.value);
        super.display();
    }
}

public class SuperKeywordExample {
    public static void main(String[] args) {
        Child child = new Child();
        child.display();
    }
}
