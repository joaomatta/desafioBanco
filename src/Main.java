public class Main {
    public static void main(String[] args) {
       Cliente joao = new Cliente();
       joao.setNome("Joao");

       Conta cc = new ContaCorrente(joao);
       Conta poupanca = new ContaPoupanca(joao); 

       cc.depositar(130);
       cc.transferir(poupanca, 140);
       cc.imprimirExtrato();
       poupanca.imprimirExtrato();
    }

}
