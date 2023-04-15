package FrequentInterviewPrograms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class EmplSort {
    public String name;
    public int age;

    public EmplSort(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "EmplSort{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        List<EmplSort> employeeList = new ArrayList<>();
        employeeList.add(new EmplSort("Niyaz", 21));
        employeeList.add(new EmplSort("Raez", 32));
        employeeList.add(new EmplSort("Siha", 53));
        employeeList.add(new EmplSort("Lafir", 23));
        employeeList.add(new EmplSort("Sabiq", 32));
        employeeList.add(new EmplSort("Lafir", 33));
        System.out.println("Before sorting");
        for(EmplSort e : employeeList){
            System.out.println(e);
        }
        employeeList.sort(Comparator.comparing(EmplSort::getName).thenComparing(EmplSort::getAge));
        System.out.println("After sorting");
        for(EmplSort s : employeeList){
            System.out.println(s);
        }
    }
}
