package Jogo.Equipamentos;

public class Espada extends Equipamento {

    public Espada() {
        super("Espada", 80, 6.5, 60);
    }

    @Override
    protected int getUsoDeDurabilidedePorUtilizacao() {
        return 5;
    }
}
