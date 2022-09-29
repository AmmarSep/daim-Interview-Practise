package Again2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class EmplSortComparator
{
    public String name;
    public int age;
    public EmplSortComparator(String name, int age)
    {
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
    public String toString()
    {
        return "EmplSort{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public static void main(String[] args)
    {
        List<EmplSortComparator> employeeList = new ArrayList<>();
        employeeList.add(new EmplSortComparator("Niyaz", 21));
        employeeList.add(new EmplSortComparator("Raez", 32));
        employeeList.add(new EmplSortComparator("Siha", 53));
        employeeList.add(new EmplSortComparator("Lafir", 33));
        employeeList.add(new EmplSortComparator("Sabiq", 32));
        employeeList.add(new EmplSortComparator("Lafir", 23));
        System.out.println("Before Sorting");
        for(EmplSortComparator p : employeeList)
        {
            System.out.println(p);
        }
        //Comparable interface Example:
        System.out.println("\nAfter sorting using comparable");
        Collections.sort(employeeList,(o1, o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println(employeeList);
        for(EmplSortComparator q : employeeList)
        {
            System.out.println(q);
        }
        //Comparator interface Example:
        System.out.println("\nAfter sorting using comparator");
        employeeList.sort(Comparator.comparing(EmplSortComparator::getName).thenComparing(EmplSortComparator::getAge));
        for(EmplSortComparator r : employeeList)
        {
            System.out.println(r);
        }
    }
}
