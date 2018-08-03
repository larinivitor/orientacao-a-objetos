package aula;

class Relogio {

    String transformarMinutosEmHoras(int minutos) {
        StringBuilder stringBuilder = new StringBuilder();
        Calculadora calculadora = new Calculadora();
        int horas = (int) calculadora.dividir(minutos,60);
        int min = (int) calculadora.calcularModuloRetornandoInteiro(minutos, 60);
        stringBuilder.append(String.valueOf(horas));
        stringBuilder.append(" Horas e ");
        stringBuilder.append(String.valueOf(min));
        stringBuilder.append(" Minutos");
        return stringBuilder.toString();
    }

    String transformarSegundosEmHoras(int segundos){
        Calculadora calculadora = new Calculadora();
        int minutos = (int) calculadora.dividir(segundos, 60);
        return  transformarMinutosEmHoras(minutos);
    }
}
