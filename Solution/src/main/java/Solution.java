import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    /*
     * Complete the 'fetchItemsToDisplay' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_STRING_ARRAY items
     *  2. INTEGER sortParameter
     *  3. INTEGER sortOrder
     *  4. INTEGER itemPerPage
     *  5. INTEGER pageNumber
     */

    public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int pageNumber) {

        List<List<String>> sortedList = new ArrayList<>();
        if (sortParameter == 0){
            List<String> itemNames = getItemNames(items);
            if(sortOrder == 0){
            Collections.sort(itemNames, new Comparator<String>() {

                @Override
                public int compare(String o1, String o2) {
                    return o2.compareTo(o1);
                }
            });

            }
            else {
                Collections.sort(itemNames, new Comparator<String>() {

                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                });
            }
        }
        return sortedList.get(pageNumber);
    }

    private static List<String> getItemNames(List<List<String>> items) {
        List<String> itemNames = new ArrayList<>();
        for (List<String> item: items) {
            itemNames.add(item.get(0));
        }
        return itemNames;
    }

    private static List<String> getItemRelevances(List<List<String>> items) {
        List<String> itemNames = new ArrayList<>();
        for (List<String> item: items) {
            itemNames.add(item.get(1));
        }
        return itemNames;
    }

    private static List<String> getItemRPrices(List<List<String>> items) {
        List<String> itemNames = new ArrayList<>();
        for (List<String> item: items) {
            itemNames.add(item.get(2));
        }
        return itemNames;
    }




    /*
     * Complete the 'countPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY numbers
     *  2. INTEGER k
     */


        /*
         * Complete the 'countPairs' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER_ARRAY numbers
         *  2. INTEGER k
         */

        public static int countPairs(List<Integer> numbers, int k) {
            Set<Integer> duplicateRemoved = new HashSet<>(numbers);
            /*List<Integer> uniqueNumbers = new ArrayList<>(duplicateRemoved);
            Map<Integer, Integer> validPairs = new HashMap<>();

            for (int i = 0; i < uniqueNumbers.size(); i++) {
                for (int j = i + 1; j < uniqueNumbers .size(); j++){
                    if (uniqueNumbers.get(i) + k == uniqueNumbers.get(j))
                        validPairs.put(uniqueNumbers.get(i), uniqueNumbers.get(j));
                }


            }
            return validPairs.size();*/
            long matchCount = duplicateRemoved.stream()
                    .filter(i -> duplicateRemoved.contains(i - k))
                    .count();

            return (int) matchCount;
        }


   /* public int countPairs(List<Integer> numbers, int k) {
        Set<Integer> duplicateRemoved = new HashSet<>(numbers);
        List<Integer> uniqueNumbers = new ArrayList<>(duplicateRemoved);
        Map<Integer, Integer> validPairs = new HashMap<>();

        for (int i = 0; i < uniqueNumbers.size(); i++) {
            for (int j = i + 1; j < uniqueNumbers .size(); j++){
                if (uniqueNumbers.get(i) + k == uniqueNumbers.get(j))
                    validPairs.put(uniqueNumbers.get(i), uniqueNumbers.get(j));
            }


        }
       *//* IntStream.range(0,  numbers.size()).forEach(i -> IntStream.range(0,  numbers.size())
                .filter(j -> i != j && numbers.get(i) + k == numbers.get(j))
                .forEach(j -> duplicateRemoved.add(new IntPair(numbers.get(i), numbers.get(j)))));*//*

return uniqueNumbers.size();
    }*/


    /*
     * Complete the 'winner' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING erica
     *  2. STRING bob
     */

    public static String winner(String erica, String bob) {
        int scoreErica = 0;
        int scoreBob = 0;
        char[] ericaCharArray = erica.toCharArray();
        char[] bobCharArray = bob.toCharArray();

        for (int i=0 ; i<ericaCharArray.length; i++) {
            scoreErica+=getScore(ericaCharArray[i]);
            scoreBob+=getScore(bobCharArray[i]);
        }
        if(scoreErica == scoreBob){
            return "Tie";
        }else if(scoreErica > scoreBob){
            return "Erica";
        }else {
            return "Bob";
        }
    }

    private static int getScore(char c) {
        switch (c){
            case 'E':
                return 1;
            case 'M':
                return 3;
            case 'H':
                return 5;

        }
        return 0;
    }

    /*
     * Complete the 'addNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. FLOAT a
     *  2. FLOAT b
     */

    public static int addNumbers(float a, float b) {
        return (int) Math.floor(a+b);
    }
    /*https://www.hackerrank.com/contests/hackerrank-women-technologists-codesprint-2019/challenges/signal-classification*/


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

    public List<Integer> classifySignals(List<Integer> freq_standard, List<Integer> freq_signals) {
        List<Integer> resultList = new ArrayList();
        List<Integer> sortedFrequencyStandards = new ArrayList(freq_standard);
        Collections.sort(sortedFrequencyStandards);
        Map<Integer, Integer> indices = new HashMap();
        for (int i = 0; i < freq_standard.size(); i++) {
            indices.put(freq_standard.get(i), i+1);
        }

        for (Integer freq_signal : freq_signals) {
            Integer index = Collections.binarySearch(sortedFrequencyStandards, freq_signal);
            index = index>=0? index : Math.abs(index+1);
            if (index == sortedFrequencyStandards.size()){
                resultList.add(index);
            }
            else {
                if(index != 0 && Math.abs(sortedFrequencyStandards.get(index-1)-freq_signal) < Math.abs(sortedFrequencyStandards.get(index)-freq_signal)){
                    index = index-1;
                }
                resultList.add(indices.get(sortedFrequencyStandards.get(index)));
            }
        }
        return resultList;
    }

    public static int finalInstances(int instances, List<Integer> averageUtil) {
        Integer resultingInstances = instances;
        for (int i = 0; i<averageUtil.size(); i++) {
            Integer averageUtilization = averageUtil.get(i);
            if(averageUtilization <25 && resultingInstances > 1){
                resultingInstances = (int)Math.ceil(resultingInstances/2.00);
                i+=10;
            }else if (averageUtilization > 60 && resultingInstances <= (2*Math.pow(10,8))){
                resultingInstances = resultingInstances*2;
                i+=10;
            }
        }
        return resultingInstances;
}


    public static void fizzBuzz(int n) {

        String result = "";
        if(n%3 == 0){
            if(n%5 == 0){
                result = "FizzBuzz";
            }else{
                result = "Fizz";
            }
        }else if(n%5 == 0){
            result = "Buzz";
        }else{
            result = String.valueOf(n);
        }

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