package aula;

class CalculadoraInteligente {

    String apresentarSoma(Calculadora calculadora, Auxiliar auxiliar, int x, int y) {
        int resultado = calculadora.somar(x, y);
        return auxiliar.adicionarSufixo(String.valueOf(resultado), "Resultado da soma:");
    }
    String apresentarDivisao(Calculadora calculadora, Auxiliar auxiliar, int x, int y){
        double resultado = calculadora.dividir(x, y);
        return auxiliar.adicionarSufixo(String.valueOf(resultado), "Resultado da divisão:");
    }
    String apresentarSubtracao(Calculadora calculadora, Auxiliar auxiliar, int x, int y){
        int resultado = calculadora.subtrair(x, y);
        return  auxiliar.adicionarSufixo(String.valueOf(resultado), "Resultado da subtração:");
    }
    String apresentarMultiplicacao(Calculadora calculadora, Auxiliar auxiliar, int x, int y){
        double resultado = calculadora.multiplicar(x, y);
        return  auxiliar.adicionarSufixo(String.valueOf(resultado), "Resultado da multiplicação:");
    }
}