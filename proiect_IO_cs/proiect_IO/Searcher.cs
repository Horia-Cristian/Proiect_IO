using System;
using System.IO;
using System.Text.RegularExpressions;

namespace proiect_IO
{

	public class Searcher
	{
		StreamReader file;
		string word;
		private StreamReader reader;

		public Searcher()
		{
			file = new StreamReader("");
			word = "";
		}
		public Searcher(string filepath, string word)
		{
			this.file = new StreamReader(filepath);
			this.word = word;
		}

		public virtual string getLine(int index)
		{
			string line = "";
			int i = 0;

			reader = new StreamReader(file.BaseStream);
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

			string pattern = ".*\\s*" + word + "\\s*.*";
			Match match;

			reader = new StreamReader(file.BaseStream);
			while (!string.ReferenceEquals((line = reader.ReadLine()), null))
			{
				match = Regex.Match(line, @pattern);
				if (match.Success)
				{
					found = line;
				}
			}

			return found;
		}
	}

}
