using System;
using System.Windows.Forms;

namespace proiect_IO
{
    public partial class Form1 : Form
    {
        //TO DO: schimbat nume var
        private string filename, word;
        private Searcher searcher;

        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            // Configure open file dialog box
            OpenFileDialog dlg = new OpenFileDialog();
            dlg.FileName = "Document"; // Default file name
            dlg.DefaultExt = ".txt"; // Default file extension
            dlg.Filter = "Text documents (.txt)|*.txt"; // Filter files by extension

            // Show open file dialog box
            DialogResult result = dlg.ShowDialog();

            // Process open file dialog box results
            if (result.Equals(DialogResult.OK))
            {
                // Open document
                filename = dlg.FileName;
                Console.WriteLine(filename);
            }
            
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            word = textBox1.Text;
            searcher = new Searcher(filename, word);

            string result = searcher.lastContaining();
            //string result = searcher.getLine( Int16.Parse(word) );

            //Console.WriteLine("Incepe cautare");
            label3.Text = result;
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            filename = "";
            word = "";
        }
    }
}