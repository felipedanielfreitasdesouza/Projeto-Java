import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Estoque {

    private double preco;
    private String nome;
    private String descrição;
    private int quantidadeEstoque;
    private String faixaEtaria;
    private String tamanho;
    private String tipo; //Eletrica ou manual
    private String validade;
    private int gramas;
    int escolha;
    int escolha1;

    Scanner scan = new Scanner(System.in);
    private ArrayList<Produto> estoque = new ArrayList<>();

    public ArrayList<Produto> getEstoque() {
        return estoque;
    }

    public void setEstoque(ArrayList<Produto> estoque) {
        this.estoque = estoque;
    }

    public void addEstoque(){
        do{
            System.out.println("Escolha um item para adicionar ao estoque:\n1 - Adicionar Roupa\n2 - Adicionar Ferramenta\n3 - Adicionar Brinquedo\n4 - Adicionar Alimento");
            escolha = scan.nextInt();
            switch(escolha){
                case 1:
                System.out.println("Digite o modelo da peça: ");
                nome = scan.next();
        
                System.out.println("Digite o preço: ");
                preco = scan.nextDouble();
        
                System.out.println("Digite a descrição: ");
                descrição = scan.next();

                System.out.println("Digite o tamanho da peça: ");
                tamanho = scan.next();

                System.out.println("Digite a quantidade para adicionar ao estoque: ");
                quantidadeEstoque = scan.nextInt();
        
                Vestuario roupa = new Vestuario(preco, nome, descrição, quantidadeEstoque, tamanho);
                System.out.println("Roupa adicionada!");
                estoque.add(roupa);
                
                break;
                
                case 2:
                System.out.println("Digite o nome da ferramenta: ");
                nome = scan.next();
        
                System.out.println("Digite o preço: ");
                preco = scan.nextDouble();
        
                System.out.println("Digite a descrição: ");
                descrição = scan.next();

                
                do{
                System.out.println("A ferramenta é elétrica ou manual?\n1 - Elétrica\n2 - Manual");
                escolha1 = scan.nextInt();
                switch(escolha1){
                    case 1:
                        tipo = "Elétrica";
                        break;

                    case 2:
                        tipo = "Manual";
                        break;
                }
                }while(escolha <1 || escolha >2);

                System.out.println("Digite a quantidade para adicionar ao estoque: ");
                quantidadeEstoque = scan.nextInt();
        
                Ferramenta ferramenta = new Ferramenta(preco, nome, descrição, quantidadeEstoque, tipo);
                
                System.out.println("Ferramenta adicionada!");
                estoque.add(ferramenta);
                
                break;
                
                case 3:
                System.out.println("Digite o modelo da peça: ");
                nome = scan.next();
        
                System.out.println("Digite o preço: ");
                preco = scan.nextDouble();
        
                System.out.println("Digite a descrição: ");
                descrição = scan.next();

                System.out.println("Digite a Faixa Etária: ");
                faixaEtaria = scan.next();

                System.out.println("Digite a quantidade para adicionar ao estoque: ");
                quantidadeEstoque = scan.nextInt();
        
                Brinquedo brinquedo = new Brinquedo(preco, nome, descrição, quantidadeEstoque, faixaEtaria);

                System.out.println("Brinquedo adicionada!");
                estoque.add(brinquedo);
                
                
                break;

                case 4:
                System.out.println("Digite o nome do alimento: ");
                nome = scan.next();
        
                System.out.println("Digite o preço: ");
                preco = scan.nextDouble();
        
                System.out.println("Digite a descrição: ");
                descrição = scan.next();

                System.out.println("Digite a validade: ");
                validade = scan.next();

                System.out.println("Digite o peso em gramas: ");
                gramas = scan.nextInt();


                System.out.println("Digite a quantidade para adicionar ao estoque: ");
                quantidadeEstoque = scan.nextInt();
        
                Alimento alimento = new Alimento(preco, nome, descrição, quantidadeEstoque, validade, gramas);
                System.out.println("Alimento adicionado!");
                estoque.add(alimento);
                

                
                break;
            }
        }while(escolha < 1 || escolha > 4);

    }

   
public void removerEstoque() {
    System.out.println("Escolha um item para remover o estoque:\n");
    int contador = 1;
    for (Produto p : estoque) {
        System.out.println(contador + " - " + p.toString());
        contador += 1;
    }

    int remover = scan.nextInt();

    Iterator<Produto> iterator = estoque.iterator();
    contador = 1;  
    while (iterator.hasNext()) {
        Produto p = iterator.next();
        if (contador == remover) {
            System.out.println("Digite a quantidade para remover do estoque:\n");
            int remover1 = scan.nextInt();
            if (remover1 < p.getQuantidadeEstoque()) {
                p.setQuantidadeEstoque(p.getQuantidadeEstoque() - remover1);
                System.out.println("Estoque removido!");
            } else if (remover1 == p.getQuantidadeEstoque()) {
                iterator.remove();
                System.out.println("Todo o estoque removido! O produto foi deletado do estoque!");
            } else {
                System.out.println("Erro! Não pode remover uma quantidade maior do que há no estoque!");
            }
            return;
        }
        contador++;
    }
    System.out.println("Item não encontrado!");
}


public void deletarItemEstoque() {

    System.out.println("Escolha um item para deletar do estoque:\n");
    int contador = 1;
    for (Produto p : estoque) {
        System.out.println(contador + " - " + p.toString());
        contador += 1;
    }

    int remover = scan.nextInt();

    Iterator<Produto> iterator = estoque.iterator();
    contador = 1; 
    while (iterator.hasNext()) {
        Produto p = iterator.next();
        if (contador == remover) {
            iterator.remove();
            System.out.println("Produto deletado do estoque!");
            return;
        }
        contador++;
    }
    System.out.println("Item não encontrado!");
}

public void listarEstoque(){
    int contador = 1;
    for (Produto p : estoque) {
        System.out.println(contador + " - " + p.toString());
        contador += 1;
    }
}

public void modificarEstoque(){
    System.out.println("Escolha um item para modificar o estoque:\n");
    int contador = 1;
    for (Produto p : estoque) {
        System.out.println(contador + " - " + p.toString());
        contador += 1;
    }
    int att = scan.nextInt();

    Iterator<Produto> iterator = estoque.iterator();
    contador = 1; 
    while (iterator.hasNext()) {
        Produto p = iterator.next();
        if (contador == att) {
            System.out.println("Digite a quantidade para adicionar ao estoque:\n");
            int quantidadeAdd = scan.nextInt();
            p.setQuantidadeEstoque(p.getQuantidadeEstoque() + quantidadeAdd);
            return;
        }
        contador++;
    }
    System.out.println("Item não encontrado!");
}
}

    


