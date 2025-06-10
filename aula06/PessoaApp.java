package aula06;

import java.time.LocalDate;

public class PessoaApp {
    public static class DateYMD {
        private int day, month, year;

        public DateYMD(int day, int month, int year) {
            if (!valid(day, month, year))
                throw new IllegalArgumentException("Data inválida!");
            this.day = day;
            this.month = month;
            this.year = year;
        }

        public static boolean valid(int day, int month, int year) {
            if (year < 0 || month < 1 || month > 12)
                return false;
            int[] daysInMonth = { 31, (leapYear(year) ? 29 : 28), 31, 30, 31, 30,
                                31, 31, 30, 31, 30, 31 };
            return day >= 1 && day <= daysInMonth[month - 1];
        }

        public static boolean leapYear(int year) {
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        }

        public int getDay() { return day; }
        public int getMonth() { return month; }
        public int getYear() { return year; }

        @Override
        public String toString() {
            return String.format("%02d/%02d/%04d", day, month, year);
        }
    }

    public static class Pessoa {
        private String nome;
        private int cc;
        private DateYMD dataNasc;

        public Pessoa(String nome, int cc, DateYMD dataNasc) {
            if (nome == null || nome.trim().isEmpty()) {
                throw new IllegalArgumentException("Nome inválido!");
            }
            if (cc <= 0) {
                throw new IllegalArgumentException("Número do cartão do cidadão inválido!");
            }
            if (dataNasc == null) {
                throw new IllegalArgumentException("Data de nascimento inválida!");
            }

            this.nome = nome;
            this.cc = cc;
            this.dataNasc = dataNasc;
        }

        public String getNome() {
            return nome;
        }

        public int getCC() {
            return cc;
        }

        public DateYMD getDataNasc() {
            return dataNasc;
        }

        @Override
        public String toString() {
            return nome + "; CC: " + cc + "; Data de Nascimento: " + dataNasc;
        }
    }

    public static class Aluno extends Pessoa {
        private static int contadorNMec = 100;
        private int nMec;
        private DateYMD dataInsc;

        public Aluno(String nome, int cc, DateYMD dataNasc, DateYMD dataInsc) {
            super(nome, cc, dataNasc);
            this.nMec = contadorNMec++;
            this.dataInsc = dataInsc;
        }

        public Aluno(String nome, int cc, DateYMD dataNasc) {
            super(nome, cc, dataNasc);
            this.nMec = contadorNMec++;
            LocalDate hoje = LocalDate.now();
            this.dataInsc = new DateYMD(hoje.getDayOfMonth(), hoje.getMonthValue(), hoje.getYear());
        }

        public int getNMec() {
            return nMec;
        }

        public DateYMD getDataInsc() {
            return dataInsc;
        }

        @Override
        public String toString() {
            return super.toString() + "; NMec: " + nMec + "; Data de Inscrição: " + dataInsc;
        }
    }

    public static class Professor extends Pessoa {
        private String categoria;
        private String departamento;

        public Professor(String nome, int cc, DateYMD dataNasc, String categoria, String departamento) {
            super(nome, cc, dataNasc);
            this.categoria = categoria;
            this.departamento = departamento;
        }

        public String getCategoria() {
            return categoria;
        }

        public String getDepartamento() {
            return departamento;
        }

        @Override
        public String toString() {
            return super.toString() + "; Categoria: " + categoria + "; Departamento: " + departamento;
        }
    }

    public static class Bolseiro extends Aluno {
        private Professor orientador;
        private double bolsa;

        public Bolseiro(String nome, int cc, DateYMD dataNasc, Professor p1, double bolsa) {
            super(nome, cc, dataNasc);
            this.orientador = p1;
            this.bolsa = bolsa;
        }

        public Professor getOrientador() {
            return orientador;
        }

        public double getBolsa() {
            return bolsa;
        }

        public void setBolsa(double novaBolsa) {
            this.bolsa = novaBolsa;
        }

        @Override
        public String toString() {
            return super.toString() + "; Bolsa: " + bolsa + "; Orientador: " + orientador.getNome();
        }
    }
}
