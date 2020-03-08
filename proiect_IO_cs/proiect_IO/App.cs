using System;
using System.Windows.Forms;

namespace proiect_IO
{
    static class App
    {

        [STAThread]
        static void Main(String[] args)
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Form1());
        }
    }
}