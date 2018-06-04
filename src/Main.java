/********************************************************************************************
 * @author Sheila Czech
 * @version 1.0.0
 * @since 4/29/18
 * @methods Main class has two methods:  getNumericInput to process the numbers the user
 * enters for the calculations and processStringInput that processes user commands.
 * @return Main class calls methods in the Calculation class to perform arithmetic operations.
 * User has the option to continue performing calculations or typing exit to quit the program
 *********************************************************************************************/

import java.util.Scanner;

public class Main extends Calculation {
    public static void main(String[] args) {
        //inUse determines whether or not the program should keep running
        boolean inUse = true;

        //declare and initialize variables needed for calculations
        double firstNumber = 0;
        double secondNumber = 0;
        String operator;

        //prompt for user to start a calculation
        final String introPrompt = "Do you want to perform a calculation?  Type on to continue or off to quit." +
                "\nType help to show the possible operations.";

        //Print introduction to get the user started
        System.out.println(introPrompt);

        Scanner inputReader = new Scanner(System.in);

        inUse = processStringInput(inputReader, inUse);

        //use while loop to allow user to perform multiple calculations
        while(inUse) {
            //prompt for the first operand and convert to double
            System.out.println("Please enter a first number: ");
            firstNumber = getNumericInput(inputReader);

            //prompt for an operator to be used in the calculation
            System.out.println("Please enter an operator: ");

            boolean operatorValid = true;

            do{
                operator = inputReader.next();
                if (operator.equalsIgnoreCase("+") ||
                            operator.equalsIgnoreCase("-") ||
                            operator.equalsIgnoreCase("*") ||
                            operator.equalsIgnoreCase("/") ||
                            operator.equalsIgnoreCase("%") ||
                            operator.equalsIgnoreCase("^") ||
                            operator.equalsIgnoreCase("~")) {
                    operatorValid = true;
                }else{
                    System.out.println("Please enter a valid operator: ");
                    operatorValid = false;
                }
            } while (!operatorValid);


            //prompt for a second operand and convert from String to double
            System.out.println("Please enter a second number: ");
            secondNumber = getNumericInput(inputReader);

            //determine what type of calculation to perform based on the operator the user entered
            if (operator.equalsIgnoreCase("+")) {
                System.out.println(Calculation.addFirstAndSecond(firstNumber, secondNumber));
            } else if (operator.equalsIgnoreCase("-")) {
                System.out.println(Calculation.subtractFirstNumberFromSecondNumber(firstNumber, secondNumber));
            } else if (operator.equalsIgnoreCase("*")) {
                System.out.println(Calculation.multiplyFirstNumberAndSecondNumber(firstNumber, secondNumber));
            } else if (operator.equalsIgnoreCase("/")) {
                System.out.println(Calculation.divideFirstNumberBySecondNumber(firstNumber, secondNumber));
            } else if (operator.equalsIgnoreCase("%")) {
                System.out.println(Calculation.firstNumberModuloSecondNumber(firstNumber, secondNumber));
            } else if (operator.equalsIgnoreCase("^")) {
                System.out.println(Calculation.firstNumberRaisedToSecondNumber(firstNumber, secondNumber));
            } else if (operator.equalsIgnoreCase("~")){
                System.out.println(Calculation.rootOfFirstNumber(firstNumber, secondNumber));
            }

            //give user an option to perform more calculations or to quit the program
            System.out.println(introPrompt);
            inUse = processStringInput(inputReader, inUse);
        }
    }

    /************************************************************************************
     * getNumericInput takes in the user input from the scanner to be used in the user's
     * desired calculations
     * @param numberScanner is passed in to get input from the user
     * @return numberInput is of type double and will be used in the calculation
     ************************************************************************************/

    public static double getNumericInput(Scanner numberScanner){
        double numberInput = 0;
        boolean numberValid = true;

        do{
            String numberString = numberScanner.next();
            try{
                numberInput = Calculation.stringToDouble(numberString);
                numberValid = true;
            } catch (NumberFormatException e){
                System.out.println("Please enter a valid number: ");
                numberValid = false;
            }
        } while (!numberValid);

        return numberInput;
    }

    /***********************************************************************************
     * processStringInput takes in the scanner input and processes user commands such as
     * help, on, and off
     * @param operatorScanner is passed in to read the user input for commands
     * @param bool is passed in and process to determiine whether or not the user will
     * continue to use the program.
     * @return bool is returned to determine whether or not the user will continue
     * using the program.
     **********************************************************************************/

    public static boolean processStringInput(Scanner operatorScanner, boolean bool){
        //help message to introduce the user to the functionality of the program
        final String help = "\nWelcome to the calculator program. To use this calculator program, provide the desired input at the prompts." +
                "\n\nArithmetic operations" +
                "\naddition:            input + at the operation prompt to add one number to another number" +
                "\nsubtraction:         input - at the operation prompt to subtract one number from another number" +
                "\ndivision:            input / at the operation prompt to divide one number by another number" +
                "\nmultiplication:      input * at the operation prompt to multiply one number by another" +
                "\nexponent:            input ^ at the operation prompt to raise one number to the power of another number" +
                "\nroot of a number:    input ~ at the operation prompt to get any root of a first number" +
                "\n\nYou can type in pi at the number prompt to use pi as one of your operands";

        String stringInput;
        boolean responseValid = true;

        do {
            stringInput = operatorScanner.next();
            if (stringInput.equalsIgnoreCase("on") ||
                    stringInput.equalsIgnoreCase("help") ||
                    stringInput.equalsIgnoreCase("off")){
                responseValid = true;
            }else{
                System.out.println("Please enter a valid command:");
                responseValid = false;
            }
        }while(!responseValid);


        if (stringInput.equalsIgnoreCase("on")) {
            bool = true;
        }else if (stringInput.equalsIgnoreCase("help")){
            bool = true;
            System.out.println(help);
        }else if (stringInput.equalsIgnoreCase("off")){
            bool = false;
            operatorScanner.close();
            System.exit(1);
        }
        return bool;
    }
}

