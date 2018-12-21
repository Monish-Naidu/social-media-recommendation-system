package edu.neu.ccs.cs5004.assignment8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Graph Database class that will have methods that take to create a database of profiles,
 * followers, and influencers.
 *
 * @author Monish Naidu and Vivek Shah
 */
public class GraphDatabase {

  protected ArrayList<Profile> profiles = new ArrayList<>();
  protected Map<Integer, Set<Integer>> followers = new HashMap<>();
  protected Map<Integer, Set<Integer>> influencers = new HashMap<>();

  /**
   * Empty constructor of a graph database.
   */
  public GraphDatabase() {
  }

  /**
   * Adds profile to the list of profiles in the database.
   *
   * @param profile the profile to be added to the database.
   */
  public void addProfiles(Profile profile) {
    profiles.add(profile);

  }

  /**
   * Adds followers to a followee.
   *
   * @param follower The follower to be added.
   * @param followee The followee which is being followed.
   */
  public void addFollowers(Integer follower, Integer followee) {
    if (!followers.containsKey(follower)) {
      TreeSet<Integer> temp = new TreeSet();
      temp.add(followee);
      followers.put(follower, temp);
      System.out.println("Adding first influencer of follower.");
    } else {
      Set<Integer> temp = followers.get(follower);
      temp.add(followee);
      followers.put(follower, temp);
    }
  }

  /**
   * Adds influencers to the graph database.
   *
   * @param follower the follower following the influencer.
   * @param followee the influencer.
   */
  public void addInfluencers(Integer follower, Integer followee) {
    if (!influencers.containsKey(followee)) {
      TreeSet<Integer> temp = new TreeSet();
      temp.add(follower);
      influencers.put(followee, temp);
      System.out.println("Adding first follower for the influencer.");
    } else {
      Set<Integer> temp = influencers.get(followee);
      temp.add(follower);
      influencers.put(followee, temp);
      System.out.println("Adding another follower for the influencer.");
    }


  }

}
