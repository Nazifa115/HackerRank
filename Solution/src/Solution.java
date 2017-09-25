import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
Graduation year: 2017
Applying as: New Grad
*/
class Solution {

	class Node {
		String value;
		boolean visited;

		public Node(String val, boolean visit) {
			this.value = val;
			this.visited = visit;
		}
	}

	public static List<List<String>> createWorkflowStages(List<List<String>> precursorSteps) {
		// IMPLEMENTATION GOES HERE
		List<List<String>> result = new ArrayList<>();
		HashMap<Integer, ArrayList<String>> resultHashMap = new HashMap<>();
		HashMap<String, ArrayList<String>> dependencyTree = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < precursorSteps.size(); i++) {
			List<String> curList = precursorSteps.get(i);
			String dependency = curList.get(0);
			String dependant = curList.get(1);
			if (dependencyTree.containsKey(dependant)) {
				ArrayList<String> curDependencyList = dependencyTree.get(dependant);
				curDependencyList.add(dependency);
				dependencyTree.put(dependant, curDependencyList);
			} else {
				ArrayList<String> curDependencyList = new ArrayList<String>();
				curDependencyList.add(dependency);
				dependencyTree.put(dependant, curDependencyList);
			}
			if (!dependencyTree.containsKey(dependency)) {
				ArrayList<String> curDependencyList = new ArrayList<String>();
				dependencyTree.put(dependency, curDependencyList);
			}
		}

		Set<String> keys = dependencyTree.keySet();
		int level = 0;
		while (!keys.isEmpty()) {
			ArrayList<String> leasfNodesAtCurrentLevel = new ArrayList<>();
			for (Entry<String, ArrayList<String>> e : dependencyTree.entrySet()) {
				String key = e.getKey();
				ArrayList<String> value = e.getValue();
				if (value.size() == 0) {
					leasfNodesAtCurrentLevel.add(key);
					dependencyTree.remove(key);

					Iterator<Map.Entry<String, ArrayList<String>>> iter = dependencyTree.entrySet().iterator();
					while (iter.hasNext()) {
						String curKey = iter.next().getKey();
						ArrayList<String> dependencyList = dependencyTree.get(curKey);
						ArrayList<String> tempDepenedncyList = dependencyList;
						if (tempDepenedncyList.contains(key)) {
							tempDepenedncyList.remove(key);
						}

						dependencyList = new ArrayList<>(tempDepenedncyList);

						dependencyTree.put(curKey, dependencyList);

					}

				}
			}

			resultHashMap.put(level, leasfNodesAtCurrentLevel);
			level++;
		}

		for (Entry<Integer, ArrayList<String>> e : resultHashMap.entrySet()) {
			ArrayList<String> value = e.getValue();
			result.add(value);
		}
		return result;
	}

	// START TEST CASES
	//
	// You can add test cases below. Each test case should be an instance of
	// Test
	// constructed with:
	//
	// Test(String name, List<List<String>> input, List<List<String>>
	// expectedOutput);
	//

	static List<Test> tests = Arrays.asList(
			new Test(
					// name
					"build stages",
					// input
					Arrays.asList(Arrays.asList("clean", "build"), Arrays.asList("metadata", "binary"),
							Arrays.asList("build", "link"), Arrays.asList("link", "binary"),
							Arrays.asList("clean", "metadata"), Arrays.asList("build", "resources")),
					// expected output
					Arrays.asList(Arrays.asList("clean"), Arrays.asList("build", "metadata"),
							Arrays.asList("resources", "link"), Arrays.asList("binary"))),
			new Test(
					// name
					"making dinner",
					// input
					Arrays.asList(Arrays.asList("boil", "serve"), Arrays.asList("chop", "boil"),
							Arrays.asList("stir", "boil"), Arrays.asList("set table", "serve")),
					// expected output
					Arrays.asList(Arrays.asList("chop", "stir", "set table"), Arrays.asList("boil"),
							Arrays.asList("serve"))));

	// END TEST CASES
	// DO NOT MODIFY BELOW THIS LINE

	private static class Test {

		public String name;
		public List<List<String>> input;
		public List<List<String>> expectedOutput;

		public Test(String name, List<List<String>> input, List<List<String>> expectedOutput) {
			this.name = name;
			this.input = input;
			this.expectedOutput = expectedOutput;
		}
	}

	private static boolean equalOutputs(List<List<String>> a, List<List<String>> b) {
		if (a == null || b == null || a.size() != b.size()) {
			return false;
		}
		for (int i = 0; i < a.size(); i++) {
			List<String> a1 = new ArrayList<>(a.get(i));
			List<String> b1 = new ArrayList<>(b.get(i));
			a1.sort(null);
			b1.sort(null);
			if (!a1.equals(b1)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int passed = 0;
		for (Test test : tests) {
			System.out.printf("==> Testing %s...\n", test.name);
			List<List<String>> actualOutput = createWorkflowStages(test.input);
			if (equalOutputs(actualOutput, test.expectedOutput)) {
				System.out.println("PASS");
				passed++;
			} else {
				System.out.println("FAIL");
				System.out.printf("Input: %s\n", test.input);
				System.out.printf("Expected output: %s\n", test.expectedOutput);
				System.out.printf("Actual output: %s\n", actualOutput);
			}
		}
		System.out.printf("==> Passed %d of %d tests\n", passed, tests.size());
	}
}
