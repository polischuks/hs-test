package outcomes.lib;

import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;
import org.hyperskill.hstest.testcase.TestCase;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;

class MainMethodNotStaticMain {
    public void main(String[] args) {
        System.out.println("Hello World!");
    }
}

public class MainMethodNotStatic extends StageTest {

    public MainMethodNotStatic() {
        super(MainMethodNotStaticMain.class);
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {
        exception.expect(AssertionError.class);
        exception.expectMessage(
                "Error in test #1\n"
                + "\n"
                + "Main method is not static in class outcomes.lib.MainMethodNotStaticMain");
        exception.expectMessage(not(containsString("Unexpected error")));
    }

    @Override
    public List<TestCase> generate() {
        return Arrays.asList(
            new TestCase()
        );
    }

    @Override
    public CheckResult check(String reply, Object attach) {
        return CheckResult.correct();
    }

}
