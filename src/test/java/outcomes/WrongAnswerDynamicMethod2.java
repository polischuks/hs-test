package outcomes;

import org.hyperskill.hstest.v7.dynamic.input.DynamicTestingMethod;
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

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;

class WrongAnswerDynamicMethod2Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1");
        System.out.println(scanner.nextLine());
    }
}

public class WrongAnswerDynamicMethod2 extends StageTest<String> {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {
        exception.expect(AssertionError.class);
        exception.expectMessage("Wrong answer in test #");
        exception.expectMessage("WA TEST 2");
        exception.expectMessage(not(containsString("Fatal error")));
    }

    @DynamicTestingMethod
    CheckResult test1() {
        TestedProgram pr = new TestedProgram(WrongAnswerDynamicMethod2Main.class);
        String out = pr.start();
        if (!out.equals("1\n")) {
            return CheckResult.wrong("WA TEST 1");
        }
        out += pr.execute("2");
        return new CheckResult(out.equals("1\n2\n"), "");
    }

    @DynamicTestingMethod
    CheckResult test2() {
        TestedProgram pr = new TestedProgram(WrongAnswerDynamicMethod2Main.class);
        String out = pr.start();
        if (!out.equals("2\n")) {
            return CheckResult.wrong("WA TEST 2");
        }
        out += pr.execute("3");
        return new CheckResult(out.equals("2\n3\n"), "");
    }
}