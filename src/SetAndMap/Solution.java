package SetAndMap;

import java.util.TreeSet;

public class Solution {

    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        TreeSet<String> set=new TreeSet<>();
        for(String word:words){
            StringBuilder stringBuffer=new StringBuilder();
            for(int i=0;i<word.length();i++){
                stringBuffer.append(codes[word.charAt(i)-'a']);
            }
            String s= String.valueOf(stringBuffer);
            set.add(s);
        }
        return set.size();
    }
}
