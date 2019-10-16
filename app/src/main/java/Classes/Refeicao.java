package Classes;

public enum Refeicao {
    CAFE_DA_MANHA(1), LANCHE_DA_MANHA(2), ALMOCO(3),
    LANCHE_DA_TARDE(4), JANTAR(5), CEIA(6);

    private final int valor;

    Refeicao(int valorOpcao){
        valor = valorOpcao;
    }

    public int getValor(){
        return valor;
    }
}
