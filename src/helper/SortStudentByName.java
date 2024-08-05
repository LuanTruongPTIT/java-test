package helper;

import model.Student;

import java.util.Comparator;

// Lớp này dùng để sắp xếp học sinh theo tên kế thừa
// từ interface Comparator override phương thức compare(theo tính chất kế thừa của hướng đối tượng)
public class SortStudentByName implements Comparator<Student> {
  @Override
  public int compare(Student student1, Student student2) {
    return student1.getName().compareTo(student2.getName());
  }
}