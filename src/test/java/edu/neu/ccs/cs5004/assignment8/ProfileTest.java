package edu.neu.ccs.cs5004.assignment8;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class ProfileTest {

  Profile newProfile ;
  Profile testProfile;
  Profile sameProfile;
  Profile differentProfile;
  Profile diffId;
  Profile diffDate;
  Profile diffGender;
  Profile diffAge;
  Profile diffCity;

  @Before
  public void setUp() throws Exception {
    testProfile = new Profile(101, "2017-01-23", "M", 23, "Seattle");
    sameProfile = new Profile(101, "2017-01-23", "M", 23, "Seattle");
    differentProfile = new Profile(202, "2017-04-12", "F", 28, "Boston");
    diffId = new Profile(102, "2017-01-23", "M", 23, "Seattle");
    diffDate = new Profile(101, "2017-01-24", "M", 23, "Seattle");
    diffGender = new Profile(101, "2017-01-23", "F", 23, "Seattle");
    diffAge = new Profile(101, "2017-01-23", "M", 24, "Seattle");
    diffCity = new Profile(101, "2017-01-23", "M", 23, "Bellevue");

  }

  @Test
  public void getId() {
    assertEquals((Integer) 101, testProfile.getId());
  }

  @Test
  public void toStringTest() {
    assertEquals("Profile{id=101, createdAt=2017-01-23, gender=M, age=23, city='Seattle'}",
        testProfile.toString());
  }

  @Test
  public void equalsTest() {
    assertTrue(testProfile.equals(testProfile));
    assertFalse(testProfile.equals(null));
    assertTrue(testProfile.equals(sameProfile));
    assertTrue(testProfile.equals(sameProfile) && sameProfile.equals(testProfile));
    assertFalse(testProfile.equals(differentProfile));
    assertFalse(testProfile.equals(differentProfile) && differentProfile.equals(testProfile));
    assertFalse(testProfile.equals(diffId));
    assertFalse(testProfile.equals(diffDate));
    assertFalse(testProfile.equals(diffGender));
    assertFalse(testProfile.equals(diffAge));
    assertFalse(testProfile.equals(diffCity));

  }

  @Test
  public void hashCodeTest() {
    assertEquals(true, testProfile.hashCode() == sameProfile.hashCode());
  }
}