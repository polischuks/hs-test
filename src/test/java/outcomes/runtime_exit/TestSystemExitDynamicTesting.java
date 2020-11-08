package outcomes.runtime_exit;

import org.hyperskill.hstest.testcase.CheckResult;
import org.hyperskill.hstest.testcase.TestCase;
import org.hyperskill.hstest.testing.TestedProgram;
import outcomes.base.ContainsMessage;
import outcomes.base.UserErrorTest;

import java.util.Arrays;
import java.util.List;

class TestSystemExitDynamicTestingMain {
    public static void main(String[] args) {
        System.exit(0);
    }
}

public class TestSystemExitDynamicTesting extends UserErrorTest {

    @ContainsMessage
    String m = "Wrong answer in test #1";

    @Override
    public List<TestCase> generate() {
        return Arrays.asList(
            new TestCase().setDynamicTesting(() -> {
                TestedProgram pr = new TestedProgram(TestSystemExitDynamicTestingMain.class);
                pr.start();
                return CheckResult.wrong("");
            })
        );
    }
}

