package corredores;

import erros.*;
import item.*;
import pista.Pista;

public abstract class Corredor {
    private final int CASAS_POR_MOVIMENTO = 3;
    private Pista pistaEmQueEstaCorrendo;

    private int vida;

    private Item itemEquipado;

    public Corredor(int vida) {
        this.vida = vida;
    }

    public void andar() throws CorredorNaoEstaNaPistaException {
        this.andar(this.getCasasPorMovimento());
    }

    public int getCasasPorMovimento() {
        return CASAS_POR_MOVIMENTO;
    }

    public void setarPistaEmQueEstaCorrendo(Pista pista) {
        this.pistaEmQueEstaCorrendo = pista;
    }

    public int getVida() {
        return vida;
    }

    public void equiparItem(Item item) {
        item.vincularAoCorredor(this);
        this.itemEquipado = item;
    }

    public void desequiparItem() {
        this.itemEquipado.desvincularDoCorredor();
        this.itemEquipado = null;
    }

    public void usarItem(ItemDeUso itemDeUso) throws ItemInvalidoException, CorredorNaoEstaNaPistaException {
        this.validarSeTemItemEquipado(itemDeUso);

        if (itemDeUso instanceof ItemDeBonus) {
            this.usarItemDeBonus((ItemDeBonus) itemDeUso);
        }
        else if (itemDeUso instanceof ItemDeRecuperacao) {
            this.usarItemDeRecuperacao((ItemDeRecuperacao) itemDeUso);
        }
        else {
            throw new ItemInvalidoException();
        }

        this.desequiparItem();
    }

    public void usarItem(ItemDeAtaque itemDeAtaque, Corredor alvo) throws AlvoInvalidoException, ItemInvalidoException {
        this.validarSeTemItemEquipado(itemDeAtaque);

        if (alvo == this) {
            throw new AlvoInvalidoException();
        }

        itemDeAtaque.atacar(alvo);

        this.desequiparItem();
    }

    public void perderVida(int quantidade) {
        this.vida -= quantidade;

        if (vida <= 0) {
            this.pistaEmQueEstaCorrendo.removerCorredor(this);
        }
    }

    public Item getItemEquipado() {
        return itemEquipado;
    }

    public Pista getPistaEmQueEstaCorrendo() {
        return pistaEmQueEstaCorrendo;
    }

    private void andar(int numeroDeCasas) throws CorredorNaoEstaNaPistaException {
        if (this.pistaEmQueEstaCorrendo == null) {
            throw new CorredorNaoEstaNaPistaException();
        }

        this.pistaEmQueEstaCorrendo.moverCorredor(this, numeroDeCasas);
    }

    private void usarItemDeBonus(ItemDeBonus itemDeBonus) throws CorredorNaoEstaNaPistaException {
        this.andar(itemDeBonus.getValorBonus());
    }

    private void usarItemDeRecuperacao(ItemDeRecuperacao itemDeRecuperacao) {
        this.vida += itemDeRecuperacao.getValorRecuperacao();
    }

    private void validarSeTemItemEquipado(Item item) throws ItemInvalidoException {
        if (this.itemEquipado == null || item != this.itemEquipado) {
            throw new ItemInvalidoException();
        }
    }
}
