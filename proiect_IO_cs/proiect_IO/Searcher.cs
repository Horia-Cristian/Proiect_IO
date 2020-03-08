using System.IO;

namespace proiect_IO
{

	public class Searcher
	{
		FileInfo file;
		string word;
		private StreamReader reader;

		public Searcher()
		{
			file = new FileInfo("");
			word = "";
		}
		public Searcher(string filepath, string word)
		{
			this.file = new FileInfo(filepath);
			this.word = word;
		}

		public virtual string getLine(int index)
		{
			string line = "";
			int i = 0;

			reader = new StreamReader(file);
			while (!string.ReferenceEquals((line = reader.ReadLine()), null))
			{
				if (i == index)
				{
					break;
				}
				i++;
			}

			if (i != index)
			{
				throw new IOException("Index out of bounds");
			}

			return line;
		}

		public virtual string lastContaining()
		{
			string line = "", found = "";

			reader = new StreamReader(file);
			while (!string.ReferenceEquals((line = reader.ReadLine()), null))
			{
				if (line.Contains(".*\\s*" + word + "\\s*.*"))
				{
					found = line;
				}
			}

			return found;
		}
	}

}
