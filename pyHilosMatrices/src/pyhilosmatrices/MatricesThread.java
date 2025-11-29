/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyhilosmatrices;

/**
 *
 * @author GABRIEL SALGADO
 */
public class MatricesThread extends Thread {
   private Double[][] matrizA;
    private Double[][] matrizB;
    private String operacion;
    private Matrices helper;
    private Double [][] resultado;

    public MatricesThread(Double[][] matrizA, Double[][] matrizB, String operacion) {
        this.matrizA = matrizA;
        this.matrizB = matrizB;
        this.operacion = operacion;
        this.helper = new Matrices(); // usa tu clase auxiliar
    }

    @Override
    public void run() {
        switch (operacion.toLowerCase()) {
            case "suma":
                resultado =helper.sumaMatrices(matrizA, matrizB);
                break;
            case "resta":
                resultado =helper.restaMatrices(matrizA, matrizB);
                break;
            case "multiplicacion":
                resultado=multiplicacionMatricesThread(matrizA, matrizB);
                break;
            default:
                System.out.println("Operación no reconocida: " + operacion);
        }
    }
    public Double[][] multiplicacionMatricesThread(Double[][] matrizA, Double[][] matrizB){
        int filasA = matrizA.length;       // m
        int colsA = matrizA[0].length;   // n (de A)
        int filasB = matrizB.length;     // n (de B)
        int colsB = matrizB[0].length;   // p
        if (colsA != filasB) {
            System.out.println("Error: Dimensiones incompatibles para la multiplicación.");
            System.out.println("Columnas de Matriz A (" + colsA + ") deben ser igual a Filas de Matriz B (" + filasB + ")");
            return null;
        }
        long tiempoInicial; 
        long tiempoProceso; 
        Double [][] resultado = new Double [filasA][colsB];//Separa memoria para la matriz resultante
        Thread[] hilos = new Thread[filasA]; //Generamos Hilos para cada fila
        tiempoInicial  = System.nanoTime(); //Tiempo inicial cuando empieza el proceso
        for (int i = 0; i < filasA; i++) { // Recorrido por columnas i: numero de filas
            final int fila = i; // Necesario para usar dentro del hilo
            hilos[i] = new Thread(() -> {
                for (int j = 0; j < colsB; j++) {
                    double suma = 0.0;
                    for (int k = 0; k < colsA; k++) {
                        suma += matrizA[fila][k] * matrizB[k][j];
                    }
                    resultado[fila][j] = suma;

                    // Pausa de 2 segundos por cada cálculo fila/columna
                    simularProceso(2);
                }
            });

            hilos[i].start(); // Iniciamos el hilo
        }
        
        // Esperamos a que todos los hilos terminen
        for (int i = 0; i < matrizA.length; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        tiempoProceso  = System.nanoTime()-tiempoInicial; //Tiempo final: tiempoActual - tiempoInicial
        System.out.println("\t Multiplicación de matrices: "+"       --Calculado en "+ tiempoProceso+" nanosegundos");
        return resultado;
    }
    public void simularProceso(long segundos){
        try{
            Thread.sleep(segundos*1000);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public Double[][] getResultado() {
        return resultado;
    }

}
