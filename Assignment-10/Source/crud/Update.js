
var MongoClient = require('mongodb').MongoClient;
var assert = require('assert');
var url = "mongodb://akshayvamshi:qwerty123@ds051873.mlab.com:51873/akshay";

var updateUserwithName = function(db,callback) {
    db.collection('demoase').update( {

        "fname":"gupta"
         // "_id": {"5823acbd7f3c51436c89fc41"}
}, {
            $set: { "fname": "akshayg","lname": "gaju", type: 0,  },
            $currentDate: { lastModified: true }
        },

        function(err, result) {
        assert.equal(err, null);
        console.log("updated a document into akshay's collection.");
        callback();
    });
};
MongoClient.connect(url, function(err, db) {
    assert.equal(null, err);
    updateUserwithName(db, function() {
        db.close();
    });
});
