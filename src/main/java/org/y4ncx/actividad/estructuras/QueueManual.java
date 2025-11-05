package org.y4ncx.actividad.estructuras;

import org.example.excepciones.EmptyQueueException;

public class QueueManual<T> {
    private Object[] items;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public QueueManual(int capacity) {
        this.capacity = capacity;
        this.items = new Object[capacity];
        this.size = 0;
        this.head = 0;
        this.tail = 0;
    }

    public void enqueue(T value) {
        if (size == capacity) throw new IllegalStateException("Cola llena");
        items[tail] = value;
        tail = (tail + 1) % capacity;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) throw new EmptyQueueException();
        T value = (T) items[head];
        items[head] = null;
        head = (head + 1) % capacity;
        size--;
        return value;
    }

    public T front() {
        if (isEmpty()) throw new EmptyQueueException();
        return (T) items[head];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) items[i] = null;
        head = tail = size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            int index = (head + i) % capacity;
            sb.append(items[index]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
