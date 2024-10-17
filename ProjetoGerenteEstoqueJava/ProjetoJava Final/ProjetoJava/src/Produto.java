public class Produto {
    private double preço;
    private String nome;
    private String descrição;
    private int quantidadeEstoque;
    //Superclasse Produto, da qual Brinquedo, Alimento, Vestuario e Ferramenta herdam

    
    public Produto(double preço, String nome, String descrição, int quantidadeEstoque) {
        this.preço = preço;
        this.nome = nome;
        this.descrição = descrição;
        this.quantidadeEstoque = quantidadeEstoque;
    }


    public double getPreço() {
        return preço;
    }


    public void setPreço(double preço) {
        this.preço = preço;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getDescrição() {
        return descrição;
    }


    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }


    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }


    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }


    @Override
    public String toString() {
        return "Produto [preço=" + preço + ", nome=" + nome + ", descrição=" + descrição + ", quantidadeEstoque="
                + quantidadeEstoque + "]";
    }

    
        
}
