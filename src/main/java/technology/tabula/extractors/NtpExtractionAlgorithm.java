package technology.tabula.extractors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

import technology.tabula.Line;
import technology.tabula.Page;
import technology.tabula.Rectangle;
import technology.tabula.Ruling;
import technology.tabula.Table;
import technology.tabula.TextChunk;
import technology.tabula.TextElement;
import technology.tabula.extractors.BasicExtractionAlgorithm;


public class NtpExtractionAlgorithm implements ExtractionAlgorithm{

	public NtpExtractionAlgorithm(){
	}

	public List<Table> extract(Page page) {
		List<TextElement> textElements = page.getText();
		
		if (textElements.size()==0){
			//There is no text on this page. Return empty table.
            return Arrays.asList(new Table[] { Table.empty() });
		}

        List<TextChunk> textChunks;
		//if (this.verticalRulings == null) 
		if (true) {//if vertical rulings exists include it in merging
			textChunks = TextElement.mergeWords(page.getText());
		}
		else {	
			//textChunks = TextElement.mergeWords(page.getText(), this.verticalRulings);
		}

        List<Line> lines = TextChunk.groupByLines(textChunks);
		List<Float> floats = BasicExtractionAlgorithm.columnPositions(lines);
		

		System.out.println("Columns: ");
		for (Float x : floats) {
			System.out.print("->");
			System.out.print(x);
			System.out.println("<-");
		}

		/*System.out.println("Elements: ");
		for (TextElement x : textElements) {
			System.out.print("->");
			System.out.print(x.getText());
			System.out.println("<-");
		}

		System.out.println("Chunks: ");
		for (TextChunk x : textChunks) {
			System.out.print("->");
			System.out.print(x.getText());
			System.out.println("<-");
		}

		System.out.println("Chunks: ");
		for (TextChunk x : textChunks) {
			System.out.print("->");
			System.out.print(x.toString());
			System.out.println("<-");
		}
		
		System.out.println("Lines: ");
		for (TextChunk x : textChunks) {
			System.out.print("->");
			System.out.print(x.toString());
			System.out.println("<-");
		}*/
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
