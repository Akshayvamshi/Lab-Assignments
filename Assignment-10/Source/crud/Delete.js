
var MongoClient = require('mongodb').MongoClient;
var assert = require('assert');
var url = "mongodb://akshayvamshi:qwerty123@ds051873.mlab.com:51873/akshay";

var deleteUserwithName = function(db,callback) {
    db.collection('test').remove( {

            "fname":"akshayg"

        },

        function(err, result) {
            assert.equal(err, null);
            console.log("deleted a document from akshay's collection.");
            callback();
        });
};
MongoClient.connect(url, function(err, db) {
    assert.equal(null, err);
    deleteUserwithName(db, function() {
        db.close();
    });
});
