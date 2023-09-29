package homework.braceChecker;


public class BraceChecker {
    ///
    private String text;
    private Stack stack = new Stack();
    private int index;
    public BraceChecker(String text) {
        this.text = text;
    }
    public void check() {
        for (index = 0; index < text.length(); index++) {
            char symbol = text.charAt(index);
            switch (symbol) {
                case '{':
                case '[':
                case '(':
                    stack.push(symbol);
                    break;
                case '}':
                case ']':
                case ')':
                    if (stack.getSize() == -1){
                        System.err.println("closed " + text.charAt(index) + " but didn't open");
                    }else {
                        char pop = (char) stack.pop();
                        if (symbol == '}' && pop != '{' || symbol == ']' && pop != '[' || symbol == ')' && pop != '('){
                            System.err.println("opened " + pop + " but closed " + symbol + " by index is " + (index)+"-th");
                        }
                    }
            }
        }
        int stackSize = stack.getSize();
        for (int i = 0; i <= stackSize; i++) {
            System.err.println("opened " + (char) stack.pop() + " but didn't close");
        }
    }
}
