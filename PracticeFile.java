import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
interface Drawable{
    public void draw();
}

interface Sayable{
    void say(String name);
}

class StringConsumerImpl implements Consumer<String>{
    @Override
    public void accept(String str) {
        System.out.println("Value: "+str);
    }
}

public class PracticeFile {
    public static void main(String args[]){
//        int n=3;
//        char ch='A';
//        for(int i=0;i<n;i++){
//            ch += i;
//            for(int j=0;j<=i;j++){
//                System.out.print(ch+" ");
//            }
//            System.out.println();
//        }
//		if(args.length>0){
//			System.out.println(args[0]);
//		}

//        int a = 10,b = 0;
//
//        try{
//            int c = a/b;
//        }catch (ArithmeticException e){
//            System.out.println(e);
//            System.out.println(e.getMessage());
//            System.out.println(e.toString());
//            System.out.println(e.getCause());
//        }

//        Drawable d1 = () -> {
//            System.out.println("First implementation");
//        };
//
//        Drawable d2 = () -> {
//            System.out.println("Second implementation");
//        };
//
//        d1.draw();
//        d2.draw();
//
//        Sayable say1 = myName ->
//            System.out.println("First Name is "+myName);
//
//
//        Sayable say2 = (myName) -> {
//            System.out.println("Last name is "+myName);
//        };
//
//        say1.say("Pradeep");
//        say2.say("Yadav");


//        List<Person> personList = new ArrayList<>();
//        personList.add(new Person("Pradeep",25));
//        personList.add(new Person("Abc",20));
//        personList.add(new Person("Xyz",18));
//
//        System.out.println("Before sorting");
//        System.out.println(personList);
//
//        Comparator<Person> c = (p1,p2)->{
//            return p1.getAge() - p2.getAge();
//        };
//
//        Collections.sort(personList,c);
//
//        System.out.println("After sorting");
//        System.out.println(personList);

        /* Consumer interface example*/
        List<String> list = new ArrayList<>();
        list.add("Pradeep");
        list.add("Kumar");
        list.add("Yadav");

        System.out.println("First way-------");
        list.forEach(string -> System.out.println("Value: "+string));

        System.out.println("Second way------");
        Consumer<String> stringConsumer = string -> System.out.println("Value: "+string);
        list.forEach(stringConsumer);

        System.out.println("Third way------");
        Consumer<String> consumer = new StringConsumerImpl();
        for (String string:list) {
            consumer.accept(string);
        }

        System.out.println();

        /* Supplier interface example*/
        Supplier<LocalDateTime> dateTimeSupplier = ()->{
                                        LocalDateTime dateTime = LocalDateTime.now();
                                        System.out.println(dateTime);
                                        return dateTime;
                            };

        dateTimeSupplier.get();

        //New line
        System.out.println();

        //Create a stream using builder() method
        Stream<String> build = Stream.<String>builder().add("Hi").add("Me").build();

        //Stream practice
        Stream<String> stream = list.stream();
        long count = stream.filter(element->element.contains("dav")).count();
        System.out.println("Number of elements in stream: "+count);
//        stream.count();  //can't reuse again after terminal operation

        System.out.println("map() method use------");
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,"Pradeep","IT"));
        employeeList.add(new Employee(2,"TheDog","Bark"));
        employeeList.add(new Employee(3,"TheDog2","Bark"));
        employeeList.add(new Employee(4,"TheCat","Meow"));
        employeeList.add(new Employee(5,"TheBee","Fly..."));
        System.out.println("Employees: "+employeeList);

        List<String> dept = employeeList.stream().map(emp->emp.getDepartment()).distinct().collect(Collectors.toList());
        System.out.println("Used map() method to get department stream");
        System.out.println("Distinct department: "+dept);

        System.out.println(employeeList.stream().skip(2).collect(Collectors.toList()));


        



    }
}

class Employee{
    private int empId;
    private String name;
    private String department;

    public Employee(){

    }

    public Employee(int empId, String name, String department) {
        this.empId = empId;
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

class Person{
    private String name;
    private int age;

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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


}
