package aula;

class Calculadora {

    int somar(int x, int y){
        int resultado = x + y;
        return resultado;
    }
    int subtrair (int x, int y){
        int resultado = x - y;
        return resultado;
    }
    double multiplicar(int x, int y){
        double resultado = x * y;
        return resultado;
    }
    double dividir(int x, int y){
        double resultado = (double) x/y;
        return resultado;
    }
}
