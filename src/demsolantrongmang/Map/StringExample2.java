package demsolantrongmang.Map;

import java.util.Map;
import java.util.TreeMap;

import static jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType.SPACE;

public class StringExample2 {
    public static final char TAB = '\t';
    public static final char BREAK_LINE = '\n';

    public static void main(String[] args) {
        String str = "liet ke so lan xuat hien trong chuoi";
        System.out.println("------------------");
        System.out.println(str);
        System.out.println("-------------------");
        System.out.println("so lan xuat hien ");
        Map<String,Integer>wordMap = countWords(str);
        for (String key : wordMap.keySet()){
            System.out.println(key + " " + wordMap.get(key) + "\n");
        }
    }

//    private static Map<String, Integer> countWords(String str) {
//        return null;
//    }
    public static Map<String,Integer> countWords(String input){
        Map<String,Integer> wordMap = new TreeMap<String , Integer>();
        if (input == null){
            return wordMap;
        }
        int size = input.length();
        StringBuilder sb = new StringBuilder();
        for (int i= 0; i< size; i++){
            if (input.charAt(i) != SPACE && input.charAt(i) != TAB  && input.charAt(i) != BREAK_LINE){
                sb.append(input.charAt(i));
            }else {
               addWord(wordMap, sb);
               sb = new StringBuilder();
            }
        }
        addWord(wordMap, sb);
        return wordMap;
    }
    public static void addWord(Map<String,Integer>wordMap,StringBuilder sb){
        String word = sb.toString();
        if (word.length()==0){
            return;
        }
        if (wordMap.containsKey(word)){
            int count = wordMap.get(word) +1;
            wordMap.put(word,count);
        }else {
            wordMap.put(word,1);
        }
    }

}
