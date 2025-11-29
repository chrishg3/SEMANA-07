/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyhilosmatrices;

/**
 *
 * @author GABRIEL SALGADO
 */
public class MatrizHilos{
    private Double[][] matrizA;
    private Double[][] matrizB;

    public MatrizHilos(Double[][] matrizA, Double[][] matrizB) {
        this.matrizA = matrizA;
        this.matrizB = matrizB;
    }

   
    //Ejecutar todo en Paralelo
    public void ejecutarOperacionesParalelas(boolean desicion) {
        System.out.println("-----------Proceso con Operaciones Paralelas-------------- ");
        MatricesThread hiloSuma = new MatricesThread(matrizA, matrizB, "suma");   //Ejecutamos en Paralelo
        MatricesThread hiloResta = new MatricesThread(matrizA, matrizB, "resta");  //Ejecutamos en Paralelo
        MatricesThread hiloMulti=null;
        if(desicion){
             hiloMulti= new MatricesThread(matrizA, matrizB, "multiplicacion");//Ejecutamos  en Paralelo
        }  

        long tiempoInicial = System.nanoTime();

        // Iniciar los tres hilos al mismo tiempo
        hiloSuma.start();
        hiloResta.start();
        if(desicion) {
            hiloMulti.start();
        }
        // Esperar a que todos terminen
        try {
            hiloSuma.join();
            hiloResta.join();
            if(desicion)
                hiloMulti.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long timeProceso = System.nanoTime() - tiempoInicial;
        System.out.println("Suma: ");
         Matrices.mostrarMatriz(hiloSuma.getResultado(), "Resultado");
         System.out.println("Resta: ");
         Matrices.mostrarMatriz(hiloResta.getResultado(), "Resultado");
         if(desicion){
             System.out.println("Multiplicacion: ");
             Matrices.mostrarMatriz(hiloMulti.getResultado(), "Resultado");
         }
        System.out.println("\n==> Todas las operaciones terminaron en " + timeProceso + " nanosegundos");
        
    }
    public void ejecutarMultiplicacion(){
        Double  [][] resultado =null;
       System.out.println("-----------Proceso con Operaciones Paralelas-------------- ");
       MatricesThread matrizT = new MatricesThread(matrizA, matrizB, "multiplicacion");  //Ejecutamos 
       long tiempoInicial = System.nanoTime();
       resultado=matrizT.multiplicacionMatricesThread(matrizA, matrizB);
        long timeProceso = System.nanoTime() - tiempoInicial;
        System.out.println("Multiplicacion: ");
        Matrices.mostrarMatriz(resultado, "Resultado");
        System.out.println("\n==> Todas las operaciones terminaron en " + timeProceso + " nanosegundos");
    }
    //Get y Set de los atributos

    public Double[][] getMatrizA() {
        return matrizA;
    }

    public void setMatrizA(Double[][] matrizA) {
        this.matrizA = matrizA;
    }

    public Double[][] getMatrizB() {
        return matrizB;
    }

    public void setMatrizB(Double[][] matrizB) {
        this.matrizB = matrizB;
    }
    
}
