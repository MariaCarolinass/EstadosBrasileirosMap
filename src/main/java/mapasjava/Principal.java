package mapasjava;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import static mapasjava.Municipio.pesquisarMunicipio;
import static mapasjava.Municipio.calcularPopulacaoEstado;
import static mapasjava.Municipio.calcularPorteMunicipio;
import static mapasjava.Municipio.calcularPopulacaoPorte;
import static mapasjava.Municipio.retornarDadosPorteLista;
        
public class Principal {

    public static void main(String[] args) throws IOException {
        
        String path = "/Z/soarescarol/compartilhado/municipios.csv";
        
        Map <String, ArrayList<Municipio>> dados = CSV.leitura(path);
        
        System.out.println("Dados do munícipio");
        pesquisarMunicipio("RO", "Alta Floresta D´oeste", dados);
        
        System.out.println("------------------------------------------");
        System.out.println("População total do estado");
        calcularPopulacaoEstado("RO", dados);
        
        System.out.println("------------------------------------------");
        System.out.println("Dados do porte dos munícipios");
        calcularPorteMunicipio("RO", dados);
        
        System.out.println("------------------------------------------");
        System.out.println("Dados da população dos munícipios por porte");
        calcularPopulacaoPorte("RO", dados);
        
        System.out.println("------------------------------------------");
        System.out.println("Dados do porte dos munícipios (código usando lista)");
        retornarDadosPorteLista("RO", dados);
        
    }
    
}
