package whatsapp.base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReport {
	public static void generateJVMReport(String jsonFile) {
		File location = new File ("src\\test\\resources\\reports");
		Configuration config = new Configuration(location, "Whatsapp Web");
		config.addClassifications("OS", "Windows 10");
		config.addClassifications("Browser", "Google Chrome");
		config.addClassifications("Version", "79.*");
		config.addClassifications("Eclipse", "Photon R");
		config.addClassifications("Date", "27 May 20");
		
		List<String> jsonFiles= new ArrayList<String>();
		jsonFiles.add(jsonFile);
		
		ReportBuilder builder = new ReportBuilder(jsonFiles,config);
		builder.generateReports();
	}
}
