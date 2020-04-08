package outcomes.dynamic_method;

import org.hyperskill.hstest.v7.dynamic.input.DynamicTestingMethod;
import org.hyperskill.hstest.v7.stage.StageTest;
import org.hyperskill.hstest.v7.testcase.CheckResult;
import org.hyperskill.hstest.v7.testcase.TestCase;
import org.hyperskill.hstest.v7.testing.TestedProgram;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class TestDynamicMethodProgramNotFinishedAfterTestServer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Server started!");
        System.out.println("S1: " + scanner.nextLine());
        System.out.println("S2: " + scanner.nextLine());
    }
}

class TestDynamicMethodProgramNotFinishedAfterTestClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Client started!");
        System.out.println("C1: " + scanner.nextLine());
        System.out.println("C2: " + scanner.nextLine());
    }
}

public class TestDynamicMethodProgramNotFinishedAfterTest extends StageTest<String> {
    @DynamicTestingMethod
    CheckResult test() {
        TestedProgram server = new TestedProgram(
            TestDynamicMethodProgramNotFinishedAfterTestServer.class);

        TestedProgram client = new TestedProgram(
            TestDynamicMethodProgramNotFinishedAfterTestClient.class);

        String out1 = server.start();
        String out2 = client.start();
        if (!out1.equals("Server started!\n")
            || !out2.equals("Client started!\n")) {
            return CheckResult.wrong("");
        }

        return CheckResult.correct();
    }
}