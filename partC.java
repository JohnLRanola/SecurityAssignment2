import java.util.*;

public class partC {
    private static final String ENGLISH_FREQUENCIES = "etaoinshrdlcumwfgypbvkjxqz";

    public static void main(String[] args) {
        String cipherText = "UZQSOVUOHXMOPVGPOZPEVSGZWSZOPFPESXUDBMETSXAIZVUEPHZHMDZSHZOWSFPAPPDTSVPQUZWYMXUZUHSXEPYEPOPDZSZUFPOMBZWPFUPZHMDJUDTMOHMQ";
        System.out.println(decipher(cipherText));
    }

    private static String decipher(String cipherText) {
        Map<Character, Integer> cipherFrequencies = new HashMap<>();
        for (char c : cipherText.toCharArray()) {
            cipherFrequencies.put(c, cipherFrequencies.getOrDefault(c, 0) + 1);
        }

        // Print the frequency of each letter
        System.out.println("Letter frequencies: " + cipherFrequencies);

        List<Map.Entry<Character, Integer>> sortedFrequencies = new ArrayList<>(cipherFrequencies.entrySet());
        sortedFrequencies.sort(Map.Entry.comparingByValue());
        Collections.reverse(sortedFrequencies);

        Map<Character, Character> cipherToEnglish = new HashMap<>();
        for (int i = 0; i < sortedFrequencies.size(); i++) {
            cipherToEnglish.put(sortedFrequencies.get(i).getKey(), ENGLISH_FREQUENCIES.charAt(i));
        }

        // Print the mapping of each cipher text letter to the English frequency letter
        System.out.println("Cipher to English mapping: " + cipherToEnglish);

        StringBuilder plaintext = new StringBuilder();
        for (char c : cipherText.toCharArray()) {
            plaintext.append(cipherToEnglish.get(c));
        }

        return plaintext.toString();
    }
}