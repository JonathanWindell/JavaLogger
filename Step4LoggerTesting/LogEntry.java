package Step4LoggerTesting;
import java.time.LocalDateTime;

/**
 * Represents a single log entry with timestamp, message, and type
 */
public class LogEntry {
    
    private LocalDateTime timeStamp;
    private String message;
    private String type;
    
    /**
     * Creates a new log entry
     * @param timeStamp Time when the log entry was created
     * @param message Content of the log message
     * @param type Category or severity of the log entry
     */
    public LogEntry(LocalDateTime timeStamp, String message, String type) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.type = type;
    }
    
    /**
     * Gets the type of this log entry
     * @return The log type as a string
     */
    public String getType() {
        return type;
    }
    
    /**
     * Gets the timestamp of this log entry
     * @return The timestamp when this log was created
     */
    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
    
    /**
     * Gets the message content
     * @return The log message text
     */
    public String getMessage() {
        return message;
    }
    
    /**
     * Formats the log entry as a string
     * @return Formatted string with timestamp, type, and message
     */
    @Override
    public String toString() {
        return timeStamp + ", " + type + ", " + message;
    }
}