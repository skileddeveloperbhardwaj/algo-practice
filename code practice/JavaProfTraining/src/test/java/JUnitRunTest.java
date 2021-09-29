import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JUnitRunTest {
    @Test
    void firstTest() {
        String str = "Hello";
        assertEquals("Hello", str);
        assertFalse(true);
    }

    @Test
    void secondTest() {
        int i = 1;
        assertEquals(1,i);
    }
}