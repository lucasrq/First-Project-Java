import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void LimparTerminal() {
        String sistema = System.getProperty("os.name").toLowerCase();
        try {
            if (sistema.contains("win")) {
                // Comando para Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Comando para sistemas Unix (Linux/Mac)
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int NewQuest() {
        System.out.print("Digite um numero:\n");
        System.out.println("1: Modo relaxar!");
        System.out.println("2: Modo Jogo!");
        System.out.println("3: Modo Estudos!");
        System.out.println("4: Modo Lazer!");
        return scanner.nextInt();

    }

    public static int Relaxar() {
        System.out.println("Voce escolheu o modo de relaxo!\n");
        System.out.println("Gostaria de tocar um Lo-Fi?\n");
        System.out.println("1: Sim");
        System.out.println("2: Não");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public static int EscolherPlataforma() {
        System.out.println("Deseja ouvir pelo Spotify ou Youtube?");
        System.out.println("1: Spotify");
        System.out.println("2: Youtube");
        int PlataformaEscolhida = scanner.nextInt();
        switch (PlataformaEscolhida) {
            case 1:
                System.out.println("Abrindo Spotify...");
                break;
            case 2:
                System.out.println("Abrindo YouTube...");
                break;
            default:
                System.out.println("Opção inválida.");
                return EscolherPlataforma(); // Repetir a escolha de plataforma se inválida
        }
        return PlataformaEscolhida;
    }

    public static void main(String[] args) {

        int Escolha = NewQuest();
        while (Escolha < 1 || Escolha > 4) { // Continua pedindo até uma escolha válida
            System.out.println("Sua escolha é inválida. Escolha novamente.");
            Escolha = NewQuest(); // Atualiza a escolha\
            LimparTerminal();
        }
        switch (Escolha) {
            case 1: // Modo relaxar
                int UsoDePlataforma = Relaxar();
                LimparTerminal();
                while (UsoDePlataforma != 1 && UsoDePlataforma != 2) { // Verifica se a opção é válida
                    System.out.println("Opção inválida. Tente novamente.");
                    UsoDePlataforma = Relaxar(); // Repetir a pergunta até ser válida
                }
                if (UsoDePlataforma == 1) {
                    LimparTerminal();
                    EscolherPlataforma();
                } else {
                    LimparTerminal();
                    System.out.println("Tudo bem, aproveite o modo Relaxar sem música!");
                }
                break;
            case 2: // Modo Jogo
                System.out.println("Você escolheu o Modo Jogo!");
                break;
            case 3: // Modo Estudos
                System.out.println("Você escolheu o Modo Estudos!");
                break;
            case 4: // Modo Lazer
                System.out.println("Você escolheu o Modo Lazer!");
                break;
        }
        scanner.close();
    }
}
