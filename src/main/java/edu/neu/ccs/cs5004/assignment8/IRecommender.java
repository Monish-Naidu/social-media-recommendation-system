package edu.neu.ccs.cs5004.assignment8;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Represents the expected operations to be performed on a service that recommends user profiles to
 * follow.
 *
 * @author Vivek Shah and Monish Naidu
 */
public interface IRecommender {

  /**
   * Generate an set of user profiles that are recommended to be followed by a user profile.
   *
   * @param profileId unique identifier of the user profile.
   * @param influencers map of influencer user profiles and those that follow them.
   * @param followers map of follower user profiles and the influencers they follow.
   * @param profiles list of all user profiles in the network.
   * @param numRecs number of user profiles to recommend.
   * @param threshold threshold for the number of followers a user profile needs to have to be
   * considered an influencer.
   * @param recs current set of recommended user profiles.
   * @return unique set of user profiles to follow.
   */
  Set<Integer> recommend(Integer profileId, Map<Integer, Set<Integer>> influencers,
      Map<Integer, Set<Integer>> followers, List<Profile> profiles, Integer numRecs,
      Integer threshold, Set<Integer> recs);

}
