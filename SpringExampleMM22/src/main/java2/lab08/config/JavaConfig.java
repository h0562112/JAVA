package lab08.config;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("lab08.properties")
public class JavaConfig {
	
	@Value("${lab08.infile.name}")
	String inFilename;
	@Value("${lab08.outfile.name}")
	String outFilename;
	
	@Bean
	public File inFile() {
		File f = new File(inFilename);
		return f;
	}
	
	@Bean
	public File outFile() {
		File f = new File(outFilename);
		return f;
	}
	
	@Bean 
		FileInputStream fis() throws FileNotFoundException {
		FileInputStream f = new FileInputStream(inFile());
		return f;
	}
	
	@Bean 
	FileOutputStream fos() throws FileNotFoundException {
		FileOutputStream f = new FileOutputStream(outFile());
		return f;
	}
}
