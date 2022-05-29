public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int conta;
    protected double saldo = 0;
    protected Cliente cliente;

    public Conta( Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.conta = SEQUENCIAL++;
        this.cliente = cliente;
    }


    @Override
    public void sacar(double valor) {
        if(saldo == 0 && valor > saldo){
            System.out.println("Saldo insuficiente");
        }else {
            saldo-=valor;
        }

    }

    @Override
    public void depositar(double valor) {
        saldo+=valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(saldo == 0 && valor > saldo){
            System.out.println("Saldo insuficiente");
        }else {
            this.sacar(valor);
            contaDestino.depositar(valor);
        }
    }
    @Override
    public void aumentoMensal(double perc){
        saldo = saldo * ((perc/100)+1);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getConta() {
        return conta;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s",this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d",this.agencia));
        System.out.println(String.format("Conta: %d",this.conta));
        System.out.println(String.format("Saldo: %.2f",this.saldo));
    }
}
