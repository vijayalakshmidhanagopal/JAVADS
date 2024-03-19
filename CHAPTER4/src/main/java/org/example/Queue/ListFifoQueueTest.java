package org.example.Queue;

public class ListFifoQueueTest extends AbstractFifoQueueTestCase{
    protected Queue createFifoQueue() {
        return new ListFifoQueue();
    }
}
