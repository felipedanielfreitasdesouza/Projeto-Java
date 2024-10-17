public class Ferramenta extends Produto{
    private String tipo; //Eletrica ou manual

    public Ferramenta(double preço, String nome, String descrição, int quantidadeEstoque, String tipo) {
        super(preço, nome, descrição, quantidadeEstoque);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + "Ferramenta [tipo=" + tipo + "]";
    }
     
    
}