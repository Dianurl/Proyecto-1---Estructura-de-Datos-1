import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ToTXT {
    public String ClientTexto;
    public void convertTxt(TreeNode root, String path, String name) {
        ClientTexto = "";
        File file = new File(path+name);
        recorridoPorNiveles(root);
        try {
            file.createNewFile();
            java.io.FileWriter fw = new java.io.FileWriter(file);//Abrimos el archivo
            fw.write(ClientTexto);//Escribimos el texto
            fw.close();//Cerramos el archivo
        } catch (Exception e) {
            e.printStackTrace();//Si hay un error
        }
    }

    public void PorNivel(TreeNode root, int nivel, List<String> nivelActual) {
        if (root == null) {
            nivelActual.add("null");
            return;
        }

        if (nivel == 1) {
            nivelActual.add(String.valueOf(root.client.getId()));
        } else {
            PorNivel(root.left, nivel - 1, nivelActual);
            PorNivel(root.right, nivel - 1, nivelActual);
        }
    }

    public void recorridoPorNiveles(TreeNode root) {
        ClientTexto = ""; // Inicializamos ClientTexto aquí para asegurarnos de que esté vacío al inicio
        if (root == null) {
            return; // Si el árbol está vacío, no hacemos nada
        }

        int altura = Altura(root);
        List<String> allLevels = new ArrayList<>();
        for (int i = 1; i <= altura; i++) {
            List<String> nivelActual = new ArrayList<>();
            PorNivel(root, i, nivelActual);
            allLevels.addAll(nivelActual);
        }
        ClientTexto = String.join(",", allLevels);
    }

    private int Altura(TreeNode root)
    {
        if(root!=null)
        {
            int L = Altura(root.left);
            int R = Altura(root.right);
            if(L>R)
                return 1+L;
            else
                return 1+R;
        }
        else
            return 0;
    }
}
