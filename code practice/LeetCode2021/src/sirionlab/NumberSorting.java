package sirionlab;

import java.util.*;

//String[] arr = {"1","-2","99","a","0a","-1","-1"};
public class NumberSorting {
    public static void getSortedList(String[] arr) {
        Set<Integer> numberSet = new HashSet<>();
        List<String> nonNumberList = new ArrayList<>();
        for(String s: arr) {
//            if(isNumber(s)) {
//                numberSet.add(Integer.parseInt(s));
//            } else {
//                nonNumberList.add(s);
//            }
            try {
                numberSet.add(Integer.parseInt(s));
            } catch(NumberFormatException ex) {
                nonNumberList.add(s);
            }
        }
        List<Integer> numberList = new ArrayList<>(numberSet);
        Collections.sort(numberList);

        System.out.print("Numbers after sorting:");
        for(int i:numberList) {
            System.out.print(i+" ");
        }

        System.out.println();
        for(String s:nonNumberList) {
            System.out.print(s+" ");
        }

    }

    private static boolean isNumber(String s) {
        for(int i=0;i<s.length();i++) {
            if(s.charAt(0) == '-') continue;
            if(!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        getSortedList(new String[]{"1","-2","99","a","0a","-1","-1"});
    }
}
