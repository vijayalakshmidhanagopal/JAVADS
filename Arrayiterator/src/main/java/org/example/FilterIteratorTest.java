package org.example;


import junit.framework.TestCase;

public class FilterIteratorTest extends TestCase {
    public static final Object[] ARRAY = {"A", "B", "C"};

    private static class DummyPredicate implements Predicate {
        private final Iterators _iterator;
        private final boolean _result;

        public DummyPredicate(boolean result, Iterators iterator) {
            _iterator = iterator;
            _result = result;
            _iterator.first();
        }

        public boolean evaluate(Object object) {
            assertSame(_iterator.current(), object);
            _iterator.next();
            return _result;
        }
    }


    public void testForwardsIterationIncludesItemsWhenPredicateReturnsTrue() {
        Iterators expectedIterator = new ArrayIterator(ARRAY);
        Iterators underlyingIterator = new ArrayIterator(ARRAY);
        Iterators iterator = new FilterIterator(underlyingIterator, new DummyPredicate(true, expectedIterator));
        iterator.first();
        assertFalse(iterator.isDone());
        assertSame(ARRAY[0], iterator.current());
        iterator.next();
        assertFalse(iterator.isDone());
        assertSame(ARRAY[1], iterator.current());
        iterator.next();
        assertFalse(iterator.isDone());
        assertSame(ARRAY[2], iterator.current());
        iterator.next();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
// expected
        }
        assertTrue(expectedIterator.isDone());
        assertTrue(underlyingIterator.isDone());
    }
    public void testForwardsIterationExcludesItemsWhenPredicateReturnsFalse() {
        Iterators expectedIterator = new ArrayIterator(ARRAY);
        Iterators underlyingIterator = new ArrayIterator(ARRAY);
        Iterators iterator = new FilterIterator(underlyingIterator,
                new DummyPredicate(false, expectedIterator));
        iterator.first();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
// expected
        }
        assertTrue(expectedIterator.isDone());
        assertTrue(underlyingIterator.isDone());
    }


    }

