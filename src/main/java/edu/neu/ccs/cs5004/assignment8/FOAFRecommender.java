package edu.neu.ccs.cs5004.assignment8;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Represents a service that recommends new user profiles to follow depending on whether your
 * followee is a follower of a user profile.
 *
 * @author Vivek Shah and Monish Naidu
 */
public class FOAFRecommender implements IRecommender {

  @Override
  public Set<Integer> recommend(Integer profileId, Map<Integer, Set<Integer>> influencers,
      Map<Integer, Set<Integer>> followers, List<Profile> profiles, Integer numRecs,
      Integer threshold, Set<Integer> recs) {

    // Initialize set that will contain all new recommendations.
    Set<Integer> allRecs = new TreeSet<>();

    // Calculate how many new user profiles to recommend.
    Integer reqRecs = numRecs - recs.size();

    Set<Integer> followees = followers.get(profileId);

    // If target number of recommendations is already met, or there are no followees, do nothing.
    if (reqRecs == 0 || followees == null) {
      return allRecs;
    }

    // For each followee, add all user profiles that the followee is following.
    for (Integer followee : followees) {
      if (followers.get(followee) != null) {
        allRecs.addAll(followers.get(followee));
      }
    }

    // Remove any user profiles that are already followees from being recommended.
    allRecs.removeAll(followees);

    // Remove yourself from being a recommendation.
    allRecs.remove(profileId);

    Iterator<Integer> iter = allRecs.iterator();

    Set<Integer> newRecs = new TreeSet<>();

    // Load a subset of all recommendations into a new set based on the target number specified.
    while (reqRecs > 0 && iter.hasNext()) {
      newRecs.add(iter.next());
      reqRecs--;
    }
    return newRecs;

  }
}
