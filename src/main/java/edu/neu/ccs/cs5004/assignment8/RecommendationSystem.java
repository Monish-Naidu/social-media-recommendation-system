package edu.neu.ccs.cs5004.assignment8;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Represents a service that recommends new user profiles to follow based on a prescribed sequence
 * of recommenders.
 *
 * @author Vivek Shah and Monish Naidu
 */
public class RecommendationSystem {

  /**
   * @param recSeq the order of recommenders in which to process.
   * @param profileId unique identifier of the user profile.
   * @param influencers map of influencer user profiles and those that follow them.
   * @param followers map of follower user profiles and the influencers they follow.
   * @param profiles list of all user profiles in the network.
   * @param numRecs number of user profiles to recommend.
   * @param threshold threshold for the number of followers a user profile needs to have to be
   * @return set of recommended user profiles.
   */
  public static Set<Integer> recommendInOrder(List<IRecommender> recSeq, Integer profileId,
      Map<Integer, Set<Integer>> influencers,
      Map<Integer, Set<Integer>> followers, List<Profile> profiles,
      Integer numRecs, Integer threshold) {

    Integer seqCounter = 0;

    Set<Integer> recs = new TreeSet<>();

    while (seqCounter < recSeq.size() && recs.size() != numRecs) {
      recs.addAll(
          recSeq.get(seqCounter).recommend(profileId, influencers, followers, profiles,
              numRecs, threshold, recs));
      seqCounter++;
    }
    return recs;

  }

}
