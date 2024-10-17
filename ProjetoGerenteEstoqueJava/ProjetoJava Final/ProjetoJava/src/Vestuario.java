public class Vestuario extends Produto{
    private String tamanho;

    public Vestuario(double preço, String nome, String descrição, int quantidadeEstoque, String tamanho) {
        super(preço, nome, descrição, quantidadeEstoque);
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return super.toString() + "Vestuario [tamanho=" + tamanho + "]";
    }
    
    
    
}
