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
    
    // Encontrar os dados de um munícipio
    public static void pesquisarMunicipios(String estado, String municipio,
            Map <String, ArrayList<Municipio>> dados) {
        
        ArrayList<Municipio> lista = dados.get(estado);
        
        if (lista == null) {
            System.out.println("Estado não encontrado!");
            return;
        }
        
        for (Municipio i: lista) {
            
            if (i.getEstado().equals(estado) && i.getMunicipio().equals(municipio)) {
                System.out.println("- Estado: " + i.getEstado());
                System.out.println("- Munícipio: " + i.getMunicipio());
                System.out.println("- Região: " + i.getRegiao());
                System.out.println("- População: " + i.getPopulacao());
                System.out.println("- Porte: " + i.getPorte());
                System.out.println("- Capital: " + i.getCapitalString());
                return;
            }
            
        }
        
        System.out.println("Munícipio não encontrado!");
        
    }
    
    // Encontrar toda a população de um estado e mostrar o total
    public static int pesquisarPopulacao(String estado,
            Map <String, ArrayList<Municipio>> dados) {
        
        ArrayList<Municipio> lista = dados.get(estado);
        
        Integer total = 0;
        for (Municipio i: lista) {
            total += i.getPopulacao();
        } 
        
        System.out.println("- A população total de "+estado+" é de: "+total);
        return total;
        
    }
    
    // Encontrar cada porte do estado e retornar o total de cada tipo usando mapa
    // Calcular a média da população de cada munícipio por tipo de porte
    public static void pesquisarPorte(String estado, 
            Map <String, ArrayList<Municipio>> dados) {
        
        Map <String, Integer> porte = new HashMap<>();
        ArrayList<Municipio> lista = dados.get(estado);
      
        for (Municipio i: lista) {
            
            if (!porte.containsKey(i.getPorte())){
                porte.put(i.getPorte(), 0);
            } 
            
            porte.put(i.getPorte(), porte.get(i.getPorte()) + 1);
        
        }
        
        System.out.println("Dados do porte no estado de "+estado);
        System.out.println();
        porte.entrySet().forEach(entry -> {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("- "+key+" tem: "+value+" porte(s)");
        });
        
    }
    
    // Encontrar cada porte do estado e retornar o total de cada tipo usando lista
    // Calcular a média da população de cada munícipio por tipo de porte
    public static void pesquisarPorteLista(String estado,
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

        System.out.println("Dados do porte no estado de "+estado+"\n");
        System.out.println("- Pequeno I tem: "+pequenoI+" porte(s)");
        System.out.println("- Pequeno II tem: "+pequenoII+" porte(s)");
        System.out.println("- Médio tem: "+medio+" porte(s)");
        System.out.println("- Grande tem: "+grande+" porte(s)");
        System.out.println("- Metrópoles tem: "+metropole+" porte(s)");
        System.out.println();
        
        if (pequenoI > 0) {
            Integer mediaPequenoI = contarPopulacaoPequenoI / pequenoI;
            System.out.println("- A média da população com porte pequeno I é: "+mediaPequenoI);
        } else {
            System.out.println("- A população com porte pequeno I não teve média");
        }
        
        if (pequenoII > 0) {
            Integer mediaPequenoII = contarPopulacaoPequenoII / pequenoII;
            System.out.println("- A média da população com porte pequeno II é: "+mediaPequenoII);
        } else {
            System.out.println("- A população com porte pequeno II não teve média");
        }
        
        if (medio > 0) {
            Integer mediaMedio = contarPopulacaoMedio / medio;
            System.out.println("- A média da população com porte médio é: "+mediaMedio);
        } else {
            System.out.println("- A população com porte médio não teve média");
        } 
        
        if (grande > 0) {
            Integer mediaGrande = contarPopulacaoGrande / grande;
            System.out.println("- A média da população com porte grande é: "+mediaGrande);
        } else {
            System.out.println("- A população com porte grande não teve média");
        }
        
        if (metropole > 0) {
            Integer mediaMetropole = contarPopulacaoMetropole / metropole;
            System.out.println("- A média da população com porte metropóle é: "+mediaMetropole);
        } else {
            System.out.println("- A população com porte metrópole não teve média");
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
