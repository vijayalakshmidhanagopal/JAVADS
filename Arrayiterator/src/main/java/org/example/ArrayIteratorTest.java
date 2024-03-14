package org.example;

import junit.framework.TestCase;

public class ArrayIteratorTest extends TestCase{
    public void testIterationRespectsBounds() {
        Object[] array = new Object[] {"A","B","C","D"};
        ArrayIterator iterator = new ArrayIterator(array, 1, 3);
        iterator.first();
        assertFalse(iterator.isDone());
        assertSame(array[1], iterator.current());
        iterator.next();
        assertFalse(iterator.isDone());
        assertSame(array[2], iterator.current());
        iterator.next();
        assertFalse(iterator.isDone());
        assertSame(array[3], iterator.current());
        iterator.next();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {

        }
    }

}
