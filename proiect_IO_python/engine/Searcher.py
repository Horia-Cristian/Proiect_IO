import re

class SearcherClass:
    def __init__(self, filepath="", word=""):
        self.file = filepath
        self.word = word

    def setFile(self, filepath):
        self.file = filepath

    def setWord(self, word):
        self.word = word

    def getLine(self, index):
        try:
            line = ""

            print('Incerc sa citesc ', self.file, '...')
            reader = open(self.file, 'r')

            i = 0
            line = reader.readline()

            while line:
                if i==index:
                    reader.close()
                    return line

                i = i+1
                line = reader.readline()

            reader.close()
            if i<index:
                return "";

        except:
            print('N-o mers ;(')
            return ""

    def lastContaining(self):
        line = ""
        found = ""

        print('Incerc sa citesc ', self.file, '...')
        reader = open(self.file, 'r')

        line = reader.readline()
        while line:
            if re.search(".*\\s*"+self.word+"\\s*.*", line):
                found = line
            line = reader.readline()

        reader.close()

        return found