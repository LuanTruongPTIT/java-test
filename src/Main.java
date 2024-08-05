import module.StudentManager;
import module.TutorManager;

import java.util.Scanner;


public class Main {
  public static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String choose = null;
    boolean exit = false;
    boolean isStudent = true;


    StudentManager studentManager = new StudentManager();
    TutorManager tutorManager = new TutorManager();

    while (true) {

      showInitialMenu();
      choose = scanner.nextLine();

      switch (choose) {
        case "1":
          isStudent = true;
          break;
        case "2":
          isStudent = false;
          break;
        default:
          System.out.println("Invalid choice! Please choose again.");
          continue;
      }


      while (true) {
        showMenu(isStudent);
        choose = scanner.nextLine();

        if (isStudent) {
          switch (choose) {
            case "1":
              studentManager.add();
              break;
            case "2":
              int studentId = studentManager.inputId();
              studentManager.edit(studentId);
              break;
            case "3":
              studentId = studentManager.inputId();
              studentManager.delete(studentId);
              break;
            case "4":
              studentManager.sortStudentByGPA();
              break;
            case "5":
              studentManager.sortStudentByName();
              break;
            case "6":
              studentManager.show();
              break;
            case "0":
              System.out.println("Returning to entity selection...");
              break;
            default:
              System.out.println("Invalid! Please choose an action from the menu.");
              continue;
          }
        } else {
          switch (choose) {
            case "1":
              tutorManager.add();
              break;
            case "2":
              int tutorId = tutorManager.inputId();
              tutorManager.edit(tutorId);
              break;
            case "3":
              tutorId = tutorManager.inputId();
              tutorManager.delete(tutorId);
              break;
            case "4":
              tutorManager.sortTutorByHourlyRate();
              break;
            case "5":
              tutorManager.sortTutorByName();
              break;
            case "6":
              tutorManager.show();
              break;
            case "0":
              System.out.println("Returning to entity selection...");
              break;
            default:
              System.out.println("Invalid! Please choose an action from the menu.");
              continue;
          }
        }
        if (choose.equals("0")) {
          break;
        }
      }

      // Check if user wants to exit
      if (choose.equals("0") && exit) {
        System.out.println("Exited!");
        break;
      }
    }
  }

  public static void showInitialMenu() {
    System.out.println("Choose entity type:");
    System.out.println("1. Student");
    System.out.println("2. Tutor");
    System.out.print("Please choose: ");
  }

  public static void showMenu(boolean isStudent) {
    if (isStudent) {
      System.out.println("-----------Student Menu------------");
      System.out.println("1. Add student.");
      System.out.println("2. Edit student by id.");
      System.out.println("3. Delete student by id.");
      System.out.println("4. Sort student by gpa.");
      System.out.println("5. Sort student by name.");
      System.out.println("6. Show student.");
      System.out.println("0. Return to entity selection.");
    } else {
      System.out.println("-----------Tutor Menu------------");
      System.out.println("1. Add tutor.");
      System.out.println("2. Edit tutor by id.");
      System.out.println("3. Delete tutor by id.");
      System.out.println("4. Sort tutor by hourly rate.");
      System.out.println("5. Sort tutor by name.");
      System.out.println("6. Show tutor.");
      System.out.println("0. Return to entity selection.");
    }
    System.out.println("----------------------------------");
    System.out.print("Please choose: ");
  }
}

