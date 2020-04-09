<?php
class Searcher{
	private $file, $word;
	
	function __construct($filepath="", $word=""){
		$this->file = $filepath;
		$this->word = $word;
	}
	
	function getLine($index){
		$stream = fopen($this->file, "r");
		$i = 0;
		
		if($stream){
			while(!feof($stream)){
				$line = fgets($stream);
				
				if($i==$index)
					break;
				$i++;
			}
			fclose($stream);
			if($i==$index)
				return $line;
		}else{
			echo "Error while opening the file.";
		}
	}
	
	function getLast(){
		$stream = fopen($this->file, "r");
		$found = "";
		
		if($stream){
			while(!feof($stream)){
				$line = fgets($stream);
				
				if(preg_match("/.*\\s*" . $this->word . "\\s*.*/", $line))
					$found = $line;
			}
			fclose($stream);
			return $found;
		}else{
			echo "Error while opening the file.";
		}
	}
}

$filepath = $_FILES['search_file']['tmp_name'];
$word = $_POST['search_word'];

$searcher = new Searcher($filepath, $word);
print_r($searcher->getLast());
?>