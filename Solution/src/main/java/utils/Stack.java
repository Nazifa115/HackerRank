package utils;

import java.util.ArrayList;

public class Stack {
	ArrayList<Object> stack;
	
	public Stack() {
		this.stack = new ArrayList<>();
	}

	public void push(Object value) {
		stack.add(value);
	}

	public Object pop() {
		if (stack.size() > 0) {
			Object returnElement = stack.get(stack.size() - 1);
			stack.remove(stack.size() - 1);
			return returnElement;
		}
		return null;

	}

	public int getSize() {
		return stack.size();
	}

	public void clearStack() {
		stack.clear();
	}
}
