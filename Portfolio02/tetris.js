function Tetris() {

    var self = this;

    this.stats = new Stats();
    this.piece = null;
    this.board = null;

    this.unit  = 20;
    this.boardX = 20;
    this.boardY = 20;


    this.start = function() {
        self.reset();
        self.stats.start();
        $('#next-piece').css("display","block");
        self.board = new Board(self.unit, self.boardX, self.boardY, "board");
        self.piece = new Piece(self, self.board);
        if (self.piece.mayPlace()) {
            self.piece.place();
        } else {
            self.gameOver();
        }
    }

    this.reset = function() {
        if (self.piece) {
            self.piece.destroy();
            self.piece = null;
        }
        if (self.board) {
            self.board.destroy();
            self.board = null;
        }
        $('#game-over').css("display","none");
        $('#next-piece').css("display","none");
        self.stats.reset();
    }

    this.gameOver = function() {
        self.stats.stop();
        self.piece.stop();
        $('#game-over').css("display","block");
        $('#next-piece').css("display","none");
    }


    this.up = function() {
        if (self.piece && self.piece.isRunning() && !self.piece.isStopped() && self.piece.mayRotate()) {
            self.piece.rotate();
        }
    }

    this.down = function() {
        if (self.piece && self.piece.isRunning() && !self.piece.isStopped() && self.piece.mayMoveDown()) {
            self.stats.setScore(self.stats.getScore() + 5 + self.stats.getLevel());
            self.piece.moveDown();
        }
    }

    this.left = function() {
        if (self.piece && self.piece.isRunning() && !self.piece.isStopped() && self.piece.mayMoveLeft()) {
            self.piece.moveLeft();
        }
    }

    this.right = function() {
        if (self.piece && self.piece.isRunning() && !self.piece.isStopped() && self.piece.mayMoveRight()) {
            self.piece.moveRight();
        }
    }

    this.space = function() {
        if (self.piece && self.piece.isRunning() && !self.piece.isStopped()) {
            self.piece.stop();
            self.piece.forceMoveDown();
        }
    }

    $('#start').click(function () {
        self.start();
        this.blur();
    });

    $('#reset').click(function () {
        self.reset();
        this.blur();
    });

    $('#up').click(function () {
        self.up();
        this.blur();
    });

    $('#down').click(function () {
        self.down();
        this.blur();
    });

    $('#left').click(function () {
        self.left();
        this.blur();
    });

    $('#right').click(function () {
        self.right();
        this.blur();
    });

    var keyboard = new Keyboard();
    keyboard.set(keyboard.n, this.start);
    keyboard.set(keyboard.r, this.reset);
    keyboard.set(keyboard.up, this.up);
    keyboard.set(keyboard.down, this.down);
    keyboard.set(keyboard.left, this.left);
    keyboard.set(keyboard.right, this.right);
    keyboard.set(keyboard.space, this.space);
    document.onkeydown = keyboard.event;


    function Keyboard() {
        this.up = 38;
        this.down = 40;
        this.left = 37;
        this.right = 39;
        this.n = 78;
        this.r = 82;
        this.space = 32;
        this.f12 = 123;
        this.escape = 27;

        this.keys = [];
        this.funcs = [];

        var self = this;

        this.set = function(key, func) {
            this.keys.push(key);
            this.funcs.push(func);
        }

        this.event = function(e) {
            if (!e) { e = window.event; }
            for (var i = 0; i < self.keys.length; i++) {
                if (e.keyCode == self.keys[i]) {
                    self.funcs[i]();
                }
            }
        }
    }


    function Stats() {

        this.level;
        this.lines;
        this.score;
        this.pieces;

        this.actions;

        this.sel = {
            "level": $("#level"),
            "lines": $("#lines"),
            "score": $("#score")
        }

        this.timerId = null;
        var self = this;

        this.start = function() {
            this.reset();
            this.timerId = setInterval(this.incTime, 1000);
        }

        this.stop = function() {
            if (this.timerId) {
                clearInterval(this.timerId);
            }
        }

        this.reset = function() {
            this.stop();
            this.level = 1;
            this.lines = 0;
            this.score = 0;
            this.pieces = 0;
            this.sel.level.html(this.level);
            this.sel.lines.html(this.lines);
            this.sel.score.html(this.score);
        }


        this.setScore = function(i) {
            this.score = i;
            this.sel.score.html(this.score);
        }

        this.setLevel = function(i) {
            this.level = i;
            this.sel.level.html(this.level);
        }

        this.setLines = function(i) {
            this.lines = i;
            this.el.lines.html(this.lines);
        }

        this.setPieces = function(i) {
            this.pieces = i;
        }

        this.getScore = function() {
            return this.score;
        }

        this.getLevel = function() {
            return this.level;
        }

        this.getLines = function() {
            return this.lines;
        }

        this.getPieces = function() {
            return this.pieces;
        }
    }

    function Board(unit, x, y, id) {

        this.unit = unit;
        this.x = x;
        this.y = y;
        this.sel = $("#" + id);

        this.board = [];

        for (var y = 0; y < this.y; y++) {
            this.board.push(new Array());
            for (var x = 0; x < this.x; x++) {
                this.board[y].push(0);
            }
        }

        this.destroy = function() {
            for (var y = 0; y < this.board.length; y++) {
                for (var x = 0; x < this.board[y].length; x++) {
                    if (this.board[y][x]) {
                        this.sel.remove(this.board[y][x]);
                        this.board[y][x] = 0;
                    }
                }
            }
        }

        this.removeFullLines = function() {
            var lines = 0;
            for (var y = this.y - 1; y > 0; y--) {
                if (this.isLineFull(y)) {
                    this.removeLine(y);
                    lines++;
                    y++;
                }
            }
            return lines;
        }

        this.isLineFull = function(y) {
            for (var x = 0; x < this.x; x++) {
                if (!this.board[y][x]) {
                    return false;
                }
            }
            return true;
        }

        this.removeLine = function(y) {
            for (var x = 0; x < this.x; x++) {
                this.sel.remove(this.board[y][x]);
                this.board[y][x] = 0;
            }
            y--;
            for (; y > 0; y--) {
                for (var x = 0; x < this.x; x++) {
                    if (this.board[y][x]) {
                        var sel = this.board[y][x];
                        var offset = sel.offset();
                        sel.css("top", offset.top + this.unit + "px");
                        this.board[y+1][x] = sel;
                        this.board[y][x] = 0;
                    }
                }
            }
        }

        this.getBlock = function(y, x) {
            if (y < 0) {
                return 0;
            }
            if (y < this.y && x < this.x) {
                return this.board[y][x];
            } else {
                console.log("Board.getBlock("+y+", "+x+") failed");
            }
        }

        this.addElement = function(sel) {
            var offset = sel.offset();
            var x = parseInt(offset.left / this.unit);
            var y = parseInt(offset.top / this.unit);
            if (y >= 0 && y < this.y && x >= 0 && x < this.x) {
                this.board[y][x] = sel;
            }
        }
    }

    function Piece(tetris, board) {

        var self = this;
        this.tetris = tetris;
        this.board = board;

        this.fallDownID = null;
        this.forceMoveDownID = null;

        this.type = null;
        this.nextType = null;
        this.position = null;
        this.speed = null;
        this.running = null;
        this.stopped = null;

        this.boardElements = [];
        this.elements = [];
        this.nextElements = [];
        this.x = null;
        this.y = null;

        this.pieces = [
            [
                [0,0,1],
                [1,1,1],
                [0,0,0]
            ],
            [
                [1,0,0],
                [1,1,1],
                [0,0,0]
            ],
            [
                [0,1,1],
                [1,1,0],
                [0,0,0]
            ],
            [
                [1,1,0],
                [0,1,1],
                [0,0,0]
            ],
            [
                [0,1,0],
                [1,1,1],
                [0,0,0]
            ],
            [
                [1,1],
                [1,1]
            ],
            [
                [0,0,0,0],
                [1,1,1,1],
                [0,0,0,0],
                [0,0,0,0]
            ]
        ];

        this.reset = function() {
            if (this.fallDownID) {
                clearTimeout(this.fallDownID);
            }
            if (this.forceMoveDownID) {
                clearTimeout(this.forceMoveDownID);
            }
            this.type = this.nextType;
            this.nextType = random(this.pieces.length);
            this.position = 0;
            this.speed = 80 + (700 / this.tetris.stats.getLevel());
            this.running = false;
            this.stopped = false;
            this.boardElements = [];
            this.elements = [];
            for (var i = 0; i < this.nextElements.length; i++) {
                $("#nextpiece").remove(this.nextElements[i]);
            }
            this.nextElements = [];
            this.x = null;
            this.y = null;
        }

        this.nextType = random(this.pieces.length);
        this.reset();

        this.isRunning = function() {
            return this.running;
        }

        this.isStopped = function() {
            return this.stopped;
        }

        this.getX = function() {
            return this.x;
        }

        this.getY = function() {
            return this.y;
        }

        this.mayPlace = function() {
            var piece = this.pieces[this.type];
            var boardStartX = parseInt((this.board.x - piece[0].length) / 2);
            var boardStartY = 1;
            var lineFound = false;
            var lines = 0;
            for (var y = piece.length - 1; y >= 0; y--) {
                for (var x = 0; x < piece[y].length; x++) {
                    if (piece[y][x]) {
                        lineFound = true;
                        if (this.board.getBlock(boardStartY, boardStartX + x)) {
                            return false;
                        }
                    }
                }
                if (lineFound) {
                    lines++;
                }
                if (boardStartY - lines < 0) {
                    break;
                }
            }
            return true;
        }

        this.place = function() {
            this.tetris.stats.setPieces(this.tetris.stats.getPieces() + 1);
            if (this.tetris.stats.getPieces() >= (10 + this.tetris.stats.getLevel() * 2)) {
			    this.tetris.stats.setLevel(this.tetris.stats.getLevel() + 1);
			    this.tetris.stats.setPieces(0);
		    }
            var piece = this.pieces[this.type];
            var boardStartX = parseInt((this.board.x - piece[0].length) / 2);
            var boardStartY = 1;
            var lineFound = false;
            var lines = 0;
            this.x = boardStartX;
            this.y = 1;
            this.boardElements = this.createEmptyPiece(piece.length, piece[0].length);

            for (var y = piece.length - 1; y >= 0; y--) {
                for (var x = 0; x < piece[y].length; x++) {
                    if (piece[y][x]) {
                        lineFound = true;
                        var div = $('<div></div');
                        div.addClass("block" + this.type);
                        div.css("left", (boardStartX + x) * this.board.unit + "px");
                        div.css("top", (boardStartY - lines) * this.board.unit + "px");
                        this.board.sel.append(div);
                        this.boardElements[y][x] = div;
                        this.elements.push(div);
                    }
                }
                if (lines) {
                    this.y--;
                }
                if (lineFound) {
                    lines++;
                }
            }
            this.running = true;
            this.fallDownID = setTimeout(this.fallDown, this.speed);
            $("#next-piece").empty();
            var nextPiece = this.pieces[this.nextType];
            for (var y = 0; y < nextPiece.length; y++) {
                for (var x = 0; x < nextPiece[y].length; x++) {
                    if (nextPiece[y][x]) {
                        var sel = $("<div></div>");
                        sel.addClass("block" + this.nextType);
                        sel.css("left", (x * this.board.unit) + "px");
                        sel.css("top", (y * this.board.unit) + "px");
                        $("#next-piece").append(sel);
                        this.nextElements.push(sel);
                    }
                }
            }
        }

        this.destroy = function() {
            for (var i = 0; i < this.elements.length; i++) {
                this.board.sel.remove(this.elements[i]);
            }
            this.elements = [];
            this.boardElements = [];
            this.reset();
        }

        this.createEmptyPiece = function(y, x) {
            var piece = [];
            for (var y2 = 0; y2 < y; y2++) {
                piece.push(new Array());
                for (var x2 = 0; x2 < x; x2++) {
                    piece[y2].push(0);
                }
            }
            return piece;
        }

        this.fallDown = function() {
            if (self.isRunning()) {
                if (self.mayMoveDown()) {
                    self.moveDown();
                    self.fallDownID = setTimeout(self.fallDown, self.speed);
                } else {
                    for (var i = 0; i < self.elements.length; i++) {
                        self.board.addElement(self.elements[i]);
                    }
                    // stats
                    var lines = self.board.removeFullLines();
                    if (lines) {
                        self.tetris.stats.setLines(self.tetris.stats.getLines() + lines);
                        self.tetris.stats.setScore(self.tetris.stats.getScore() + (1000 * self.tetris.stats.getLevel() * lines));
                    }
                    // reset piece
                    self.reset();
                    if (self.mayPlace()) {
                        self.place();
                    } else {
                        self.tetris.gameOver();
                    }
                }
            }
        }

        this.forceMoveDown = function() {
            if (!self.isRunning() && !self.isStopped()) {
                if (self.mayMoveDown()) {
                    // stats: score, actions
                    self.tetris.stats.setScore(self.tetris.stats.getScore() + 5 + self.tetris.stats.getLevel());
                    self.moveDown();
                    self.forceMoveDownID = setTimeout(self.forceMoveDown, 30);
                } else {
                    // move blocks into board board
                    for (var i = 0; i < self.elements.length; i++) {
                        self.board.addElement(self.elements[i]);
                    }
                    // stats: lines
                    var lines = self.board.removeFullLines();
                    if (lines) {
                        self.tetris.stats.setLines(self.tetris.stats.getLines() + lines);
                        self.tetris.stats.setScore(self.tetris.stats.getScore() + (1000 * self.tetris.stats.getLevel() * lines));
                    }
                    // reset piece
                    self.reset();
                    if (self.mayPlace()) {
                        self.place();
                    } else {
                        self.tetris.gameOver();
                    }
                }
            }
        }
        this.stop = function() {
            this.running = false;
        }

        this.mayRotate = function() {
            for (var y = 0; y < this.boardElements.length; y++) {
                for (var x = 0; x < this.boardElements[y].length; x++) {
                    if (this.boardElements[y][x]) {
                        var newY = this.getY() + this.boardElements.length - 1 - x;
                        var newX = this.getX() + y;
                        if (newY >= this.board.y || newX < 0 || newX >= this.board.x || this.board.getBlock(newY, newX) ) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        this.rotate = function() {
            var piece = this.createEmptyPiece(this.boardElements.length, this.boardElements[0].length);
            for (var y = 0; y < this.boardElements.length; y++) {
                for (var x = 0; x < this.boardElements[y].length; x++) {
                    if (this.boardElements[y][x]) {
                        var newY = piece.length - 1 - x;
                        var newX = y;
                        var sel = this.boardElements[y][x];
                        var offset = sel.offset();
                        var moveY = newY - y;
                        var moveX = newX - x;
                        sel.offset({
                            left: offset.left + (moveX * this.board.unit),
                            top: offset.top + (moveY * this.board.unit)
                        });
                        piece[newY][newX] = sel;
                    }
                }
            }
            this.boardElements = piece;
        }

        this.mayMoveDown = function() {
            for (var y = 0; y < this.boardElements.length; y++) {
                for (var x = 0; x < this.boardElements[y].length; x++) {
                    if (this.boardElements[y][x]) {
                        if (this.getY() + y + 1 >= this.board.y || this.board.getBlock(this.getY() + y + 1, this.getX() + x)) {
                            this.stopped = true;
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        this.moveDown = function() {
            for (var i = 0; i < this.elements.length; i++) {
                var offset = this.elements[i].offset();
                this.elements[i].offset({top: offset.top + this.board.unit});
            }
            this.y++;
        }

        this.mayMoveLeft = function() {
            for (var y = 0; y < this.boardElements.length; y++) {
                for (var x = 0; x < this.boardElements[y].length; x++) {
                    if (this.boardElements[y][x]) {
                        if (this.getX() + x - 1 < 0 || this.board.getBlock(this.getY() + y, this.getX() + x - 1)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        this.moveLeft = function() {
            for (var i = 0; i < this.elements.length; i++) {
                var offset = this.elements[i].offset();
                this.elements[i].offset({left: offset.left - this.board.unit});
            }
            this.x--;
        }

        this.mayMoveRight = function() {
            for (var y = 0; y < this.boardElements.length; y++) {
                for (var x = 0; x < this.boardElements[y].length; x++) {
                    if (this.boardElements[y][x]) {
                        if (this.getX() + x + 1 >= this.board.x || this.board.getBlock(this.getY() + y, this.getX() + x + 1)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        this.moveRight = function() {
            for (var i = 0; i < this.elements.length; i++) {
                var offset = this.elements[i].offset();
                this.elements[i].offset({left: offset.left + this.board.unit});
            }
            this.x++;
        }
    }

    function random(i) {
        return Math.floor(Math.random() * i);
    }


}

if (!String.prototype.trim) {
    String.prototype.trim = function() {
        return this.replace(/^\s*|\s*$/g, "");
    };
}

if (!Array.prototype.removeByIndex) {
    Array.prototype.removeByIndex = function(index) {
        this.splice(index, 1);
    };
}

if (!String.prototype.format) {
    String.prototype.format = function() {
        if (!arguments.length) { throw "String.format() failed, no arguments passed, this = "+this; }
        var tokens = this.split("?");
        if (arguments.length != (tokens.length - 1)) { throw "String.format() failed, tokens != arguments, this = "+this; }
        var s = tokens[0];
        for (var i = 0; i < arguments.length; ++i) {
            s += (arguments[i] + tokens[i + 1]);
        }
        return s;
    };
}
