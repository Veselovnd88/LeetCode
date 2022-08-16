/*Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.*/

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public static int solve(String s){
        int result =-1;
        HashMap<Character, Integer> map = new LinkedHashMap<>();

        for( int i=0; i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                int qnt = map.get(s.charAt(i))+1;
                map.put(s.charAt(i),qnt);
            }
            else{
                map.put(s.charAt(i),1);
            }
        }
        System.out.println(map);
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            if(entry.getValue()==1){
                result=s.indexOf(entry.getKey());
                break;
            }
        }
        return result;
    }


}
