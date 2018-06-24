package fr.bouvier.marc;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
/**
 * Unit test for simple App.
 */
public class AppIT
{
    @Test
    public void testApp()
    {
        assertThat(App.printHelloWorld(),is(equalTo("Hello World!")));
    }
}
