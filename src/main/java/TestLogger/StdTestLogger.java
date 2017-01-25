package TestLogger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Rabot'aga on 22.12.2016.
 */
public class StdTestLogger implements TestLogger {
    private int stepCounter =0;
    @Override
    public void log(String msg) {
        System.out.println(getLogString(msg));
    }
    private String timeStamp() {
        SimpleDateFormat std = new SimpleDateFormat("HH:mm:ss.SSS");
        return std.format(new Date());
    }
    private String curThread(){
        return Thread.currentThread().getName();
    }

    protected String getLogString(String sms){
        stepCounter++;
        return stepCounter+ ") " + timeStamp() + " [" + curThread() + "]: " + sms;
    }

}
