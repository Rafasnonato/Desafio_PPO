import Utilitarios.Utils;

public class ContaCorrente extends Conta{

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public int getConta() {
        return super.getConta();
    }

    @Override
    public void setConta(int conta) {
        super.setConta(conta);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("--- Extrato conta Corrente ---");
        System.out.println(toString());
        System.out.println("Saldo: " + Utils.doubleToString(this.getSaldo()));
    }

    public String toString() {
        return "\nBanco: " + this.agencia+
                "\nConta: " + this.conta +
                "\nConta Corrente" +
                "\nNome: " + this.cliente.getNome()+
                "\nCPF: "+ this.cliente.getCpf()+
                "\nEmail: "+ this.cliente.getEmail();
    }

}
