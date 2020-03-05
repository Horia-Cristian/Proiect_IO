package engine;

import java.io.*;

public class Searcher {
    File file;
    String word;
    private BufferedReader reader;

    public Searcher(){
        file = new File("");
        word = "";
    }
    public Searcher(String filepath, String word ){
        this.file = new File(filepath);
        this.word = word;
    }

    public String getLine(int index) throws IOException {
        String line = "";
        int i = 0;

        reader = new BufferedReader(new FileReader(file));
        while( (line = reader.readLine()) != null ){
            if(i==index)
                break;
            i++;
        }

        if( i!=index )
            throw new IOException("Index out of bounds");

        return line;
    }

    public String lastContaining() throws IOException {
        String line = "", found = "";

        reader = new BufferedReader(new FileReader(file));
        while( (line = reader.readLine()) != null ){
            if( line.matches(".*\\s*"+word+"\\s*.*") )
                found = line;
        }

        return found;
    }
}
