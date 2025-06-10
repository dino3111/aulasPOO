package Parte2;

public class UDP extends Pacote {
    private String mensagem;

    public UDP(String source, String destination, String mensagem) {
        super(source, destination);
        if (mensagem.length() > 1480) {
            throw new IllegalArgumentException("Mensagem UDP excede 1480 caracteres");
        }
        this.mensagem = mensagem;
    }

    @Override
    public String getDescricao() {
        return String.format("UDP (source:%s, destination:%s) msg: [%s]", 
                              source, destination, mensagem);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UDP)) return false;
        UDP other = (UDP) obj;
        return this.source.equals(other.source) &&
               this.destination.equals(other.destination) &&
               this.mensagem.equals(other.mensagem);
    }

    @Override
    public int hashCode() {
        return source.hashCode() + destination.hashCode() + mensagem.hashCode();
    }

    public String getMensagem() {
        return mensagem;
    }    
}
