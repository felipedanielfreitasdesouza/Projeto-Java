import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Pedido {
    private ArrayList<Produto> itens = new ArrayList<>();
    private Estoque estoque;
    private String statusPedido;
    private String infoPagamento;
    private String entrega;
    private boolean statusPagamento;

    Scanner scan = new Scanner(System.in);

    public Pedido(String statusPedido, String infoPagamento, String entrega, Estoque estoque, boolean statusPagamento) {
        this.statusPedido = statusPedido;
        this.infoPagamento = infoPagamento;
        this.entrega = entrega;
        this.estoque = estoque;
        this.statusPagamento = statusPagamento;
    }

    public ArrayList<Produto> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Produto> itens) {
        this.itens = itens;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public String getInfoPagamento() {
        return infoPagamento;
    }

    public void setInfoPagamento(String infoPagamento) {
        this.infoPagamento = infoPagamento;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public void criarPedido() {
        System.out.println("Escolha um item para adicionar ao pedido:\n");
        int contador = 1;
        for (Produto p : estoque.getEstoque()) {
            System.out.println(contador + " - " + p.toString());
            contador += 1;
        }
        int add = scan.nextInt();
        scan.nextLine(); 

        if (add > 0 && add <= estoque.getEstoque().size()) {
            Produto produtoEscolhido = estoque.getEstoque().get(add - 1);
            if (produtoEscolhido.getQuantidadeEstoque() > 0) {
              
                itens.add(new Produto(produtoEscolhido.getPreço(), produtoEscolhido.getNome(), produtoEscolhido.getDescrição(), 1));
                produtoEscolhido.setQuantidadeEstoque(produtoEscolhido.getQuantidadeEstoque() - 1);
                System.out.println("Produto adicionado ao pedido!");
            } else {
                System.out.println("Produto fora de estoque!");
            }
        } else {
            System.out.println("Item não encontrado!");
        }
    }

    public void removerPedido() {
        System.out.println("Escolha um item para remover do pedido:\n");
        int contador = 1;
        for (Produto p : itens) {
            System.out.println(contador + " - " + p.toString());
            contador += 1;
        }
        int remover = scan.nextInt();
        scan.nextLine(); 

        Iterator<Produto> iterator = itens.iterator();
        contador = 1;  
        while (iterator.hasNext()) {
            Produto p = iterator.next();
            if (contador == remover) {
                iterator.remove();
                System.out.println("Produto deletado do pedido!");
                return;
            }
            contador++;
        }
        System.out.println("Item não encontrado!");
    }

    public void calcularPedido() {
        double total = 0;
        for (Produto p : itens) {
            total += p.getPreço();
        }
        System.out.println("O total do pedido é: " + total);
    }

    public void realizarPagamento() {
        System.out.println("Escolha uma forma de pagamento:\n1 - Cartão de crédito\n2 - Pix\n3 - Boleto");
        int escolha2 = scan.nextInt();
        scan.nextLine();
        switch (escolha2) {
            case 1:
                setInfoPagamento("Cartão de crédito");
                System.out.println("Pagamento será no cartão de crédito!");
                break;
            case 2:
                setInfoPagamento("Pix");
                System.out.println("Pagamento será no Pix!");
                break;
            case 3:
                setInfoPagamento("Boleto");
                System.out.println("Pagamento será no Boleto!");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    public void confirmarPedido() {
        System.out.println("Deseja confirmar o pedido?\n1 - Sim\n2 - Não");
        int escolha3 = scan.nextInt();
        scan.nextLine();

        switch (escolha3) {
            case 1:
                if (getInfoPagamento() == null) {
                    System.out.println("Favor escolher a forma de pagamento antes de confirmar o pedido!");
                } else if (itens.isEmpty()) {
                    System.out.println("Favor adicionar um produto para confirmar o pedido!");
                } else {
                    System.out.println("Pedido confirmado!");
                    setEntrega("A caminho");
                    setStatusPedido("Confirmado");
                    System.out.println("Itens do pedido:\n");
                    for (Produto p : itens) {
                        System.out.println(p.toString());
                    }
                    System.out.println(getEntrega() + "\n" + getInfoPagamento() + "\n" + getStatusPedido());
                }
                break;
            case 2:
                System.out.println("Pedido não confirmado!");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    public void listarPedido() {
        System.out.println(toString());
        for (Produto p : itens) {
            System.out.println(p.toString());
        }
    }

    @Override
    public String toString() {
        return "Pedido [statusPedido=" + statusPedido + ", infoPagamento=" + infoPagamento + ", entrega=" + entrega
                + ", statusPagamento=" + statusPagamento + "]";
    }
}
