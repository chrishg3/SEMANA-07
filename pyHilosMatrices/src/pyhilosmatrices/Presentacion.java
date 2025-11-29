/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyhilosmatrices;

import java.util.Scanner;

/**
 *
 * @author GABRIEL SALGADO
 */
public class Presentacion {
     private static Scanner sc = new Scanner(System.in);
     private static Double [][] matrizA;
     private static Double [][] matrizB;
     // Función para leer una matriz desde consola
    public static Double[][] leerMatriz(Scanner sc, String nombre) { //Parametros, el scanner para la lectura y el Nombre de la matriz
        
        System.out.println("Ingrese el numero de filas de la matriz " + nombre + ": ");
        int filas = sc.nextInt();   //Obtiene el valor ingresado en la consola para las filas
        System.out.println("Ingrese el numero de columnas de la matriz " + nombre + ": ");
        int columnas = sc.nextInt(); //Obtiene el valor ingresado en la consola para las columnas

        Double[][] matriz = new Double[filas][columnas];  //Genera espacio de memoria en una array para la matriz
        System.out.println("Ingrese los elementos de la matriz " + nombre + ":");

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");  //Presentación para insertar valor
                matriz[i][j] = sc.nextDouble();    //Resecciona y guarda el valor de la consola en la matriz
            }
        }

        return matriz; //devuelve la matriz generada
    }
    // Método principal
    public static void main(String[] args) {
       menu();
    }
    private static void menu(){
        int opciones=0;
        do{
            System.out.println("Menu de opciones: ");
            System.out.println("Seleccione 1 para Sumar y restar Matrices: ");
            System.out.println("Seleccione 2 para Multiplicar Matrices: ");
            System.out.println("Seleccione 3 para Realizar todas las operaciones");
            System.out.println("Presione 4 para Salir: ");
            opciones = sc.nextInt(); //Obtener opcion
            menuOpciones(opciones);
        }while(opciones!=4);
    }
    private static void menuOpciones(int opcion){
        switch(opcion){
            case 1: {
                System.out.println("Es necesario para la suma y resta de matrices que las columnas y filas sean iguales");
                
                 // Leer matriz A
                matrizA = leerMatriz(sc, "A");
                // Mostrar matriz A
                Matrices.mostrarMatriz(matrizA, "A");
                //Leer matriz B
                matrizB = leerMatriz(sc, "B");
                //mostrar matriz B
                Matrices.mostrarMatriz(matrizB,"B");
                if(matrizA.length!=matrizB.length||matrizA[0].length!=matrizB[0].length){
                    System.out.println("Es necesario matrices con columnas y filas iguales"); 
                    break;
                }
                MatrizNormal calculo1 = new MatrizNormal(matrizA, matrizB);
                MatrizHilos calculo2 = new MatrizHilos(matrizA, matrizB);
                calculo1.ejecutarTodos(false);
                calculo2.ejecutarOperacionesParalelas(false);
                break;
            }
            case 2: {
                System.out.println("Para la multiplica el mxn de A para B pxq, p==n ");
                 // Leer matriz A
                matrizA = leerMatriz(sc, "A");
                // Mostrar matriz A
                Matrices.mostrarMatriz(matrizA, "A");
                //Leer matriz B
                matrizB = leerMatriz(sc, "B");
                //mostrar matriz B
                Matrices.mostrarMatriz(matrizB,"B");
                MatrizNormal calculo1 = new MatrizNormal(matrizA, matrizB);
                MatrizHilos calculo2 = new MatrizHilos(matrizA, matrizB);
                calculo1.ejecutarMultiplicacion();
                calculo2.ejecutarMultiplicacion();
                break;
            }
            case 3:{
                System.out.println("Es necesario para la suma y resta de matrices que las columnas y filas sean iguales");
                 // Leer matriz A
                matrizA = leerMatriz(sc, "A");
                // Mostrar matriz A
                Matrices.mostrarMatriz(matrizA, "A");
                //Leer matriz B
                matrizB = leerMatriz(sc, "B");
                //mostrar matriz B
                Matrices.mostrarMatriz(matrizB,"B");
                MatrizNormal calculo1 = new MatrizNormal(matrizA, matrizB);
                MatrizHilos calculo2 = new MatrizHilos(matrizA, matrizB);
                calculo1.ejecutarTodos(true);
                calculo2.ejecutarOperacionesParalelas(true);
                break;
            }
            case 4: System.out.println("Programa finalizado "); break;
        }
    }
    
}
