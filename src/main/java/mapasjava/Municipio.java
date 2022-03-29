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
    
    // Encontrar toda a população de um estado e somar
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
    
    // Encontrar o porte de um estado e somar por tipo
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
        porte.entrySet().forEach(entry -> {
            String key = entry.getKey();
            Integer value = entry.getValue();   
            System.out.println("- "+key+" tem: "+value+" porte(s)");
        });
        
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
