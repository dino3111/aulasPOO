package Parte2;

import java.util.regex.Pattern;

public abstract class Pacote {
    protected String source;
    protected String destination;

    private static final Pattern IP_PATTERN = Pattern.compile("((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)");

    public Pacote(String source, String destination) {
        if (!IP_PATTERN.matcher(source).matches() || !IP_PATTERN.matcher(destination).matches()) {
            throw new IllegalArgumentException("IP inválido");
        }
        this.source = source;
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public abstract String getDescricao();
}
