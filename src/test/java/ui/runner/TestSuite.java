package ui.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ui.tests.CheckCarDetailsTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CheckCarDetailsTest.class

})
public class TestSuite {
}
