package edu.neu.ccs.cs5004.assignment8;


import static edu.neu.ccs.cs5004.assignment8.InputParameters.DELIMITER;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * An input file reader class.
 *
 * @author Monish Naidu and Vivek Shah
 */

public class InputFileReader {

  /**
   * Read files to database takes in command line arguments and updates the graph database.
   *
   * @param args the arguments to be taken in.
   * @param database the database to be updated.
   * @throws IOException is thrown when the file isn't read properly.
   */
  public void readFilesToDatabase(String[] args, GraphDatabase database)
      throws IOException {

    InputParameters.configureParams(args);

    try (BufferedReader nodesFile = new BufferedReader(new FileReader(args[0]));
        BufferedReader edgesFile = new BufferedReader(new FileReader(args[1]))) {

      // skips the first line in the nodes_small file
      nodesFile.readLine();
      edgesFile.readLine();

      String nodeLine, edgeLine;

      while ((nodeLine = nodesFile.readLine()) != null) {
        String columns[] = nodeLine.split(DELIMITER);

        Integer userID = Integer.parseInt(columns[0]);
        String dateCreated = columns[1];
        String gender = columns[2];
        Integer age = Integer.parseInt(columns[3]);
        String city = columns[4];

        Profile newProfile = new Profile(userID, dateCreated, gender, age, city);

        database.addProfiles(newProfile);
      }

      while ((edgeLine = edgesFile.readLine()) != null) {

        String columns[] = edgeLine.split(DELIMITER);

        Integer follower = Integer.parseInt(columns[0]);
        Integer followee = Integer.parseInt(columns[1]);

        database.addFollowers(follower, followee);
        database.addInfluencers(follower, followee);

      }

    }
  }


}
