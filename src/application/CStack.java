package application;

public class CStack<T extends Comparable<T>> implements Stackable<T> {
    private CursorArray<T> stackCursorArray;
    private int p;
    private T top;  

    public CStack(int capacity) {
        this.stackCursorArray = new CursorArray<>(capacity + 1);
        p = stackCursorArray.createList();
    }

    @Override
    public void push(T data) {
        stackCursorArray.insertAtHead(data, p);
        top = data;  
    }

    @Override
    
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T itemToPop = top;
        
        stackCursorArray.delete(itemToPop, p);
        top = null;
        return itemToPop;
    }

    @Override
    public T peek() {
        return top;  
    }

    @Override
    public boolean isEmpty() {
        return stackCursorArray.isEmpty(p);
    }

    @Override
    public void clear() {
        stackCursorArray.clear(p);
        top = null; 
    }
}
