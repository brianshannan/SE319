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
        if(val.equals("true")) {
            stack.push(true);
        } else {
            stack.push(false);
        }
    }

    // Apply unary operation (one argument)
    // Didn't realize not was the only one of these, might as well keep it generic
    public void applyBoolUnaryOperation(String op) {
        checkNumArguments(op, 1);

        Object obj = stack.pop();
        checkBool(op, obj);

        boolean first = (boolean) obj;

        switch(op) {
            case "!":
                stack.push(!first);
                break;
            default:
                throw new IllegalArgumentException("Unrecognized operation " + op);
        }
    }

    // Apply an integer binary operation (two arguments) given the operation as a string using the stack
    public void applyIntBinaryOperation(String op) {
        checkNumArguments(op, 2);

        Object obj2 = stack.pop();
        checkInt(op, obj2);
        Object obj1 = stack.pop();
        checkInt(op, obj1);

        int first = (int) obj1;
        int second = (int) obj2;

        switch(op) {
            case "+":
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
            case "<":
                stack.push(first < second);
                break;
            case "<=":
                stack.push(first <= second);
                break;
            case "==":
                stack.push(first == second);
                break;
            case "!=":
                stack.push(first != second);
                break;
            case ">=":
                stack.push(first >= second);
                break;
            case ">":
                stack.push(first > second);
                break;
            default:
                throw new IllegalArgumentException("Unrecognized operation " + op);
        }
    }

    // Apply a boolean binary operation (two arguments) given the operation as a string using the Stack
    public void applyBoolBinaryOperation(String op) {
        checkNumArguments(op, 2);

        Object obj2 = stack.pop();
        checkBool(op, obj2);
        Object obj1 = stack.pop();
        checkBool(op, obj1);

        boolean first = (boolean) obj1;
        boolean second = (boolean) obj2;

        switch(op) {
            case "&&":
                stack.push(first && second);
                break;
            case "||":
                stack.push(first || second);
                break;
            default:
                throw new IllegalArgumentException("Unrecognized operation " + op);
        }
    }

    public void checkNumArguments(String op, int argsReq) {
        if(stack.size() < argsReq) {
            throw new IllegalArgumentException("Not enough arguments for operation " + op + ", expecting " + argsReq);
        }
    }

    public void checkBool(String op, Object obj) {
        if(!(obj instanceof Boolean)) {
            throw new IllegalArgumentException("Expecting a boolean for operation " + op + ", got " + obj);
        }
    }

    public void checkInt(String op, Object obj) {
        if(!(obj instanceof Integer)) {
            throw new IllegalArgumentException("Expecting an integer for operation " + op + ", got " + obj);
        }
    }

    public void endExpr() {
        if(stack.size() < 1) {
            System.out.println("No data to show");
            return;
        }
        if(stack.size() > 1) {
            System.out.println("More than one result, showing the first");
        }
        System.out.println(stack.pop());
        stack.clear()
    }
}

// Lexer rules
INT             : [0-9]+                    {pushIntToStack(getText());};
BOOL            : ('true'|'false')          {pushBoolToStack(getText());};
WS              : [ \r\t\n]+ -> skip;
BOOL_UN_OP      : '!'                       {applyBoolUnaryOperation(getText());};
INT_BIN_OP      : ('+'|'-'|'*'|'/'|'%'|'<'|'<='|'=='|'!='|'>='|'>')
                                            {applyIntBinaryOperation(getText());};
BOOL_BIN_OP     : ('&&'|'||')               {applyBoolBinaryOperation(getText());};
END             : ';'                       {endExpr();};


// Parser rules
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
    : BOOL_UN_OP
    | bin_op
    ;

bin_op
    : INT_BIN_OP
    | BOOL_BIN_OP
    ;
