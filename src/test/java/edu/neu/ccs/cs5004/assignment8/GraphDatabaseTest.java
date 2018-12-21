package edu.neu.ccs.cs5004.assignment8;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class GraphDatabaseTest {

  @Before
  public void setUp() throws Exception {
    List<IRecommender> recommendMethods = new ArrayList<IRecommender>();
    recommendMethods.add(new FOAFRecommender());
    recommendMethods.add(new InfluencerRecommender());
    recommendMethods.add(new RandomRecommender());
  }

  @Test
  public void addProfiles() {
  }

  @Test
  public void addFollowers() {
  }

  @Test
  public void addInfluencers() {
  }
}