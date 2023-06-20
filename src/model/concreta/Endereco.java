package src.model.concreta;

public class Endereco {
    private String rua;
    private int numero;
    private long cep;

    public Endereco(String rua, int numero, long cep) {
        // TODO: Verificar exceções

        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
    }

    public void setRua(String rua) {
        // TODO: Verificar exceções

        this.rua = rua;
    }

    public void setNumero(int numero) {
        // TODO: Verificar exceções

        this.numero = numero;
    }

    public void setCep(long cep) {
        // TODO: Verificar exceções

        this.cep = cep;
    }

    public String getRua() {
        return this.rua;
    }

    public int getNumero() {
        return this.numero;
    }

    public long getCep() {
        return this.cep;
    }
}
