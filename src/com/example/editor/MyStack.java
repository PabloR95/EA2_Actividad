package com.example.editor;

/**
 * Pila genérica implementada manualmente
 * Operaciones: push, pop, peek, isEmpty, size, clear, toArray */
public class MyStack<T> {

    private static class Node<E> {
        E data;
        Node<E> next;
        Node(E d, Node<E> n) { data = d; next = n; }
    }

    private Node<T> top;
    private int count;

    /** Inserta un elemento en la cima de la pila. */
    public void push(T value) {
        top = new Node<>(value, top);
        count++;
    }

    /** Quita y retorna el elemento en la cima. */
    public T pop() {
        if (isEmpty()) throw new IllegalStateException("La pila está vacía");
        T value = top.data;
        top = top.next;
        count--;
        return value;
    }

    /** Retorna el elemento de la cima sin quitarlo. */
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("La pila está vacía");
        return top.data;
    }

    /** ¿Está vacía? */
    public boolean isEmpty() {
        return top == null;
    }

    /** Cantidad de elementos. */
    public int size() {
        return count;
    }

    /** Elimina todos los elementos. */
    public void clear() {
        top = null;
        count = 0;
    }

    /* Retorna el contenido de la pila como arreglo */
    @SuppressWarnings("unchecked")
    public T[] toArray(Class<T> clazz) {
        // Crear arreglo destino
        T[] arr = (T[]) java.lang.reflect.Array.newInstance(clazz, count);

        
        Object[] temp = new Object[count];
        Node<T> cur = top;
        int i = 0;
        while (cur != null) {
            temp[i++] = cur.data;
            cur = cur.next;
        }

       
        for (int j = 0; j < count; j++) {
            arr[j] = (T) temp[count - 1 - j];
        }

        return arr;
    }
}
