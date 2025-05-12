package com.example;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.json.JSONObject;
import org.yaml.snakeyaml.Yaml;
public class YamlToJson {
public static void main(String [] args) {
	File YamlFile = new File ("C:\\Users\\DT-BSIT-005\\eclipse-workspace\\YamlToJson\\src\\com\\example\\yamlFile.yaml");
	File JsonFile = new File ("C:\\Users\\DT-BSIT-005\\eclipse-workspace\\YamlToJson\\src\\com\\example\\jsonFile.json");
	boolean yamlPresent = YamlFile.exists();
    boolean jsonPresent = JsonFile.exists()	;
    System.out.println("yaml File present" + yamlPresent );
	System.out.println("json File present" + jsonPresent );
    if(yamlPresent==false) {
    	try {
    		boolean created = YamlFile.createNewFile();
    		System.out.println("Yaml File Created: " + created);
    		}catch(IOException e) {
    			e.printStackTrace();
    		}
    }
    
   if(jsonPresent==false) {
	   try {
		   boolean created = JsonFile.createNewFile();
		   System.out.println("Json File Created: " + created);
	   }catch(IOException e) {
		   e.printStackTrace();
	   }
   }
   
   try(FileReader reader = new FileReader(YamlFile);
	   FileWriter writer = new FileWriter(JsonFile))
		   {
	   Yaml yamlContent = new Yaml();
	   Map<String,Object> data = yamlContent.load(reader);
		JSONObject jsonObject = new JSONObject (data);
		writer.write(jsonObject.toString(4));
        System.out.println("\n File copied successfully to: " + JsonFile.getAbsolutePath());

			   
		   }catch(IOException e) {
			   e.printStackTrace();
		   }
}
}
