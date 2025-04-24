Logger System
This project is a customizable Java-based logging system that allows users to store, filter, and manage log messages. It supports logging to files, applying thresholds for file writes, filtering log entries, and user-defined file paths.

📦 Features
Log messages of different types: INFO, WARNING, ERROR

Automatically append logs to a file when a threshold is reached

Customize log file name and path

Filter logs by:

Log type

Text in the message

Both type and message content

Print all logs to the console

Automatically create the log file if it doesn't exist

Fallback to default file if custom path fails

🚀 Usage Example
java
Kopiera
Redigera
LoggerConfig config = new LoggerConfig();
config.setLogToFile(true);
config.setLogThreshold(10);
config.setLogFilePath("logs");
config.setLogFileName("logs.txt");

Logger logger = new Logger(new ArrayList<>(), config);

logger.logAppend(LocalDateTime.now(), "Program started", LogType.INFO.toString());
logger.logAppend(LocalDateTime.now(), "This is a warning", LogType.WARNING.toString());
logger.logAppend(LocalDateTime.now(), "Something went wrong!", LogType.ERROR.toString());

logger.filterByType(LogType.ERROR);
logger.filterByMessage("warning");
logger.filterByTypeAndMessage(LogType.INFO, "Program");
logger.printAllLogs();

logger.thresholdToLog(config);
logger.createLogFile(System.err);
🛠 Class and Method Overview
Logger

Method	Description
logAppend()	Appends a new log entry to the in-memory list.
filterByType()	Prints logs that match a given log type.
filterByMessage()	Prints logs that contain a specific message string.
filterByTypeAndMessage()	Filters logs by both type and message content.
printAllLogs()	Prints all log entries.
thresholdToLog()	Appends logs to a file only when the number of logs reaches a defined threshold.
appendToLog()	Appends current logs to the log file.
createLogFile()	Creates a new log file at a specified path if it doesn't already exist. Includes fallback if path fails.
LoggerConfig

Method	Description
getLogToFile() / setLogToFile()	Enable or disable logging to a file.
getLogThreshold() / setLogThreshold()	Set the number of logs required before they are written to file.
getLogFilePath() / setLogFilePath()	Define the directory for the log file.
getLogFileName() / setLogFileName()	Define the name of the log file.
LogEntry
Represents a single log message with:

Timestamp (LocalDateTime)

Message string

Log type (INFO, WARNING, ERROR)

📁 File Output
Log entries are saved to the specified file once the threshold is reached or the file is manually created. If the path is invalid, a fallback file named fallback_logs.txt will be used.

✅ Requirements
Java 8 or higher
