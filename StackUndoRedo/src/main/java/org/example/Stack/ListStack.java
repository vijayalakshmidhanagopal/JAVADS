package org.example.Stack;

import org.example.Lists.LinkedList;
import org.example.Lists.List;

public class ListStack implements Stack{
    private final List _list = new LinkedList();
    public void push(Object value) {

        _list.add(value);
    }
    public void enqueue(Object value)
    {
        push(value);
    }
    public Object pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return _list.delete(_list.size() - 1);
    }
    public Object dequeue() throws EmptyQueueException {
        try {
            return pop();
        } catch (EmptyStackException e) {
            throw new EmptyQueueException();
        }
    }
    public Object peek() throws EmptyStackException {
        Object result = pop();
        push(result);
        return result;
    }
    public void clear() {
        _list.clear();
    }
    public int size() {
        return _list.size();

    }
    public boolean isEmpty() {
        return _list.isEmpty();
    }

}
