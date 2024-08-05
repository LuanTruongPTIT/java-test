package helper;

import model.Tutor;

import java.util.Comparator;

// Lớp này dùng để sắp xếp học sinh theo tên sắp xếp
// từ interface Comparator override phương thức compare(theo tính chất kế thừa của hướng đối tượng)
public class SortTutorByHourlyRate implements Comparator<Tutor> {
  @Override
  public int compare(Tutor tutor1, Tutor tutor2) {
    if (tutor1.getHourlyRate() > tutor2.getHourlyRate()) {
      return 1;
    } else if (tutor1.getHourlyRate() < tutor2.getHourlyRate()) {
      return -1;
    } else {
      return 0;
    }
  }
}