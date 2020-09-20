package outcomes.unexpected_error;

import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.TestCase;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

class UnexpectedErrorNoCheckMethodMain {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}

public class UnexpectedErrorNoCheckMethod extends StageTest {

    public UnexpectedErrorNoCheckMethod() {
        super(UnexpectedErrorNoCheckMethodMain.class);
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {
        exception.expect(AssertionError.class);
        exception.expectMessage("Unexpected error in test #1");
        exception.expectMessage("Can't check result: override \"check\" method");
    }

    @Override
    public List<TestCase> generate() {
        return Arrays.asList(
            new TestCase()
        );
    }
}