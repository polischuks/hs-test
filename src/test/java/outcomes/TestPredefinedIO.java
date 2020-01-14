package outcomes;

import org.hyperskill.hstest.v7.stage.StageTest;
import org.hyperskill.hstest.v7.testcase.PredefinedIOTestCase;
import org.hyperskill.hstest.v7.testcase.TestCase;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


class TestPredefinedIOMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(n);
        System.out.println(n);
    }
}

public class TestPredefinedIO extends StageTest {

    public TestPredefinedIO() {
        super(TestPredefinedIOMain.class);
    }

    @Override
    public List<TestCase> generate() {
        return Arrays.asList(
            new PredefinedIOTestCase("123", "123\n123"),
            new PredefinedIOTestCase("567", "567\n567")
        );
    }
}
