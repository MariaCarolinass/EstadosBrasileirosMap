package mapasjava;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
        
public class Municipio {
    
    private String estado;
    private String municipio;
    private String regiao;
    private Integer populacao;
    private String porte;
    private Boolean capital;

    public Municipio(String estado, String municipio, String regiao, 
            Integer populacao, String porte, Boolean capital) {
        this.estado = estado;
        this.municipio = municipio;
        this.regiao = regiao;
        this.populacao = populacao;
        this.porte = porte;
        this.capital = capital;
    }
    
    
    public static void pesquisarMunicipio(String estado, String municipio,
            Map <String, ArrayList<Municipio>> dados) {
        
        ArrayList<Municipio> lista = dados.get(estado);
        
        if (lista == null) {
            System.out.println("Estado não encontrado!");
            return;
        }
        
        for (Municipio muni: lista) {
            
            // informações do munícipio
            if (muni.getEstado().equals(estado) && muni.getMunicipio(
                    ).equals(municipio)) {
                
                System.out.println("- Estado: " + muni.getEstado());
                System.out.println("- Munícipio: " + muni.getMunicipio());
                System.out.println("- Região: " + muni.getRegiao());
                System.out.println("- População: " + muni.getPopulacao());
                System.out.println("- Porte: " + muni.getPorte());
                System.out.println("- Capital: " + muni.getCapitalString());
                return;
                
            }
            
        }
        
        System.out.println("Munícipio não encontrado!");
        
    }
    
    
    public static int calcularPopulacaoEstado(String estado,
            Map <String, ArrayList<Municipio>> dados) {
        
        ArrayList<Municipio> lista = dados.get(estado);
        
        Integer total = 0;
        
        // Soma o total da população do estado
        for (Municipio muni: lista) {
            total += muni.getPopulacao();
        } 
        
        System.out.println("- A população total de "+estado+" é de: "+total);
        return total;
        
    }
    
    
    public static void calcularPorteMunicipio(String estado, 
            Map <String, ArrayList<Municipio>> dados) {
        
        Map <String, Integer> porte = new HashMap<>();
        ArrayList<Municipio> lista = dados.get(estado);
        
        // Soma a quantidade total que cada munícipio tem de porte 
        for (Municipio muni: lista) {
            
            // Verifica se a lista é vazia
            if (!porte.containsKey(muni.getPorte())){
                porte.put(muni.getPorte(), 0);
            } 
            
            // Adiciona os valores no mapa e soma o total de porte
            porte.put(muni.getPorte(), porte.get(muni.getPorte()) + 1);
            
        }
        
        porte.entrySet().forEach(entry -> {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("- Porte "+key+" tem: "+value+" porte(s)");
        });
        
    }
    
    
    public static void calcularPopulacaoPorte(String estado, 
            Map <String, ArrayList<Municipio>> dados) {
        
        Map <String, int[]> porte = new HashMap<>();
        ArrayList<Municipio> lista = dados.get(estado);
        
        // Adiciona os dados do porte em um vetor no mapa
        for (Municipio muni: lista) {
            
            int vetorPorte [] = porte.get(muni.getPorte());
           
            // Se o vetor for nulo, será criado um vetor com duas posições
            if (vetorPorte == null){
                vetorPorte = new int[2];
                porte.put(muni.getPorte(), vetorPorte);
            } 
            
            // A posição 0 do vetor retorna o total da população de cada porte
            vetorPorte[0] += muni.getPopulacao();
            
            // A posição 1 do vetor soma a quantidade total de cada porte
            vetorPorte[1]++;        
            
        }
        
        porte.entrySet().forEach(entry -> {
            
            String key = entry.getKey();
            int[] value = entry.getValue();
            
            // Caso a posição 1 seja 0, atribuir o valor 1 
            if (value[1] == 0) {
                value[1] = 1;
            }
            
            // Calcula a média da população de cada porte
            Integer mediaPopulacao = value[0] / value[1];
            System.out.println("- A média da população com porte "+key+
                    " é de: "+mediaPopulacao);
        
        });
        
    }
    
    
    public static void retornarDadosPorteLista(String estado,
            Map <String, ArrayList<Municipio>> dados) {
        
        ArrayList<Municipio> lista = dados.get(estado);
        
        Integer pequenoI = 0;
        Integer pequenoII = 0;
        Integer medio = 0;
        Integer grande = 0;
        Integer metropole = 0;
        
        Integer contarPopulacaoPequenoI = 0;
        Integer contarPopulacaoPequenoII = 0;
        Integer contarPopulacaoMedio = 0;
        Integer contarPopulacaoGrande = 0;
        Integer contarPopulacaoMetropole = 0;
        
        // Soma a quantidade total de cada porte e de população por porte
        for (Municipio i: lista) {
        
            if ("Pequeno I".equals(i.getPorte())) {
                pequenoI++;
                contarPopulacaoPequenoI += i.getPopulacao();
            } 
            
            if ("Pequeno II".equals(i.getPorte())) {
                pequenoII++;
                contarPopulacaoPequenoII += i.getPopulacao();
            } 
            
            if ("Médio".equals(i.getPorte())) {
                medio++;
                contarPopulacaoMedio += i.getPopulacao();
            } 
            
            if ("Grande".equals(i.getPorte())) {
                grande++;
                contarPopulacaoGrande += i.getPopulacao();
            }
            
            if ("Metrópole".equals(i.getPorte())) {
                metropole++;
                contarPopulacaoMetropole += i.getPopulacao();
            }
            
            /*switch (i.getPorte()) {
                case "Pequeno I" -> pequenoI++;
                case "Pequeno II" -> pequenoII++;
                case "Médio" -> medio++;
                case "Grande" -> grande++;
                case "Metrópole" -> metropole++;
            }*/
            
        }

        System.out.println("- Porte pequeno I tem: "+pequenoI+" porte(s)");
        System.out.println("- Porte pequeno II tem: "+pequenoII+" porte(s)");
        System.out.println("- Porte médio tem: "+medio+" porte(s)");
        System.out.println("- Porte grande tem: "+grande+" porte(s)");
        System.out.println("- Porte metrópoles tem: "+metropole+" porte(s)");
        
        // Verifica se a quantidade total de cada porte é maior que 0
        // Se sim, é feito o calculo da média da população por porte
        // Se não, retorna a mensagem que o porte não teve média de população
        if (pequenoI > 0) {
            Integer mediaPequenoI = contarPopulacaoPequenoI / pequenoI;
            System.out.println("- A média da população com porte pequeno I é "
                    + "de: "+mediaPequenoI);
        } else {
            System.out.println("- O porte pequeno I não teve média de população");
        }
        
        if (pequenoII > 0) {
            Integer mediaPequenoII = contarPopulacaoPequenoII / pequenoII;
            System.out.println("- A média da população com porte pequeno II é "
                    + "de: "+mediaPequenoII);
        } else {
            System.out.println("- O porte pequeno II não teve média de população");
        }
        
        if (medio > 0) {
            Integer mediaMedio = contarPopulacaoMedio / medio;
            System.out.println("- A média da população com porte médio é "
                    + "de: "+mediaMedio);
        } else {
            System.out.println("- O porte médio não teve média de população");
        } 
        
        if (grande > 0) {
            Integer mediaGrande = contarPopulacaoGrande / grande;
            System.out.println("- A média da população com porte grande é "
                    + "de: "+mediaGrande);
        } else {
            System.out.println("- O porte grande não teve média de população");
        }
        
        if (metropole > 0) {
            Integer mediaMetropole = contarPopulacaoMetropole / metropole;
            System.out.println("- A média da população com porte metropóle é "
                    + "de: "+mediaMetropole);
        } else {
            System.out.println("- O porte metrópole não teve média de população");
        }
        
    }
    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public Integer getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Integer populacao) {
        this.populacao = populacao;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public Boolean getCapital() {
        return capital;
    }
    
     public String getCapitalString() {
        return capital ? "É capital" : "Não é capital";
    }

    public void setCapital(Boolean capital) {
        this.capital = capital;
    }
    
}
