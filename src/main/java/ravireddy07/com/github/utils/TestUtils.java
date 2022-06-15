package ravireddy07.com.github.utils;

import ravireddy07.com.github.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings({"WeakerAccess", "unused"})
public class TestUtils {
    public String dateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // "yyyy-MM-dd-HH-mm-ss"
        Date date = new Date();
        return dateFormat.format(date);
    }

    public void log(String txt) {
        BaseTest base = new BaseTest();
        String msg = Thread.currentThread().getId() + ":" + base.getPlatform() + ":" + base.getBrowserName() + ":" + Thread.currentThread().getStackTrace()[2].getClassName() + ":" + txt;
        String strFile = "logs" + File.separator + base.getPlatform() + "_" + base.getBrowserName() + File.separator + dateTime();

        File logFile = new File(strFile);
        if(!logFile.exists()) {
            logFile.mkdirs();
        }

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(logFile + File.separator + "log.txt", true);
        } catch(IOException e) {
            e.printStackTrace();
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(msg);
        printWriter.close();
    }

    public Logger log() {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
    }
}
