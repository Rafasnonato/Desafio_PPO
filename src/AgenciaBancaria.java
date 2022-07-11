import java.util.ArrayList;
import java.util.Scanner;


public class AgenciaBancaria {

    static ArrayList<Conta> contasBancarias = new ArrayList<Conta>();
    static Scanner teclado = new Scanner(System.in);

    public static void operacoes(){
        System.out.println("\n---------- Bem vindos a nossa Agência Bancária ----------");
        System.out.println("---------------------------------------------------------");
        System.out.println("--------------- Selecione a opção desejada --------------");
        System.out.println("---------------------------------------------------------");
        System.out.println("|  Opção 01 - Criar conta   |");
        System.out.println("|  Opção 02 - Depositar     |");
        System.out.println("|  Opção 03 - Sacar         |");
        System.out.println("|  Opção 04 - Transferir    |");
        System.out.println("|  Opção 05 - Ver Saldo     |");
        System.out.println("|  Opção 06 - Listar        |");
        System.out.println("|  Opção 07 - Sair          |");
        int operacao = teclado.nextInt();

        switch (operacao){
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir ();
                break;
            case 5:
                imprimirExtrato();
                break;
            case 6:
                listarContas();
                break;
            case 7:
                System.out.println("Obrigado por visitar nossa agência!");
                System.exit(0);

            default:
                System.out.println("Opção invalida, tente novamente!");
                operacoes();
                break;
        }

    }

    public static void criarConta(){
        String nome,cpf,email;
        int senha,opcao;
        System.out.println("Nome:");
        nome=teclado.next();

        System.out.println("CPF:");
        cpf=teclado.next();

        System.out.println("email:");
        email=teclado.next();

        System.out.println("senha:");
        senha=teclado.nextInt();

        Cliente cliente = new Cliente(nome,cpf,email,senha);

        System.out.println("Qual tipo de conta você quer criar? (1) Corrente (2) Poupanca");
        opcao= teclado.nextInt();
        while (opcao<1||opcao>2){
            System.out.println("Opção invalida, digite novamente");
            opcao= teclado.nextInt();
        }
        if (opcao==1) {
            ContaCorrente conta = new ContaCorrente(cliente);
            contasBancarias.add(conta);
            System.out.println("Sua conta corrente foi criada com sucesso!");
        }else {
            ContaPoupanca conta = new ContaPoupanca(cliente);
            contasBancarias.add(conta);
            System.out.println("Sua conta Poupanca foi criada com sucesso!");
        }

        /*Conta conta = new Conta(cliente);
        contasBancarias.add(conta);
        System.out.println("Sua conta foi criada com sucesso!");*/
        operacoes();
    }

    private static Conta encontrarConta (int numeroConta){
        Conta conta = null;
        if (contasBancarias.size()>0){
            for (Conta c : contasBancarias){
                if(c.getConta()== numeroConta){
                    conta = c;
                }
            }
        }return conta;
    }

    public static void depositar(){
        System.out.println("Número da conta: ");
        int numeroConta = teclado.nextInt();
        Conta conta = encontrarConta(numeroConta);
        if(conta != null){
            System.out.println("Digite a senha");
            int senha = teclado.nextInt();
            while (senha!=conta.cliente.getSenha()) {
                System.out.println("Senha incorreta!Deseja digitar novamente? " +
                        "(1) Sim e (2)Não");
                int resposta = teclado.nextInt();
                if (resposta != 1) {
                    operacoes();
                } else {
                    System.out.println("Digite a Senha novamente: ");
                    senha = teclado.nextInt();
                }
            }
            System.out.println("Qual valor que deseja depositar? ");
            double valorDeposito = teclado.nextDouble();
            conta.depositar(valorDeposito);

        }else System.out.println("Conta não foi encontrada!");

        operacoes();
    }

    public static void sacar(){
        System.out.println("Número da conta: ");
        int numeroConta = teclado.nextInt();
        Conta conta = encontrarConta(numeroConta);
        if(conta != null){
            System.out.println("Digite a senha");
            int senha = teclado.nextInt();
            while (senha!=conta.cliente.getSenha()) {
                System.out.println("Senha incorreta!Deseja digitar novamente? " +
                        "(1) Sim e (2)Não");
                int resposta = teclado.nextInt();
                if (resposta != 1) {
                    operacoes();
                } else {
                    System.out.println("Digite a Senha novamente: ");
                    senha = teclado.nextInt();
                }
            }
            System.out.println("Qual valor que deseja sacar? ");
            double valorSaque = teclado.nextDouble();
            conta.sacar(valorSaque);

        }else System.out.println("Conta não foi encontrada!");

        operacoes();
    }

    public static void transferir(){
        System.out.println("Número da conta do remetente: ");
        int numeroContaRemetente = teclado.nextInt();
        Conta contaRemetente = encontrarConta(numeroContaRemetente);
        if(contaRemetente != null){
            System.out.println("Número da conta do destinatário: ");
            int numeroContaDestinatario = teclado.nextInt();
            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
            if(contaDestinatario != null){
                System.out.println("Digite a senha");
                int senha = teclado.nextInt();
                while (senha!=contaRemetente.cliente.getSenha()){
                    System.out.println("Senha incorreta!Deseja digitar novamente? " +
                            "(1) Sim e (2)Não");
                    int resposta = teclado.nextInt();
                    if (resposta!=1){
                        operacoes();
                    }else {
                        System.out.println("Digite a Senha novamente: ");
                        senha=teclado.nextInt();
                    }

                }
                System.out.println("Digite o valor que deseja transferir? ");
                double valorTransferencia = teclado.nextDouble();
                contaRemetente.transferir(contaDestinatario,valorTransferencia);

            }else System.out.println("Conta não foi encontrada!");
        }else System.out.println("Conta não foi encontrada!");
        operacoes();
    }

    public static void imprimirExtrato(){
        System.out.println("Número da conta: ");
        int numeroConta = teclado.nextInt();
        Conta conta = encontrarConta(numeroConta);
        if(conta != null){
            System.out.println("Digite a senha");
            int senha = teclado.nextInt();
            while (senha!=conta.cliente.getSenha()) {
                System.out.println("Senha incorreta!Deseja digitar novamente? " +
                        "(1) Sim e (2)Não");
                int resposta = teclado.nextInt();
                if (resposta != 1) {
                    operacoes();
                } else {
                    System.out.println("Digite a Senha novamente: ");
                    senha = teclado.nextInt();
                }
            }
            conta.imprimirExtrato();
        } else System.out.println("Conta não foi encontrada!");

        operacoes();
    }

    public static void listarContas(){
        if (contasBancarias.size() > 0){
            for (Conta conta: contasBancarias){
                System.out.println(conta);
            }
        }else System.out.println("Não há contas cadastradas");
        operacoes();
   }

}
