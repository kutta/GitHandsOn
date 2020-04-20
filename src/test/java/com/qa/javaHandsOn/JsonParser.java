package com.qa.javaHandsOn;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.node.ObjectNode;



public class JsonParser {
	
	final static Logger Log = Logger.getLogger(JsonParser.class.getName());
	
	public static void changeContent(JsonNode parent, String fieldName, String newValue) throws JsonProcessingException, IOException{
		
		Log.debug("Start Cahnge");
		
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
		
		if(parent.has(fieldName)) {
			
			try {
				
				JsonNode jsonNode = mapper.readTree(newValue);
				((ObjectNode) parent).put(fieldName, jsonNode);
				
			}catch(Exception e) {
				
				Log.debug("JSON is not a string");
				((ObjectNode) parent).put(fieldName, newValue);
			}
		}
		
		for(JsonNode child : parent) {
			
			changeContent(child, fieldName, newValue);
		}
		
		Log.debug("End of Change");
		
	}
	
	public static String jsonParser() throws IOException, ParseException, InvalidFormatException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		JsonFactory jsonfactory = new JsonFactory();
		
		com.fasterxml.jackson.core.JsonParser jp = jsonfactory.createJsonParser(new File(System.getProperty("user.dir")+"\\testdata\\EncrypDecryptDownlinkBody.json"));
		
		jp.setCodec(new ObjectMapper());
		
		JsonNode jsonNode = jp.readValueAsTree();
		
		/*String con = "{\"payload_dl\":{\"deveui\":\"456789\"}}";*/
		
		/*String cnf = "kannan";*/
		
		String rn = "Test-01";
		
		changeContent(jsonNode, "rn", rn);
		
		Log.debug("Modified JSON" + jsonNode);
		
		return mapper.writeValueAsString(jsonNode);
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		try {
			
			System.out.println(jsonParser());
			
			
		}catch(Exception e) {
			
			System.out.println("Change Content Failed");
			
		}

	}
	}
	
