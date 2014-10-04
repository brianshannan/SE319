var Calculator = function() {
    var self = this;
    self.memoryValue = 0;
    self.blankFunc = function() {};

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

        self.setOnClick = function(func) {
            self.button.click(func);
        }
    }

    self.equalButton = new Button('equals', '=', self.blankFunc);

    self.addButton = new Button('add', '+', function() {
        var first = 'thing';  // TODO get value
        // TODO clear text field
        self.equalButton.setOnClick(function() {
            var second = 'thing';
            // Set text field to first + second
        });
    });

    self.subButton = new Button('sub', '-', function() {
        var first = 'thing';  // TODO get value
        // TODO clear text field
        self.equalButton.setOnClick(function() {
            var second = 'thing';
            // Set text field to first - second
        });
    });

    self.mulButton = new Button('mul', '*', function() {
        var first = 'thing';  // TODO get value
        // TODO clear text field
        self.equalButton.setOnClick(function() {
            var second = 'thing';
            // Set text field to first * second
        });
    });

    self.divButton = new Button('div', '/', function() {
        var first = 'thing';  // TODO get value
        // TODO clear text field
        self.equalButton.setOnClick(function() {
            var second = 'thing';
            // Set text field to first / second
        });
    });
};
