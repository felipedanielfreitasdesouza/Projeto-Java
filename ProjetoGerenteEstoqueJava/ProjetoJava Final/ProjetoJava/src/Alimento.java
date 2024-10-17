public class Alimento extends Produto{
    private String validade;
    private int gramas;
    public Alimento(double preço, String nome, String descrição, int quantidadeEstoque, String validade, int gramas) {
        super(preço, nome, descrição, quantidadeEstoque);
        this.validade = validade;
        this.gramas = gramas;
    }
    @Override
    public String toString() {
        return super.toString() + "Alimento [validade=" + validade + ", gramas=" + gramas + "]";
    }
    

    
}
