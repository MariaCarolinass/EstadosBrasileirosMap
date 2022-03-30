package mapasjava;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import static mapasjava.Municipio.pesquisarMunicipios;
import static mapasjava.Municipio.pesquisarPopulacao;
import static mapasjava.Municipio.pesquisarPorte;
import static mapasjava.Municipio.pesquisarPorteLista;
        
public class Principal {

    public static void main(String[] args) throws IOException {
        
        String path = "/Z/soarescarol/compartilhado/municipios.csv";
        
        Map <String, ArrayList<Municipio>> dados = CSV.leitura(path);
        System.out.println("Dados do Munícipio");
        System.out.println();
        pesquisarMunicipios("RO", "Cabixi", dados);
        
        System.out.println("------------------------------------------");
        System.out.println("Dados da População");
        System.out.println();
        pesquisarPopulacao("RO", dados);
        
        System.out.println("------------------------------------------");
        pesquisarPorte("RO", dados);
        
        System.out.println("------------------------------------------");
        pesquisarPorteLista("RO", dados);
        
    }
    
}
