from engine import Searcher

from tkinter import *

root = Tk()
root.title("Aplicatie Python")

file_label = Label(root, text="Nu a fost selectat nici un fisier")
word_label = Label(root, text="Introduceti cuvantul")
find_label = Label(root, text="Ultima linie")
word_field = Entry(root)
file_button = Button(root, text="Alege fisier...")
submit_button = Button(root, text="Incepe cautare")

file_label.grid(row=0, column=1)
word_label.grid(row=1)
find_label.grid(row=3)
word_field.grid(row=1, column=1)
file_button.grid(row=0)
submit_button.grid(row=2)

root.mainloop()