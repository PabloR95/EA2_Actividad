package com.example.editor;

import java.util.Scanner;

public class TextEditor {

    private final MyStack<String> undoStack = new MyStack<>();
    private final MyStack<String> redoStack = new MyStack<>();

    public static void main(String[] args) {
        new TextEditor().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            Utils.printDivider();
            System.out.println("Editor de Texto - Undo/Redo (Pilas manuales)");
            System.out.println("1. Escribir texto (agregar línea)");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Mostrar texto actual");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            String raw = sc.nextLine().trim();

            option = parseIntSafe(raw, -1);
            Utils.printDivider();

            switch (option) {
                case 1 -> escribirLinea(sc);
                case 2 -> deshacer();
                case 3 -> rehacer();
                case 4 -> mostrarTexto();
                case 5 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción no válida. Intenta nuevamente.");
            }
        } while (option != 5);
        sc.close();
    }

    private void escribirLinea(Scanner sc) {
        System.out.print("Escribe la línea a agregar: ");
        String linea = sc.nextLine();
        undoStack.push(linea);
        redoStack.clear(); // nueva acción invalida el historial de redo
        System.out.println("Línea agregada.");
    }

    private void deshacer() {
        if (undoStack.isEmpty()) {
            System.out.println("No hay nada que deshacer.");
            return;
        }
        String linea = undoStack.pop();
        redoStack.push(linea);
        System.out.println("Deshecho: \"" + linea + "\"");
    }

    private void rehacer() {
        if (redoStack.isEmpty()) {
            System.out.println("No hay nada que rehacer.");
            return;
        }
        String linea = redoStack.pop();
        undoStack.push(linea);
        System.out.println("Rehecho: \"" + linea + "\"");
    }

    private void mostrarTexto() {
        String[] lineas = undoStack.toArray(String.class);
        if (lineas.length == 0) {
            System.out.println("[Documento vacío]");
            return;
        }
        System.out.println("Texto actual:");
        for (int i = 0; i < lineas.length; i++) {
            System.out.printf("%2d | %s%n", i + 1, lineas[i]);
        }
    }

    private int parseIntSafe(String s, int fallback) {
        try { return Integer.parseInt(s); } catch (Exception e) { return fallback; }
    }
}
