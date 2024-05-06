package Assigment4.actors;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Door {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void acquireReadAccess() {
        readWriteLock.readLock().lock();
    }

    public void releaseReadAccess() {
        readWriteLock.readLock().unlock();
    }

    public void acquireWriteAccess() {
        readWriteLock.writeLock().lock();
    }

    public void releaseWriteAccess() {
        readWriteLock.writeLock().unlock();
    }
}
