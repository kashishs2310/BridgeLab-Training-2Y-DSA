import java.util.Stack;
import java.util.Scanner;

public class postfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the infix expression: ");
        String infix = sc.nextLine();

        String postfixExpression = convertToPostfix(infix);
        int answer = evaluatePostfix(postfixExpression);

        System.out.println("Postfix expression: " + postfixExpression);
        System.out.println("Answer: " + answer);

        sc.close();
    }

    public static String convertToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        String postfix = "";

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (ch == ' ') {
                continue;
            }

            if (Character.isDigit(ch)) {
                postfix = postfix + ch;
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix = postfix + stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(ch)) {
                    postfix = postfix + stack.pop();
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfix = postfix + stack.pop();
        }

        return postfix;
    }

    public static int priority(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        }

        if (ch == '*' || ch == '/') {
            return 2;
        }

        return 0;
    }

    public static int evaluatePostfix(String postfixExpression) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < postfixExpression.length(); i++) {
            char ch = postfixExpression.charAt(i);

            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int secondNumber = stack.pop();
                int firstNumber = stack.pop();
                int result = 0;

                if (ch == '+') {
                    result = firstNumber + secondNumber;
                } else if (ch == '-') {
                    result = firstNumber - secondNumber;
                } else if (ch == '*') {
                    result = firstNumber * secondNumber;
                } else if (ch == '/') {
                    result = firstNumber / secondNumber;
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }
}
