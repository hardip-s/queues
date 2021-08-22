package com.org.queue.app;

import java.util.List;

public class StreamTest {
  public static void main(String[] args) {
      TestFunctionalProgramming functionalProgrammin=new TestFunctionalProgramming();
  }
       /* List<Company> companies = Arrays.asList(
                new Company(Arrays.asList(new Person("Jon Skeet"), new Person("Linus Torvalds"))),
                new Company(Arrays.asList(new Person("Dennis Ritchie"), new Person("Bjarne Stroustrup"))),
                new Company(Arrays.asList(new Person("James Gosling"), new Person("Patrick Naughton")))
        );

        List<String> persons = companies.stream()
                .flatMap(company -> company.getPersons().stream())
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println(persons);
    }*/

    // check




}

class TestFunctionalProgramming {

    public TestFunctionalProgramming() {
        List<Student> classRoom1 = List.of(new Student("David", "Harvey", GENDER.MALE), new Student("Jacob", "Smith",GENDER.MALE), new Student("Ben","Garreths",GENDER.MALE));
        List<Student> classRoom2 = List.of(new Student("Anne", "Muley",GENDER.FEMALE), new Student("Dan", "Terry",GENDER.MALE), new Student("Gwen","White",GENDER.MALE));
        List<Student> classRoom3 = List.of(new Student("Abe", "Washington",GENDER.FEMALE), new Student("Sharron", "Nedson",GENDER.FEMALE));

        List<List<Student>> classes = List.of(classRoom1, classRoom2, classRoom3);
        /*String danLastName = classes.stream()
                .flatMap(croom -> croom.stream()) // returns a single Stream<Student>
                .filter(student -> student.getFirstName().equals("Dan"))
                .findFirst()
                .get()
                .getLastName();
                System.out.println(danLastName);
*/


        String AbeLastName = classes.stream()
                .flatMap(classroom->classroom.stream())
                .filter(student -> student.getFirstName().equals("Abe"))
                .findFirst()
                .orElseGet(() -> new Student("Default","Default",GENDER.FEMALE))
                .getLastName();
        System.out.println(AbeLastName);


    }

}

class Student{
    private String firstName;
    private String lastName;
    private GENDER gender;

    public Student(String firstName, String lastName, GENDER gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }
}


enum GENDER{
    MALE,FEMALE
}