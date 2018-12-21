package edu.neu.ccs.cs5004.assignment8;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Represents a service that recommends new "influencer" user profiles to follow.
 *
 * @author Vivek Shah and Monish Naidu
 */
public class InfluencerRecommender implements IRecommender {

  @Override
  public Set<Integer> recommend(Integer profileId, Map<Integer, Set<Integer>> influencers,
      Map<Integer, Set<Integer>> followers, List<Profile> profiles, Integer numRecs,
      Integer threshold, Set<Integer> recs) {

    // Calculate how many new user profiles to recommend.
    Integer reqRecs = numRecs - recs.size();

    // Initialize set that will contain all new recommendations.
    Set<Integer> allRecs = new TreeSet<>();

    // If target number of recommendations is already satisfied, do nothing.
    if (reqRecs == 0) {
      return allRecs;
    }

    // Add all user profiles who meet the "influencer" threshold for follower size.
    for (Integer influencer : influencers.keySet()) {
      if (influencers.get(influencer) != null && influencers.get(influencer).size() >= threshold) {
        allRecs.add(influencer);
      }
    }

    // Remove any "influencer" user profiles that are already followees.
    if (followers.get(profileId) != null) {
      allRecs.removeAll(followers.get(profileId));
    }

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
