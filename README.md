# Editor de Texto con Undo/Redo usando Pilas (Java)

## Objetivo
Comprender el concepto de **pila** y aplicarlo en un simulador de **deshacer/rehacer (Undo/Redo)** para un editor de texto simple en consola, implementando la estructura de la pila **manualmente** (sin `java.util.Stack`).

> Adaptación: Proyecto realizado por ** Pablo Jose Ramirez ** 

## Funcionalidades
- **Escribir texto** (agrega una línea).
- **Deshacer (Undo)** la última acción (borra la última línea agregada).
- **Rehacer (Redo)** Deshace la acción.
- **Mostrar texto actual**.
- **Salir**.

Se usan **dos pilas**:
- **Pila principal (undoStack):** almacena las líneas actuales (acciones realizadas).
- **Pila secundaria (redoStack):** almacena las líneas deshechas para permitir rehacer.

## Estructura del proyecto

├─ src/
│ └─ com/example/editor/
│ ├─ MyStack.java # Pila genérica implementada manualmente
│ ├─ TextEditor.java # Menú en consola y lógica Undo/Redo
│ └─ Utils.java # Utilidad de impresión
└─ README.md