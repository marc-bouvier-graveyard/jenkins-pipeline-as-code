package fr.bouvier.marc;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testApp() {
        assertThat(App.printHelloWorld(),is(equalTo("Hello World!")));
    }
}
