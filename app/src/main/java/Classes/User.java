package Classes;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.util.Date;

/**
 * Classe para armazenar e tratar dados do usuário, como autenticação,
 * será usado Google Authentication, porém o usuário também poderá criar sua conta.
 */

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "nome")
    private String nome;
    @ColumnInfo(name = "dataNascimento")
    @TypeConverters({DateConverter.class})
    private Date dataNascimento;
    @ColumnInfo(name = "peso")
    private double peso;
    @ColumnInfo(name = "altura")
    private double altura;

//    public User() { O Room pode emitir erro ao usar multiplos construtores, pode ser usada
//    a annotation @Ignore para resolver o problema.
//    }

    public User(int id, String nome, Date dataNascimento, double peso, double altura) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.peso = peso;
        this.altura = altura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
