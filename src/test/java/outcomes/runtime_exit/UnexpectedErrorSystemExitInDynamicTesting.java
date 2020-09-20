package outcomes.runtime_exit;

import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;
import org.hyperskill.hstest.testcase.TestCase;
import org.hyperskill.hstest.testing.TestedProgram;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class UnexpectedErrorSystemExitInDynamicTestingMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(scanner.nextLine());
    }
}

public class UnexpectedErrorSystemExitInDynamicTesting extends StageTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {
        exception.expect(AssertionError.class);
        exception.expectMessage("Unexpected error in test #2");
        exception.expectMessage("CheckExitCalled: Tried to exit");
    }

    @Override
    public List<TestCase> generate() {
        return Arrays.asList(
            new TestCase().setDynamicTesting(() -> {
                TestedProgram main = new TestedProgram(
                    UnexpectedErrorSystemExitInDynamicTestingMain.class);
                main.start();
                main.execute("123");
                return CheckResult.correct();
            }),

            new TestCase().setDynamicTesting(() -> {
                TestedProgram main = new TestedProgram(
                    UnexpectedErrorSystemExitInDynamicTestingMain.class);
                main.start();
                System.exit(0);
                main.execute("123");
                return null;
            })
        );
    }
}