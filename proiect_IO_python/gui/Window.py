from tkinter import *
from tkinter import filedialog

from engine import Searcher

class WindowClass(Tk):
    def __init__(self):
        Tk.__init__(self)
        self.title("Aplicatie Python")

        self.file_label = Label(self, text="Nu a fost selectat nici un fisier")
        self.word_label = Label(self, text="Introduceti cuvantul")
        self.find_label = Label(self, text="Ultima linie:")
        self.word_field = Entry(self)
        file_button = Button(self, text="Alege fisier...", command=self.selectFile)
        submit_button = Button(self, text="Incepe cautare", command=self.startSearch)

        self.file_label.grid(row=0, column=1)
        self.word_label.grid(row=1)
        self.find_label.grid(row=3, columnspan=2)
        self.word_field.grid(row=1, column=1)
        file_button.grid(row=0)
        submit_button.grid(row=2)

        print('Fereastra initializata...')
        self.mainloop()

    def startSearch(self):
        self.word = self.word_field.get()

        self.searcher = Searcher.SearcherClass(self.filename, self.word)

        result = self.searcher.lastContaining()
        print("Linie din fisier: ", result)

        self.find_label.configure(text="Ultima linie: "+result)


    def selectFile(self):
        self.filename = filedialog.askopenfilename(initialdir=".", title="Select file", filetypes=(("text files", "*.txt"), ("all files", "*.*")))
        self.file_label.configure(text=self.filename)