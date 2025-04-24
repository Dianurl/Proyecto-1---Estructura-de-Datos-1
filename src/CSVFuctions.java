import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CSVFuctions {
    String TextoCSV;
    public void GenerarCSV (TreeNode root, String path)
    {
        try (FileWriter writer = new FileWriter(path)) {
            // Escribir encabezado (fila 1, columnas)
            writer.append("ID,Nombre,Apellido,Apodo,Telefono,Email,Direccion,Fecha de Nacimiento\n");
            CrearCSV(root);
            // Escribir filas con datos (cada fila es una línea nueva)
            writer.append(TextoCSV);
            System.out.println("Archivo CSV creado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String CrearCSV (TreeNode root)
    {
        if(root == null)
        {
            return "";
        }
        TextoCSV = root.client.getId() + "," + root.client.getNombre() + "," + root.client.getApellido() + "," + root.client.getApodo() + "," + root.client.getTelefono() + "," + root.client.getEmail() + "," + root.client.getDireccion() + "," + root.client.getBorndate() + "\n";
        TextoCSV += CrearCSV(root.left);
        TextoCSV += CrearCSV(root.right);
        return TextoCSV;
    }
}
