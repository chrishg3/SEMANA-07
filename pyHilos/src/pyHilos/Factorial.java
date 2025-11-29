/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyHilos;

/**
 *
 * @author GABRIEL SALGADO
 */
public class Factorial {

    public Double calcular(long num){
        Double resultado = 1.0;
        long tiempoProcesamiento;
        long tiempoInicial;
        tiempoInicial = System.nanoTime();
        for(long i = 1L; i<=num; i++)
            resultado *=i;
        this.simularProceso(5);
        tiempoProcesamiento = System.nanoTime()-tiempoInicial;
        System.out.println("\tFactorial  de "+num+" = "+ resultado
        +"--Calculado en "+ tiempoProcesamiento+" nanosegundos");
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
}
