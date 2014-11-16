grammar RPN;

@header {
    import java.util.Stack;
}

@members {
    // Stack to store numbers
    Stack<Object> stack = new Stack<Object>();

    // Push a number onto the stack
    public void pushIntToStack(String val) {
        stack.push(Integer.parseInt(val));
    }

    public void pushBoolToStack(String val) {
        val == 'true' ? stack.push(true) : stack.push(false);
    }

    // Apply unary operation (one argument)
    // Didn't realize not was the only one of these, might as well keep it generic
    public void applyBooleanUnaryOperation(String op) {
        checkNumArguments(op, 1);

        Object obj = stack.pop();
        if(!(obj instanceof Boolean)) {
            throw new IllegalArgumentException("Expecting a boolean for operation " + op + ", got " + obj);
        }

        bool first = (bool) obj;
        switch(op) {
            case "!":
                stack.push(!first);
                break;
        }
    }

    // Apply an integer binary operation (two arguments) given the operation as a string using the stack
    public void applyIntBinaryOperation(String op) {
        checkNumArguments(op, 2);

        Object obj2 = stack.pop();
        Object obj1 = stack.pop();
        if()


        switch(op) {
            case "+":
                if(!(first instance))
                stack.push(first + second);
                break;
            case "-":
                stack.push(first - second);
                break;
            case "*":
                stack.push(first * second);
                break;
            case "/":
                stack.push(first / second);
                break;
            case "%":
                stack.push(first % second);
                break;
        }
    }

    // Apply a boolean binary operation (two arguments) given the operation as a string using the Stack
    public void applyBoolBinaryOperation(String op) {
        //
    }

    public void checkNumArguments(String op, int argsReq) {
        if(stack.size() < argsReq) {
            throw new IllegalArgumentException("Not enough arguments for operation " + op + ", expecting " + argsReq);
        }
    }

    public void checkBool(String op, Object obj) {
        // TODO
    }

    public void checkInt(String op, Object obj) {
        // TODO
    }
}

// Lexer rules
INT             : [0-9]+                    {pushIntToStack(getText());};
BOOL            : ('true'|'false');
WS              : [ \r\t\n]+ -> skip;
BOOL_UN_OP      : '!'                       {applyUnaryOperation(getText());};
INT_BIN_OP      : ('+'|'-'|'*'|'/'|'%'|'<'|'<='|'=='|'!='|'>='|'>')
                                            {applyIntBinaryOperation(getText());};
BOOL_BIN_OP     : ('&&'|'||')
                                            {applyBoolBinaryOperation(getText());};
END             : ';'                       {System.out.println(stack.pop());};


start
    : ((expr WS?)+ END)+
    ;

expr
    : literal
    | op
    ;

literal
    : INT
    | BOOL
    ;

op
    : UN_OP
    | bin_op
    ;

bin_op
    : INT_BIN_OP
    | BOOL_BIN_OP
    ;
