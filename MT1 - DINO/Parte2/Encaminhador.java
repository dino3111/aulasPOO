    package Parte2;

    import java.util.LinkedList;
    import java.util.List;

    public class Encaminhador {
        private String nome;
        private List<Pacote> fila;
        private Pacote ultimoEnviado;

        public Encaminhador(String nome) {
            this.nome = nome;
            this.fila = new LinkedList<>();
        }

        public void addPacote(Pacote p) {
            if (p instanceof UDP && fila.contains(p)) {
                System.out.println("(pacote duplicado)");
            }
            fila.add(p);
        }
        
        

        public void removePacote(Pacote p) {
            fila.remove(p);
        }

        public void enviarPacote() {
            if (!hasPacotes()) return;
        
            Pacote proximo = fila.get(0);
        
            if (proximo.equals(ultimoEnviado)) {
                fila.remove(0); 
                return;
            }
        
            System.out.println(proximo.getDescricao());
            fila.remove(0);
            ultimoEnviado = proximo;
        }
        

        public boolean hasPacotes() {
            return !fila.isEmpty();
        }

        public int getTamanhoFila() {
            int total = 0;
            for (Pacote p : fila) {
                if (p instanceof TCP) {
                    total += ((TCP) p).getMensagem().length();
                } else if (p instanceof UDP) {
                    total += ((UDP) p).getMensagem().length();
                }
            }
            return total;
        }

        @Override
        public String toString() {
            return String.format("Encaminhador %s está UP, tamanhoFila=%d", nome, getTamanhoFila());
        }
    }
