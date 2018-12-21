package edu.neu.ccs.cs5004.assignment8;

import java.util.Objects;

/**
 * A profile class.
 */

public class Profile {

  private Integer id;
  private String createdAt;
  private String gender;
  private Integer age;
  private String city;

  /**
   * A profile constructor.
   *
   * @param id the user id value of a profile.
   * @param createdAt the date the profile was created.
   * @param gender the gender of the user.
   * @param age the age of the user.
   * @param city the city the user resides in.
   */
  public Profile(Integer id, String createdAt, String gender, Integer age, String city) {
    this.id = id;
    this.createdAt = createdAt;
    this.gender = gender;
    this.age = age;
    this.city = city;
  }

  /**
   * Gets the id value of a profile
   *
   * @return the id value.
   */

  public Integer getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Profile{"
        + "id=" + id
        + ", createdAt=" + createdAt
        + ", gender=" + gender
        + ", age=" + age
        + ", city='" + city + '\''
        + '}';
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Profile profile = (Profile) obj;
    return Objects.equals(id, profile.id)
        && Objects.equals(createdAt, profile.createdAt)
        && Objects.equals(gender, profile.gender)
        && Objects.equals(age, profile.age)
        && Objects.equals(city, profile.city);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, createdAt, gender, age, city);
  }
}
