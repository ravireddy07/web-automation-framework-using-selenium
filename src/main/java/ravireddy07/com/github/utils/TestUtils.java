package ravireddy07.com.github.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"WeakerAccess", "unused"})
public class TestUtils {
    public String dateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // "yyyy-MM-dd-HH-mm-ss"
        Date date = new Date();
        return dateFormat.format(date);
    }

    public Logger log() {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
    }
}
