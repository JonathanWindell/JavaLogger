package Step4LoggerTesting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public interface ILogger {

    void log(String message);

    public class ConsoleLogger implements ILogger {

        @Override
        public void log(String message) {
            System.out.println(message);
        }
    }

    public class FileLogger implements ILogger {

        private String filePath;

        public FileLogger(String filePath) {
            this.filePath = filePath;
        }

        @Override
        public void log(String message) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
                writer.write(message);
                writer.newLine();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
        }
    }
    }
}
