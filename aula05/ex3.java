package aula05;

import java.util.ArrayList;
import java.util.List;

class DataYMD {
    private int dia, mes, ano;

    public DataYMD(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public String toString() {
        return ano + "-" + String.format("%02d", mes) + "-" + String.format("%02d", dia);
    }
}

class Imovel {
    private static int proximoId = 1000;
    private int id;
    private String localizacao;
    private int quartos;
    private double preco;
    private boolean disponivel;
    private DataYMD inicioLeilao;
    private DataYMD fimLeilao;

    public Imovel(String localizacao, int quartos, double preco) {
        this.id = proximoId++;
        this.localizacao = localizacao;
        this.quartos = quartos;
        this.preco = preco;
        this.disponivel = true;
    }

    public int getId() {
        return id;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void vender() {
        if (disponivel) {
            disponivel = false;
            System.out.println("Imóvel " + id + " vendido.");
        } else {
            System.out.println("Imóvel " + id + " não está disponível.");
        }
    }

    public void definirLeilao(DataYMD inicio, int duracao) {
        if (!disponivel) {
            System.out.println("Imóvel " + id + " não está disponível para leilão.");
            return;
        }
        this.inicioLeilao = inicio;
        this.fimLeilao = new DataYMD(inicio.getDia() + duracao - 1, inicio.getMes(), inicio.getAno());
    }

    public String getInformacoes() {
        String info = "Imóvel: " + id + "; quartos: " + quartos + "; localização: " + localizacao +
                      "; preço: " + preco + "; disponível: " + (disponivel ? "sim" : "não");

        if (inicioLeilao != null && fimLeilao != null) {
            info += "; leilão " + inicioLeilao + " : " + fimLeilao;
        }

        return info;
    }
}

class AgenciaImobiliaria {
    private List<Imovel> imoveis = new ArrayList<>();

    public void novoImovel(String localizacao, int quartos, double preco) {
        imoveis.add(new Imovel(localizacao, quartos, preco));
    }

    public Imovel procurarImovel(int id) {
        for (Imovel imovel : imoveis) {
            if (imovel.getId() == id) {
                return imovel;
            }
        }
        return null;
    }

    public void venderImovel(int id) {
        Imovel imovel = procurarImovel(id);
        if (imovel != null) {
            imovel.vender();
        } else {
            System.out.println("Imóvel " + id + " não existe.");
        }
    }

    public void definirLeilao(int id, DataYMD inicio, int duracao) {
        Imovel imovel = procurarImovel(id);
        if (imovel != null) {
            imovel.definirLeilao(inicio, duracao);
        } else {
            System.out.println("Imóvel " + id + " não existe.");
        }
    }

    public String toString() {
        String resultado = "Propriedades:\n";
        for (Imovel imovel : imoveis) {
            resultado += imovel.getInformacoes() + "\n";
        }
        return resultado;
    }
}

public class ex3 {
    public static void main(String[] args) {
        AgenciaImobiliaria imobiliaria = new AgenciaImobiliaria();
        imobiliaria.novoImovel("Glória", 2, 30000);
        imobiliaria.novoImovel("Vera Cruz", 1, 25000);
        imobiliaria.novoImovel("Santa Joana", 3, 32000);
        imobiliaria.novoImovel("Aradas", 2, 24000);
        imobiliaria.novoImovel("São Bernardo", 2, 20000);

        imobiliaria.venderImovel(1001);
        imobiliaria.definirLeilao(1002, new DataYMD(21, 3, 2023), 4);
        imobiliaria.definirLeilao(1003, new DataYMD(1, 4, 2023), 3);
        imobiliaria.definirLeilao(1001, new DataYMD(1, 4, 2023), 4);
        imobiliaria.definirLeilao(1010, new DataYMD(1, 4, 2023), 4);

        System.out.println(imobiliaria);
    }
}
