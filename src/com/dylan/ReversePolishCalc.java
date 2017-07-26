package com.dylan;

public class ReversePolishCalc {
    // You'll need a variable here to keep track of the top of the stack
    int numStack;
    double number1;
    double number2;

    // The array of the input string split up
    private String[] tokens;

    // The stack
    private String[] stack;


    public double calculate(String input) {


        // 1. Use the String split method to split the string into tokens at the commas
         tokens = input.split(",");

        // 2. Allocate a stack as big as the number of tokens
         stack = new String[tokens.length];


        // 3. write the algorithm
        for (String token : tokens) {
            // calls to push() and pop() and do the math here
            switch (token) {
                case "+":
                    number2 = pop();
                    number1 = pop();
                    push(number1 + number2);
                    break;
                case "-":
                    number2 = pop();
                    number1 = pop();
                    push(number1 - number2);
                    break;
                case "*":
                    number2 = pop();
                    number1 = pop();
                    push(number1 * number2);
                    break;
                case "/":
                    number2 = pop();
                    number1 = pop();
                    push(number1 / number2);
                    break;
                default:
                    push(token);
                    break;

            }


        }

        // 4. return the result
        return pop();
    }

    private void push(String number) {
        // push on the stack
        stack[numStack] = number;
        numStack++;

    }

    private void push(double d) {
        // change the double to a string and then push it on the stack
        String number = Double.toString(d);
        stack[numStack] = number;
        numStack++;
    }

    private double pop() {
        // remove the string from the top of the stack and convert it to a double and return it
        numStack--;
        double number = Double.parseDouble(stack[numStack]);
        return number;
    }
}






