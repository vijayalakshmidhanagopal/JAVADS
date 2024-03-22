package org.example;
import org.example.Lists.AbstractListTestCase;
import org.example.Lists.List;
import org.example.Lists.ArrayList;

public class UndoableListTest extends AbstractListTestCase{
    protected List createList() {
        return new UndoableList(new ArrayList());
    }
    public void testUndoInsert() {
        UndoableList list = new UndoableList(new ArrayList());
        assertFalse(list.canUndo());
        list.insert(0, VALUE_A);
        assertTrue(list.canUndo());
        list.undo();
        assertEquals(0,list.size());
        assertFalse(list.canUndo());
    }
    public void testUndoAdd() {

        UndoableList list = new UndoableList(new ArrayList());
        assertFalse(list.canUndo());
        list.add(VALUE_A);
        assertTrue(list.canUndo());
        list.undo();
        assertEquals(0,list.size());
        assertFalse(list.canUndo());
    }

    public void testUndoDeleteByPosition() {
        UndoableList list = new UndoableList(new ArrayList());
        assertFalse(list.canUndo());
        list.add(VALUE_A);
        list.add(VALUE_B);
        assertSame(VALUE_B, list.delete(1));
        assertTrue(list.canUndo());
        list.undo();
        assertEquals(2, list.size());
        assertSame(VALUE_A, list.get(0));
        assertSame(VALUE_B, list.get(1));
        assertTrue(list.canUndo());



    }
    public void testUndoDeleteByValue() {
        UndoableList list = new UndoableList(new ArrayList());
        assertFalse(list.canUndo());
        list.add(VALUE_A);
        list.add(VALUE_B);
        assertTrue(list.delete(VALUE_B));
        assertTrue(list.canUndo());
        list.undo();
        assertEquals(2, list.size());
        assertSame(VALUE_A, list.get(0));
        assertSame(VALUE_B, list.get(1));
        assertTrue(list.canUndo());
    }
    public void testUndoSet() {
        UndoableList list = new UndoableList(new ArrayList());
        assertFalse(list.canUndo());
        list.add(VALUE_A);
        assertSame(VALUE_A, list.set(0, VALUE_B));
        assertTrue(list.canUndo());
        list.undo();
        assertEquals(1, list.size());
        assertSame(VALUE_A, list.get(0));

    }
    public void testClearResetsUndoStack() {
        UndoableList list = new UndoableList(new ArrayList());
        assertFalse(list.canUndo());
        list.add(VALUE_A);
        assertTrue(list.canUndo());
        list.clear();
        assertFalse(list.canUndo());
    }
    public void testUndoMultiple() {
        UndoableList list = new UndoableList(new ArrayList());
        assertFalse(list.canUndo());
        list.add(VALUE_A);
        list.add(VALUE_B);
        list.undo();
        assertEquals(1, list.size());
        assertSame(VALUE_A, list.get(0));
        assertTrue(list.canUndo());
        list.delete(0);
        list.undo();
        assertEquals(1, list.size());
        assertSame(VALUE_A, list.get(0));
        assertTrue(list.canUndo());
        list.undo();
        assertEquals(0, list.size());
        assertFalse(list.canUndo());
    }


    }
