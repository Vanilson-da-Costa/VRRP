import java.util.Scanner;

public class SistemaEscolar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AlunoRepositorio repositorio = new AlunoRepositorio();

        while (true) {
            System.out.println("\n--- Sistema de Gestão Escolar ---");
            System.out.println("1. Cadastrar aluno");
            System.out.println("2. Listar alunos");
            System.out.println("3. Buscar aluno por matrícula");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do aluno: ");
                    String nome = scanner.nextLine();
                    System.out.print("Idade do aluno: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer
                    System.out.print("Matrícula: ");
                    String matricula = scanner.nextLine();

                    Aluno novoAluno = new Aluno(nome, idade, matricula);
                    repositorio.adicionarAluno(novoAluno);
                    System.out.println("Aluno cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("\nLista de Alunos:");
                    for (Aluno a : repositorio.listarAlunos()) {
                        System.out.println(a);
                    }
                    break;

                case 3:
                    System.out.print("Digite a matrícula: ");
                    String mat = scanner.nextLine();
                    Aluno encontrado = repositorio.buscarPorMatricula(mat);
                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
