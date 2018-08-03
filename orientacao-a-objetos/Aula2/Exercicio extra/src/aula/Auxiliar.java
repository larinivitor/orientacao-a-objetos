package aula;

class Auxiliar {

    String adicionarPrefixo(String prefixo, String texto){
        StringBuilder construtor = new StringBuilder();

        construtor.append(prefixo);
        construtor.append(" ");
        construtor.append(texto);

        return construtor.toString();
    }
    String adicionarSufixo(String sufixo, String texto){
        StringBuilder construtor = new StringBuilder();

        construtor.append(texto);
        construtor.append(" ");
        construtor.append(sufixo);

        return construtor.toString();
    }
    String adicionarPrefixoAndSufixo(String prefixo, String sufixo, String texto){
        texto = adicionarPrefixo(prefixo, texto);
        texto = adicionarSufixo(sufixo, texto);

        return texto;
    }
}
