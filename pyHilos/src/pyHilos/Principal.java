/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyHilos;

/**
 *
 * @author GABRIEL SALGADO
 */
public class Principal {
    public static void main(String[] args) {
        long tiempo;
        Double valor;
        long inicialTime;
        Combinacion combinacionNormal = new CombinacionNormal();
        Combinacion combinacionHilos = new CombinacionHilos();
        System.out.println("Procesamiento Normal: ");
        inicialTime = System.nanoTime();
        valor = combinacionNormal.calcular(50L, 5L);
        tiempo = System.nanoTime()- inicialTime;
        System.out.println("\tCombinacionNormal(50,5) = " + valor + 
                " calculado en: "+ tiempo +" nanosegundo\n");
        System.out.println("Procesamiento con Hilos: ");
        inicialTime = System.nanoTime();
        valor = combinacionHilos.calcular(50L, 5L);
        tiempo = System.nanoTime()-inicialTime;
        System.out.println("\tCombinacionHilos(50,5) = " + valor + 
                " calculado en: "+ tiempo +" nanosegundo\n");
        
    }
}
