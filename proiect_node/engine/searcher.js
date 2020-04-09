const fs = require('fs');
const readline = require('readline');

exports.getLine = function(filepath, index, callback) {
    const fileStream = fs.createReadStream(filepath);

    const reader = readline.createInterface({
        input: fileStream
    });
    // Note: we use the crlfDelay option to recognize all instances of CR LF
    // ('\r\n') in input.txt as a single line break.

    var i = 0;
    let line = "";

    reader.on('line', (current) => {
        console.log("Linia "+i+": "+current);

        if(i==index)
            line = current;

        i++;

    });

    reader.on('close', () => {
        console.log("Linia dorita: "+line);

        callback(line);
    })
};

exports.getLast = function(filepath, word, callback) {
    const fileStream = fs.createReadStream(filepath);

    const reader = readline.createInterface({
        input: fileStream
    });
    // Note: we use the crlfDelay option to recognize all instances of CR LF
    // ('\r\n') in input.txt as a single line break.

    var i = 0;
    let line = "";

    reader.on('line', (current) => {
        console.log("Linia "+i+": "+current);

        if(current.match(".*\\s*"+word+"\\s*.*"))
            line = current;

        i++;
    });

    reader.on('close', () => {
        console.log("Linia dorita: "+line);

        callback(line);
    })
};