import calculator.Operations

fun main(args: Array<String>) {
    consoleController()
}

fun consoleController() {
    var firstNumber = 0
    var secondNumber = 0
    var validInput = false
    var result = 0
    var unparsedInput = " "
    var continueCalculations = 1
    println("Welcome to my basic calculator")
    var operation: Operations? = null
    do {
        do {
            print("Your first number > ")
            unparsedInput = readLine().toString()
            if (isInt(unparsedInput)) {
                firstNumber = Integer.parseInt(unparsedInput)
                validInput = true
            } else {
                println("$unparsedInput is not a valid input")
            }
        } while (!validInput)
        validInput = false
        var operator = " "
        do {
            print("Enter your operator (+ , - , * , /)> ")
            operator = readLine().toString()
            when {
                operator.equals("+") -> {
                    validInput = true
                    operation = Operations.Addition
                }
                operator.equals("-") -> {
                    validInput = true
                    operation = Operations.Subtraction
                }
                operator.equals("*") -> {
                    validInput = true;
                    operation = Operations.Multiplication
                }
                operator.equals("/") -> {
                    validInput = true
                    operation = Operations.Division
                }
            }
        } while (!validInput)
        validInput = false
        do {
            print("Your second number > ")
            unparsedInput = readLine().toString()
            if (isInt(unparsedInput)) {
                secondNumber = Integer.parseInt(unparsedInput)
                if (operation == Operations.Division && secondNumber == 0) {
                    validInput = false
                    println("Divison by 0 is not allowed, please try again")
                } else {
                    validInput = true
                }
            } else {
                println("$unparsedInput is not a valid input")
            }
        } while (!validInput)
        when {
            operation == Operations.Addition -> {
                result = firstNumber + secondNumber
            }
            operation == Operations.Subtraction -> {
                result = firstNumber - secondNumber
            }
            operation == Operations.Multiplication -> {
                result = firstNumber * secondNumber
            }
            operation == Operations.Division -> {
                result = firstNumber / secondNumber
            }
        }
        println("The result for $firstNumber $operator $secondNumber is: $result")
        print("If you would like to make an other calculation type 1 otherwise any other input > ")
        unparsedInput = readLine().toString()
        if (isInt(unparsedInput)) {
            continueCalculations = Integer.parseInt(unparsedInput)
        } else {
            continueCalculations = 0
        }
    } while (continueCalculations == 1)
}

private fun isInt(unparsedString: String?): Boolean {
    return try {
        Integer.parseInt(unparsedString)
        true
    } catch (e: NumberFormatException) {
        false
    }
}
