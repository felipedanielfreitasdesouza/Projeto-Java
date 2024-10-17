import java.util.Scanner;
import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String endereco;
    private String telefone;
    private ArrayList<Pedido> histPedidos = new ArrayList<>();


    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Pedido> getHistPedidos() {
        return histPedidos;
    }

    public void setHistPedidos(ArrayList<Pedido> histPedidos) {
        this.histPedidos = histPedidos;
    }

    public void criarCliente(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o nome do cliente: ");
        setNome(scan.nextLine());
        System.out.print("Digite o endereço do cliente: ");
        setEndereco(scan.nextLine());
        System.out.print("Digite o telefone do cliente: ");
        setTelefone(scan.nextLine());

        
    }

    // Método para listar clientes e seus pedidos
    public void listarClientes() {
        System.out.println("Cliente [nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + "]");
        for (Pedido pedido : histPedidos) {
            pedido.listarPedido();
        }
    }

    
}


