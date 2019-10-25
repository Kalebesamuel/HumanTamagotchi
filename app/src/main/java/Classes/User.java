package Classes;

import java.sql.Date;

/**Classe para armazenar e tratar dados do usuário, como autenticação,
 * será usado Google Authentication, porém o usuário também poderá criar sua conta.
 */

public class User {


    private String nome;
    private Date dataNascimento;
    private double peso;
    private double altura;

    public User() {

    }

    public User(String nome, Date dataNascimento, double peso, double altura) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
