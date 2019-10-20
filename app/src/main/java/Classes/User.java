package Classes;

/**Classe para armazenar e tratar dados do usuário, como autenticação,
 * será usado Google Authentication, porém o usuário também poderá criar sua conta.
 */

public class User {


    private String nome;
    private String email;
    private int dataNascimento;
    private double peso;
    private double altura;

    public User() {

    }

    public User(String nome, String email, int dataNascimento, double peso, double altura) {
        this.nome = nome;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(int dataNascimento) {
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
