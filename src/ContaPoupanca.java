import Utilitarios.Utils;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }
    public void imprimirExtrato() {
        System.out.println("--- Extrato conta Poupança ---");
        System.out.println(toString());
        System.out.println("Saldo: " + Utils.doubleToString(this.getSaldo()));
    }

    @Override
    public int getConta() {
        return super.getConta();
    }

    @Override
    public void setConta(int conta) {
        super.setConta(conta);
    }

    public String toString() {
        return "\nBanco: " + this.agencia+
                "\nConta: " + this.conta +
                "\nConta Poupança" +
                "\nNome: " + this.cliente.getNome()+
                "\nCPF: "+ this.cliente.getCpf()+
                "\nEmail: "+ this.cliente.getEmail();
    }

}
