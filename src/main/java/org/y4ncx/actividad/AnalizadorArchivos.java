package org.y4ncx.actividad;

import java.io.*;
import java.util.*;

public class AnalizadorArchivos {

    public static void main(String[] args) {

        Stack<Integer> pila = new Stack<>();
        Queue<Integer> cola = new LinkedList<>();

        // --- Leer archivo desde resources ---
        List<Integer> numeros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        AnalizadorArchivos.class.getResourceAsStream("/numeros.txt")
                ))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                int num = Integer.parseInt(linea.trim());
                numeros.add(num);
                pila.push(num);
                cola.add(num);
            }

        } catch (Exception e) {
            System.out.println("⚠️ Error leyendo el archivo: " + e.getMessage());
            return;
        }

        // --- Cálculos básicos ---
        int min = Collections.min(numeros);
        int max = Collections.max(numeros);
        double promedio = numeros.stream().mapToInt(Integer::intValue).average().orElse(0);

        System.out.println("========== PARTE A ==========");
        System.out.println("Minimo : " + min);
        System.out.println("Maximo : " + max);
        System.out.println("Promedio : " + promedio);
        System.out.println();

        System.out.println("Orden Manual (original): " + numeros);
        List<Integer> ordenNativo = new ArrayList<>(numeros);
        Collections.sort(ordenNativo);
        System.out.println("Orden Nativo: " + ordenNativo);
        System.out.println();

        System.out.print("Pila (Stack - LIFO): ");
        while (!pila.isEmpty()) {
            System.out.print(pila.pop() + " ");
        }
        System.out.println();

        System.out.print("Cola (LinkedList - FIFO): ");
        while (!cola.isEmpty()) {
            System.out.print(cola.poll() + " ");
        }
        System.out.println("\n");


        Deque<Integer> pilaDeque = new ArrayDeque<>();
        Deque<Integer> colaDeque = new ArrayDeque<>();

        for (int num : numeros) {
            pilaDeque.push(num);   // (LIFO)
            colaDeque.add(num);    // (FIFO)
        }

        System.out.println("========== PARTE B ==========");
        System.out.println("Usando ArrayDeque (Deque)");

        System.out.print("Pila (Deque - LIFO): ");
        while (!pilaDeque.isEmpty()) {
            System.out.print(pilaDeque.pop() + " ");
        }
        System.out.println();

        System.out.print("Cola (Deque - FIFO): ");
        while (!colaDeque.isEmpty()) {
            System.out.print(colaDeque.poll() + " ");
        }
        System.out.println();


        long inicio = System.nanoTime();
        Deque<Integer> testDeque = new ArrayDeque<>();
        for (int i = 0; i < 100_000; i++) testDeque.push(i);
        while (!testDeque.isEmpty()) testDeque.pop();
        long fin = System.nanoTime();

        System.out.println("\nTiempo Deque (100k inserciones y extracciones): " +
                (fin - inicio) / 1_000_000.0 + " ms");

        System.out.println("\nConclusión:");
        System.out.println("ArrayDeque es más eficiente y moderno que Stack/LinkedList,");
        System.out.println("manteniendo operaciones O(1) amortizadas y menor sobrecarga.");
        System.out.println("Ideal para producción por claridad, rendimiento y menor consumo de memoria.");
    }
}
