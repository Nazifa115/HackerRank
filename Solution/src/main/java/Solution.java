// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.*;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;

public class Solution
{
	//Given a list of forward routes and return routes, find the optimal route/s which is the closest (or equal) but not greater than the maxTravelDist.
	public List<List<Integer>> findMaxTravelDistance(List<List<Integer>> forwardRouteList, List<List<Integer>> returnRouteList, Integer maxTravelDist)
	{
		Map<Integer, List<List<Integer>>> optimalTravelDistance = newHashMap();
		Integer maxCombinedDistFound = -1;
		for (List<Integer> fwdDistanceIdPair:forwardRouteList) {
			for (List<Integer> retDistanceIDPair:returnRouteList) {
				Integer combinedDistance = fwdDistanceIdPair.get(1) + retDistanceIDPair.get(1);
				if(combinedDistance <= maxTravelDist && combinedDistance >=maxCombinedDistFound) {
					maxCombinedDistFound = combinedDistance;
					List<Integer> pairToAdd = newArrayList(fwdDistanceIdPair.get(0), retDistanceIDPair.get(0));
					List<List<Integer>> existingPairs = optimalTravelDistance.containsKey(combinedDistance)? optimalTravelDistance.get(combinedDistance):newArrayList();
					existingPairs.add(pairToAdd);
					optimalTravelDistance.put(combinedDistance, existingPairs);
				}
			}
		}
		List<Integer> sortedOptimalDistance = newArrayList(optimalTravelDistance.keySet());
		Collections.sort(sortedOptimalDistance, Collections.reverseOrder());
		if(optimalTravelDistance.size()>0) return optimalTravelDistance.get(sortedOptimalDistance.get(0));
		else return newArrayList();
	}
}