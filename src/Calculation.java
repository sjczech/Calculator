/*******************************************************************************************
 * Calculation is a helper class that provides a number of methods to perform calculations
 * @methods stringToDouble, addFirstAndSecond, subtractFirstNumberFromSecondNumber,
 * multiplyFirstNumberAndSecondNumber, divideFirstNumberBySecondNumber, firstNumberModuloSecondNumber
 * firstNumberRaisedToSecondNumber, rootOfFirstNumber
 *********************************************************************************************/
import java.lang.Math;

public class Calculation {

    /*********************************************************************************************************************************************
     * stringToDouble() converts a string input that the user provides at a prompt into a double that can be used for arithmetic operations
     * @param input is of type String
     * @return parsedDouble is of type double and is converted from String input for use for arithmetic operations
     ********************************************************************************************************************************************/

    protected static Double stringToDouble(String input){
        //if user inputs the string pi, convert to double for calculations
        double parsedDouble = 0;
        if(input.equalsIgnoreCase("pi")){
            parsedDouble = Math.PI;
        } else {
            parsedDouble = Double.parseDouble(input);
        }
        return parsedDouble;
    }

    /**********************************************************************************************
     * addFirstAndSecond() adds the two doubles passed into the function and returns a double
     * @param firstNumber is of type double
     * @param secondNumber is of type double
     * @return additionResult of type double is returned
     **********************************************************************************************/

    protected static Double addFirstAndSecond(double firstNumber, double secondNumber){
        double additionResult = firstNumber + secondNumber;
        return additionResult;
    }

    /***********************************************************************************************************
     * subtractFirstNumberFromSecondNumber() subtracts the first double passed in from the second double
     * @param firstNumber is of type double
     * @param secondNumber is of type double
     * @return subtractionResult is of double
     ***********************************************************************************************************/

    protected static Double subtractFirstNumberFromSecondNumber(double firstNumber, double secondNumber){
        double subtractionResult = firstNumber - secondNumber;
        return subtractionResult;
    }

    /***********************************************************************************************************
     * multiplyFirstNumberAndSecondNumber() multiplies the first double passed in from the second double
     * @param firstNumber is of type double
     * @param secondNumber is of type double
     * @return multiplicationResult is of type double
     ***********************************************************************************************************/

    protected static Double multiplyFirstNumberAndSecondNumber(double firstNumber, double secondNumber){
        double multiplicationResult = firstNumber * secondNumber;
        return multiplicationResult;
    }

    /***********************************************************************************************************
     * divideFirstNumberBySecondNumber() divides the first double passed in by the second double
     * @param firstNumber is of type double
     * @param secondNumber is of type double
     * @return divisionResult is of type double.  divisionResult returns 0 if secondNumber is invalid for this operation.
     ***********************************************************************************************************/

    protected static Double divideFirstNumberBySecondNumber(double firstNumber, double secondNumber){
        double divisionResult = 0;
        if (secondNumber == 0){
            System.out.println("You cannot divide by zero. Your result has been set to zero.");
        }else{
            divisionResult = firstNumber/secondNumber;
        }
        return divisionResult;
    }

    /***********************************************************************************************************
     * firstNumberModuloSecondNumber() gives the remainder when first double is divided by the second double
     * @param firstNumber is of type double
     * @param secondNumber is of type double
     * @return moduloResult is of type double.  moduloResult returns if secondNumber is not valid for this operation.
     ***********************************************************************************************************/

    protected static Double firstNumberModuloSecondNumber(double firstNumber, double secondNumber){
        double moduloResult = 0;
        if (secondNumber == 0){
            System.out.println("You cannot divide by zero. Your result has been set to zero.");
        }else{
            moduloResult = firstNumber/secondNumber;
        }
        return moduloResult;
    }

    /***********************************************************************************************************
     * firstNumberRaisedToSecondNumber() raises the first double to the power of the second double
     * @param firstNumber is of type double
     * @param secondNumber is of type double
     * @return exponentResult is of type double
     ***********************************************************************************************************/

    protected static Double firstNumberRaisedToSecondNumber(double firstNumber, double secondNumber){
        double exponentResult = Math.pow(firstNumber, secondNumber);
        return exponentResult;
    }

    /***********************************************************************************************************
     * rootOfFirstNumber() uses secondNumber to calculate the nth root of firstNumber
     * @param firstNumber is of type double
     * @param secondNumber is of type double and is converted to a fraction so that it
     * can be used to determine the root of firstNumber
     * @return rootResult is of type double. rootResult returns 0 if the secondNumber is invalid for the operation.
     ***********************************************************************************************************/

    protected static Double rootOfFirstNumber(double firstNumber, double secondNumber){
        //convert secondNumber to fraction before calling Math.pow
        double rootResult = 0;
        if (secondNumber == 0){
            System.out.println("You have not entered a valid number for this operation.  Your result has been set to zero.");
        }else{
            secondNumber = 1/secondNumber;
            rootResult = Math.pow(firstNumber, secondNumber);
        }
        return rootResult;
    }


}
