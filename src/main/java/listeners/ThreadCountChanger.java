package listeners;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;

public class ThreadCountChanger implements IAlterSuiteListener {

	@Override
    public void alter(List<XmlSuite> suites) {
		FileInputStream fis;
		Properties config = new Properties();
		int count;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//---------------------------------------------------------------------------
		if(System.getProperty("threadCount")!=null) {
			count = Integer.parseInt(System.getProperty("threadCount", "-1"));
		}else if(System.getenv("threadCount") !=null && !System.getenv("threadCount").isEmpty()) {
			count = Integer.parseInt(System.getenv("threadCount"));
		} else {
			count = Integer.parseInt(config.getProperty("threadCount"));
		}
		
        System.err.println("**Alter is invoked**");
        if (count <= 0) {
            return;
        }
        for (XmlSuite suite : suites) {
            suite.setDataProviderThreadCount(count);
        }
	}
}
