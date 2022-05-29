public class Main {
    public static void main(String[] args) {
        Cliente rafael = new Cliente();
        rafael.setNome( " Rafael ");

        Conta cc = new ContaCorrente(rafael);
        Conta poupanca = new ContaPoupanca(rafael);

        cc.depositar(100);
        cc.transferir(50,poupanca);
        poupanca.transferir(2.5,cc);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        Cliente jose = new Cliente();
        jose.setNome( " jose ");

        Conta cc1 = new ContaCorrente(jose);
        Conta poupanca1 = new ContaPoupanca(jose);

        cc1.depositar(100);
        cc1.transferir(50,poupanca1);
        poupanca1.transferir(2.5,cc1);

        cc1.imprimirExtrato();
        poupanca1.imprimirExtrato();

    }
}
