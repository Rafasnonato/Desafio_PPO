import Utilitarios.Utils;

public class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int conta;
    protected double saldo = 0d;
    protected Cliente cliente;

    public Conta( Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.conta = SEQUENCIAL;
        this.cliente = cliente;
        SEQUENCIAL +=1;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void depositar(double valor) {
        if (valor>0) {
            saldo+=valor;
            System.out.println("Seu depósito foi realizado com sucesso!");
        } else System.out.println("Não foi possivel realizar o depósito!");
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0){
            if(saldo == 0 || valor > saldo){
                System.out.println("Saldo insuficiente!");
            }else {
                saldo-=valor;
                System.out.println("Saque realizado com sucesso!");
            }
        }else System.out.println("Não foi possivel realizar o saque!");
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        if (valor>0) {
            if (saldo == 0 || valor > saldo) {
                System.out.println("Saldo insuficiente!");
            } else {
                saldo-=valor;
                contaDestino.saldo = contaDestino.getSaldo()+valor;
                System.out.println("Transferencia realizado com sucesso!");
            }
        }else System.out.println("Não foi possivel realizar a transferência!");
    }

    @Override
    public void imprimirExtrato() {
        System.out.println(toString());
    }

    public String toString() {
        return "\nBanco: " + this.agencia+
                "\nConta: " + this.conta +
                "\nNome: " + this.cliente.getNome()+
                "\nCPF: "+ this.cliente.getCpf()+
                "\nEmail: "+ this.cliente.getEmail()+
                "\nSaldo: " + Utils.doubleToString(this.getSaldo())+
                "\n";
    }
}
