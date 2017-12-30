
var express = require('express'); // Web Framework
var app = express();
var sql = require('mssql'); // MS Sql Server client

var dbConfig = {
    user:  "User",
    password: "4Dmini57r470r",
    server: "localhost\\SQLEXPRESS",
    port: 1433,
    database: "Reservamos"
};

// Start server and listen on http://localhost:8081/
var server = app.listen(8081, function () {
    var host = server.address().address
    var port = server.address().port

    console.log("app listening at http://%s:%s", host, port)
});


app.get('/locales/:id/', function (req, res) {
    sql.connect(dbConfig, function () {
        var request = new sql.Request();
        var stringRequest = 'select * from [Locales] where ID = ' + req.params.id;
        request.query(stringRequest, function (err, recordset) {
            if (err) console.log(err);
            res.end(JSON.stringify(recordset)); // Result in JSON format
        });
    });
})

app.get("/locales", function (req, res) {
    sql.connect(dbConfig, function () {
        var request = new sql.Request();
        request.query('select * from [Locales]', function (err, recordset) {
            if (err) console.log(err);
            res.end(JSON.stringify(recordset)); // Result in JSON format
        });
    });
});