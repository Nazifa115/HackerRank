import java.util.*;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;

public class Solution {

    //Get state of list of cells after a certain number of days. A cell turns inactive iff both of it's adjacent cells have the same state (both are inactive or b oth are active) on the previous day.

    public static List<Integer> cellCompete(int[] states, int days) {

        for (int day = 0; day < days; day++) {
            List<Integer> previousStates = Arrays.stream(states).boxed().collect(Collectors.toList());

            for (int i = 0; i <= states.length-1; i++) {
                if( i == 0){
                    states[i] = previousStates.get(i+1).equals(1)? 1:0;
                } else if ( i == states.length -1){
                    states[i] = previousStates.get(i-1).equals(1)? 1:0;
                } else{
                    states[i] = (previousStates.get(i-1).equals(0) && previousStates.get(i+1).equals(0)) || (previousStates.get(i-1).equals(1) && previousStates.get(i+1).equals(1))? 0:1;
                }
            }

        }
        List<Integer> results = Arrays.stream(states).boxed().collect(Collectors.toList());
        return results;
    }

    public List<Integer> getRow(int rowIndex) {
        //Map<Integer, List<Integer>> pascalTriangle = new HashMap<>();
        //pascalTriangle.put(0, new ArrayList<>(1));
        List<Integer> previousRow = new ArrayList<>(1);
        List<Integer> currentRow = new ArrayList<>(1);
        for (int i = 0; i <= rowIndex; i++) {
            currentRow.clear();
            for (int j = 0; j < i+1; j++) {
                if (j==0 || j==i){
                    currentRow.add(1);
                }else {
                currentRow.add(previousRow.get(j-1) + previousRow.get(j));
                }
            }
            previousRow = new ArrayList<>(currentRow);
        }
        return currentRow;

    }

    public static int getClosingParen(String sentence, int openingParenIndex) {
        int openNestedParens = 0;

        for (int position = openingParenIndex + 1; position < sentence.length(); position++) {
            char c = sentence.charAt(position);

            if (c == '(') {
                openNestedParens++;
            } else if (c == ')') {
                if (openNestedParens == 0) {
                    return position;
                } else {
                    openNestedParens--;
                }
            }
        }

        throw new IllegalArgumentException("No closing parenthesis :(");
    }


    class DoublyLinkedListNode {
          int data;
          DoublyLinkedListNode next;
          DoublyLinkedListNode prev;
    }
    public DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        boolean inserted = false;
        DoublyLinkedListNode cur = new DoublyLinkedListNode();
        cur.data = head.data;
        cur.next = head.next;
        cur.prev = head.prev;
        DoublyLinkedListNode temp = new DoublyLinkedListNode();
        temp.data = data;
        while(null!=cur.next){
            if(cur.next.data>=data && cur.data<=data){
                temp.prev = cur.prev;
                temp.next = cur;
                head.prev = temp;
                cur.prev.next = temp;
                inserted = true;
            }
            cur = cur.next;
        }
        if(!inserted){
            temp.prev = cur;
            cur.next = temp;
            temp.next = null;
        }
        return  head;
    }
}