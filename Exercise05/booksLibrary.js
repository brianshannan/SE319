'use strict';

var Book = function (name, author, isbn) {
    this.name = name;
    this.author = author;
    this.isbn = isbn;
};

var Shelf = function (size) {
    this.size = size;
    this.books = [];
};

var Library = function () {
    this.shelves = [];
};

Library.prototype.addNCopies = function(book, n) {
    for (var i = 0; i < this.shelves.length ; i++) {
        for (var j = 0; j < Shelf.prototype.size ; j++) {
            if (n === 0){
                return;
            }
            if (this.shelves[i].books[j] == null) {
                this.shelves[i].books[j] = book;
                n--;
            }
        }
    }
    if (n > 0) {
        this.shelves.push(new Shelf());
        this.addNCopies(book, n);
    }
};

Library.prototype.findLocation = function(name) {
    for (var i = 0; i < this.shelves.length ; i++) {
        for (var j = 0; j < this.shelves[i].books.length ; j++) {
            var book = this.shelves[i].books[j];
            if (book.name === name){
                return {shelf: i, row: j};
            }
        }
    }
}

Library.prototype.getBookByName = function(name) { 
    for (var i = 0; i < this.shelves.length ; i++) {
        for (var j = 0; j < this.shelves[i].books.length ; j++) {
            var book = this.shelves[i].books[j];
            if (book.name === name){
                return book;
            }
        }
    }
}

Library.prototype.removeBook = function(name) {
    var count = 0;
    for (var i = 0; i < this.shelves.length ; i++) {
        for (var j = 0; j < this.shelves[i].books.length ; j++) {
            var book = this.shelves[i].books[j];
            if (book.name === name){
                this.shelves[i].books[j] = null;
                count++;
            }
        }
    }

    for (var i = 0; i < this.shelves.length ; i++) {
        var nulls = 0;
        for (var j = 0; j < this.shelves[i].books.length ; j++) {
            var book = this.shelves[i].books[j];
            if (book == null){
                nulls++;
            }
        }
        if (nulls === this.shelves[i].books.length){
            this.shelves.splice(i);
        }
    }

    return count;
}

Library.prototype.getShelves = function() {
    return this.shelves;
}

//Accepts List of Objects i.e. [{name: bookName, count: bookCount}]
Library.prototype.addMultiple = function(books) {
    $.forEach(books, function(book) {
        this.addNCopies(book.name, book.count);
    });
}

Shelf.prototype.size = 10;
Shelf.prototype.setSize = function (size) {
    Shelf.prototype.size = size;
};
