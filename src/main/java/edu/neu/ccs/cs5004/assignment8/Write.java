package edu.neu.ccs.cs5004.assignment8;

import static edu.neu.ccs.cs5004.assignment8.InputParameters.DELIMITER;
import static edu.neu.ccs.cs5004.assignment8.InputParameters.INFLUENCER_THRESHOLD;
import static edu.neu.ccs.cs5004.assignment8.InputParameters.NUM_PROFILES;
import static edu.neu.ccs.cs5004.assignment8.InputParameters.NUM_REC;
import static edu.neu.ccs.cs5004.assignment8.InputParameters.PROCESS_TYPE;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;


/**
 * A write class that writes csv files.
 */

public class Write {

  private static final String NEW_LINE_SEPARATOR = "\n";
  private static final String FILE_HEADER = "Node ID,Recommended nodes";

  private List<IRecommender> recommendMethods;


  /**
   * A write constructor.
   *
   * @param recommendMethods a list of methods on the ordering of recommendations in the csv file.
   */
  public Write(List<IRecommender> recommendMethods) {
    this.recommendMethods = recommendMethods;
  }

  /**
   * converts an integer set into an integer array.
   *
   * @param integerSet the set to be convered.
   * @return an integer array.
   */

  private static Integer[] integerSetToArray(Set<Integer> integerSet) {
    Integer size = integerSet.size();
    Integer[] integerArray = new Integer[size];
    integerArray = integerSet.toArray(integerArray);
    return integerArray;
  }

  /**
   * Converts an integer array into a string.
   *
   * @param integerArray the integer array to be converted.
   * @return a string.
   */
  private static String integerArrayToString(Integer[] integerArray) {
    String result = "";
    for (Integer x : integerArray) {
      result += x.toString() + " ";
    }
    return result;
  }

  /**
   * Writes recommendations into a csv file.
   *
   * @param args the argument to find the output csv file.
   * @param database the database from which the csv's contents will be from.
   * @throws IOException an exception that is thrown if the file isn't opened.
   */

  public void writeToCSVFile(String[] args, GraphDatabase database) throws IOException {
    try (BufferedWriter outPutFile = new BufferedWriter(new FileWriter(args[2]));) {
      //Write the CSV file header
      outPutFile.write(FILE_HEADER);
      //Add a new line separator after the header
      outPutFile.write(NEW_LINE_SEPARATOR);

      if (PROCESS_TYPE == ProcessingType.S) {
        writeFromStart(outPutFile, database);
      }
      if (PROCESS_TYPE == ProcessingType.E) {
        writeFromEnd(outPutFile, database);
      }

      if (PROCESS_TYPE == ProcessingType.R) {
        writeFromRandom(outPutFile, database);
      }
    }
  }

  /**
   * Writes the csv file from the start of the profile.
   *
   * @param outPutFile the csv file.
   * @param database the database to get the profiles from.
   * @throws IOException thrown if not succesfully written.
   */

  private void writeFromStart(BufferedWriter outPutFile, GraphDatabase database)
      throws IOException {
    for (int i = 0; i < NUM_PROFILES; i++) {
      outPutFile.write(database.profiles.get(i).getId().toString());
      outPutFile.write(DELIMITER);
      Integer[] integers = integerSetToArray(RecommendationSystem
          .recommendInOrder(recommendMethods, database.profiles.get(i).getId(),
              database.influencers, database.followers, database.profiles,
              NUM_REC,
              INFLUENCER_THRESHOLD));
      String recommendedUsers = integerArrayToString(integers);
      outPutFile.write(recommendedUsers);
      outPutFile.write(NEW_LINE_SEPARATOR);
    }
  }

  /**
   * Writes the csv file from the end of the profile list.
   *
   * @param outPutFile the csv file.
   * @param database the database to get the profiles from.
   * @throws IOException thrown if not successfully written.
   */
  private void writeFromEnd(BufferedWriter outPutFile, GraphDatabase database) throws IOException {
    Integer startIdx = database.profiles.size() - 1;
    Integer endIdx = database.profiles.size() - 1 - NUM_PROFILES;
    while (startIdx >= endIdx) {
      outPutFile.write(database.profiles.get(startIdx).getId().toString());
      outPutFile.write(DELIMITER);
      Integer[] integers = integerSetToArray(RecommendationSystem
          .recommendInOrder(recommendMethods, database.profiles.get(startIdx).getId(),
              database.influencers, database.followers, database.profiles,
              NUM_REC,
              INFLUENCER_THRESHOLD));
      String recommendedUsers = integerArrayToString(integers);
      outPutFile.write(recommendedUsers);
      outPutFile.write(NEW_LINE_SEPARATOR);
      startIdx--;
    }
  }

  /**
   * Writes the csv file from random profiles in the profile list.
   *
   * @param outPutFile the csv file.
   * @param database the database to get the random profiles from.
   * @throws IOException thrown if not successfully written.
   */
  private void writeFromRandom(BufferedWriter outPutFile, GraphDatabase database)
      throws IOException {
    Integer num = 0;
    Random generator = new Random();
    Set<Integer> randomUsers = new TreeSet<>();
    while (num < NUM_PROFILES) {
      Integer randomProfile = generator.nextInt(database.profiles.size());
//      if (!randomUsers.contains(randomProfile)) {
        randomUsers.add(randomProfile);
        num++;
//      }
    }
    for (Integer profile : randomUsers) {
      outPutFile.write(profile.toString());
      outPutFile.write(DELIMITER);
      Integer[] integers = integerSetToArray(RecommendationSystem
          .recommendInOrder(recommendMethods, database.profiles.get(profile).getId(),
              database.influencers, database.followers, database.profiles,
              NUM_REC,
              INFLUENCER_THRESHOLD));
      String recommendedUsers = integerArrayToString(integers);
      outPutFile.write(recommendedUsers);
      outPutFile.write(NEW_LINE_SEPARATOR);
    }


  }

}