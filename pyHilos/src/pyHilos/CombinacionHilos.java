/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyHilos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author GABRIEL SALGADO
 */
public class CombinacionHilos implements Combinacion{
    @Override
    public Double calcular(long n, long m){
        FactorialThread N = new FactorialThread(n);
        FactorialThread M = new FactorialThread(m);
        FactorialThread N_M = new FactorialThread(n-m);
        Double resultado = 0.0;
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(N);
        executor.execute(M);
        executor.execute(N_M);
        executor.shutdown();
        while(!executor.isTerminated()){
            //esperar a que termine de ejecutar todo
        }
        resultado = N.getResult()/(1.0*M.getResult()*N_M.getResult());
        return resultado;
    }
}
