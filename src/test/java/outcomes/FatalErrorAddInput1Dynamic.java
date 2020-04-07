package outcomes;

import org.hyperskill.hstest.v7.stage.StageTest;
import org.hyperskill.hstest.v7.testcase.CheckResult;
import org.hyperskill.hstest.v7.testcase.TestCase;
import org.hyperskill.hstest.v7.testing.TestedProgram;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class FatalErrorAddInput1DynamicMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());
    }
}

public class FatalErrorAddInput1Dynamic extends StageTest {

    public FatalErrorAddInput1Dynamic() {
        super(FatalErrorAddInput1DynamicMain.class);
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {
        exception.expect(AssertionError.class);
        exception.expectMessage("Fatal error in test #1, please send the report to support@hyperskill.org");
        exception.expectMessage("java.lang.ArithmeticException: / by zero");
    }

    @Override
    public List<TestCase> generate() {
        return Arrays.asList(
            new TestCase().setDynamicInput(() -> {
                TestedProgram main = new TestedProgram(FatalErrorAddInput1DynamicMain.class);
                main.start();
                int x = 0 / 0;
                main.execute("Hello");
                return CheckResult.correct();
            })
        );
    }
}
