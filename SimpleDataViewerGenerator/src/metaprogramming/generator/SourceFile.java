package metaprogramming.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SourceFile {
	
	private String name;
	private String data;
	private String path;
	
	public SourceFile (String name, String path){
		this.name = name;
		this.path = path;
	}
	
	public String getFileName() {
		return name;
	}
	public void setFileName(String fileName) {
		this.name = fileName;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public void load (){
		
		String source = "";
		
		try{
			File f = new File (getPath());
			FileReader fr = new FileReader (f);
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			line = br.readLine();
			
			while (line != null){
				source += line;
				line = br.readLine();
			}
			
			br.close();
			fr.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		this.data = source;
	}

}
