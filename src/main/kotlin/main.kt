
    fun main(args: Array<String>) {
//    print("Was ist dein Name > ")
//    var username = readLine()
//    println("Hallo $username!")
        consoleController()
    }

    fun consoleController() {
        var firstNumber = 0
        var validInput = false
        var result = 0
        println("Welcome to my basic calculator")
        var operation: Operations? = null
        do {
            print("Your First number > ")
            val unparsedInput = readLine()
            if (isInt(unparsedInput)) {
                firstNumber = Integer.parseInt(unparsedInput)
                validInput = true
            } else {
                println("$unparsedInput is not a valid input")
            }
        } while (!validInput)
        validInput = false
        var operator  = " "
        do{
            print("Enter your operator (+ , - , * , /)> ")
            operator = readLine().toString()
            if (operator.equals("+")){
                validInput = true
                operation = Operations.Addition
            }else if(operator.equals("-")){
                validInput = true
                operation = Operations.Subtraction
            }

        }while(!validInput)

    }

    private fun isInt(unparsedString: String?): Boolean {
        return try {
            Integer.parseInt(unparsedString)
            true
        } catch (e: NumberFormatException) {
            false
        }
    }
