import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;

public class Solution {
    //Given a list of co-ordinates return the number of nearest restaurant requested by the user
    List<List<Integer>> nearestVegetarianRestaurant(int totalRestaurants,
                                                    List<List<Integer>> allLocations,
                                                    int numRestaurants) {
        Map<Double, List<Integer>> distances = newHashMap();

        for (List<Integer> location : allLocations) {
            Double distance = Math.sqrt((location.get(0) * location.get(0)) + (location.get(1) * location.get(1)));
            distances.put(distance, location);
        }
        List<Double> sortedDistance = newArrayList(distances.keySet());
        Collections.sort(sortedDistance);
        List<List<Integer>> results = newArrayList();
        for (int i = 0; i < numRestaurants; i++) {
            results.add(distances.get(sortedDistance.get(i)));
        }
        return results;
    }
}