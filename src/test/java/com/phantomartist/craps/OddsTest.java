package com.phantomartist.craps;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals; 

public class OddsTest {

    @Test
    void oddsTest() {
        assertEquals(7.0, (7.0/6.0) * 6);
        assertEquals(7.0, (7.0/5.0) * 5);
        assertEquals(9.0, (9.0/5.0) * 5);
    }
}
