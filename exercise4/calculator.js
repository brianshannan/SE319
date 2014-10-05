$(document).ready(function() {
    var calculator = new Calculator();
    $('#calc').append(calculator.getDisplay());
});

/* Calculator class */
var Calculator = function() {
    /* Avoid having to bind this */
    var self = this;

    /* Class for calculator buttons */
    var Button = function(id, value, action) {
        var self = this;
        self.button = $('<input>', {
            id: id,
            type: 'button',
            value: value
        });
        self.button.click(action);

        self.getHTML = function() {
            return $('<td></td>').append(self.button);
        }
    };

    /* Whether to clear the screen on the next input */
    self.clearOnNext = false;
    /* The memory value for the calculator */
    self.memoryValue = 0;
    /* A blank function */
    self.blankFunc = function() {};
    /* The function to execute if the equals button is pressed */
    self.equalsFunc = self.blankFunc;
    /* The function to execute if an operation button is pressed */
    self.operationFunc = self.blankFunc;

    /* The root element for the calculator */
    self.root = $('<table/>', {
        id: 'calcTable',
        border: 2
    });

    /* Initializes and returns the calculator display */
    self.getDisplay = function() {
        self.init();
        return self.root;
    };

    /* Appends an item to the input box */
    self.appendInputBox = function(value) {
        var sel = $('#calc-input');
        // Clears the input box first if the current value is zero
        // or the clearOnNext flag is true
        if(sel.val() === "0" || self.clearOnNext) {
            self.clearOnNext = false;
            sel.val(value);
        } else {
            var lastVal = sel.val();
            sel.val(lastVal + value);
        }
    }

    /* Creates an operation button */
    self.createOperationButton = function(id, operation) {
        /* Performs the operation for two given arguments */
        function performOperation(first, second) {
            switch(operation) {
                case '+':
                    return first + second;
                case '-':
                    return first - second;
                case '*':
                    return first * second;
                case '/':
                    return first / second;
                default:
                    return 0;
            }
        }

        return new Button(id, operation, function() {
            // Runs the function to be run when an operation is pressed
            self.operationFunc();

            // Gets the first value for the operation and sets the calculator
            // to clear the current value when the next character is pressed
            var sel = $('#calc-input');
            var first = parseFloat(sel.val());
            self.clearOnNext = true;

            // The function to run when another operation is pressed
            self.operationFunc = function() {
                // Gets the second value for the operation and performs it
                var second = parseFloat(sel.val());
                sel.val(performOperation(first, second));
                self.operationFunc = self.blankFunc;

                // Sets the function to use when the equals button is pressed
                self.equalsFunc = function(accumulatedValue) {
                    sel.val(performOperation(accumulatedValue, second));
                }
            };
        });
    };

    /* Creates the add button */
    self.addButton = self.createOperationButton('plus', '+');

    /* Creates the minus button */
    self.subButton = self.createOperationButton('minus', '-');

    /* Creates the multiply button */
    self.mulButton = self.createOperationButton('mul', '*');

    /* Creates the divide button */
    self.divButton = self.createOperationButton('div', '/');

    /* Create the equals button */
    self.equalButton = new Button('equals', '=', function() {
        // If the operation function isn't blank, execute it
        // This means the equation button should be treated as
        // a normal operation, first time pushed in a row
        if(self.operationFunc != self.blankFunc) {
            self.operationFunc();
        } else {
            // Otherwise execute the equals function,
            // Means it been pressed more than once in a row
            var sel = $('#calc-input');
            self.equalsFunc(parseFloat(sel.val()));
        }
    })

    /* Makes the memory plus button */
    self.memPlus = new Button('mem-plus', 'M+', function() {
        var sel = $('#calc-input');
        self.memoryValue += parseFloat(sel.val());
    });

    /* Makes the read memory button */
    self.memRead = new Button('mem-read', 'MR', function() {
        var sel = $('#calc-input');
        sel.val(self.memoryValue);
    });

    /* Makes the clear memory button */
    self.memClear = new Button('mem-clear', 'MC', function() {
        self.memoryValue = 0;
    });

    /* Makes the clear button */
    self.clear = new Button('clear', 'C', function() {
        var sel = $('#calc-input');
        sel.val("0");
    })

    /* Makes the function to append a number to the input box */
    self.numberButtonFunction = function(num) {
        return function() {
            self.appendInputBox(num);
        };
    };

    /* Initializes the calculator */
    self.init = function () {
        self.root.children().remove();
        self.root.append('<tr><td colspan="4"><input id="calc-input" type="text" value="0"></td></tr>');
        var row1 = $('<tr></tr>');
        row1.append(new Button('7', '7', self.numberButtonFunction(7)).getHTML());
        row1.append(new Button('8', '8', self.numberButtonFunction(8)).getHTML());
        row1.append(new Button('9', '9', self.numberButtonFunction(9)).getHTML());
        row1.append(self.addButton.getHTML());
        self.root.append(row1);

        var row2 = $('<tr></tr>');
        row2.append(new Button('4', '4', self.numberButtonFunction(4)).getHTML());
        row2.append(new Button('5', '5', self.numberButtonFunction(5)).getHTML());
        row2.append(new Button('6', '6', self.numberButtonFunction(6)).getHTML());
        row2.append(self.subButton.getHTML());
        self.root.append(row2);

        var row3 = $('<tr></tr>');
        row3.append(new Button('1', '1', self.numberButtonFunction(1)).getHTML());
        row3.append(new Button('2', '2', self.numberButtonFunction(2)).getHTML());
        row3.append(new Button('3', '3', self.numberButtonFunction(3)).getHTML());
        row3.append(self.mulButton.getHTML());
        self.root.append(row3);

        var row4 = $('<tr></tr>');
        row4.append(new Button('0', '0', self.numberButtonFunction(0)).getHTML());
        row4.append(new Button('.', '.', self.numberButtonFunction('.')).getHTML());
        row4.append(self.equalButton.getHTML());
        row4.append(self.divButton.getHTML());
        self.root.append(row4);

        var row5 = $('<tr></tr>');
        row5.append(self.clear.getHTML());
        row5.append(self.memRead.getHTML());
        row5.append(self.memClear.getHTML());
        row5.append(self.memPlus.getHTML());
        self.root.append(row5);
    }
};
