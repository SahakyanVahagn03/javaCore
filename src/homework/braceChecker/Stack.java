package homework.braceChecker;

public class Stack {
    private int[] stack = new int[10];
    private int size;
    private void extend() {
        int[] tamp = new int[stack.length + 10];
        if (size >= 0) System.arraycopy(stack, 0, tamp, 0, size);
        stack = tamp;
    }
    public Stack() {
        size = -1;
    }
    public void push(int value) {
        if (size == stack.length) {
            extend();
        }
        stack[++size] = value;
    }
    public int pop() {
        if (size == -1) {
            return -1;
        }
        return stack[size--];
    }
    public int getSize(){
        return size;
    }
}
