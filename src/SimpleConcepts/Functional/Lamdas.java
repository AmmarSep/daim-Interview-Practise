package SimpleConcepts.Functional;

import java.util.Locale;
import java.util.function.Function;

public class Lamdas {
    public static void main(String[] args) {

        Function<String, String> upperCaseName = name -> {if(name.isBlank())
            throw new IllegalStateException("The name is blank");
            return name.toUpperCase();
        };
        System.out.println(upperCaseName.apply("Ayshamashi"));
    }
}
