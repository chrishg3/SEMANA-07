/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyHilos;

/**
 *
 * @author GABRIEL SALGADO
 */
public class FactorialThread extends Thread {
    private long n;
    private Double resultado;
    public FactorialThread(long n){
        this.n=n;
    }
    @Override
    public void run(){
        Factorial factorial = new Factorial();
        resultado = factorial.calcular(n);
    }
    public Double getResult(){
        return resultado;
    }
}
