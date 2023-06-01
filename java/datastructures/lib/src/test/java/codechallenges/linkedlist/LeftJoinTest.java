package codechallenges.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class LeftJoinTest {
    private LeftJoin sut;

    @BeforeEach
    public void setUp() {
        sut = new LeftJoin();
    }
    @Test
    public void testLeftJoin() {
        Map<String, String> synonyms = new HashMap<>();
        synonyms.put("diligent", "employed");
        synonyms.put("fond", "enamored");
        synonyms.put("guide", "usher");
        synonyms.put("outfit", "garb");
        synonyms.put("wrath", "anger");

        Map<String, String> antonyms = new HashMap<>();
        antonyms.put("diligent", "idle");
        antonyms.put("fond", "averse");
        antonyms.put("guide", "follow");
        antonyms.put("flow", "jam");
        antonyms.put("wrath", "delight");

        Map<String, List<String>> expectedOutput = new HashMap<>();
        expectedOutput.put("diligent", Arrays.asList("employed", "idle"));
        expectedOutput.put("fond", Arrays.asList("enamored", "averse"));
        expectedOutput.put("guide", Arrays.asList("usher", "follow"));
        expectedOutput.put("outfit", Arrays.asList("garb", null));
        expectedOutput.put("wrath", Arrays.asList("anger", "delight"));

        assertEquals(expectedOutput, sut.leftJoin(synonyms, antonyms));

    }
}
