var Calculator = function() {
    var self = this;
    self.memoryValue = 0;

    self.root = $('<table/>', {
        id: 'calcTable',
        border: 2
    });
    self.root.append('<tr><td><input id="calc-input" type="text" value=""></td></tr>');

    self.blankFunc = function() {};

    self.getDisplay = function() {
        return self.root;
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

    self.numberButtonFunction = function(num) {
        return function() {
            var sel = $('#calc-input');
            var val = sel.val();
            val = val + num;
            sel.val(val);
        };
    }

    for(var i = 0; i < 10; i++) {
        var numButton = new Button(i, i, self.numberButtonFunction(i));
        self.root.append(numButton.getHTML());
    }
};
