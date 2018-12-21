package edu.neu.ccs.cs5004.assignment8;

/**
 * An input paramaters class.
 *
 * @author Vivek Shah and Monish Naidu
 */
public class InputParameters {

  public static final String PROCESS_TYPE_FLAG = "-pf";
  public static final String NUM_PROFILES_FLAG = "-u";
  public static final String NUM_REC_FLAG = "-n";
  public static final Integer NUM_PROFILES_MIN = 1;
  public static final Integer NUM_PROFILES_MAX = 100;
  public static final Integer NUM_REC_MIN = 1;
  public static final Integer NUM_REC_MAX = 100;
  public static final Integer NUM_REQ_ARGS = 3;
  public static final Integer OPTIONAL_ARGS_IDX_START = 3;
  public static final String DELIMITER = ",";
  public static final Integer INFLUENCER_THRESHOLD = 15;
  public static final Integer USERS_MAX = 100;
  public static final String DATE_FORMAT = "MM/dd/yy";
  public static ProcessingType PROCESS_TYPE = ProcessingType.S;
  public static Integer NUM_PROFILES = 30;
  public static Integer NUM_REC = 10;
  public static Boolean DEBUG = false;

  /**
   * Configure params takes in arguments and manipulates them.
   *
   * @param args the arguments to be checked in the function.
   */
  public static void configureParams(String[] args) {
    if (args.length < NUM_REQ_ARGS) {
      throw new IllegalArgumentException(
          "Not enough arguments. Need at least " + NUM_REQ_ARGS + ".");
    }
    for (int i = OPTIONAL_ARGS_IDX_START; i < args.length; i++) {
      switch (args[i].toLowerCase()) {
        case PROCESS_TYPE_FLAG:
          try {
            PROCESS_TYPE = ProcessingType.valueOf(args[i + 1].toUpperCase());
          } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                "Instead of " + args[i + 1].toUpperCase()
                    + ", processing type must be (S)tart, (E)nd, or (R)andom.");
          }
          break;
        case NUM_PROFILES_FLAG:
          NUM_PROFILES = Integer.parseInt(args[i + 1]);
          if (NUM_PROFILES < NUM_PROFILES_MIN || NUM_PROFILES > NUM_PROFILES_MAX) {
            throw new IllegalArgumentException(
                "Instead of " + NUM_PROFILES
                    + ", the number of user profiles to process must be an integer in the range ["
                    + NUM_PROFILES_MIN + "," + NUM_PROFILES_MAX + "].");
          }
          break;
        case NUM_REC_FLAG:
          NUM_REC = Integer.parseInt(args[i + 1]);
          if (NUM_REC < NUM_REC_MIN || NUM_REC > NUM_REC_MAX) {
            throw new IllegalArgumentException(
                "Instead of " + NUM_REC
                    + ", the number of user profiles to process must be an integer in the range ["
                    + NUM_PROFILES_MIN + "," + NUM_PROFILES_MAX + "].");
          }
          break;
        default:
          break;
      }
    }
  }
}

