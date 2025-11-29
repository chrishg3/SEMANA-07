/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyhilosmatrices;

/**
 *
 * @author GABRIEL SALGADO
 */
public class MatrizNormal implements Matriz {
    private Double [][] matrizA;
    private Double [][] matrizB;
    private Double [][] resultado;

    public MatrizNormal(Double[][] matrizA, Double[][] matrizB) {
        this.matrizA = matrizA;
        this.matrizB = matrizB;
    }
    
    @Override
    public  Double[][] calculoSuma( ){ //Sobrescritura del método calculoSuma
        Matrices obj = new Matrices(); //Se genera una instancia
        resultado = obj.sumaMatrices(matrizA, matrizB); //se ejecuta la funcion
        return resultado; //retorna resultado
    }
    @Override
    public Double[][] calculoResta(){ //Sobrescritura del método calculoResta
        Matrices obj= new Matrices();//Se genera una instancia
        resultado = obj.restaMatrices(matrizA, matrizB);//se ejecuta la funcion
        return resultado;//retorna resultado
    }
    @Override
    public Double[][] calculoMultiplicacion(){ //Sobrescritura del método calculoMultiplicacion
        Matrices obj = new Matrices();//Se genera una instancia
        resultado = obj.multiplicacionMatrices(matrizA, matrizB);//se ejecuta la funcion
        return resultado;//retorna resultado
    }
    public void ejecutarTodos( boolean decision){//Procesamiento lineal - MonoHilo
        Double [][] resultadoSuma =null;
        Double [][] resultadoResta = null;
        Double[][] resultadoMulti = null;
        System.out.println("------------Proceso Linal - MonoHilo-------------- ");
        long timeProceso;
        long timeInicial = System.nanoTime();
        
        resultadoSuma =calculoSuma(); //Primero mostramos la suma
        resultadoResta =calculoResta(); //Segundo mostramos la resta 
        if(decision)
            resultadoMulti =calculoMultiplicacion(); //Tercero mostramos la multiplicación
        timeProceso = System.nanoTime()-timeInicial;
        System.out.println("Suma: ");
         Matrices.mostrarMatriz(resultadoSuma, "Resultado");
         System.out.println("Resta: ");
         Matrices.mostrarMatriz(resultadoResta, "Resultado");
         if(decision){
             System.out.println("Multiplicacion: ");
             Matrices.mostrarMatriz(resultadoMulti, "Resultado");
         }
        System.out.println("\n==> Todas las operaciones terminaron en " + timeProceso + " nanosegundos");
    }
    public void ejecutarMultiplicacion(){
        Double[][] resultadoMulti = null;
        System.out.println("------------Proceso Linal - MonoHilo-------------- ");
        long timeProceso;
        long timeInicial = System.nanoTime();
        resultadoMulti =calculoMultiplicacion(); //Tercero mostramos la multiplicación
        timeProceso = System.nanoTime()-timeInicial;
        System.out.println("Multiplicacion: ");
        Matrices.mostrarMatriz(resultadoMulti, "Resultado");
        System.out.println("\n==> Todas las operaciones terminaron en " + timeProceso + " nanosegundos");
    }

    //Get and Set de las matrices 
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
