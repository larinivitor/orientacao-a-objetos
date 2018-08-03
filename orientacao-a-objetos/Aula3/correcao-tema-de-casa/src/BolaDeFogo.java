public class BolaDeFogo {
    private int poderDaEscolaDeMagia;
    private int poderDoMago;
    private int pontosDeManaUtilizados;

    public BolaDeFogo(int poderDaEscolaDeMagia, int poderDoMago, int pontosDeManaUtilizados) {
        this.poderDaEscolaDeMagia = poderDaEscolaDeMagia;
        this.poderDoMago = poderDoMago;
        this.pontosDeManaUtilizados = pontosDeManaUtilizados;
    }

    public int getPoder() {
        return this.poderDaEscolaDeMagia
                + this.poderDoMago
                + this.pontosDeManaUtilizados;
    }
}
