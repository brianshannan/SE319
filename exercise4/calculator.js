var Calculator = function() {
    var self = this;
    self.memoryValue = 0;

    self.root = $('<table/>', {
        id: 'calcTable',
        border: 2
    });
    self.root.append('<tr><td><input id="calc-input" type="text" value="0"></td></tr>');

    self.blankFunc = function() {};

    self.getDisplay = function() {
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
        if(action != null) {
            self.button.click(action);
        }

        self.getHTML = function() {
            return self.button;
        }

        self.setOnClick = function(func) {
            self.button.click(func);
        }
    }

    self.addButton = new Button('plus', '+', function() {
        var sel = $('#calc-input');
        var first = parseFloat(sel.val());
        return function() {
            var second = 'thing';
            return first + second;
        }
    })

    self.memPlus = new Button('mem-plus', 'M+', function() {
        var sel = $('#calc-input');
        self.memoryValue += sel.val();
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
        sel.val("");
    })

    self.numberButtonFunction = function(num) {
        return function() {
            self.appendInputBox(num);
        };
    };

    for(var i = 0; i < 10; i++) {
        var numButton = new Button(i, i, self.numberButtonFunction(i));
        self.root.append(numButton.getHTML());
    }
};
