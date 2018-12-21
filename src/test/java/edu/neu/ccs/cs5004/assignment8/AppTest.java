package edu.neu.ccs.cs5004.assignment8;

import java.io.IOException;
import java.text.ParseException;
import org.junit.Before;
import org.junit.Test;

public class AppTest {
  App recommendations;

  @Before
  public void setUp() throws Exception {
    recommendations = new App();
  }

  @Test
  public void mainTest() throws ParseException, IOException {
    String[] args = {"nodes_small.csv", "edges_small.csv", "recommendations.csv", "-n", "93", "-u",
        "5", "-pf", "s"};
    recommendations.main(args);

    String argsFromEnd[] = {"nodes_small.csv", "edges_small.csv", "recommendations.csv", "-n", "93", "-u", "5", "-pf", "e"};
    recommendations.main(argsFromEnd);

    String argsFromRandom[] = {"nodes_small.csv", "edges_small.csv", "recommendations.csv", "-n", "93", "-u", "5", "-pf", "r"};
    recommendations.main(argsFromRandom);






  }
}