package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyHelper {
   static InputStream input = null;
   static Properties prop = null;
   static FileOutputStream output = null;

    public static String readProperty(String key) throws IOException {
         String result = "";
         String fileName = "config.properties";

        try {
            prop = new Properties();
            ClassLoader loader = PropertyHelper.class.getClassLoader();
            input = loader.getResourceAsStream("properties/"+fileName);
            //System.getProperty("user.dir")+ "/PropertyFiles/"+fileName
			/* input = new FileInputStream("resources/"+fileName); */

            if(input != null){
                prop.load(input);
            }else{
               System.out.println("File not found");
            }

            result = prop.getProperty(key);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            input.close();
        }
        return result;
    }

	/*
	 * public static void writeProperty(String fileName, String key, String value)
	 * throws IOException {
	 * 
	 * try { prop = new Properties(); prop.load(new
	 * FileInputStream("resources/"+fileName)); prop.setProperty(key, value);
	 * 
	 * output = new FileOutputStream("resources/"+fileName);
	 * System.out.println(output); prop.store(output, null);
	 * 
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }finally { output.close(); }
	 * 
	 * 
	 * }
	 */


}
