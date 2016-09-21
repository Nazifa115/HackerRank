//Complete this code or write your own from scratch
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*Introduction
 Suppose you are creating an internal networking site for your company.

 You have two data sets to work with. The first data set is the employees at your company, and the second is all the pairs of employees who are virtually friends so far. It does not matter which employee’s ID is in which column, the friendships are bidirectional. To get started, you need to parse and represent each data set in its entirety in code.

 Furthermore, you also need to implement a function that, given the employees and friendships as parameters, returns this data in the form of an adjacency list representation. This is a mapping of each employee ID to a list of his/her friends on the site.*/

class Solution {
	public static void main(String[] args) {

		Solution solution = new Solution();
		HashMap<Integer, Employee> employeeList = new HashMap<Integer, Employee>();

		if (args.length == 0) {
			System.out.println("Error: Bad command or filename.");
			System.exit(0);
		} else {
			String employeeFileName = args[0]; /*
												 * Assuming the filename is
												 * passed as an argument to the
												 * main function
												 */
			String friendshipFileName = args[1];

			try {

				BufferedReader reader = new BufferedReader(new FileReader(
						employeeFileName));
				String line = null;
				Scanner scanner = null;
				int lineCount, id = 0;
				String name = null, dept;
				while ((line = reader.readLine()) != null) {
					lineCount = 1;
					scanner = new Scanner(line);
					scanner.useDelimiter(",");
					while (scanner.hasNext()) {
						// scanCount = 1;
						String data = scanner.next();
						if (!data.equalsIgnoreCase("employee_id")
								&& !data.equalsIgnoreCase("name")
								&& !data.contains("department")) {
							if (lineCount == 1) {
								id = Integer.parseInt(data);
								lineCount++;
							} else if (lineCount == 2) {
								name = data;
								lineCount++;
							} else if (lineCount == 3) {
								dept = data;
								Employee curEmp = solution.new Employee(id++,
										name, dept);
								employeeList
										.put(curEmp.getEmployeeId(), curEmp);
								lineCount = 0;
							}
						}
					}
				}

				reader = new BufferedReader(new FileReader(friendshipFileName));
				line = null;
				scanner = null;
				ArrayList<String> friendIDs = new ArrayList<String>();
				try {
					int count = 0;
					while ((line = reader.readLine()) != null) {
						scanner = new Scanner(line);
						scanner.useDelimiter(",");
						while (scanner.hasNext()) {
							String data = scanner.next();
							if (count > 0) {
								friendIDs.add(data);
							}
						}
						count++;
					}
					reader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				// System.out.println(friendIDs.size());
				for (Iterator iterator = friendIDs.iterator(); iterator
						.hasNext();) {
					String f_1 = (String) iterator.next();
					// System.out.println("f_1:" + f_1);
					Integer f_1_id = Integer.parseInt(f_1);
					Employee emp_f_1 = employeeList.get(f_1_id);
					String f_2 = (String) iterator.next();
					Integer f_2_id = Integer.parseInt(f_2);
					// System.out.println(f_2);
					Employee emp_f_2 = employeeList.get(f_2_id);
					emp_f_1.addFriends(f_2_id);
					emp_f_2.addFriends(f_1_id);
				}
				generateAdjacencyList(employeeList);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	private static void generateAdjacencyList(
			HashMap<Integer, Employee> employeeList) {
		Iterator it = employeeList.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			Employee curEmp = (Employee) pair.getValue();
			if (curEmp.get_friend_list_size() > 0) {
				System.out.println(curEmp.getEmployeeId() + ": "
						+ curEmp.getFriends());
			}else {
				System.out.println(curEmp.getEmployeeId() + ": "
						+ "None");
			}
		}
	}

	public class Employee {
		Integer employeeId;
		String name, department;
		List<Integer> friends = new ArrayList<Integer>();

		public String getFriends() {
			StringBuilder builder = new StringBuilder();
			for (Iterator iterator = friends.iterator(); iterator.hasNext();) {
				Integer integer = (Integer) iterator.next();
				builder.append(integer);
				if (iterator.hasNext())
					builder.append(", ");
			}
			return builder.toString();
		}

		public void addFriends(Integer id) {
			this.friends.add(id);
		}

		public int get_friend_list_size() {
			return friends.size();
		}
		
		public Integer getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(Integer employeeId) {
			this.employeeId = employeeId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public Employee(Integer id, String name, String dept) {
			this.employeeId = id;
			this.name = name;
			this.department = dept;
		}
	}

}
