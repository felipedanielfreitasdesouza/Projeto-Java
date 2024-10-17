import java.util.ArrayList;
import java.util.Scanner;

public class Gerenciador {
    ArrayList<Estoque> estoques = new ArrayList<>();
    ArrayList<Pedido> pedidos = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public void iniciarGerenciamento() {
        int escolha;
        do {
            System.out.println("Bem-vindo ao Sistema de gerenciamento!\nEscolha uma operação:\n1 - Gerenciamento de estoque\n2 - Gerenciamento de pedido\n3 - Gerenciamento de cliente\n4 - Sair");
            escolha = scan.nextInt();
            scan.nextLine(); // Consumir a nova linha

            switch (escolha) {
                case 1:
                    gerenciamentoEstoque();
                    break;
                case 2:
                    gerenciamentoPedido();
                    break;
                case 3:
                    gerenciamentoCliente();
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (escolha != 4);
    }

    
    public void gerenciamentoEstoque() {
        int operacao;
        do {
            System.out.println("Escolha uma operação:\n1 - Criar estoque\n2 - Selecionar estoque\n3 - Listar estoques\n4 - Voltar");
            operacao = scan.nextInt();
            scan.nextLine();

            switch (operacao) {
                case 1:
                    Estoque novoEstoque = new Estoque();
                    estoques.add(novoEstoque);
                    System.out.println("Estoque criado com sucesso!");
                    break;
                case 2:
                    if (estoques.size() > 0) { //Checa se há algum estoque criado
                        System.out.println("Escolha um estoque pelo número:");
                        for (int i = 0; i < estoques.size(); i++) {
                            System.out.println((i + 1) + " - Estoque " + (i + 1));
                        }
                        int estoqueIndice = scan.nextInt() - 1;
                        if (estoqueIndice >= 0 && estoqueIndice < estoques.size()) {
                            Estoque estoqueSelecionado = estoques.get(estoqueIndice);
                            operarEstoque(estoqueSelecionado);
                        } else {
                            System.out.println("Estoque inválido.");
                        }
                    } else {
                        System.out.println("Nenhum estoque disponível.");
                    }
                    break;
                case 3:
                    listarEstoques();
                    //Lista todos os estoques existe no arrayList
                    break;
                case 4:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Operação inválida! Tente novamente.");
            }
        } while (operacao != 4);
    }

    //Método para fazer as diversas operações com estoque
    public void operarEstoque(Estoque estoque) {
        int operacao;
        do {
            System.out.println("Escolha uma operação:\n1 - Criar um item no estoque\n2 - Remover quantidade estoque\n3 - Deletar item do estoque\n4 - Listar estoque\n5 - Adicionar quantidade ao estoque\n6 - Voltar");
            operacao = scan.nextInt();
            scan.nextLine(); // Consumir a nova linha

            switch (operacao) {
                case 1:
                    estoque.addEstoque();
                    break;
                case 2:
                    estoque.removerEstoque();
                    break;
                case 3:
                    estoque.deletarItemEstoque();
                    break;
                case 4:
                    estoque.listarEstoque();
                    break;
                case 5:
                    estoque.modificarEstoque();
                    break;
                case 6:
                    System.out.println("Voltando ao gerenciamento de estoques...");
                    break;
                default:
                    System.out.println("Operação inválida! Tente novamente.");
            }
        } while (operacao != 6);
    }

    public void listarEstoques() {
        if (estoques.size() > 0) {
            for (int i = 0; i < estoques.size(); i++) {
                System.out.println("Estoque " + (i + 1));
                estoques.get(i).listarEstoque();
            }
        } else {
            System.out.println("Nenhum estoque disponível.");
        }
    }


    public void gerenciamentoPedido() {
        int operacao;
        do {
            System.out.println("Escolha uma operação:\n1 - Criar pedido\n2 - Remover pedido\n3 - Calcular total do pedido\n4 - Realizar pagamento\n5 - Confirmar pedido\n6 - Listar pedidos\n7 - Voltar");
            operacao = scan.nextInt();
            scan.nextLine(); // Consumir a nova linha

            switch (operacao) {
                case 1:
                    if (estoques.size() > 0) {
                        System.out.println("Escolha um estoque para o pedido pelo número:");
                        for (int i = 0; i < estoques.size(); i++) {
                            System.out.println((i + 1) + " - Estoque " + (i + 1));
                        }
                        int estoqueIndice = scan.nextInt() - 1;
                        if (estoqueIndice >= 0 && estoqueIndice < estoques.size()) {
                            Estoque estoqueSelecionado = estoques.get(estoqueIndice);
                            Pedido pedido = new Pedido("Pendente", null, null, estoqueSelecionado, false);
                            pedido.criarPedido();
                            pedidos.add(pedido);
                        } else {
                            System.out.println("Estoque inválido.");
                        }
                    } else {
                        System.out.println("Nenhum estoque disponível.");
                    }
                    break;
                case 2:
                    if (pedidos.size() > 0) {
                        System.out.println("Escolha um pedido para remover pelo número:");
                        for (int i = 0; i < pedidos.size(); i++) {
                            System.out.println((i + 1) + " - Pedido " + (i + 1));
                        }
                        int pedidoIndice = scan.nextInt() - 1;
                        if (pedidoIndice >= 0 && pedidoIndice < pedidos.size()) {
                            Pedido pedido = pedidos.get(pedidoIndice);
                            pedido.removerPedido();
                            pedidos.remove(pedidoIndice);
                        } else {
                            System.out.println("Pedido inválido.");
                        }
                    } else {
                        System.out.println("Nenhum pedido encontrado.");
                    }
                    break;
                case 3:
                    if (pedidos.size() > 0) {
                        System.out.println("Escolha um pedido para calcular o total pelo número:");
                        for (int i = 0; i < pedidos.size(); i++) {
                            System.out.println((i + 1) + " - Pedido " + (i + 1));
                        }
                        int pedidoIndice = scan.nextInt() - 1;
                        if (pedidoIndice >= 0 && pedidoIndice < pedidos.size()) {
                            Pedido pedido = pedidos.get(pedidoIndice);
                            pedido.calcularPedido();
                        } else {
                            System.out.println("Pedido inválido.");
                        }
                    } else {
                        System.out.println("Nenhum pedido encontrado.");
                    }
                    break;
                case 4:
                    if (pedidos.size() > 0) {
                        System.out.println("Escolha um pedido para realizar pagamento pelo número:");
                        for (int i = 0; i < pedidos.size(); i++) {
                            System.out.println((i + 1) + " - Pedido " + (i + 1));
                        }
                        int pedidoIndice = scan.nextInt() - 1;
                        if (pedidoIndice >= 0 && pedidoIndice < pedidos.size()) {
                            Pedido pedido = pedidos.get(pedidoIndice);
                            pedido.realizarPagamento();
                        } else {
                            System.out.println("Pedido inválido.");
                        }
                    } else {
                        System.out.println("Nenhum pedido encontrado.");
                    }
                    break;
                case 5:
                    if (pedidos.size() > 0) {
                        System.out.println("Escolha um pedido para confirmar pelo número:");
                        for (int i = 0; i < pedidos.size(); i++) {
                            System.out.println((i + 1) + " - Pedido " + (i + 1));
                        }
                        int pedidoIndice = scan.nextInt() - 1;
                        if (pedidoIndice >= 0 && pedidoIndice < pedidos.size()) {
                            Pedido pedido = pedidos.get(pedidoIndice);
                            pedido.confirmarPedido();
                        } else {
                            System.out.println("Pedido inválido.");
                        }
                    } else {
                        System.out.println("Nenhum pedido encontrado.");
                    }
                    break;
                case 6:
                    if (pedidos.size() > 0) {
                        for (Pedido p : pedidos) {
                            p.listarPedido();
                        }
                    } else {
                        System.out.println("Nenhum pedido encontrado.");
                    }
                    break;
                case 7:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Operação inválida! Tente novamente.");
            }
        } while (operacao != 7);
    }


    public void gerenciamentoCliente() {
        int operacao;
        do {
            System.out.println("Escolha uma operação:\n1 - Adicionar cliente\n2 - Listar clientes\n3 - Adicionar pedido a cliente\n4 - Voltar");
            operacao = scan.nextInt();
            scan.nextLine(); // Consumir a nova linha

            switch (operacao) {
                case 1:
                    Cliente novoCliente = new Cliente();
                    novoCliente.criarCliente();
                    clientes.add(novoCliente);
                    System.out.println("Cliente adicionado com sucesso!");
                    break;
                case 2:
                    if (clientes.size() > 0) {
                        for (Cliente c : clientes) {
                            c.listarClientes();
                        }
                    } else {
                        System.out.println("Nenhum cliente encontrado.");
                    }
                    break;
                case 3:
                    if (clientes.size() > 0 && pedidos.size() > 0) {
                        System.out.println("Escolha um cliente pelo número:");
                        for (int i = 0; i < clientes.size(); i++) {
                            System.out.println((i + 1) + " - Cliente " + (i + 1));
                        }
                        int clienteIndice = scan.nextInt() - 1;
                        if (clienteIndice >= 0 && clienteIndice < clientes.size()) {
                            Cliente cliente = clientes.get(clienteIndice);
                            System.out.println("Escolha um pedido pelo número:");
                            for (int i = 0; i < pedidos.size(); i++) {
                                System.out.println((i + 1) + " - Pedido " + (i + 1));
                            }
                            int pedidoIndice = scan.nextInt() - 1;
                            if (pedidoIndice >= 0 && pedidoIndice < pedidos.size()) {
                                Pedido pedidoSelecionado = pedidos.get(pedidoIndice);
                                cliente.getHistPedidos().add(pedidoSelecionado);
                                System.out.println("Pedido adicionado ao cliente com sucesso!");
                            } else {
                                System.out.println("Pedido inválido.");
                            }
                        } else {
                            System.out.println("Cliente inválido.");
                        }
                    } else {
                        System.out.println("Nenhum cliente ou pedido encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Operação inválida! Tente novamente.");
            }
        } while (operacao != 4);
    }

}
