package Assigment4.miningOperation;

import Assigment4.interfaces.Queue;

import java.util.ArrayList;

public class Deposit<T> implements Queue<T> {
    private ArrayList<T> arrayList;

    public Deposit() {
        this.arrayList = new ArrayList<>();
    }


    @Override
    public synchronized void enqueue(T element) {
        arrayList.add(element);
        notify();
    }

    @Override
    public synchronized T dequeue() throws InterruptedException {
        if (isEmpty())
        {
            wait();
        }
        return arrayList.remove(0);
    }

    @Override
    public synchronized boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public synchronized int size() {
        return arrayList.size();
    }
}
