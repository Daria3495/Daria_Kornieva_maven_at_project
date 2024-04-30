package automation.runner;

import java.io.IOException;

public class EnvironmentRunner {

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("CONFIG"));
    }
}
