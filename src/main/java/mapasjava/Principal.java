package mapasjava;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import static mapasjava.Municipio.pesquisarMunicipios;
import static mapasjava.Municipio.pesquisarPopulacao;
import static mapasjava.Municipio.pesquisarPorte;

public class Principal {

    public static void main(String[] args) throws IOException {
        
        String path = "/Z/soarescarol/compartilhado/municipios.csv";
        
        Map <String, ArrayList<Municipio>> dados = CSV.leitura(path);
        System.out.println("Dados do Munícipio");
        pesquisarMunicipios("RO", "Cabixi", dados);
        System.out.print("------------------------------------------\n");
        
        System.out.println("Dados da População");
        pesquisarPopulacao("RO", dados);
        
        System.out.print("------------------------------------------\n");
        pesquisarPorte("RO", dados);
    }
    
}
