package helper;

import model.Student;

import java.util.Comparator;
// Lớp này dùng để sắp xếp học sinh theo điểm (GPA) kế thừa
// từ interface Comparator override phương thức compare(theo tính chất kế thừa của hướng đối tượng)
public class SortStudentByGPA implements Comparator<Student> {
  @Override
  public int compare(Student student1, Student student2) { // dùng để so sánh để sắp xếp đối tượng
    if (student1.getGpa() > student2.getGpa()) {
      return 1;
    }
    return -1;
  }
}