package Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String continueCalculate = "yes", addPreviousSum = "no";
        boolean shouldContinue = true;
        double firstNum;

        double secondNum;
        char operator = ' ';
        double sum = 0;


        System.out.println("""
                **************************
                   🤖 The Calculator 🤖
                **************************
                """);

        do {
                if (continueCalculate.equals("yes")) {
                    operator = ' ';

                    if (addPreviousSum.equals("yes")){
                        firstNum = sum;
                    }
                    else{
                        firstNum = selectNumber(scanner, operator);
                    }
                    operator = selectOperator(scanner);
                    secondNum = selectNumber(scanner, operator);
                    sum = makeCalculation(firstNum, secondNum, sum, operator);
                    System.out.printf("""
                            ***************************************************
                                            %s %s %s = %s
                            ***************************************************
                            %n""", firstNum, operator, secondNum, sum);
                    System.out.print("Do you wish to continue calculate? Type 'yes'/'no': ");
                    continueCalculate = scanner.nextLine();
//                    System.out.println(continueCalculate);
                    if (continueCalculate.equals("yes")){
                        System.out.println("************************************************************************");
                        System.out.print("Do you wish to apply calculation to the result (" + sum + ")? Type 'yes'/'no': ");
                        addPreviousSum = scanner.nextLine();
                        System.out.println("************************************************************************");
                    }

                } else if (continueCalculate.equals("no")) {
                    shouldContinue = false;
                    System.out.println();
                    System.out.println("""
                            *************************************
                                    🤖 Have a nice day 🤖
                            *************************************
                            """);
                } else {
                    System.out.println();
                    System.out.println("""
                    ************************************************************************
                                       🥸 Write EITHER 'yes' or 'no' 🥸
                    ************************************************************************
                    """);
                    System.out.println();
                    System.out.print("Do you wish to continue calculate? Type 'yes'/'no': ");
                    continueCalculate = scanner.nextLine();
//                    System.out.println(continueCalculate);
                    if (continueCalculate.equals("yes")){
                        System.out.println("************************************************************************");
                        System.out.print("Do you wish to apply calculation to the result (" + sum + ")? Type 'yes'/'no': ");
                        addPreviousSum = scanner.nextLine();
                        System.out.println("************************************************************************");

                    }
                }
        }while (shouldContinue);
    }

    public static double makeCalculation(double n1, double n2, double sum, char operator) {

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

    public static double selectNumber(Scanner scanner, char operator) {
        double num = 1;
        boolean InputIsValid;
        do {
            try {
                System.out.print("Enter number: ");
                num = scanner.nextDouble();
                InputIsValid = true;
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("""
                        *************************************************
                                 🧐 Hey, that wasn't a number 🧐
                        *************************************************
                        """);
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
                    System.out.println();
                    System.out.println("""
                    *****************************************
                          🥸 YOU CAN'T DIVIDE BY ZERO! 🥸
                    *****************************************
                    """);
                    InputIsValid = false;
                }
            }
        } while (!InputIsValid);

        return num;
    }

    public static char selectOperator(Scanner scanner) {

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
                System.out.println();
                System.out.println("""
                        ***********************************************************************
                                   🧐 Pay attention, that wasn't a valid operator 🧐
                        ***********************************************************************
                        """);
                scanner.nextLine();
            }
        } while (!InputIsValid);

        return operator;
    }
}
