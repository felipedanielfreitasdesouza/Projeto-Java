import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Gerenciador gerenciador = new Gerenciador();
        Scanner scan = new Scanner(System.in);
        int selection;
        
        do{
            System.out.println("---------MENU---------");
            System.out.println("1 » Gerenciamento");
            System.out.println("2 » Sair\n");

            selection = scan.nextInt();

            switch (selection) {
                case 1:
                gerenciador.iniciarGerenciamento();
                    break;

                case 2:
                    System.out.println("Finalizando menu...");
                    break;

                default:
                    System.out.println("Número inválido!\nEscolha uma opção do menu.\n");
                    break;

            }
        } while (selection != 2);
        scan.close();
    }
}
