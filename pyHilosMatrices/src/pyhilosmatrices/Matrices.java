/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyhilosmatrices;


/**
 *
 * @author GABRIEL SALGADO
 */
public class Matrices {
    public Double[][]  sumaMatrices (Double [][] matrizA, Double [][] matrizB){ //LLegan las dos matrices de Reales
        long tiempoInicial; 
        long tiempoProceso; 
        int filas = matrizA.length;
        int columnas = matrizA[0].length;
        Double [][] resultado = new Double [filas][columnas]; //Separa memoria para la matriz resultante
        tiempoInicial  = System.nanoTime(); //Tiempo inicial cuando empieza el proceso
        for (int i = 0; i < filas; i++) { //recorrido por filas i : numero de la fila
            for (int j = 0; j < columnas; j++) { // j: numero de columna, la condición debe ser j < columnas (o matrizA[0].length)
                resultado[i][j] = matrizA[i][j] + matrizB[i][j]; //realiza la suma
            }
        }
        tiempoProceso  = System.nanoTime()-tiempoInicial; //Tiempo final: tiempoActual - tiempoInicial
        System.out.println("\t Suma de matrices: "+"       --Calculado en "+ tiempoProceso+" nanosegundos");
        return resultado;
    }
    public Double[][]  restaMatrices (Double [][] matrizA, Double [][] matrizB){ //LLegan las dos matrices de Reales
        long tiempoInicial; 
        long tiempoProceso; 
        int filas = matrizA.length;
        int columnas = matrizA[0].length;
        Double [][] resultado = new Double [filas][columnas];//Separa memoria para la matriz resultante
        tiempoInicial  = System.nanoTime(); //Tiempo inicial cuando empieza el proceso
        for(int i=0; i<filas;i++){ //recorrido por columnas i : numero de la fila
           for(int j =0; j<columnas;j++){ // j: numero de columna
                resultado[i][j]= matrizA[i][j]-matrizB[i][j]; //realiza la resta
            }
        }
        tiempoProceso  = System.nanoTime()-tiempoInicial; //Tiempo final: tiempoActual - tiempoInicial
        System.out.println("\t Resta de matrices: "+"       --Calculado en "+ tiempoProceso+" nanosegundos");
        return resultado;
    }
    public Double[][] multiplicacionMatrices(Double[][] matrizA, Double[][] matrizB){
        
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
        tiempoInicial  = System.nanoTime(); //Tiempo inicial cuando empieza el proceso
        for (int i = 0; i < filasA; i++) { // Recorrido por columnas i: numero de filas
            for (int j = 0; j < colsB; j++) { // j= numero de columnas
                double suma = 0.0;
                for (int k = 0; k < colsA; k++) { // columnas de A = filas de B
                    suma += matrizA[i][k] * matrizB[k][j];
                }
                resultado[i][j] = suma;

                // Pausa de 2 segundos por cada cálculo fila/columna
                simularProceso(2);
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

    // Función para mostrar la matriz con formato \n y \t : Para mejor visualización
    public static void mostrarMatriz(Double[][] matriz, String nombre) { //Parametros: La matriz a mostrar y su nombre
        System.out.println("\nMatriz " + nombre + ":"); 
        for (Double[] fila : matriz) {
            for (Double valor : fila) {
                System.out.print(valor + "\t");  //Muestra el valor y deja un espacio adecuado
            }
            System.out.print("\n"); //salto de linea
        }
    }

}
