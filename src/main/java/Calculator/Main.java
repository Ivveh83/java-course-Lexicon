package Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String choiceContinueProgram = "yes";
        boolean shouldContinue = true;


        System.out.println("""
                **************************
                Welcome to the Calculator
                **************************
                """);

        do {
            try {
                if (choiceContinueProgram.equals("yes")) {

                    double firstNum;
                    double secondNum;
                    char operator = ' ';
//                    System.out.print("Would you like to reset sum or add or subtract from it? ('yes'/'no'): ");
                    double sum = 0;

                    firstNum = selectNumber(operator);
                    operator = selectOperator();
                    secondNum = selectNumber(operator);
                    sum = makeCalculation(firstNum, secondNum, sum, operator);
                    System.out.println(firstNum + " " + operator + " " + secondNum + " = " + sum);
                    System.out.print("Do you wish to continue calculate? Type 'yes'/'no': ");
                    choiceContinueProgram = scanner.nextLine();
                    System.out.println("Do you wish to add sum to next addition or subtraction? Type 'yes'/'no': ");
                    choiceContinueProgram = scanner.nextLine();


//                    do {
//                        try {
//                            System.out.print("Enter the first number: ");
//                            firstNum = scanner.nextDouble();
//                            allInputsIsValid = true;
//                        } catch (InputMismatchException e) {
//                            System.out.println("That wasn't a number!");
//                            allInputsIsValid = false;
//                        } catch (Exception e) {
//                            System.out.println("Something went wrong.");
//                            allInputsIsValid = false;
//                        } finally {
//                            scanner.nextLine();
//                        }
//                    }while (!allInputsIsValid);


//                    if (allInputsIsValid){
//                        do {
//                            try {
//                                System.out.print("Enter the second number: ");
//                                secondNum = scanner.nextDouble();
//                                allInputsIsValid = true;
//                            } catch (InputMismatchException e) {
//                                System.out.println("That wasn't a number!");
//                                allInputsIsValid = false;
//                            } catch (Exception e) {
//                                System.out.println("Something went wrong.");
//                                allInputsIsValid = false;
//                            } finally {
//                                scanner.nextLine();
//                            }
//                        }while (!allInputsIsValid);
//
//                    }

//                    if (allInputsIsValid) {
//                        do {
//                                System.out.print("Type in an operator ('+', '-', '*', '/'): ");
//                                operator = scanner.next().charAt(0);
//                                if (operator == '+' || operator == '-' || operator == '/' || operator == '*'){
//                                    allInputsIsValid = true;
//                                    scanner.nextLine();
//                                }
//                                else {
//                                    allInputsIsValid = false;
//                                    System.out.println("That wasn't a valid operator!");
//                                    scanner.nextLine();
//                                }
//                        }while (!allInputsIsValid);
//                    }

//                    try {
//                        sum = makeCalculation(firstNum, secondNum, sum, operator);
//                        System.out.println(firstNum + " " + operator + " " + secondNum + " = " + sum);
//                    } catch (ArithmeticException e) {
//                        System.out.println("YOU CAN'T DIVIDE BY ZERO!");
//                    }

                } else if (choiceContinueProgram.equals("no")) {
                    shouldContinue = false;
                    System.out.println("Exit Calculator");
                } else {
                    System.out.println("Write either 'yes' or 'no'");
                }
            }catch (InputMismatchException e){
                System.out.println("Write either yes or no");
            }
        }while (shouldContinue);
    }

    static double makeCalculation(double n1, double n2, double sum, char operator) {

        switch (operator) {
            case '+' -> {
                return n1 + n2;
            }
            case '-' -> {
                return n1 - n2;
            }
            case '*' -> {
                return n1 * n2;
            }
            case '/' -> {
                if (n2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                } else {
                    return n1 / n2;
                }
            }
        }
        return sum;
    }

    static double selectNumber(char operator) {
        double num = 0;
        Scanner scanner = new Scanner(System.in);
        boolean InputIsValid = true;
        do {
            try {
                System.out.print("Enter the number: ");
                num = scanner.nextDouble();
                InputIsValid = true;
            } catch (InputMismatchException e) {
                System.out.println("That wasn't a number!");
                InputIsValid = false;
            } catch (Exception e) {
                System.out.println("Something went wrong.");
                InputIsValid = false;
            }
            finally {
                scanner.nextLine();
            }
            if (operator == '/') {
                if (num == 0) {
                    System.out.println("YOU CAN'T DIVIDE BY ZERO!");
                    InputIsValid = false;
                }
            }
        } while (!InputIsValid);

        return num;
    }

    static char selectOperator() {

        Scanner scanner = new Scanner(System.in);
        boolean InputIsValid;
        char operator = ' ';

        do {
            System.out.print("Type in an operator ('+', '-', '*', '/'): ");
            operator = scanner.next().charAt(0);
            if (operator == '+' || operator == '-' || operator == '/' || operator == '*') {
                InputIsValid = true;
                scanner.nextLine();
            } else {
                InputIsValid = false;
                System.out.println("That wasn't a valid operator!");
                scanner.nextLine();
            }
        } while (!InputIsValid);
        return operator;
    }
}
