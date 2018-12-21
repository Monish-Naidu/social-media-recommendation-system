package edu.neu.ccs.cs5004.assignment8;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * Represents a service that randomly recommends new user profiles to follow.
 *
 * @author Vivek Shah and Monish Naidu
 */
public class RandomRecommender implements IRecommender {

  @Override
  public Set<Integer> recommend(Integer profileId, Map<Integer, Set<Integer>> influencers,
      Map<Integer, Set<Integer>> followers, List<Profile> profiles, Integer numRecs,
      Integer threshold, Set<Integer> recs) {

    // Calculate how many new user profiles to recommend.
    Integer reqRecs = numRecs - recs.size();

    // Initialize set that will contain all new recommendations.
    Set<Integer> newRecs = new TreeSet<>();

    // If target number of recommendations is already satisfied, do nothing.
    if (reqRecs == 0) {
      return newRecs;
    }

    // Initialize range of integers that will serve as boundaries for random number "selection".
    Integer min = 0;
    int max = profiles.size();
    Random generator = new Random();

    while (reqRecs > 0) {
      Integer randomId = generator.nextInt(max - min);

      /*
      Ensure that the existing set and new set of recommendations don't already have the randomly
      selected user profile and that the user profile is not yourself.
       */
      if (!recs.contains(randomId) && !newRecs.contains(randomId) && !profileId.equals(randomId)) {
        newRecs.add(randomId);
        reqRecs--;
      }
    }
    return newRecs;
  }
}
