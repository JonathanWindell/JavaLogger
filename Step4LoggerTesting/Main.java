package Step4LoggerTesting;

import java.time.LocalDateTime;
import java.util.ArrayList;

import Step4LoggerTesting.Logger.LogType;

public class Main {

    public static void main(String[] args) {

         // Step 1: Configure logger
        LoggerConfig config = new LoggerConfig();
        config.setLogToFile(true);                     
        config.setLogThreshold(10);                     
        config.setLogFilePath("logs");                 
        config.setLogFileName("logs.txt");     

        // Step 2: Create logger
        Logger logger = new Logger(new ArrayList<LogEntry>(), config);

        // Step 3: Add logs 
        logger.logAppend(LocalDateTime.now(), "Program started", LogType.INFO.toString());
        logger.logAppend(LocalDateTime.now(), "This is a warning", LogType.WARNING.toString());
        logger.logAppend(LocalDateTime.now(), "Something went wrong!", LogType.ERROR.toString());

        // Step 4: Filter loggar
        System.out.println("\nFilter by type (ERROR):");
        logger.filterByType(LogType.ERROR);

        System.out.println("\nFilter by message ('warning'):");
        logger.filterByMessage("warning");

        System.out.println("\nFilter by type and message (INFO, 'Program'):");
        logger.filterByTypeAndMessage(LogType.INFO, "Program");

        System.out.println("\nPrint all logs:");
        logger.printAllLogs();

        // Step 5: Test threshold and add to file
        logger.thresholdToLog(config);

        // Step 6: Create log if not exist
        logger.createLogFile(System.err);

    }

}