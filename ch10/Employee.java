package ch10;

/**
 * Created by ikirilov on 20/04/15.
 */
public class Employee extends Person {
    private String company;
    public void setCompany(String company){
        this.company = company;
    }
    public String getCompany(){
        return company;
    }

    public static void main(String[] args) {
        Student student = new Student();
        Employee employee = new Employee();
        Person person = new Person();

        person.setName("Peter_person");
        student.setName("Tom_student");
        employee.setName("John_employee");

        System.out.println(person.getName());

        person = student;

        System.out.println(person.getName());

        person = employee;

        System.out.println(person.getName());
    }
}

