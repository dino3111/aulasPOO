package aula05b;

public class ContaBanco {
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    public void estadoAtual() {
        System.out.println("===========================");
        System.out.println("\nConta: " + this.getNumConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status: " + this.getStatus());
    }

    public void abrirConta(String t){
        this.setTipo(t);
        this.setStatus(true);
        if (t == "CC") {
            this.setSaldo(50);
        } else if(t == "CP") {
            this.setSaldo(150);
        }
        System.out.println("Conta aberto com sucesso!");

    }

    public void fecharConta(){
        if (this.getSaldo() > 0) {
            System.out.println("Conta com Dinheiro, não pode ser fechada.");
        } else if (this.getSaldo() < 0) {
            System.out.println("Conta em débito, não pode ser fechada.");
        } else {
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso.");
        }

    }

    public void depositar(float v){
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() + v);
            System.out.println("Dinheiro depositado na conta de " + this.getDono() + "com sucesso.");
        } else {
            System.out.println("Impossível depositar em uma conta fechada.");
        }

    }
    public void sacar(float v){
        if(this.getStatus()) {
            if (this.getSaldo() >= v){
                this.setSaldo(this.getSaldo() - v);
                System.out.println("Dinheiro retirado com sucesso na conta de " + this.getDono() + "\nSaldo bancário:" + this.getSaldo());
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } else{
            System.out.println("Impossível retirar.");
        }

    }

    public void pagarMensal(){

        int v;

        if(this.getTipo() == "CC"){
            v = 12;
        } else if (this.getTipo() == "CP"){
            v = 20;
        } else{
            v = 0;
        }

        if(this.getStatus()){
            if(this.getSaldo() > v){
                this.setSaldo(this.getSaldo() - v);
                System.out.println("Mensalidade paga com sucesso por " + this.getDono());
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("Impossível Pagar.");
        }

    }

    public ContaBanco() {
        this.setSaldo(0);
        this.setStatus(false);
        
    }
    public int getNumConta() {
        return numConta;
    }
    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getDono() {
        return dono;
    }
    public void setDono(String dono) {
        this.dono = dono;
    }
    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }


}
