package module;



import dao.TutorDao;
import helper.SortTutorByHourlyRate;
import helper.SortTutorByName;
import model.Tutor;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TutorManager {
  public static Scanner scanner = new Scanner(System.in);
  private List<Tutor> tutorList;
  private TutorDao tutorDao;

  public TutorManager() {
    tutorDao = new TutorDao();
    tutorList = tutorDao.read();
  }

  public void add() {
    int id = (tutorList.size() > 0) ? (tutorList.size() + 1) : 1;
    System.out.println("tutor id = " + id);
    String fullName = inputFullName();
    byte experienceYears = inputExperienceYears();
    String subject = inputSubject();
    float hourlyRate = inputHourlyRate();
    Tutor tutor = new Tutor(id, fullName, experienceYears, subject, hourlyRate);
    tutorList.add(tutor);
    tutorDao.write(tutorList);
  }

  public void edit(int id) {
    boolean isExisted = false;
    int size = tutorList.size();
    for (int i = 0; i < size; i++) {
      if (tutorList.get(i).getTutorId() == id) {
        isExisted = true;
        tutorList.get(i).setFullName(inputFullName());
        tutorList.get(i).setExperienceYears(inputExperienceYears());
        tutorList.get(i).setSubject(inputSubject());
        tutorList.get(i).setHourlyRate(inputHourlyRate());
        break;
      }
    }
    if (!isExisted) {
      System.out.printf("id = %d not existed.\n", id);
    } else {
      tutorDao.write(tutorList);
    }
  }

  public void delete(int id) {
    Tutor tutor = null;
    int size = tutorList.size();
    for (int i = 0; i < size; i++) {
      if (tutorList.get(i).getTutorId() == id) {
        tutor = tutorList.get(i);
        break;
      }
    }
    if (tutor != null) {
      tutorList.remove(tutor);
      tutorDao.write(tutorList);
    } else {
      System.out.printf("id = %d not existed.\n", id);
    }
  }

  public void sortTutorByName() {
    Collections.sort(tutorList, new SortTutorByName());
  }

  public void sortTutorByHourlyRate() {
    Collections.sort(tutorList, new SortTutorByHourlyRate());
  }

  public void show() {
    for (Tutor tutor : tutorList) {
      System.out.format("%5d | ", tutor.getTutorId());
      System.out.format("%20s | ", tutor.getFullName());
      System.out.format("%5d | ", tutor.getExperienceYears());
      System.out.format("%20s | ", tutor.getSubject());
      System.out.format("%10.2f%n", tutor.getHourlyRate());
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

  /**
   * input tutor full name
   *
   * @return tutor full name
   */
  private String inputFullName() {
    System.out.print("Input tutor full name: ");
    return scanner.nextLine();
  }

  /**
   * input tutor experience years
   *
   * @return tutor experience years
   */
  private byte inputExperienceYears() {
    System.out.print("Input tutor experience years: ");
    while (true) {
      try {
        byte experienceYears = Byte.parseByte(scanner.nextLine());
        if (experienceYears < 0 || experienceYears > 100) {
          throw new NumberFormatException();
        }
        return experienceYears;
      } catch (NumberFormatException ex) {
        System.out.print("invalid! Input tutor experience years again: ");
      }
    }
  }

  private String inputSubject() {
    System.out.print("Input tutor subject: ");
    return scanner.nextLine();
  }

  private float inputHourlyRate() {
    System.out.print("Input tutor hourly rate: ");
    while (true) {
      try {
        float hourlyRate = Float.parseFloat(scanner.nextLine());
        if (hourlyRate < 0.0f) {
          throw new NumberFormatException();
        }
        return hourlyRate;
      } catch (NumberFormatException ex) {
        System.out.print("invalid! Input tutor hourly rate again: ");
      }
    }
  }

  // getter && setter
  public List<Tutor> getTutorList() {
    return tutorList;
  }

  public void setTutorList(List<Tutor> tutorList) {
    this.tutorList = tutorList;
  }
}
