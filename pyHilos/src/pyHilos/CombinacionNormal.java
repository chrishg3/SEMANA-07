/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyHilos;

/**
 *
 * @author GABRIEL SALGADO
 */
public class CombinacionNormal implements Combinacion {
    @Override
    public Double calcular(long n, long m){
      Factorial X= new Factorial();
      Double resultado;
      resultado = X.calcular(n)/(1.0*X.calcular(m)*X.calcular(n-m));
      return resultado;
    }
}
