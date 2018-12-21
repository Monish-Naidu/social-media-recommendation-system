package edu.neu.ccs.cs5004.assignment8;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class InputFileReaderTest {

  private InputFileReader reader;
  private GraphDatabase database;

  private String[] args = {"nodes_blah.csv", "edges_small.csv", "recommendations.csv", "-n", "93",
      "-u", "5", "-pf", "s"};
  private String[] args2 = {"nodes.csv", "edges_small_blah.csv", "recommendations.csv", "-n", "93",
      "-u", "5", "-pf", "s"};
  @Before
  public void setUp() throws Exception {
    reader = new InputFileReader();
    database = new GraphDatabase();
  }
  @Test
  public void readFilesToDatabase1() {
    try {
      reader.readFilesToDatabase(args, database);
      fail("Should not have read files.");
    } catch (IOException e) {
      assertTrue("Files were correcly not read or written.", true);
    }
  }

  @Test
  public void readFilesToDatabase2() {
    try {
      reader.readFilesToDatabase(args2, database);
      fail("Should not have read files.");
    } catch (IOException e) {
      assertTrue("Files were correcly not read or written.", true);
    }
  }
}