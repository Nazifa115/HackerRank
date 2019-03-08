import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

import static com.google.common.collect.Maps.newHashMap;

public class sortByFrequency {
   public void sort(){
       Map<String, Integer> map = newHashMap();
       List<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
       Stream<Entry<String,Integer>> sorted =
               map.entrySet().stream()
                       .sorted(Map.Entry.comparingByValue());
       list.sort((a,b) -> map.get(a) - map.get(b));
       ArrayList<Integer> arrL = new ArrayList<Integer>();
       arrL.forEach(n -> System.out.println(n));
   }

}
