public class Brinquedo extends Produto{
    private String faixaEtaria;

    public Brinquedo(double preço, String nome, String descrição, int quantidadeEstoque, String faixaEtaria) {
        super(preço, nome, descrição, quantidadeEstoque);
        this.faixaEtaria = faixaEtaria;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    @Override
    public String toString() {
        return super.toString() + "Brinquedo [faixaEtaria=" + faixaEtaria + "]";
    }

    
}
