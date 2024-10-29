package application;

public class SQueue<T extends Comparable<T>> implements Queueable<T> {
	private StackLinkedStack<T> stack = new StackLinkedStack<>();

	@Override
	public T dequeue() {
		T data = null;
		if (!stack.isEmpty()) {
			data = stack.pop().getData();
		}
		return data;
	}

	@Override
	public T getFront() {
		T data = null;
		if (!stack.isEmpty()) {
			data = stack.peek().getData();
		}
		return data;
	}

	@Override
	public void enqueue(T data) {
		StackLinkedStack<T> tempStack = new StackLinkedStack<>();
		while (!stack.isEmpty()) {
			tempStack.push(stack.pop().getData());
		}
		stack.push(data);
		while (!tempStack.isEmpty()) {
			stack.push(tempStack.pop().getData());
		}
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public void clear() {
		if (!stack.isEmpty()) {
			stack.clear();
		}

	}

	@Override
	public String toString() {
		String string = "";
		StackLinkedStack<T> tempStack = new StackLinkedStack<>();
		while (!stack.isEmpty()) {
			tempStack.push(stack.pop().getData());
		}
		while (!tempStack.isEmpty()) {
			Node<T> node = tempStack.pop();
			stack.push(node.getData());
			string += node.getData() + " ";
		}

		return string;
	}

	
}