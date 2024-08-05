package module;

import dao.StudentDao;
import helper.SortStudentByGPA;
import helper.SortStudentByName;
import model.Student;
import java.io.*;
import java.util.*;

public class StudentManager {
  public static Scanner scanner = new Scanner(System.in);
  private List<Student> studentList;
  private StudentDao studentDao;

  public StudentManager() {
    // constructor
    studentDao = new StudentDao();
    studentList = studentDao.read();
  }

  public void add() {
    int id = (studentList.size() > 0) ? (studentList.size() + 1) : 1;
    System.out.println("student id = " + id);
    String name = inputName();
    byte age = inputAge();
    String address = inputAddress();
    float gpa = inputGpa();
    Student student = new Student(id, name, age, address, gpa);
    studentList.add(student);
    studentDao.write(studentList);
  }

  public void edit(int id) {
    boolean isExisted = false;
    int size = studentList.size();
    for (int i = 0; i < size; i++) {
      if (studentList.get(i).getId() == id) {
        isExisted = true;
        studentList.get(i).setName(inputName());
        studentList.get(i).setAge(inputAge());
        studentList.get(i).setAddress(inputAddress());
        studentList.get(i).setGpa(inputGpa());
        break;
      }
    }
    if (!isExisted) {
      System.out.printf("id = %d not existed.\n", id);
    } else {
      studentDao.write(studentList);
    }
  }

  public void delete(int id) {
    Student student = null;
    int size = studentList.size();
    for (int i = 0; i < size; i++) {
      if (studentList.get(i).getId() == id) {
        student = studentList.get(i);
        break;
      }
    }
    if (student != null) {
      studentList.remove(student);
      studentDao.write(studentList);
    } else {
      System.out.printf("id = %d not existed.\n", id);
    }
  }

  public void sortStudentByName() {
    Collections.sort(studentList, new SortStudentByName());
  }

  public void sortStudentByGPA() {
    Collections.sort(studentList, new SortStudentByGPA());
  }

  public void show() {
    for (Student student : studentList) {
      System.out.format("%5d | ", student.getId());
      System.out.format("%20s | ", student.getName());
      System.out.format("%5d | ", student.getAge());
      System.out.format("%20s | ", student.getAddress());
      System.out.format("%10.1f%n", student.getGpa());
    }
  }

  public Student searchById(int id) {
    for (Student student : studentList) {
      if (student.getId() == id) {
        return student;
      }
    }
    System.out.printf("id = %d not existed.\n", id);
    return null;
  }

  public List<Student> searchByName(String name) {
    List<Student> result = new ArrayList<>();
    for (Student student : studentList) {
      if (student.getName().toLowerCase().contains(name.toLowerCase())) {
        result.add(student);
      }
    }
    if (result.isEmpty()) {
      System.out.printf("No students found with name = %s.\n", name);
    }
    return result;
  }

  public double calculateAverageGpa() {
    if (studentList.isEmpty()) {
      return 0.0;
    }
    double totalGpa = 0;
    for (Student student : studentList) {
      totalGpa += student.getGpa();
    }
    return totalGpa / studentList.size();
  }

  public void exportToFile(String filename) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
      for (Student student : studentList) {
        writer.write(student.getId() + "," + student.getName() + "," + student.getAge() + ","
          + student.getAddress() + "," + student.getGpa());
        writer.newLine();
      }
      System.out.println("Data exported to " + filename);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private String inputName() {
    System.out.print("Input student name: ");
    return scanner.nextLine();
  }

  private String inputAddress() {
    System.out.print("Input student address: ");
    return scanner.nextLine();
  }

  private byte inputAge() {
    System.out.print("Input student age: ");
    while (true) {
      try {
        byte age = Byte.parseByte(scanner.nextLine());
        if (age < 0 || age > 100) {
          throw new NumberFormatException();
        }
        return age;
      } catch (NumberFormatException ex) {
        System.out.print("invalid! Input student age again: ");
      }
    }
  }

  private float inputGpa() {
    System.out.print("Input student gpa: ");
    while (true) {
      try {
        float gpa = Float.parseFloat(scanner.nextLine());
        if (gpa < 0.0f || gpa > 10.0f) {
          throw new NumberFormatException();
        }
        return gpa;
      } catch (NumberFormatException ex) {
        System.out.print("invalid! Input student gpa again: ");
      }
    }
  }

  public int inputId() {
    System.out.print("Input tutor id: ");
    while (true) {
      try {
        int id = Integer.parseInt(scanner.nextLine());
        return id;
      } catch (NumberFormatException ex) {
        System.out.print("invalid! Input tutor id again: ");
      }
    }
  }
  public List<Student> getStudentList() {
    return studentList;
  }

  public void setStudentList(List<Student> studentList) {
    this.studentList = studentList;
  }
}
