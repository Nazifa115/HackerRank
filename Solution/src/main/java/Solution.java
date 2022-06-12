import com.sun.tools.javac.util.StringUtils;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;


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
        if (sortParameter == 0) {
            List<String> itemNames = getItemNames(items);
            if (sortOrder == 0) {
                Collections.sort(itemNames, new Comparator<String>() {

                    @Override
                    public int compare(String o1, String o2) {
                        return o2.compareTo(o1);
                    }
                });

            } else {
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
        for (List<String> item : items) {
            itemNames.add(item.get(0));
        }
        return itemNames;
    }

    private static List<String> getItemRelevances(List<List<String>> items) {
        List<String> itemNames = new ArrayList<>();
        for (List<String> item : items) {
            itemNames.add(item.get(1));
        }
        return itemNames;
    }

    private static List<String> getItemRPrices(List<List<String>> items) {
        List<String> itemNames = new ArrayList<>();
        for (List<String> item : items) {
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

        for (int i = 0; i < ericaCharArray.length; i++) {
            scoreErica += getScore(ericaCharArray[i]);
            scoreBob += getScore(bobCharArray[i]);
        }
        if (scoreErica == scoreBob) {
            return "Tie";
        } else if (scoreErica > scoreBob) {
            return "Erica";
        } else {
            return "Bob";
        }
    }

    private static int getScore(char c) {
        switch (c) {
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
        return (int) Math.floor(a + b);
    }
    /*https://www.hackerrank.com/contests/hackerrank-women-technologists-codesprint-2019/challenges/signal-classification*/


    /*https://www.hackerrank.com/challenges/permutation-equation/problem*/
    public int[] permutationEquation(int[] p) {
        Map<Integer, Integer> indexMap = new HashMap();
        int[] resultMap = new int[p.length];

        for (int i = 0; i < p.length; i++) {
            indexMap.put(p[i], i + 1);
        }
        for (int i = 1; i <= p.length; i++) {
            int position = indexMap.get(i);
            resultMap[i - 1] = indexMap.get(position);
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
            indices.put(freq_standard.get(i), i + 1);
        }

        for (Integer freq_signal : freq_signals) {
            Integer index = Collections.binarySearch(sortedFrequencyStandards, freq_signal);
            index = index >= 0 ? index : Math.abs(index + 1);
            if (index == sortedFrequencyStandards.size()) {
                resultList.add(index);
            } else {
                if (index != 0 && Math.abs(sortedFrequencyStandards.get(index - 1) - freq_signal) < Math.abs(sortedFrequencyStandards.get(index) - freq_signal)) {
                    index = index - 1;
                }
                resultList.add(indices.get(sortedFrequencyStandards.get(index)));
            }
        }
        return resultList;
    }

    public static int finalInstances(int instances, List<Integer> averageUtil) {
        Integer resultingInstances = instances;
        for (int i = 0; i < averageUtil.size(); i++) {
            Integer averageUtilization = averageUtil.get(i);
            if (averageUtilization < 25 && resultingInstances > 1) {
                resultingInstances = (int) Math.ceil(resultingInstances / 2.00);
                i += 10;
            } else if (averageUtilization > 60 && resultingInstances <= (2 * Math.pow(10, 8))) {
                resultingInstances = resultingInstances * 2;
                i += 10;
            }
        }
        return resultingInstances;
    }


    public static void fizzBuzz(int n) {

        String result = "";
        if (n % 3 == 0) {
            if (n % 5 == 0) {
                result = "FizzBuzz";
            } else {
                result = "Fizz";
            }
        } else if (n % 5 == 0) {
            result = "Buzz";
        } else {
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
//        cur.next = head.next;
//        cur.prev = head.prev;
//        DoublyLinkedListNode temp = new DoublyLinkedListNode();
//        temp.data = data;
//        while (null != cur.next) {
//            if (cur.next.data >= data && cur.data <= data) {
//                temp.prev = cur.prev;
//                temp.next = cur;
//                head.prev = temp;
//                cur.prev.next = temp;
//                inserted = true;
//            }
//            cur = cur.next;
//        }
//        if (!inserted) {
//            temp.prev = cur;
//            cur.next = temp;
//            temp.next = null;
//        }
        return head;
    }

    /*https://leetcode.com/problems/flood-fill/
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int prevColor = image[sr][sc];
        return floodFillHelper(image, sr, sc, prevColor, newColor);
    }

    private int[][] floodFillHelper(int[][] image, int sr, int sc, int prevColor, int newColor) {
        if (((0 <= sr && sr < image.length) && (0 <= sc && sc < image[0].length) && image[sr][sc] == prevColor && image[sr][sc] != newColor)) {
            image[sr][sc] = newColor;
            floodFillHelper(image, sr, sc - 1, prevColor, newColor);
            floodFillHelper(image, sr - 1, sc, prevColor, newColor);
            floodFillHelper(image, sr, sc + 1, prevColor, newColor);
            floodFillHelper(image, sr + 1, sc, prevColor, newColor);
        }

        return image;
    }

    public static int connectedSum(int n, List<String> edges) {
        Integer[][] adjacencyMatrix = new Integer[n][n];
        for (String s : edges) {
            int startingNode = Integer.valueOf(s.split(" ")[0]);
            int endingNode = Integer.valueOf(s.split(" ")[1]);
            System.out.println(startingNode + "," + endingNode);
            adjacencyMatrix[startingNode][endingNode] = 1;
        }

        List<Integer> sizeOfIsolatedSets = countIsolatedSets(adjacencyMatrix);
        int totalCost = 0;
        for (Integer cost : sizeOfIsolatedSets) {
            totalCost += Math.ceil(Math.sqrt(cost));
        }
        return totalCost;
    }

    private static List<Integer> countIsolatedSets(Integer[][] adjacencyMatrix) {
        ArrayList isolatedSets = new ArrayList();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    isolatedSets.add(dfs(adjacencyMatrix, i, j, 0));
                }

            }
        }
        return isolatedSets;
    }

    private static Integer dfs(Integer[][] adjacencyMatrix, int i, int j, int count) {
        if (i < 0 || i > adjacencyMatrix.length || j < 0 || j > adjacencyMatrix.length)
            return 0;
        count++;
        dfs(adjacencyMatrix, i - 1, j - 1, count);
        dfs(adjacencyMatrix, i - 1, j, count);
        dfs(adjacencyMatrix, i - 1, j + 1, count);
        dfs(adjacencyMatrix, i, j - 1, count);
        dfs(adjacencyMatrix, i, j, count);
        dfs(adjacencyMatrix, i, j + 1, count);
        dfs(adjacencyMatrix, i + 1, j - 1, count);
        dfs(adjacencyMatrix, i + 1, j, count);
        dfs(adjacencyMatrix, i + 1, j + 1, count);
        return count;
    }


    public long storage(int n, int m, List<Integer> h, List<Integer> v) {
        long area = 1;
        for (int i = 1; i <= n; ) {
            int length = 1;
            int width = 1;
            while (h.contains(i)) {
                i++;
                length++;
            }
            for (int j = 1; j <= m; ) {
                while (v.contains(j)) {
                    j++;
                    width++;
                }
                if (length * width > area)
                    area = length * width;
                j++;
            }
            i++;
        }
        return area;
    }

    public int addDigits(int n) {
        int divisor = 10;
        int sum = 0;
        for (int i = n; i > 0; i = i / divisor) {
            sum = sum + (i % divisor);
        }
        return sum;
    }

    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        HashMap<Integer, Integer> sum = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            sum.put(target - nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (sum.containsKey(nums[i]) && sum.get(nums[i]) != i) {
                result[0] = i;
                result[1] = sum.get(nums[i]);
                break;
            }

        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 0;
        int len2 = 0;
        ListNode cur = l1;
        for (len1 = 1; cur != null; len1++) {
            cur = cur.next;
        }
        cur = l2;
        for (len2 = 1; cur != null; len2++) {
            cur = cur.next;
        }

        int length = len1 > len2 ? len1 : len2;
        int carry = 0;
        int sum = 0;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode sumListHead = new ListNode();
        while (length > 0) {
            sum = ((null != cur1 ? cur1.val : 0) + (null != cur2 ? cur2.val : 0) + carry) % 10;
            ListNode curSum = new ListNode(sum);
            curSum.next = null;
            sumListHead.val = curSum.val;
            sumListHead.next = null;

            carry = ((null != cur1 ? cur1.val : 0) + (null != cur2 ? cur2.val : 0)) / 10;
            length--;

        }
        return null;
    }

    public int[] sortedSquares(int[] nums) {
        int p = 0;
        int q = 0;
        int[] results = new int[nums.length];
        while (p < nums.length && Math.abs(nums[p]) > Math.abs(nums[p + 1])) {
            p++;
        }
        q = p == nums.length ? p : p + 1;
        for (int j = 0; j < nums.length; j++) {
            if (p < 0 || (q < nums.length && Math.abs(nums[p]) >= Math.abs(nums[q]))) {
                results[j] = nums[q] * nums[q];
                q++;
            } else if (q >= nums.length || (p >= 0 && Math.abs(nums[p]) <= Math.abs(nums[q]))) {
                results[j] = nums[p] * nums[p];
                p--;
            }
        }
        return results;
    }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int max_index = 0;
        int difference = 0;
        int left = 0, right = 0;
        while (left < prices.length && right < prices.length) {
            if (prices[left] < min) {
                min = prices[left];
                right = left + 1;
                if (max_index < right) {
                    max = prices[right];
                    for (int i = right; i < prices.length; i++) {
                        if (prices[i] >= max && prices[i] > prices[left]) {
                            max = prices[i];
                            max_index = i;
                            if (prices[i] - prices[left] > difference) {
                                difference = prices[i] - prices[left];
                            }
                        }
                    }
                } else if (prices[max_index] - prices[left] > difference) {
                    difference = prices[max_index] - prices[left];
                }
            }
            left += 1;
            right = left + 1;

        }
        return difference;
    }

    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();
        for (int i = 0; i <= nums.length; i++) {
            if (numbers.containsKey(nums[i])) {
                return false;
            } else {
                numbers.put(nums[i], 1);
            }
        }
        return true;
    }

    public static List<Integer> sleepSort(int[] nums) {
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            SleepSortRun sleeper = new SleepSortRun(nums[i], output);
            new Thread(sleeper).start();
        }

        return output;
    }

    static class SleepSortRun implements Runnable {
        int val;
        ArrayList<Integer> result;

        public SleepSortRun(int num, ArrayList<Integer> output) {
            this.val = num;
            this.result = output;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000 * val);
                System.out.println("Print inside sleeping thread: " + val);
                result.add(val);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int maxSubArray(int[] nums) {
        int left = 0, right = left + 1;
        int localSum = nums[left];
        int globalSum = nums[left];
        if (nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];
        while (left < nums.length && right < nums.length) {
            if (localSum + nums[right] > nums[right]) {
                localSum = localSum + nums[right];
                right++;
            } else {
                left++;
                localSum = nums[left];
                right = left + 1;
            }
            globalSum = Math.max(localSum, globalSum);
        }

        return globalSum;
    }

    public int lengthOfLongestSubstring(String s) {
        int globalLength = 0;
        for (int left = 0; left < s.length(); left++) {
            Set<Character> visited = new HashSet<Character>();
            for (int right = left + 1; right < s.length(); right++) {
                Character c = s.charAt(right);
                if (visited.contains(c)) {
                    int length = visited.size();
                    globalLength = Math.max(length, globalLength);
                } else {
                    visited.add(c);
                }
            }
        }
        return globalLength;
    }

    public int maxEvents(List<Integer> arrival, List<Integer> duration) {
        HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
        for (int i = 0; i < arrival.size(); i++) {
            if (!visited.containsKey(arrival.get(i))) {
                visited.put(arrival.get(i), arrival.get(i) + duration.get(i));
            } else {
                int end_time1 = arrival.get(i) + visited.get(arrival.get(i));
                int end_time2 = arrival.get(i) + duration.get(i);
                if (end_time1 > end_time2) {
                    visited.put(arrival.get(i), end_time2);
                }
            }
        }

        Collections.sort(arrival);
        Integer meetings = 1;
        for (int i = 0; i < arrival.size() - 1; i++) {
            int start_time = arrival.get(i);
            int end_time = visited.get(start_time);
            if (end_time <= arrival.get(i + 1)) {
                visited.remove(arrival.get(i + 1));
            }
        }
        return visited.size();
    }

    public String solution(String S) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        int maxFrequency = 1;
        for (Character c : S.toCharArray()) {
            if (isVowel(c)) {
                frequency.merge(c, 1, Integer::sum);
                maxFrequency = Math.max(maxFrequency, frequency.get(c));
            }
        }
        StringBuilder sb = new StringBuilder();
        Character[] vowels = new Character[]{'a', 'e', 'i', 'o', 'u'};
        for (Character c : vowels) {
            if (frequency.containsKey(c) && frequency.get(c) == maxFrequency) {
                sb.append("\n").append(c).append(" ").append("appears ").append(maxFrequency).append(" ").append(maxFrequency == 1 ? "time" : "times");
            }
        }
        return sb.toString().trim();
    }

    public Boolean isVowel(Character ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public int[] sumZero(int n) {
        int dummyN = n;
        int[] output = new int[n];
        if (n == 1) return output;
        dummyN = (dummyN / 2) * -1;
        for (int i = 0; i < n; dummyN++) {
            if (dummyN == 0 && n % 2 == 0) {
                continue;
            } else {
                output[i++] = dummyN;
            }
        }
        return output;
    }

    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        int maxDegree = Integer.MIN_VALUE;
        for (int num : nums) {
            frequency.merge(num, 1, Integer::sum);
            maxDegree = Math.max(maxDegree, frequency.get(num));
        }
        int startIndex = 0;
        int endIndex = nums.length - 1;
        for (int li = 0; li < nums.length; li++) {
            Integer degree = frequency.get(nums[li]);
            if (degree == maxDegree) {
                for (int ri = nums.length - 1; ri > li; ri--) {
                    if (nums[ri] == nums[li] && (ri - li) < (endIndex - startIndex)) {
                        startIndex = li;
                        endIndex = ri;
                        break;
                    }
                }
            }
        }

        int length = maxDegree == 1 ? 1 : (endIndex - startIndex + 1);
        return length;
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int remainingAmount = amount;
        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            int coin = coins[i];
            while (remainingAmount >= coin) {
                remainingAmount -= coin;
                count++;
            }
        }
        return remainingAmount == 0 ? count : -1;
    }

    public int soln(String s) {
        String current = s;
        while (current.contains("01") || current.contains("10")) {
            current = current.replaceAll("(01|10)", "");
            current = current.replaceAll("\\s+", "");
        }
        return current.length();
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(subsets, nums);
        return subsets;
    }

    public List<List<Integer>> generateSubsets(List<List<Integer>> subsets, int[] nums) {
        if (nums.length == 0) {
            subsets.add(new ArrayList<>());
            return subsets;
        }
        generateSubsets(subsets, Arrays.copyOfRange(nums, 1, nums.length));
        List<List<Integer>> currentSubsets = new ArrayList<>();
        for (int i = 0; i < subsets.size(); i++) {
            List<Integer> currentSet = new ArrayList<>(subsets.get(i));
            currentSet.add(nums[0]);
            //String s = currentSet.stream().map(n -> String.valueOf(n)).collect(Collectors.joining("", "", ""));
            currentSubsets.add(currentSet);
        }
        subsets.addAll(currentSubsets);
        return subsets;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        generateSubsetsWithDup(subsets, nums, seen);
        return subsets;
    }

    public List<List<Integer>> generateSubsetsWithDup(List<List<Integer>> subsets, int[] nums, Set<String> seen) {
        if (nums.length == 0) {
            subsets.add(new ArrayList<>());
            seen.add("");
            return subsets;
        }
        generateSubsetsWithDup(subsets, Arrays.copyOfRange(nums, 1, nums.length), seen);
        List<List<Integer>> currentSubsets = new ArrayList<>();
        for (int i = 0; i < subsets.size(); i++) {
            List<Integer> currentSet = new ArrayList<>(subsets.get(i));
            currentSet.add(nums[0]);
            String s = currentSet.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(",", "", ""));
            if (seen.contains(s)) {
                System.out.println(s);
            }
            if (!seen.contains(s)) {
                currentSubsets.add(currentSet);
                seen.add(s);
            }
        }
        subsets.addAll(currentSubsets);
        return subsets;
    }

    public List<Integer> minimalHeaviestSetA(List<Integer> arr) {
        int left = 0;
        int right = arr.size() - 1;
        int sumA = 0;
        int sumB = 0;
        int rightIndex = 0;
        Collections.sort(arr);
        while (left < right) {
            sumA += arr.get(right);
            rightIndex = right;
            while ((sumB + arr.get(left)) < sumA && left < right) {
                sumB += arr.get(left);
                left++;
            }
            right--;
        }
        return arr.subList(rightIndex, arr.size());
    }

    public int countGroups(List<String> related) {
        int[][] matrix = new int[related.size()][];
        int i = 0;
        for (String s : related) {
            char[] chars = s.toCharArray();
            System.out.println(s);
            int j = 0;
            matrix[i] = new int[chars.length];
            for (char c : chars) {
                matrix[i][j] = c == '1' ? 1 : 0;
                j++;
            }
            i++;
        }

        int[] visited = new int[matrix.length];
        int count = 0;
        for (i = 0; i < matrix.length; i++) {
            if (visited[i] == 0) {
                dfsHelper(matrix, visited, i);
                count++;
            }
        }
        return count;
    }

    public void dfsHelper(int[][] matrix, int[] visited, int pos) {
        for (int j = 0; j < matrix.length; j++) {
            if (matrix[pos][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfsHelper(matrix, visited, j);
            }
        }
    }

    public void priorityQueueTest() {
        PriorityQueue<Character> minHeap
                = new PriorityQueue<>();

        String input = "gwefznknfxzl";
        for (Character c : input.toCharArray()) {
            minHeap.add(c);
        }
        System.out.println(minHeap);
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (Character c : input.toCharArray()) {
            maxHeap.add(c);
        }
        System.out.println(maxHeap);
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap= new PriorityQueue<>((a,b) -> (b[0]-a[0]) + (b[1]-a[1]));

        for (int[] point:points) {
            if(maxHeap.size() < k)
                maxHeap.add(point);
            else if (maxHeap.size() > k && point[0] < maxHeap.peek()[0] ){
                maxHeap.poll();
                maxHeap.add(point);
            }
        }
        int[][] result = new int[k][2];
        int i = 0;
        for (int[] point: maxHeap) {
            result[i][0] = point[0];
            result[i][1] = point[1];
            i++;
        }
        return result;

    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for(int num: nums){
            minHeap.add(num);
            if(minHeap.size()>k)
                minHeap.poll();
        }

        return minHeap.poll();
    }
    public int totalStrength(int[] strength) {
        List<List<Integer>> contiguousGroups  = new ArrayList<List<Integer>>();
        List<Integer> sumOfGroups = new ArrayList<Integer>();
        contiguousGroupGenerator(contiguousGroups, sumOfGroups, 0,  strength);
        return sumOfGroups.stream().mapToInt(a->a).sum();
    }

    private void contiguousGroupGenerator(List<List<Integer>> contiguousGroups, List<Integer> sumOfGroups, int size, int[] strength) {
        if (size == strength.length-1){
            List<Integer> contiguousGroup = Arrays.stream(strength).boxed().collect(Collectors.toList());
            contiguousGroups.add(contiguousGroup);
            sumOfGroups.add(generateSum(contiguousGroup));
        }
    }

    private Integer generateSum(List<Integer> contiguousGroup) {
        return null;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> combinedArrays = new ArrayList<>();
        int i = 0, j = 0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] <= nums2[j]){
                combinedArrays.add(nums1[i++]);
            }else{
                combinedArrays.add(nums2[j++]);
            }
        }
        if(i<nums1.length){
            while(i<nums1.length){
                combinedArrays.add(nums1[i++]);
            }
        }
        if(j<nums2.length){
            while(j<nums2.length){
                combinedArrays.add(nums2[j++]);
            }
        }

        double median;
        if(combinedArrays.size()%2 == 0){
            int index = combinedArrays.size()/2;
            median = (combinedArrays.get(index-1) + combinedArrays.get(index))/2.00;
        }else{
            int index = ((combinedArrays.size()+1)/2);
            median = combinedArrays.get(index-1);
        }
        return median;
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for(int num: nums){
            frequency.merge(num, 1, Integer::sum);
        }
        PriorityQueue<Integer> pq = new PriorityQueue((a,b) -> frequency.get(a) - frequency.get(b));
        for(Integer num: frequency.keySet()){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] result = new int[k];
        while(--k>=0){
            result[k]= pq.poll();
        }
        return result;
    }
    public void getIntervals(){
        Integer[][] input = new Integer[3][3];
        input[0][0] = 0;
        input[0][1] =200;
        input[1][0]=600;
        input[1][1]=1440;
        input[2][0]=200;
        input[2][1]=400;
        PriorityQueue<Integer[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for(Integer[] period: input){
            queue.add(period);
        }
        int i = queue.size();
        while(i-->1){
            Integer[] current = queue.poll();
            Integer[] next = queue.poll();
            if(current[1] >= next[0]){
                Integer[] merged = new Integer[2];
                merged[0]=current[0];
                merged[1] = current[1]>next[1]? current[1]: next[1];
                queue.add(merged);
            }else{
                queue.add(current);
                queue.add(next);
            }
        }
        int startTime =  0;
        List<Integer[]> intervals = new ArrayList<>();
        Iterator<Integer[]>  iter = queue.iterator();
        while (iter.hasNext()) {
            Integer[] period = iter.next();
            if(period[0] -  startTime > 0){
                Integer[] block = new Integer[2];
                block[0] = startTime;
                block[1] = period[0];
                intervals.add(block);
            }
            startTime=period[1];
        }
        Integer[] lastBlock = intervals.get(intervals.size() - 1);
        if(startTime < 1440){
            Integer[] block = new Integer[2];
            block[0] = lastBlock[1];
            block[1] = 1440;
            intervals.add(block);
        }
        for (Integer[] interval: intervals) {
            System.out.println("[" + interval[0] + "," + interval[1] + "]");
        }
    }
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        List<int[]> mergedIntervals = new ArrayList<>();
        int[] prev = new int[2];
        prev[0] = intervals[0][0];
        prev[1] = intervals[0][1];
        mergedIntervals.add(prev);

        for(int i=1; i< intervals.length; i++){
            int[] current = new int[2];
            current[0] = intervals[i][0];
            current[1] = intervals[i][1];
            if(prev[1]>=current[0]){
                prev[1] = Math.max(prev[1], current[1]);
            }else{
                mergedIntervals.add(current);
                prev = current;
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    long solution(int[] arr, int k, long s) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsetsOfSizeK(subsets, arr, k);
        int count = 0;
        for (List<Integer> subset: subsets) {
            Integer sum = subset.stream().mapToInt(Integer::valueOf).sum();
            if(sum == s) count++;
        }
        return count;
    }

    public void generateSubsetsOfSizeK(List<List<Integer>> subsets, int[] array, int size){
        if(array.length == 0){
            subsets.add(new ArrayList<>());
            return;
        }
        generateSubsetsOfSizeK(subsets, Arrays.copyOfRange(array, 1, array.length), size);

        for (List<Integer> subset:subsets) {
            if(subset.size() < size){
                subset.add(array[0]);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int[]  visited  = new int[isConnected.length];
        int count = 0;
        for(int i = 0; i< isConnected.length; i++){
            if(visited[i] != 1){
                count++;
                //dfsHelper(i, isConnected, visited);
            }
        }
        return  count;
    }
    public  void dfHelper(int index, int[][] isConnected, int[] visited ){
        visited[index] = 1;
        for(int j = 0; j< isConnected[index].length; ){

        }
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        //populate a queue with nodes of each level separated by null
        Queue<Node> pq = new LinkedList<Node>();
        pq.add(root);
        pq.add(null);
        Node prev = root;
        while(pq.size() > 0){
            int size = pq.size();
            Node cur = pq.poll();
            for (int i = 0; i < size; i++){
                if(null!=prev){
                    prev.next = cur;
                    if(null!= prev.left)
                        pq.add(prev.left);
                    if(null!= prev.right) pq.add(prev.right);
                }
                prev = cur;
            }
            pq.add(null);
            if(null == prev && null == cur)
                break;
        }

        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        sum = rangeSumBSTHelper(root, low, high, sum);
        return sum;
    }
    public int rangeSumBSTHelper(TreeNode root, int low, int high, int sum){
        if(null == root)
            return 0;
        if(low > root.val)
            sum = rangeSumBSTHelper(root.right, low, high, sum);
        else if(low <= root.val && root.val <= high){
            sum+=root.val + rangeSumBSTHelper(root.left, low, high, sum) + rangeSumBSTHelper(root.right, low, high, sum);
        }else if(high < root.val){
            sum = rangeSumBSTHelper(root.left, low, high, sum);
        }
        return sum;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        permutationHelper(permutations, new ArrayList(),  nums);
        return new ArrayList<>(permutations);
    }

    public void permutationHelper(List<List<Integer>> permutations, ArrayList tempList, int[] nums){
        if(nums.length == 1){
            tempList.add(nums[0]);
            permutations.add(new ArrayList<>(tempList));
            tempList.remove(tempList.size()-1);
        }else{
            for (int i = 0; i < nums.length; i++) {
                tempList.add(nums[i]);
                swap(nums, 0, i);
                permutationHelper(permutations, tempList, Arrays.copyOfRange(nums,1, nums.length));
                swap(nums, 0, i);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int smallestPositiveInteger(int[] A) {
        Arrays.sort(A);
        int low = 0; int high = A.length-1;
        while (low<=high){
            int mid = low + ((high-low)/2);
            if(A[mid]>0){
                high = low;
            }
        }
        BigInteger bi;

        return 1;

    }

    public int twitch(String S) {
        Integer upperLimit = 1048576;
        Stack<Integer> wordMachine = new Stack<>();
        for(String cur: S.split(" ")){
            if(cur.matches("^\\d+$")){
                try{
                    Integer current = Integer.parseInt(cur);
                    if(0 <= current && current < upperLimit)
                    {
                        wordMachine.push(current);
                    }
                    else{
                        return -1;
                    }
                }
                catch(Exception e){
                    return -1;
                }
            }else if(cur.equalsIgnoreCase("POP")){
                if(wordMachine.isEmpty()) return -1;
                wordMachine.pop();
            }else if(cur.equalsIgnoreCase("DUP")){
                if(wordMachine.isEmpty()) return -1;
                Integer top = wordMachine.peek();
                wordMachine.push(top);
            }else if(cur.equals("+")){
                if(wordMachine.size() < 2) return -1;
                Integer op1 = wordMachine.pop();
                Integer op2 = wordMachine.pop();
                Integer sum = op1+op2;
                if(sum < upperLimit){
                    wordMachine.push(sum);
                }else{
                    return 1;
                }
            }else if(cur.equals("-")){
                if(wordMachine.size() < 2) return -1;
                Integer op1 = wordMachine.pop();
                Integer op2 = wordMachine.pop();
                Integer diff = op1-op2;
                if(0> diff){
                    wordMachine.push(diff);
                }else{
                    return -1;
                }
            }
        }
        Integer result = wordMachine.isEmpty()? -1: wordMachine.peek();
        return result;
    }
}

