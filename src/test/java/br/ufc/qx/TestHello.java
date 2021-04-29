package br.ufc.qx;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


import java.io.*;

public class TestHello {

    @Test
    public void testHelloWorld()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Runner.main(null);

        // assertion
        assertEquals("Hello world!\n", bos.toString());

        // undo the binding in System
        System.setOut(originalOut);
    }
}