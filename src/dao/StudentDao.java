package dao;

import model.Student;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Lớp này để Đọc/ghi file đối tượng học sinh (student)
public class StudentDao {
  private static final String STUDENT_FILE_NAME = "student.txt";

  public void write(List<Student> studentList) {
    FileOutputStream fos = null;
    ObjectOutputStream oos = null;
    try {
      fos = new FileOutputStream(new File(STUDENT_FILE_NAME));
      oos = new ObjectOutputStream(fos); // instance
      oos.writeObject(studentList);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      closeStream(fos);
      closeStream(oos);
    }
  }

  public List<Student> read() {
    List<Student> studentList = new ArrayList<>();
    File file = new File(STUDENT_FILE_NAME);
    if (!file.exists()) {
      try {
        file.createNewFile(); // Tạo tệp mới nếu chưa tồn tại
      } catch (IOException e) {
        e.printStackTrace();
      }
      return studentList; // Trả về danh sách trống nếu tệp không tồn tại
    }

    FileInputStream fis = null;
    ObjectInputStream ois = null;
    try {
      fis = new FileInputStream(file);
      ois = new ObjectInputStream(fis);
      studentList = (List<Student>) ois.readObject();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } finally {
      closeStream(fis);
      closeStream(ois);
    }
    return studentList;
  }

  private void closeStream(InputStream is) {
    if (is != null) {
      try {
        is.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private void closeStream(OutputStream os) {
    if (os != null) {
      try {
        os.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
