package Parte2;

public class TCP extends Pacote {
    private static int nextSeq = 100;
    private int seqNumber;
    private String mensagem;

    public TCP(String source, String destination, String mensagem) {
        super(source, destination);
        if (mensagem.length() > 1460) {
            throw new IllegalArgumentException("Mensagem TCP excede 1460 caracteres");
        }
        this.mensagem = mensagem;
        this.seqNumber = nextSeq++;
    }

    public int getSeqNumber() {
        return seqNumber;
    }

    @Override
    public String getDescricao() {
        return String.format("TCP (source:%s, destination:%s, seq:%d) msg: [%s]", 
                              source, destination, seqNumber, mensagem);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TCP)) return false;
        TCP other = (TCP) obj;
        return this.source.equals(other.source) &&
               this.destination.equals(other.destination) &&
               this.seqNumber == other.seqNumber;
    }

    @Override
    public int hashCode() {
        return source.hashCode() + destination.hashCode() + seqNumber;
    }

    public String getMensagem() {
        return mensagem;
    }    
}
