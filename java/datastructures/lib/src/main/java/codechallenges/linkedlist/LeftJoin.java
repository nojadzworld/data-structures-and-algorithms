package codechallenges.linkedlist;

import java.util.*;
public class LeftJoin {
    public Map<String, List<String>> leftJoin(Map<String, String> synonyms, Map<String, String> antonyms) {
        Map<String, List<String>> output = new HashMap<>();

        for (String key : synonyms.keySet()) {
            List<String> values = new ArrayList<>();
            values.add(synonyms.get(key));

            if (antonyms.containsKey(key)) {
                values.add(antonyms.get(key));
            } else {
                values.add(null);
            }
            output.put(key, values);
        }
        return output;
    }
}
