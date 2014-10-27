function Tetris() {

    var self = this;

    this.stats = new Stats();
    this.piece = null;
    this.board = null;

    this.unit  = 20;
    this.boardX = 12;
    this.boardY = 20;

    /*
        Initializes the game, board, and piece.
    */
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

    /*
        Clears the board and stats
    */
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

    /*
        Ends Game and stops
    */
    this.gameOver = function() {
        self.stats.stop();
        self.piece.stop();
        $('#game-over').css("display","block");
        $('#next-piece').css("display","none");
    }

    /*
        Rotates piece if able to
    */
    this.up = function() {
        if (self.piece && self.piece.isRunning() && !self.piece.isStopped() && self.piece.mayRotate()) {
            self.piece.rotate();
        }
    }

    /*
        Increases speed of going down and increases score
    */
    this.down = function() {
        if (self.piece && self.piece.isRunning() && !self.piece.isStopped() && self.piece.mayMoveDown()) {
            self.stats.setScore(self.stats.getScore() + 5 + self.stats.getLevel());
            self.piece.moveDown();
        }
    }

    /*
        Moves Piece left if able to
    */
    this.left = function() {
        if (self.piece && self.piece.isRunning() && !self.piece.isStopped() && self.piece.mayMoveLeft()) {
            self.piece.moveLeft();
        }
    }

    /*
        Moves Piece right if able to
    */
    this.right = function() {
        if (self.piece && self.piece.isRunning() && !self.piece.isStopped() && self.piece.mayMoveRight()) {
            self.piece.moveRight();
        }
    }

    /*
        Sends piece to the bottom
    */
    this.space = function() {
        if (self.piece && self.piece.isRunning() && !self.piece.isStopped()) {
            self.piece.stop();
            self.piece.forceMoveDown();
        }
    }

    /*
        Calls start on click
    */
    $('#start').click(function () {
        self.start();
    });

    /*
        Calls reset on click
    */
    $('#reset').click(function () {
        self.reset();
    });

    /*
        Calls up on click
    */
    $('#up').click(function () {
        self.up();
    });

    /*
        Calls down on click
    */
    $('#down').click(function () {
        self.down();
    });

    /*
        Calls left on click
    */
    $('#left').click(function () {
        self.left();
    });

    /*
        Calls right on click
    */
    $('#right').click(function () {
        self.right();
    });

    /*
        Binds keyboard events to functions
    */
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

    /*
        Keeps track of stats for each game
    */
    function Stats() {

        this.level;
        this.lines;
        this.score;
        this.pieces;

        this.sel = {
            level: $("#level"),
            lines: $("#lines"),
            score: $("#score")
        }

        var self = this;
        this.timerId = null;

        this.start = function() {
            this.reset();
        }

        this.stop = function() {
            if (this.timerId) {
                clearInterval(this.timerId);
            }
        }

        /*
            Resets the stats
        */
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

        /*
            Set Score
        */
        this.setScore = function(i) {
            this.score = i;
            this.sel.score.html(this.score);
        }

        /*
            Set Level
        */
        this.setLevel = function(i) {
            this.level = i;
            this.sel.level.html(this.level);
        }

        this.setPieces = function(i) {
            this.pieces = i;
        }

        /*
            Set Lines
        */
        this.setLines = function(i) {
            this.lines = i;
            this.sel.lines.html(this.lines);
        }

        /*
            Get Score
        */
        this.getScore = function() {
            return this.score;
        }

        /*
            Get Level
        */
        this.getLevel = function() {
            return this.level;
        }

        /*
            Get Pieces
        */
        this.getPieces = function() {
            return this.pieces;
        }

        /*
            Get Lines
        */
        this.getLines = function() {
            return this.lines;
        }
    }

    function Board(unit, x, y, id) {

        this.unit = unit;
        this.x = x;
        this.y = y;
        this.sel = $("#" + id);

        this.board = [];

        // instantiates board with 0's
        for (var y = 0; y < this.y; y++) {
            this.board.push(new Array());
            for (var x = 0; x < this.x; x++) {
                this.board[y].push(0);
            }
        }

        // clears board of pieces, and sets 0's
        this.destroy = function() {
            for (var y = 0; y < this.board.length; y++) {
                for (var x = 0; x < this.board[y].length; x++) {
                    if (this.board[y][x]) {
                        this.board[y][x] = 0;
                    }
                }
            }
            this.sel.empty();
        }

        // Checks if a line is full, if so remove it
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

        // Checks if a line is full
        this.isLineFull = function(y) {
            for (var x = 0; x < this.x; x++) {
                if (!this.board[y][x]) {
                    return false;
                }
            }
            return true;
        }

        // Clear full line and moves lines down
        this.removeLine = function(y) {
            for (var x = 0; x < this.x; x++) {
                this.board[y][x].empty();
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

        // Returns a block if block exists or a 0 if not
        this.getBlock = function(y, x) {
            if (y < 0) {
                return 0;
            }
            if (y < this.y && x < this.x) {
                return this.board[y][x];
            }
        }

        // Adds a block of a Piece to the board
        this.addElement = function(sel) {
            var y = sel.css("top");
            var x = sel.css("left");
            y = parseInt(y.replace("px", "") / this.unit);
            x = parseInt(x.replace("px", "") / this.unit);
            console.log(x, y);
            if (y >= 0 && y-2 < this.y && x >= 0 && x < this.x) {
                this.board[y-2][x] = sel;
            }else{
                console.log("failed");
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

        /*
            Reset the Current Piece
        */
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

        /*
            Check if piece is able to get render
        */
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

        /*
            render piece onto the board and show the next piece
        */
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

        /*
            clear piece
        */
        this.destroy = function() {
            this.board.sel.empty();
            this.elements = [];
            this.boardElements = [];
            this.reset();
        }

        /*
            Instantiate new clear piece
        */
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

        /*
            When piece is falling, check if it collides, end game if cant create new piece
        */
        this.fallDown = function() {
            if (self.isRunning()) {
                if (self.mayMoveDown()) {
                    self.moveDown();
                    self.fallDownID = setTimeout(self.fallDown, self.speed);
                } else {
                    for (var i = 0; i < self.elements.length; i++) {
                        self.board.addElement(self.elements[i]);
                    }
                    var lines = self.board.removeFullLines();
                    if (lines) {
                        self.tetris.stats.setLines(self.tetris.stats.getLines() + lines);
                        self.tetris.stats.setScore(self.tetris.stats.getScore() + (1000 * self.tetris.stats.getLevel() * lines));
                    }
                    self.reset();
                    if (self.mayPlace()) {
                        self.place();
                    } else {
                        self.tetris.gameOver();
                    }
                }
            }
        }

        /*
            When piece is falling, check if it collides, end game if cant create new piece
        */
        this.forceMoveDown = function() {
            if (!self.isRunning() && !self.isStopped()) {
                if (self.mayMoveDown()) {
                    self.tetris.stats.setScore(self.tetris.stats.getScore() + 5 + self.tetris.stats.getLevel());
                    self.moveDown();
                    self.forceMoveDownID = setTimeout(self.forceMoveDown, 30);
                } else {
                    for (var i = 0; i < self.elements.length; i++) {
                        self.board.addElement(self.elements[i]);
                    }
                    var lines = self.board.removeFullLines();
                    if (lines) {
                        self.tetris.stats.setLines(self.tetris.stats.getLines() + lines);
                        self.tetris.stats.setScore(self.tetris.stats.getScore() + (1000 * self.tetris.stats.getLevel() * lines));
                    }
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

        // Checks if piece can rotate
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

        // Rotates piece
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

        //Checks if can move down
        this.mayMoveDown = function() {
            for (var y = 0; y < this.boardElements.length; y++) {
                for (var x = 0; x < this.boardElements[y].length; x++) {
                    if (this.boardElements[y][x]) {
                        if (this.getY() + y - 1  >= this.board.y || this.board.getBlock(this.getY(), this.getX())) {
                            this.stopped = true;
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        //Moves down
        this.moveDown = function() {
            for (var i = 0; i < this.elements.length; i++) {
                var offset = this.elements[i].offset();
                this.elements[i].offset({top: offset.top + this.board.unit});
            }
            this.y++;
        }

        //Checks if can move left
        this.mayMoveLeft = function() {
            for (var y = 0; y < this.boardElements.length; y++) {
                for (var x = 0; x < this.boardElements[y].length; x++) {
                    if (this.boardElements[y][x]) {
                        if (this.getX() + x - 1 < 0 || this.board.getBlock(this.getY() + y, this.getX() + x + 1)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        // Moves left
        this.moveLeft = function() {
            for (var i = 0; i < this.elements.length; i++) {
                var offset = this.elements[i].offset();
                this.elements[i].offset({left: offset.left - this.board.unit});
            }
            this.x--;
        }

        //Checks if can move right
        this.mayMoveRight = function() {
            for (var y = 0; y < this.boardElements.length; y++) {
                for (var x = 0; x < this.boardElements[y].length; x++) {
                    if (this.boardElements[y][x]) {
                        if (this.getX() + x + 1 >= this.board.x || this.board.getBlock(this.getY() + y, this.getX() + x - 1)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        // Moves right
        this.moveRight = function() {
            for (var i = 0; i < this.elements.length; i++) {
                var offset = this.elements[i].offset();
                this.elements[i].offset({left: offset.left + this.board.unit});
            }
            this.x++;
        }
    }

    // Random
    function random(i) {
        return Math.floor(Math.random() * i);
    }
}
