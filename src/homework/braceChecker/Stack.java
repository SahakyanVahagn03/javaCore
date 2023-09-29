package homework.braceChecker;

public class Stack {
    //
    private int[] stack = new int[10];
    private int size;
    private void checkIfNeedToExtend() {
        if (size == stack.length) {
            extend();
        }
    }
    private void extend() {
        int[] tamp = new int[stack.length + 10];
        if (size >= 0) System.arraycopy(stack, 0, tamp, 0, size);
        stack = tamp;
    }
    public Stack() {
        size = -1;
    }
    public void push(int value) {
        checkIfNeedToExtend();
        stack[++size] = value;
    }
    public int pop() {
        if (size == -1) {
            return -1;
        }
        return stack[size--];
    }
    public boolean exists(int value) {
        for (int valueOfTheArray : stack) {
            if (valueOfTheArray == value) {
                return true;
            }
        }
        return false;
    }
    public int getSize(){
        return size;
    }
}
