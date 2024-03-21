package org.example;

public class CustomerServiceAgent implements Runnable{
    public static final Call GO_HOME = new Call(-1, 0);
    private final int _id;
    private final Queue _calls;
    public CustomerServiceAgent(int id, Queue calls) {
        assert calls != null : "calls can't be null";
        _id = id;
        _calls = calls;
    }
    public String toString() {

        return " Agent " + _id;
    }
    public void run() {
        System.out.println(this + " clocked on");
        while (true) {
            System.out.println(this + " Waiting");
            Call call = (Call) _calls.dequeue();
            System.out.println(this + " answering" + call);
            if (call == GO_HOME) {
                break;
            }
            call.answer();

        }
        System.out.println(this +" going home");
    }

}
