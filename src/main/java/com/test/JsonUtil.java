package com.test;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonUtil {
	
	
	private String directoryPath = "src/main/resources/schema";
	private String fileName= "Loop.json";
	private String packageName = "ultifi.vehicle.ufl.v1.";
	
	
	
	
	public static void main(String args[]) throws Exception {
		JsonUtil util = new JsonUtil();
		
		try {
			
			
			Path path = Paths.get(util.directoryPath);
			
			try
			{
				Files.newDirectoryStream(path).forEach(file -> {
					
					String fileName= file.getFileName().toString();
					if(!fileName.equals(util.fileName)) {
						try {
							Files.delete(file);
						}
						catch(IOException e) {
							throw new UncheckedIOException(e);
						}
						
						
					}else {
						
						
						
						Path path2 = Paths.get(util.directoryPath+fileName);
						Charset charset = StandardCharsets.UTF_8;
						String content;
						try {
							content = new String(Files.readAllBytes(path2),charset);
						
						content = content.replaceAll(util.packageName, "");
						Files.write(path2, content.getBytes(charset));
						
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					}
					
					
					
					
					
				});
				
				
				
				
				
				
				
				
			}
			catch(Exception e) {
				throw e;
			}
			
			
			
		}
		catch(Exception e) {
			throw e;
			
		}
		
		
		
		
		
		
	}

}
