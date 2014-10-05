var Calculator = function() {
    var self = this;
    self.opperator = null;
    self.memoryValue = 0;

    self.root = $('<table/>', {
        id: 'calcTable',
        border: 2
    });
    self.root.append('<tr><td colspan="4"><input id="calc-input" type="text" value="0"></td></tr>');

    self.blankFunc = function() {};

    self.getDisplay = function() {
        self.init();
        return self.root;
    };

    self.appendInputBox = function(value) {
        var sel = $('#calc-input');
        if(sel.val() === "0") {
            sel.val(value);
        } else {
            var lastVal = sel.val();
            sel.val(lastVal + value);
        }
    }

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
            // return '<td>'+ self.button + '</td>';
        }
    }

    self.calculate = function (){

    }



    self.addButton = new Button('plus', '+', function() {
        var sel = $('#calc-input');
        var first = parseFloat(sel.val());

        // ops
        return function() {
            var second = 'thing';
            return first + second;
        }
    })

    self.memPlus = new Button('mem-plus', 'M+', function() {
        var sel = $('#calc-input');
        self.memoryValue += parseFloat(sel.val());
    });

    self.memRead = new Button('mem-read', 'MR', function() {
        var sel = $('#calc-input');
        sel.val(self.memoryValue);
    });

    self.memClear = new Button('mem-clear', 'MC', function() {
        self.memoryValue = 0;
    });

    self.clear = new Button('clear', 'C', function() {
        var sel = $('#calc-input');
        sel.val("0");
    })

    self.numberButtonFunction = function(num) {
        return function() {
            self.appendInputBox(num);
        };
    };

    self.opperatorButtonFunction = function (opperator) {
        return function() {
            self.calculate(opperator)
        }
    };

    // for(var i = 0; i < 10; i++) {
    //     var numButton = new Button(i, i, self.numberButtonFunction(i));
    //     self.root.append(numButton.getHTML());
    // }

    self.init = function () {
        var buttons = [9,8,7,"+",6,5,4,"-",3,2,1,'*',0,'.','=','/','C','MR','MC','M+'];
        var row1 = $('<tr></tr>');
        row1.append(new Button('7', '7', self.numberButtonFunction(7)).getHTML());
        row1.append(new Button('8', '8', self.numberButtonFunction(8)).getHTML());
        row1.append(new Button('9', '9', self.numberButtonFunction(9)).getHTML());
        // Append plus
        self.root.append(row1);

        var row2 = $('<tr></tr>');
        row2.append(new Button('4', '4', self.numberButtonFunction(4)).getHTML());
        row2.append(new Button('5', '5', self.numberButtonFunction(5)).getHTML());
        row2.append(new Button('6', '6', self.numberButtonFunction(6)).getHTML());
        // Append minus
        self.root.append(row2);

        var row3 = $('<tr></tr>');
        row3.append(new Button('1', '1', self.numberButtonFunction(1)).getHTML());
        row3.append(new Button('2', '2', self.numberButtonFunction(2)).getHTML());
        row3.append(new Button('3', '3', self.numberButtonFunction(3)).getHTML());
        // Append mul
        self.root.append(row3);

        var row4 = $('<tr></tr>');
        row4.append(new Button('0', '0', self.numberButtonFunction(0)).getHTML());
        row4.append(new Button('.', '.', self.numberButtonFunction('.')).getHTML());
        // Append equals
        // Append div
        self.root.append(row4);

        var row5 = $('<tr></tr>');
        row5.append(self.clear.getHTML());
        row5.append(self.memRead.getHTML());
        row5.append(self.memClear.getHTML());
        row5.append(self.memPlus.getHTML());
        self.root.append(row5);
    }
};
