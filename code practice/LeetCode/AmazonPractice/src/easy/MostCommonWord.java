package easy;

import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord {
    public static void main(String[] args) {
            MostCommonWord word = new MostCommonWord();
            String para = "Bob hit a ball, the hit BALL flew far after it was hit.";
            String[] banned = new String[]{"hit"};
            String countWord = word.mostCommonWord(para, banned);
            System.out.println(countWord);
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        String maxCountWord = "";
        HashSet<String> bannedWords = new HashSet<>();
        for(int i=0;i<banned.length;i++) {
            bannedWords.add(banned[i]);
        }
        String[] para = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase().split("\\s+");
        int maxCount = 0;
        for (int i=0;i<para.length;i++) {
            if(!bannedWords.contains(para[i])) {
                if(!wordCount.keySet().contains(para[i])) {
                    wordCount.put(para[i], 1);
                } else {
                    int count = wordCount.get(para[i]);
                    wordCount.put(para[i], count+1);
                }
                if(maxCount < wordCount.get(para[i])) {
                    maxCount = wordCount.get(para[i]);
                    maxCountWord = para[i];
                }
            }
        }
        return maxCountWord;
    }
}
