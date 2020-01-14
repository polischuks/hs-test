package outcomes;

import org.hyperskill.hstest.v7.stage.StageTest;
import org.hyperskill.hstest.v7.testcase.CheckResult;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;


class FatalErrorNotGeneratingTestsMain {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}

public class FatalErrorNotGeneratingTests extends StageTest {

    public FatalErrorNotGeneratingTests() {
        super(FatalErrorNotGeneratingTestsMain.class);
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {
        exception.expect(AssertionError.class);
        exception.expectMessage("Fatal error during testing, please send the report to support@hyperskill.org");
        exception.expectMessage("Can't create tests: override \"generate\" method");
    }

    @Override
    public CheckResult check(String reply, Object attach) {
        return CheckResult.TRUE;
    }

}
