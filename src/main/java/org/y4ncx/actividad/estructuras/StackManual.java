package org.y4ncx.actividad.estructuras;

import org.example.excepciones.EmptyStackException;

public class StackManual<T> {
    private Object[] items;
    private int size;
    private int capacity;

    public StackManual(int capacity) {
        this.capacity = capacity;
        this.items = new Object[capacity];
        this.size = 0;
    }

    public void push(T value) {
        if (size == capacity) throw new IllegalStateException("Pila llena");
        items[size++] = value;
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T value = (T) items[--size];
        items[size] = null;
        return value;
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return (T) items[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) items[i] = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = size - 1; i >= 0; i--) {
            sb.append(items[i]);
            if (i > 0) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
