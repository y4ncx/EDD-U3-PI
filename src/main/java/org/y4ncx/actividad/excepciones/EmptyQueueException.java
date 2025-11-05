package org.y4ncx.actividad.excepciones;

public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
        super("La cola está vacía");
    }
}
