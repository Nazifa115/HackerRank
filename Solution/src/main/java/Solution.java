import java.util.*;
import java.util.stream.Collectors;

import static com.google.common.collect.Maps.newHashMap;

public class Solution {

    /*https://www.hackerrank.com/challenges/permutation-equation/problem*/
    public int[] permutationEquation(int[] p) {
        Map<Integer, Integer> indexMap = new HashMap();
        int[] resultMap = new int[p.length];

        for (int i = 0; i < p.length; i++) {
            indexMap.put(p[i], i+1);
        }
        for (int i = 1; i <= p.length; i++) {
            int position = indexMap.get(i);
            resultMap[i-1] = indexMap.get(position);
        }
        return resultMap;
    }



    /*https://www.hackerrank.com/challenges/sock-merchant/problem*/
    public int sockMerchant(int n, int[] ar) {
        HashMap<Integer, Integer> socks = new HashMap<>();
        int pairs = 0;

        for (int sockColor : ar) {
            {
                if (socks.containsKey(sockColor)) {
                    int count = socks.get(sockColor);
                    socks.put(sockColor, ++count);
                    if (count % 2 == 0) {
                        pairs++;
                    }

                } else {
                    socks.put(sockColor, 1);
                }
            }
        }
        return pairs;
    }

    /*https://leetcode.com/problems/remove-element/*/
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                count++;
                length--;
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                if (nums[i] == val) i--;
            }
        }

        return nums.length - count;
    }

    /*https://leetcode.com/problems/reverse-string/*/
    public void reverseString(char[] s) {
        if (s.length == 1 || s.length == 2)
            return;
        else {
            char c = s[0];
            s[0] = s[s.length - 1];
            s[s.length - 1] = c;
            reverseString(Arrays.copyOfRange(s, 1, s.length - 1));
        }
        System.out.println(s.toString());
    }

    //Get state of list of cells after a certain number of days. A cell turns inactive iff both of it's adjacent cells have the same state (both are inactive or b oth are active) on the previous day.

    public static List<Integer> cellCompete(int[] states, int days) {

        for (int day = 0; day < days; day++) {
            List<Integer> previousStates = Arrays.stream(states).boxed().collect(Collectors.toList());

            for (int i = 0; i <= states.length - 1; i++) {
                if (i == 0) {
                    states[i] = previousStates.get(i + 1).equals(1) ? 1 : 0;
                } else if (i == states.length - 1) {
                    states[i] = previousStates.get(i - 1).equals(1) ? 1 : 0;
                } else {
                    states[i] = (previousStates.get(i - 1).equals(0) && previousStates.get(i + 1).equals(0)) || (previousStates.get(i - 1).equals(1) && previousStates.get(i + 1).equals(1)) ? 0 : 1;
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
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    currentRow.add(1);
                } else {
                    currentRow.add(previousRow.get(j - 1) + previousRow.get(j));
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
        while (null != cur.next) {
            if (cur.next.data >= data && cur.data <= data) {
                temp.prev = cur.prev;
                temp.next = cur;
                head.prev = temp;
                cur.prev.next = temp;
                inserted = true;
            }
            cur = cur.next;
        }
        if (!inserted) {
            temp.prev = cur;
            cur.next = temp;
            temp.next = null;
        }
        return head;
    }
}