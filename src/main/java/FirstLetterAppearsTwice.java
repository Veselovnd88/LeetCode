/*2351. First Letter to Appear Twice*/

import java.util.HashMap;
import java.util.HashSet;

public class FirstLetterAppearsTwice {

    public static char solve(String s){
        char result=' ';
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length();i++){
            char curr = s.charAt(i);
            if(map.containsKey(curr)){
                int qnt = map.get(curr)+1;
                map.put(curr,qnt);
                if(map.get(curr)==2){
                    result=curr;
                    return result;
                }
            } else {
                map.put(curr,1);
            }
        }
        return result;
    }
    public static char solve2(String s){//better
        char result=' ';
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<s.length();i++){
            char curr = s.charAt(i);
            if(set.contains(curr)){
                return curr;
            }
            else{
                set.add(curr);
            }
        }
        return result;
    }
}
