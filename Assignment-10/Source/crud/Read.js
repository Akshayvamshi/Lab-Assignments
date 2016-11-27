
var MongoClient = require('mongodb').MongoClient;
var assert = require('assert');
var url = "mongodb://akshayvamshi:qwerty123@ds051873.mlab.com:51873/akshay";

var findUserwithName = function(db,callback) {
    var cursor = db.collection('demoase').find({"fname":"akshay"});
    cursor.each(function(err,doc) {
        assert.equal(err,null);
        if(doc != null)
        {
            console.log("First Name:" + doc.fname);
            console.log("Last Name:" + doc.lname);
            console.log("email:" + doc.email);
        }
    });}
    MongoClient.connect(url, function(err, db) {
        assert.equal(null, err);
        findUserwithName(db, function() {
            db.close();
        });
    });
