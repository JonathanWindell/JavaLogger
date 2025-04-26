package Step4LoggerTesting;

public interface ILogger {

    void log(String message);

    public class ConsoleLogger implements ILogger {

        @Override
        public void log(String message) {
            System.out.println(message);
        }
    }

    

}
