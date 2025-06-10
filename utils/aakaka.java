package utils;

---READ FILES---

public String load(String filepath){
        try {
            Scanner sc = new Scanner(new FileReader(filepath));
			
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] parts = line.split("[ \t]+");
                
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

---FILES---
	import java.util.io*;
	public void generateReport(String filename) throws IOException{
        File file = new File("src/Aula11/"+filename);

        FileWriter writer = new FileWriter(file);

        for (Integer key : map.keySet()) {
            writer.write("Id Cliente: "+key+" Leituras: "+map.get(key)+"\n");
        }

        writer.close();

    }
	
	
---SPLIT---
        String[] contact = line.split("[ \t]+"); #TABS E ESPAÇOS



---CONVERTER---
        int telemovel = Integer.parseInt(contact[2]);
		Double telemovel = Double.parseDouble(contact[2]);
		LocalDate data = LocalDate.parse(contact[4]);

---SORT---

        Map<String, Integer> totalvoos = new HashMap<String, Integer>();
		#Ordenar por nº de voos decrescente que é o value do Map
        totalvoos.entrySet().stream()
                            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                            .forEachOrdered(entry -> {String formattedEntry = String.format("%-20s %d", entry.getKey(), entry.getValue());
            

	  Map<String,String> sortedmap = new TreeMap<>(map);
        for (String key : sortedmap.keySet()) {
            System.out.println(key + " -> " + sortedmap.get(key));
        }


	-----
ArrayList<Movie> conjuntmovies = new ArrayList<>();
conjuntmovies.sort((m1, m2) -> m1.getName().compareTo(m2.getName()));

conjuntmovies.sort((m1, m2) -> Double.compare(m2.getScore(), m1.getScore())); #DECRESCENTE


----------

Map<String, Pessoa> map = new HashMap<>();
        map.put("p1", new Pessoa("Alice", 25));
        map.put("p2", new Pessoa("Bob", 30));
        map.put("p3", new Pessoa("Charlie", 20));

        // Converter o mapa em uma lista de entradas
        List<Map.Entry<String, Pessoa>> entryList = new ArrayList<>(map.entrySet());

        // Classificar a lista com base na idade das pessoas
        entryList.sort(Map.Entry.comparingByValue(Comparator.comparing(Pessoa::getIdade)));

        // Criar um novo mapa para armazenar os valores ordenados
        Map<String, Pessoa> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Pessoa> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        // Imprimir o mapa ordenado pela idade das pessoas
        System.out.println("Mapa ordenado pela idade das pessoas: " + sortedMap);


@Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Plane)) {
            return false;
        }
        Plane plane = (Plane) o;
        return Objects.equals(identificador, plane.identificador) && Objects.equals(fabricante, plane.fabricante) && Objects.equals(modelo, plane.modelo) && ano_producao == plane.ano_producao && máx_passageiros == plane.máx_passageiros && velocidade_máxima == plane.velocidade_máxima;
    }

@Override
    public int hashCode() {
        return Objects.hash(identificador, fabricante, modelo, ano_producao, máx_passageiros, velocidade_máxima);
    }
	

