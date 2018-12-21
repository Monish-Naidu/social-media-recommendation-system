package edu.neu.ccs.cs5004.assignment8;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

import org.junit.Test;

public class InputParametersTest {

  String[] testArgs = {"Hello", "World"};

  @Test
  public void configureParams() {
    try {
      InputParameters.configureParams(testArgs);
      fail("Should not have initialized params.");
    } catch (IllegalArgumentException e) {
      assertTrue("Params were correctly not initialized.", true);
    }
  }
}