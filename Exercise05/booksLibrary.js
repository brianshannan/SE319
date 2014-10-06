
var Book = function () {

};


var Library = function () {
    this.shelves = [];

};

Libary.prototype.addNCopies = function addNBook(book, n) {
    for (var i = 0; i < this.shelves.length ; i++) {
        for (var j = 0; j < Shelf.prototype.size ; j++)
            if (n == 0){
                return;
            }
            if (this.shelves[i].books[j] === null) {
                this.shelves[i].books[j] = book;
                n--;
            }
        });
    });
    if (n > 0) {
        this.shelves.push(new Shelf());
        addNBook(book, n)
    }
};

var Shelf = function () {
    this.size = size;
    this.books = [this.size];
};

Shelf.protoype.size = 10;
Shelf.protoype.setSize = function (size) {
    Shelf.prototype.size = size;
};
