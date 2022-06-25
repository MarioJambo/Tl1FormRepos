package mz.ac.isutc.i33.tl1;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private String nome;
    private String apelido;
    private String provincia;
    private String sexo;
    private String deficiencia;
    private  int idade;
    double altura , peso;

    public Pessoa(String nome, String apelido, String provincia, String sexo, String deficiencia, int idade, double altura, double peso) {
        this.nome = nome;
        this.apelido = apelido;
        this.provincia = provincia;
        this.sexo = sexo;
        this.deficiencia = deficiencia;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(String deficiencia) {
        this.deficiencia = deficiencia;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }



    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", apelido='" + apelido + '\'' +
                ", provincia='" + provincia + '\'' +
                ", sexo='" + sexo + '\'' +
                ", deficiencia='" + deficiencia + '\'' +
                ", idade=" + idade +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }
}
