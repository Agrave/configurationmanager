package TestLogger;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileTestLogger implements TestLogger {
    private String fileName = "target\\custom-logs\\"+"report_" + date() + ".txt";
    private int stepCounter;
    private List<String> log;
    private String start =timeStamp();

    public FileTestLogger() {
        log=new ArrayList<>();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                saveToFile();
            }
        });
        stepCounter = 0;
    }

    public void log(String msg) {
        log.add(getLogString(msg));
    }
    private void saveToFile() {

        try (FileWriter reportFile = new FileWriter(fileName, true)) {
            reportFile.write("logging start at: "+start+"\n");
            reportFile.write("logging stop  at: "+timeStamp()+"\n");
            if (!log.isEmpty())
                for (int i = 0; i < log.size(); i++) {
                    reportFile.write(log.get(i) + "\n");
                }
                reportFile.write("\n");
            reportFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String timeStamp() {
        SimpleDateFormat std = new SimpleDateFormat("HH:mm:ss.SSS");
        return std.format(new Date());
    }

    private String curThread() {
        return Thread.currentThread().getName();
    }

    protected String getLogString(String sms) {
        stepCounter++;
        return stepCounter + ") " + timeStamp() + " [" + curThread() + "]: " + sms;
    }

    private String date() {
        SimpleDateFormat std = new SimpleDateFormat("yyyy_MM_dd");
        return std.format(new Date());
    }
}
