var http = require('http');
var url = require('url');
var fs = require('fs');
var formidable = require('formidable');
var searcher = require('./engine/searcher');

http.createServer(function (req, res) {
    function respond(data){
        res.writeHead(200, {'Content-Type': 'text/html'});
        res.write(data);
        return res.end();
    }

    var q = url.parse(req.url, true);
    var filename = "." + q.pathname;

    if(filename == "./"){
        res.writeHead(302, {
            'Location': '/gui/gui.html'
        });
        return res.end();
    }
    else
    if(filename == "./engine"){
        var form = new formidable.IncomingForm();
        form.parse(req, function (err, fields, files) {
            var oldpath = files.search_file.path;
            var newpath = 'file/' + files.search_file.name;
            fs.copyFile(oldpath, newpath, (cp_err) => {
                if (cp_err)
                    console.error("Copying error: ",cp_err.message);
                else
                    console.log("File uploaded succesfully");
            });

            fs.unlink(oldpath, (del_err) => {
                if (del_err)
                    console.error("Deletion error: ", del_err.message);
                else
                    console.log("Temp file deleted succesfully");
            });

            var search_word = fields.search_word;
            var search_file = newpath;

            searcher.getLast(search_file, search_word, (line) => {
                    console.log('Linia ceruta: '+line);

                fs.unlink(newpath, (del_err) => {
                    if (del_err)
                        console.error("Deletion error: ", del_err.message);
                    else
                        console.log("Uploaded file deleted succesfully");
                });

                respond("Linia cautata: "+line);
            });
        });
    }
    else
    fs.readFile(filename, function(err, data) {
        if (err) {
            res.writeHead(404, {'Content-Type': 'text/html'});
            return res.end("404 Not Found");
        }

        respond(data);
    });
}).listen(8080);