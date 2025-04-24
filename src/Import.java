import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Import {
    public Client ImportarCSV(String path, Integer id, Integer lineaObjetivo) {
        String linea;
        int contador = 0;

        Client client = new Client(null, null, null, null, null, null, null, null);

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((linea = br.readLine()) != null) {
                contador++;

                // Saltar encabezado
                if (contador == 1) continue;

                // Si llegamos a la línea deseada
                if (contador == lineaObjetivo + 1) { // +1 porque la línea 1 es encabezado
                    String[] columnas = linea.split(",");

                    client.setId(id);
                    client.setNombre(columnas[1]);
                    client.setApellido(columnas[2]);
                    client.setApodo(columnas[3]);
                    client.setTelefono(columnas[4]);
                    client.setEmail(columnas[5]);
                    client.setDireccion(columnas[6]);
                    client.setBorndate(columnas[7]);

                    return client;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; // Si no se encuentra la línea deseada
    }

    public int contarLineasSinEncabezado(String path) {
        int contador = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            // Saltar el encabezado
            br.readLine();

            // Contar líneas restantes
            while (br.readLine() != null) {
                contador++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return contador;
    }
}
