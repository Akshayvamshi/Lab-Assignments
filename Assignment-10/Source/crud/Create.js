
var MongoClient = require('mongodb').MongoClient;
var assert = require('assert');
var url = "mongodb://akshayvamshi:qwerty123@ds051873.mlab.com:51873/akshay";
var insertDocument = function(db, callback) {
    db.collection('test').insert( {
        "fname" : "akshay",
        "lname" : "g",
        "email": "asdfg526813@mail.umkc.edu",

        "password":"qwerty12"
    }, function(err, result) {
        assert.equal(err, null);
        console.log("Inserted a document into harsha's collection.");
        callback();
    });
};

MongoClient.connect(url, function(err, db) {
    assert.equal(null, err);
    insertDocument(db, function() {
        db.close();
    });
});