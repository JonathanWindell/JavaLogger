package Step4LoggerTesting;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintStream;
import java.nio.Buffer;

/**
 * Logger class for tracking application events and errors
 */
public class Logger {

    // Collection to store log entries
    private ArrayList<LogEntry> log = new ArrayList<>(); 
    private LoggerConfig config;

    /**
     * Constructor with existing log list
     * @param log List of log entries
     */
    public Logger(ArrayList<LogEntry> log, LoggerConfig config) {
        this.log = log;
        this.config = config;
    }

    /**
     * Returns the current log list
     * @return ArrayList of log entries
     */
    public ArrayList<LogEntry> getLog() {
        return log;
    }

    /**
     * Creates and adds a new log entry
     * @param timeStamp Time of the log event
     * @param message Log message content
     * @param type Log entry type
     */
    public void logAppend(LocalDateTime timeStamp, String message, String type) {
        Logger.LogType currentType = Logger.LogType.valueOf(type);
    
        if (currentType.ordinal() >= config.getMinimumLogLevel().ordinal()) {
            LogEntry entry = new LogEntry(timeStamp, message, type);
            log.add(entry);
        }
    }

    /**
     * Enum for standard log types
     */
    public enum LogType {
        ERROR, INFO, WARNING, DEBUG
    }

    /**
     * Lets user decide level of filtering
     */
    public void printFilteredLogs() {
        switch (config.getFilterMode()) {
            case BY_TYPE:
                filterByType(config.getFilterType());
                break;
            case BY_TEXT:
                filterByMessage(config.getFilterMessage());
                break;
            case BY_TYPE_AND_TEXT:
                filterByTypeAndMessage(config.getFilterType(), config.getFilterMessage());
                break;
            default:
                printAllLogs();
                break;
        }
    }
    
    /**
     * Filters and prints logs by type
     * @param type The log type to filter by
     */
    public void filterByType(LogType type) {
        for (LogEntry entry : log) {
            if (entry.getType().equals(type.toString())) {
                System.out.println(entry);
            }
        }
    }

    /**
     * Filters and prints logs containing specific text
     * @param messageText Text to search for in log messages
     */
    public void filterByMessage(String messageText) {
        for (LogEntry entry : log) {
            if (entry.getMessage().contains(messageText)) {
                System.out.println(entry);
            }
        }
    }
    
    /**
     * Filters and prints logs by both type and message content
     * @param type Log type to filter by
     * @param messageText Text to search for in log messages
     */
    public void filterByTypeAndMessage(LogType type, String messageText) {
        for (LogEntry entry : log) {
            if (entry.getType().equals(type.toString()) && 
                entry.getMessage().contains(messageText)) {
                System.out.println(entry);
            }
        }
    }
    
    /**
     * Prints all log entries to console
     */
    public void printAllLogs() {
        for (LogEntry entry : log) {
            System.out.println(entry);
        }
    }

    /**
     * Creates a new log file or reports if it exists
     * @param errorOutput Stream where error messages should be written
     */
    public void createLogFile(PrintStream errorOutput) {
        try {

            String path = config.getLogFilePath().isEmpty() ? "." : config.getLogFilePath();
            String name = config.getLogFileName().isEmpty() ? "logs.txt" : config.getLogFileName();

            File myObj = new File(path, name);
            if (myObj.createNewFile()) {
                errorOutput.println("File created: " + myObj.getAbsolutePath());
                BufferedWriter buffWriter = new BufferedWriter(new FileWriter(myObj));
                buffWriter.write(log.toString());
                buffWriter.close();
            } else {
                errorOutput.println("File already exists.");
            }
        } catch (IOException e) {
            errorOutput.println("An error occurred.");
            e.printStackTrace(errorOutput);
        }
    }

    /**
     * Appends logs to file when log count exceeds threshold
     */
    public void appendToLog(LoggerConfig config) {
        if (config.getLogToFile()) { 
            try {

                String path = config.getLogFilePath().isEmpty() ? "." : config.getLogFilePath();
                String name = config.getLogFileName().isEmpty() ? "logs.txt" : config.getLogFileName();

                File myObj = new File(path, name); 
                BufferedWriter writer = new BufferedWriter(new FileWriter(myObj, true));
                writer.write(log.toString());
                writer.close();
                System.out.println("Logs appended to file");
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void thresholdToLog(LoggerConfig config) {
        if (log.size() >= config.getLogThreshold()) {
            appendToLog(config);
            System.out.println("Logs appended to file given users threshold");
        } else {
            System.out.println("Logs not appended to file given users threshold: ");
        }
    }

    /**
     * Removes all log entries
     */
    public void clearLogs(LoggerConfig config) {
        if (config.getClearLogs()) {
            log.clear();
            System.out.println("Logs cleared");
            config.setClearLogs(false);
        } else {
            System.out.println("Logs not cleared");
        }
        
    }

    /**
     * Logs exceptions with appropriate log level based on exception type
     * @param e The exception to log
     * @param context Description of where the exception occurred
     */
    public void logImportantException(Exception e, String context, LoggerConfig config) {
        LogType logType;

        if (e instanceof NullPointerException || 
            e instanceof ArithmeticException || 
            e instanceof IllegalArgumentException) {
            logType = LogType.ERROR;
        }
        else if (e instanceof IOException) {
            logType = LogType.WARNING;
        }
        else {
            logType = LogType.INFO;
        }
        
        LogEntry entry = new LogEntry(
            LocalDateTime.now(),
            context + ": " + e.getClass().getSimpleName() + " - " + e.getMessage(),
            logType.toString() 
        );

        if (logType.ordinal() >= config.getLogImportantExceptions().ordinal()) {
            this.log.add(entry);
        }
    }
}

