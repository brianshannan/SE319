var Tetris = function () {
    tetris.initBoard();
};

Tetris.prototype.initBoard = function() {
    var canvas = $("#canvas").get(0);

    if (!canvas || !canvas.getContext || !canvas.getContext('2d')){
      alert("You must use a browser that supports HTML5 Canvas.");
    }

    Tetris.board = new Board(canvas);
};

Tetris.B_HEIGHT = 20;
Tetris.B_WIDTH = 10;

Tetris.BLOCK_SIZE_PX = 25;
Tetris.B_HEIGHT_PX = Tetris.B_HEIGHT * Tetris.BLOCK_SIZE_PX;
Tetris.B_WIDTH_PX = Tetris.B_WIDTH * Tetris.BLOCK_SIZE_PX;

Tetris.BLOCK_BORDER = "#484848";
Tetris.COLORS = {
                  'b': 'black',
                  'c': 'cyan',
                  'B': 'blue',
                  'o': 'orange',
                  'y': 'yellow',
                  'g': 'green',
                  'p': 'purple',
                  'r': 'red'
                };

//Delay 300ms
Tetris.GRAVITY = 300;
Tetris.EMPTY_LINE = "          ";
Tetris.FULL_LINE =  "XXXXXXXXXX";
Tetris.COMPLETE_LINE= /[^ ]{10}/;

Tetris.SHAPES = [];
 for (var i = 0; i < 4; i++) { Tetris.SHAPES[i] = []; }
 Tetris.SHAPES[0][0] = [ "    ",   "    ",   "    ",   "    ",   "    ",   "    ",   "    " ];
 Tetris.SHAPES[0][1] = [ "    ",   "p   ",   "  B ",   " rr ",   " cc ",   " y  ",   "gg  " ];
 Tetris.SHAPES[0][2] = [ "oooo",   "ppp ",   "BBB ",   " rr ",   "cc  ",   "yyy ",   " gg " ];
 Tetris.SHAPES[0][3] = [ "    ",   "    ",   "    ",   "    ",   "    ",   "    ",   "    " ];
 Tetris.SHAPES[1][0] = [ " o  ",   "    ",   "    ",   "    ",   "    ",   "    ",   "  g " ];
 Tetris.SHAPES[1][1] = [ " o  ",   " p  ",   "BB  ",   " rr ",   " c  ",   " y  ",   " gg " ];
 Tetris.SHAPES[1][2] = [ " o  ",   " p  ",   " B  ",   " rr ",   " cc ",   " yy ",   " g  " ];
 Tetris.SHAPES[1][3] = [ " o  ",   "pp  ",   " B  ",   "    ",   "  c ",   " y  ",   "    " ];
 Tetris.SHAPES[2][0] = [ "    ",   "    ",   "    ",   "    ",   "    ",   "    ",   "    " ];
 Tetris.SHAPES[2][1] = [ "    ",   "    ",   "    ",   " rr ",   " cc ",   "    ",   "gg  " ];
 Tetris.SHAPES[2][2] = [ "oooo",   "ppp ",   "BBB ",   " rr ",   "cc  ",   "yyy ",   " gg " ];
 Tetris.SHAPES[2][3] = [ "    ",   "  p ",   "B   ",   "    ",   "    ",   " y  ",   "    " ];
 Tetris.SHAPES[3][0] = [ " o  ",   "    ",   "    ",   "    ",   "    ",   "    ",   "  g " ];
 Tetris.SHAPES[3][1] = [ " o  ",   " pp ",   " B  ",   " rr ",   " c  ",   " y  ",   " gg " ];
 Tetris.SHAPES[3][2] = [ " o  ",   " p  ",   " B  ",   " rr ",   " cc ",   "yy  ",   " g  " ];
 Tetris.SHAPES[3][3] = [ " o  ",   " p  ",   " BB ",   "    ",   "  c ",   " y  ",   "    " ];

Tetris.Board = function (canvas) {
    this.canvas = canvas;
    this.context = canvas.getContext('2d');
};

Tetris.Board.prototype.draw = function (){
    this.context.clearRect(0, 0, Tetris.B_WIDTH_PX, Tetris.B_HEIGHT_PX);

    for (var x = 0; x < Tetris.B_WIDTH; x++) {
        for (var y = 0; y < Tetris.B_HEIGHT; y++) {
            var colorValue = this.getBlockVal(x, y);
            if (colorValue != ' ') {
                var left = x * Tetris.BLOCK_SIZE_PX;
                var top = y * Tetris.BLOCK_SIZE_PX;
                this.context.fillStyle = Tetris.COLORS[colorValue];
                this.context.fillRect(left, top, Tetris.BLOCK_SIZE_PX, Tetris.BLOCK_SIZE_PX);
                this.context.lineWidth = 1;
                this.context.strokeStyle = Tetris.BLOCK_BORDER;
                this.context.strokeRect(left, top, Tetris.BLOCK_SIZE_PX, Tetris.BLOCK_SIZE_PX);
            }
        }
    }
};

 Tetris.Board.prototype.getRow = function (y) {
    return Tetris.EMPTY_LINE;
  };

Tetris.Board.prototype.getBlockVal = function (x, y) {
    return this.getRow(y).charAt(x);
};

Tetris.Piece = function (pNumber, x, y, orientation){

};
