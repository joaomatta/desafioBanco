public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 01;
    private static int SEQUENCIAL = 1;

    protected int agencia ;
    protected int conta;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente){
        this.agencia = Conta.AGENCIA_PADRAO;
        this.conta = SEQUENCIAL++;
        this.cliente = cliente;
    }


    @Override
    public void sacar(double valor) {
        if(valor <= saldo){
            saldo -= valor;
        }else{
            System.out.println("Valor a ser sacado acima do saldo");
        }  
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(IConta contaDestino, double valor) {
        if(valor <= saldo){
            this.sacar(valor);
            contaDestino.depositar(valor);
        }else{
            System.out.println("Valor a ser transferido acima do saldo");
        }     
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
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.conta));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
