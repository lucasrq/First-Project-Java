import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um numero:\n");

        int Escolha = scanner.nextInt();


        System.out.println("Ola voce escolheu a Opção " + Escolha);
        scanner.close();
    }
}
