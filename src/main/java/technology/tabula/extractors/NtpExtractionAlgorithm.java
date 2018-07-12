package technology.tabula.extractors;

import java.util.List;
import technology.tabula.Table;
import technology.tabula.Page;
import technology.tabula.TextChunk;
import technology.tabula.Cell;
import java.util.Arrays;
import java.util.ArrayList;
import technology.tabula.TextElement;
import technology.tabula.extractors.BasicExtractionAlgorithm;


public class NtpExtractionAlgorithm implements ExtractionAlgorithm{

	public NtpExtractionAlgorithm(){
	}

	public List<Table> extract(Page page) {
		List<TextElement> textElements = page.getText();
		List<String> strings = new ArrayList<String>();
		for (TextElement x : textElements) {
			System.out.print("->");
			System.out.println(x.getText());
		}
		return exampleTables(1);
	}

	//Used for debugging
	public List<Table> exampleTables(){
		return exampleTables(3);
	}

	//Used for debugging
	public List<Table> exampleTables(int size){
		Table table = Table.empty();
		String letters = "abcdefgh";
		String nums = "12345689";
		for (int i = 0; i<size; i++){
			for (int p = 0; p<size; p++){
				char[] a = {letters.charAt(i),nums.charAt(p)};
				String el = new String(a);
				TextElement te = new TextElement(0,0,0,0,null,15,el,2);
				TextChunk tc = new TextChunk(te);
				table.add(tc,i,p);
			}
		}
		return Arrays.asList(new Table[] { table });
	}
}
