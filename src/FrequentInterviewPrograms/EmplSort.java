package FrequentInterviewPrograms;

import CopyPastedPrograms.EmployeeSort;

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
        List<EmployeeSort> employeeList = new ArrayList<>();
        employeeList.add(new EmployeeSort("Niyaz", 21));
        employeeList.add(new EmployeeSort("Raez", 32));
        employeeList.add(new EmployeeSort("Siha", 53));
        employeeList.add(new EmployeeSort("Lafir", 23));
        employeeList.add(new EmployeeSort("Sabiq", 32));
        employeeList.add(new EmployeeSort("Lafir", 33));
        for(EmployeeSort e : employeeList){
            System.out.println("Before sorting" +e);
        }
        employeeList.sort(Comparator.comparing(EmployeeSort::getName).thenComparing(EmployeeSort::getAge));
        System.out.println(employeeList);
        for(EmployeeSort s : employeeList){
            System.out.println(s);
        }
    }
}
