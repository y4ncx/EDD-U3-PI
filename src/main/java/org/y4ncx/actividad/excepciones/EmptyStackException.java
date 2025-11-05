package org.y4ncx.actividad.excepciones;

public class EmptyStackException extends RuntimeException {
    public EmptyStackException() {
        super("La pila está vacía");
    }
}
