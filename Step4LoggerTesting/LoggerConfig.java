package Step4LoggerTesting;

public class LoggerConfig {

    // Minimum logger level
    private Logger.LogType minimumLogLevel = Logger.LogType.INFO;

    public Logger.LogType getMinimumLogLevel() {
        return minimumLogLevel;
    }

    public void setMinimumLogLevel(Logger.LogType minimumLogLevel) {
        this.minimumLogLevel = minimumLogLevel;
    }

    // Clear logs
    private boolean clearLogs = false;

    public boolean getClearLogs() {
        return clearLogs;
    }

    public void setClearLogs(boolean clearLogs) {
        this.clearLogs = clearLogs;
    }

    // Log to file
    private boolean logToFile = false;

    public boolean getLogToFile() {
        return logToFile;
    }

    public void setLogToFile(boolean logToFile) {
        this.logToFile = logToFile;
    }

    // User threshold before logging
    private int logThreshold = 0;

    public int getLogThreshold() {
        return logThreshold;
    }

    public void setLogThreshold(int logThreshold) {
        this.logThreshold = logThreshold;
    }

    // Letting user decide path and file name
    private String logFilePath = "";
    private String logFileName = "";

    public String getLogFilePath() {
        return logFilePath;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public void setLogFilePath(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    public void setLogFileName(String logFileName) {
        this.logFileName = logFileName;
    }

    // Log important exceptions
    private Logger.LogType logImportantExceptions = Logger.LogType.ERROR;

    public Logger.LogType getLogImportantExceptions() {
        return logImportantExceptions;
    }

    public void setLogImportantExceptions(Logger.LogType logImportantExceptions) {
        this.logImportantExceptions = logImportantExceptions;
    }

    // Log type and message 
    private Logger.LogType filterType;
    private String filterMessage;
    private FilterMode filterMode;

    public enum FilterMode {
        ALL, BY_TYPE, BY_TEXT, BY_TYPE_AND_TEXT
    }

    public Logger.LogType getFilterType() {
        return filterType;
    }

    public void setFilterType(Logger.LogType filterType) {
        this.filterType = filterType;
    }

    public String getFilterMessage() {
        return filterMessage;
    }

    public void setFilterMessage(String filterMessage) {
        this.filterMessage = filterMessage;
    }

    public FilterMode getFilterMode() {
        return filterMode;
    }

    public void setFilterMode(FilterMode filterMode) {
        this.filterMode = filterMode;
    }


    
    
    


    







}
