package party;

import alvos.Alvo;
import personagem.Humano;
import personagem.Personagem;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Grupo {
    private List<Personagem> grupoPersonagem;

    public Grupo() {
        grupoPersonagem = new LinkedList<>();
    }

    public void adicionarPersonagem(Personagem personagem) {
        grupoPersonagem.add(personagem);
    }

    public void adicionarListaPersonagens(List<Personagem> listaPersonagens) {
        grupoPersonagem.addAll(listaPersonagens);
    }

    public void atacarSimples(Alvo alvo) {
        atacar(grupoPersonagem, alvo);
    }

    public int getPoderAtaqueGrupo() {
        int poderTotalGrupo = 0;
        for (Personagem personagem : grupoPersonagem) {
            poderTotalGrupo += personagem.calcularPoderAtaque();
        }
        return poderTotalGrupo;
    }

    public void atacarSomenteComHumanos(Alvo alvo){
        List<Personagem> personagens = new LinkedList<>();
        for(Personagem personagemAtual : grupoPersonagem){
            if(personagemAtual instanceof Humano) {
                personagens.add(personagemAtual);
            }
        }
        atacar(personagens, alvo);
    }

    public void atacarOrdenado(Alvo alvo){
        Comparator<Personagem> porNome = Comparator.comparing(Personagem::getNome);
        List<Personagem> personagensOrdenados = grupoPersonagem.stream().sorted(porNome).collect(Collectors.toList());
        atacar(personagensOrdenados, alvo);
    }

    private void atacar(List<Personagem> personagens, Alvo alvo) {
        for (Personagem personagem : personagens) {
            alvo.receberAtaque(personagem.calcularPoderAtaque());
        }
    }
}
