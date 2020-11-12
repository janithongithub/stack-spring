package ie.ucd.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StackTest {
    @Test
    public void testEmpty() {
        LinkedStack<String> stack = new LinkedStack<String>();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void testinsertSingle() {
        LinkedStack<String> stack = new LinkedStack<String>();
        stack.push("Happy");
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals("Happy", stack.top());
    }

    @Test
    public void testinsertRemoveSingle() {
        LinkedStack<String> stack = new LinkedStack<String>();
        stack.push("Happy");
        stack.pop();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
        stack.push("Happy");
        assertEquals("Happy",stack.pop());
        
    }

    
}