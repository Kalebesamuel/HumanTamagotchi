package Classes;

import java.util.ArrayList;
import java.util.List;

/**Classe responsavel por armazenar a alimentação diária do usuário, informando os
 * alimentos que ele ingeriu na determinada refeicao;
 */

public class Alimentacao {

    private List<Alimentos> alimentacao;
    private Refeicao refeicao;

    public Alimentacao() {
        alimentacao = new ArrayList();
    }

    public Alimentacao(List<Alimentos> alimentacao, Refeicao refeicao) {
        this.alimentacao = alimentacao;
        this.refeicao = refeicao;
    }

    public List<Alimentos> getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(List<Alimentos> alimentacao) {
        this.alimentacao = alimentacao;
    }

    public Refeicao getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(Refeicao refeicao) {
        this.refeicao = refeicao;
    }
}
