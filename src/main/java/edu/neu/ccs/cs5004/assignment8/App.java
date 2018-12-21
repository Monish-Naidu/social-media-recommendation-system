package edu.neu.ccs.cs5004.assignment8;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * The app class will contain the main method from which we make recommendations.
 *
 * @author Vivek Shah and Monish Naidu
 */

public class App {

  /**
   * Main routine responsible for calling helper services.
   *
   * @param args command-line arguments from user.
   * @throws ParseException throws exception if command-line arguments cannot be parsed.
   * @throws IOException throws exception if file cannot be read or written.
   */
  public static void main(String[] args) throws ParseException, IOException {
    GraphDatabase database = new GraphDatabase();
    InputFileReader fileReader = new InputFileReader();

    // updates our database with input csv files
    fileReader.readFilesToDatabase(args, database);

    List<IRecommender> recommendMethods = new ArrayList<IRecommender>();
    recommendMethods.add(new FOAFRecommender());
    recommendMethods.add(new InfluencerRecommender());
    recommendMethods.add(new RandomRecommender());

    Write write = new Write(recommendMethods);

    write.writeToCSVFile(args, database);

  }


}






