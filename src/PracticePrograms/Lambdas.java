package PracticePrograms;

public class Lambdas {
    public static void main(String[] args) {
Cat myCat = new Cat();
printThing(myCat);

    }
    static void printThing(Printable thing){
        thing.print();

    }
}
