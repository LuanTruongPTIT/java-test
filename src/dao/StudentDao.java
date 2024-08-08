package dao;

import model.Student;
import model.Tutor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
  private static final String STUDENT_FILE_NAME = "student.txt";

  public void write(List<Student> studentList) {
    try (FileOutputStream fos = new FileOutputStream(STUDENT_FILE_NAME);
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {
      oos.writeObject(studentList);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public List<Student> read() {
    List<Student> studentList = new ArrayList<>();
    File file = new File(STUDENT_FILE_NAME);
    if (file.length() == 0) {
      return studentList; // Trả về danh sách rỗng nếu file rỗng
    }

    try (FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis)) {
      studentList = (List<Student>) ois.readObject();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }

    return studentList;
  }
}
