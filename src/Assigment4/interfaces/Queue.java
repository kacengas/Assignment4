package Assigment4.interfaces;

public interface Queue<T> {
    void enqueue(T element);
    T dequeue() throws InterruptedException;
    boolean isEmpty();
    int size();
}
