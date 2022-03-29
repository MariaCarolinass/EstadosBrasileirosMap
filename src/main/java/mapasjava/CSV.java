package mapasjava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CSV {

    public static Map<String, ArrayList<Municipio>> leitura(String path) throws IOException {

        Map<String, ArrayList<Municipio>> dados = new HashMap<>();

        try (BufferedReader buffRead = new BufferedReader(new FileReader(path))) {
            String linha = "";

            buffRead.readLine();

            while ((linha = buffRead.readLine()) != null) {

                String[] split = linha.replaceAll("\"", "").split(";");
                String estado = split[0].trim();
                String municipio = split[1].trim();
                String regiao = split[5].trim();
                // Atribuir valor 0 a String vázia
                if (split[6].trim().equals("")) {
                    split[6] = "0";
                }
                Integer populacao = Integer.parseInt(split[6].trim());
                String porte = split[7].trim();
                // Verdadeiro se capital estiver na posição 9
                Boolean capital = split.length == 9;
               
                ArrayList<Municipio> lista = dados.get(estado);

                if (lista == null) {
                    lista = new ArrayList<>();
                    dados.put(estado, lista);
                }

                lista.add(new Municipio(estado, municipio, regiao, populacao, porte, capital));
                
            }

        }

    return dados ;

    }

}
