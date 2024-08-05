package dao;

import model.Tutor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Lớp này để Đọc/ghi file đối tượng gia sư (tutor)
public class TutorDao {
  private static final String TUTOR_FILE_NAME = "tutor.txt";

  public void write(List<Tutor> tutorList) {
    FileOutputStream fos = null;
    ObjectOutputStream oos = null;
    try {
      fos = new FileOutputStream(new File(TUTOR_FILE_NAME));
      oos = new ObjectOutputStream(fos);
      oos.writeObject(tutorList);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      closeStream(fos);
      closeStream(oos);
    }
  }

  public List<Tutor> read() {
    List<Tutor> tutorList = new ArrayList<>();
    File file = new File(TUTOR_FILE_NAME);
    if (!file.exists()) {
      try {
        file.createNewFile(); // Tạo tệp mới nếu chưa tồn tại
      } catch (IOException e) {
        e.printStackTrace();
      }
      return tutorList; // Trả về danh sách trống nếu tệp không tồn tại
    }

    FileInputStream fis = null;
    ObjectInputStream ois = null;
    try {
      fis = new FileInputStream(file);
      ois = new ObjectInputStream(fis);
      tutorList = (List<Tutor>) ois.readObject();
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
    return tutorList;
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
