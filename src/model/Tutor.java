
package model;

import java.io.Serializable;

public class Tutor implements Serializable {
  private static final long serialVersionUID = 1L;

  private int tutorId;
  private String fullName;
  private byte experienceYears;
  private String subject;
  private float hourlyRate;

  public Tutor() {
  }

  public Tutor(int tutorId, String fullName, byte experienceYears,
      String subject, float hourlyRate) {
    super();
    this.tutorId = tutorId;
    this.fullName = fullName;
    this.experienceYears = experienceYears;
    this.subject = subject;
    this.hourlyRate = hourlyRate;
  }

  public int getTutorId() {
    return tutorId;
  }

  public void setTutorId(int tutorId) {
    this.tutorId = tutorId;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public byte getExperienceYears() {
    return experienceYears;
  }

  public void setExperienceYears(byte experienceYears) {
    this.experienceYears = experienceYears;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public float getHourlyRate() {
    return hourlyRate;
  }

  public void setHourlyRate(float hourlyRate) {
    this.hourlyRate = hourlyRate;
  }
}
