import java.util.Objects;
import java.util.Scanner;
public class TreeFuctions{
    Scanner sc = new Scanner(System.in);//Funciona para imprimir en consola con intelliji ya que que generalmente si se usa el de java retorna null
    //Copiar Arbol
    public TreeNode copyTree(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode newRoot = new TreeNode(root.client, null, null);
        newRoot.left = copyTree(root.left);
        newRoot.right = copyTree(root.right);
        return newRoot;
    }

    //Agregar cliente
    public TreeNode addClient(Client client,  TreeNode root){
        if(root == null){
            return new TreeNode(client, null, null);
        }
        else if(client.getId().compareTo(root.client.getId()) < 0){
            root.left = addClient(client, root.left);
        }
        else if(client.getId().compareTo(root.client.getId()) > 0){
            root.right = addClient(client, root.right);
        }
        return root;
    }
    
    //Eliminar cliente
    public TreeNode deleteClient(TreeNode root, Integer id){
        if(root == null){
            System.out.println("No se encontro el cliente");
            return null;
        }
        if(id.equals(root.client.getId())){
            if(root.left == null && root.right == null){
                root = null;
                return root;
            }
            else if(root.left == null){
                root = root.right;
                return root;
            }
            else if(root.right == null){
                root = root.left;
                return root;
            }
            else{
                TreeNode aux = root.right;
                while(aux.left != null){
                    aux = aux.left;
                }
                root.client = aux.client;
                root.right = deleteClient(root.right, root.client.getId());
            }
        }
        else if(id < root.client.getId()){
            root.left = deleteClient(root.left, id);
        }
        else if(id > root.client.getId()){
            root.right = deleteClient(root.right, id);
        }
        return root;

    }

    //Actualizacion de infromacion CLiente
    public  TreeNode updateClient(TreeNode root, Integer id){
        if(root == null){
            System.out.println("No se encontro el cliente");
            return null;
        }
        if(id.equals(root.client.getId())){
            System.out.println("Cliente encontrado");
            System.out.println("Nombre: " + root.client.getNombre());
            System.out.println("Apellido: " + root.client.getApellido());
            System.out.println("Telefono: " + root.client.getTelefono());
            System.out.println("Email: " + root.client.getEmail());
            System.out.println("Direccion: " + root.client.getDireccion());
            System.out.println("Fecha de nacimiento: " + root.client.getBorndate());
            System.out.println("Apodo: " + root.client.getApodo());
            System.out.println("ID: " + root.client.getId());
            System.out.println("Ingrese la nueva informacion del cliente");
            System.out.println("Nombre: ");
            String Nombre = sc.nextLine();
            System.out.println("Apellido: ");
            String Apellido = sc.nextLine();
            System.out.println("Telefono: ");
            String Telefono = sc.nextLine();
            System.out.println("Email: ");
            String email = sc.nextLine();
            System.out.println("Direccion: ");
            String Direccion = sc.nextLine();
            System.out.println("Fecha de nacimiento: ");
            String borndate = sc.nextLine();
            System.out.println("Apodo: ");
            String apodo = sc.nextLine();
            root.client.setNombre(Nombre);
            root.client.setApellido(Apellido);
            root.client.setTelefono(Telefono);
            root.client.setEmail(email);
            root.client.setDireccion(Direccion);
            root.client.setBorndate(borndate);
            root.client.setApodo(apodo);
        }
        else if(id < root.client.getId()){
            root.left = updateClient(root.left, id);
        }
        else if(id > root.client.getId()){
            root.right = updateClient(root.right, id);
        }
        return root;
    }

    //Buscar cliente
    public void searchClientId(Integer id, TreeNode root){
        if(root == null){
            System.out.println("No se encontro el cliente");
            return;
        }
        else if(id.equals(root.client.getId())){
            System.out.println("Cliente encontrado");
            System.out.println("Nombre: " + root.client.getNombre());
            System.out.println("Apellido: " + root.client.getApellido());
            System.out.println("Telefono: " + root.client.getTelefono());
            System.out.println("Email: " + root.client.getEmail());
            System.out.println("Direccion: " + root.client.getDireccion());
            System.out.println("Fecha de nacimiento: " + root.client.getBorndate());
            System.out.println("Apodo: " + root.client.getApodo());
            System.out.println("ID: " + root.client.getId());;
            return;
        }
        else if(id < root.client.getId()){
            searchClientId(id, root.left);
        }
        else if(id > root.client.getId()){
            searchClientId(id, root.right);
        }
        return;
    }

    public void searchClientNombre(String name, TreeNode root) {
        if(root == null){
            System.out.println("No se encontro el cliente");
            return;
        }
        else if(name.equals(root.client.getNombre())){
            System.out.println("Cliente encontrado");
            System.out.println("Nombre: " + root.client.getNombre());
            System.out.println("Apellido: " + root.client.getApellido());
            System.out.println("Telefono: " + root.client.getTelefono());
            System.out.println("Email: " + root.client.getEmail());
            System.out.println("Direccion: " + root.client.getDireccion());
            System.out.println("Fecha de nacimiento: " + root.client.getBorndate());
            System.out.println("Apodo: " + root.client.getApodo());
            System.out.println("ID: " + root.client.getId());
            return;
        }
        else if(name.compareTo(root.client.getNombre()) < 0){
            searchClientNombre(name, root.left);
        }
        else if(name.compareTo(root.client.getNombre()) > 0){
            searchClientNombre(name, root.right);
        }
        return;
    }

    public void searchClientApellido(String lastName, TreeNode root){
        if(root == null){
            System.out.println("No se encontro el cliente");
            return ;
        }
        else if(lastName.equals(root.client.getApellido())){
            System.out.println("Cliente encontrado");
            System.out.println("Nombre: " + root.client.getNombre());
            System.out.println("Apellido: " + root.client.getApellido());
            System.out.println("Telefono: " + root.client.getTelefono());
            System.out.println("Email: " + root.client.getEmail());
            System.out.println("Direccion: " + root.client.getDireccion());
            System.out.println("Fecha de nacimiento: " + root.client.getBorndate());
            System.out.println("Apodo: " + root.client.getApodo());
            System.out.println("ID: " + root.client.getId());
            return;
        }
        else if(lastName.compareTo(root.client.getApellido()) < 0){
            searchClientApellido(lastName, root.left);
        }
        else if(lastName.compareTo(root.client.getApellido()) > 0){
            searchClientApellido(lastName, root.right);
        }
        return;
    }

    public void searchClientTelefono(String phone, TreeNode root){
        if(root == null){
            System.out.println("No se encontro el cliente");
            return;
        }
        else if(phone.equals(root.client.getTelefono())){
            System.out.println("Cliente encontrado");
            System.out.println("Nombre: " + root.client.getNombre());
            System.out.println("Apellido: " + root.client.getApellido());
            System.out.println("Telefono: " + root.client.getTelefono());
            System.out.println("Email: " + root.client.getEmail());
            System.out.println("Direccion: " + root.client.getDireccion());
            System.out.println("Fecha de nacimiento: " + root.client.getBorndate());
            System.out.println("Apodo: " + root.client.getApodo());
            System.out.println("ID: " + root.client.getId());
            return;
        }
        else if(phone.compareTo(root.client.getTelefono()) < 0){
            searchClientTelefono(phone, root.left);
        }
        else if(phone.compareTo(root.client.getTelefono()) > 0){
            searchClientTelefono(phone, root.right);
        }
        return;

    }

    public void searchClientEmail( String email, TreeNode root){
        if(root == null){
            System.out.println("No se encontro el cliente");
            return;
        }
        else if(email.equals(root.client.getEmail())){
            System.out.println("Cliente encontrado");
            System.out.println("Nombre: " + root.client.getNombre());
            System.out.println("Apellido: " + root.client.getApellido());
            System.out.println("Telefono: " + root.client.getTelefono());
            System.out.println("Email: " + root.client.getEmail());
            System.out.println("Direccion: " + root.client.getDireccion());
            System.out.println("Fecha de nacimiento: " + root.client.getBorndate());
            System.out.println("Apodo: " + root.client.getApodo());
            System.out.println("ID: " + root.client.getId());
            return;
        }
        else if(email.compareTo(root.client.getEmail()) < 0){
            searchClientEmail(email, root.left);
        }
        else if(email.compareTo(root.client.getEmail()) > 0){
            searchClientEmail(email, root.right);
        }
        return;
    }

    public void searchClientDireccion(String address, TreeNode root){
        if(root == null){
            System.out.println("No se encontro el cliente");
            return;
        }
        else if(address.equals(root.client.getDireccion())){
            System.out.println("Cliente encontrado");
            System.out.println("Nombre: " + root.client.getNombre());
            System.out.println("Apellido: " + root.client.getApellido());
            System.out.println("Telefono: " + root.client.getTelefono());
            System.out.println("Email: " + root.client.getEmail());
            System.out.println("Direccion: " + root.client.getDireccion());
            System.out.println("Fecha de nacimiento: " + root.client.getBorndate());
            System.out.println("Apodo: " + root.client.getApodo());
            System.out.println("ID: " + root.client.getId());
            return;
        }
        else if(address.compareTo(root.client.getDireccion()) < 0){
            searchClientDireccion(address, root.left);
        }
        else if(address.compareTo(root.client.getDireccion()) > 0){
            searchClientDireccion(address, root.right);
        }
        return;
    }

    public void searchClientBorndate(String borndate, TreeNode root){
        if(root == null){
            System.out.println("No se encontro el cliente");
            return ;
        }
        else if(borndate.equals(root.client.getBorndate())){
            System.out.println("Cliente encontrado");
            System.out.println("Nombre: " + root.client.getNombre());
            System.out.println("Apellido: " + root.client.getApellido());
            System.out.println("Telefono: " + root.client.getTelefono());
            System.out.println("Email: " + root.client.getEmail());
            System.out.println("Direccion: " + root.client.getDireccion());
            System.out.println("Fecha de nacimiento: " + root.client.getBorndate());
            System.out.println("Apodo: " + root.client.getApodo());
            System.out.println("ID: " + root.client.getId());
            return;
        }
        else if(borndate.compareTo(root.client.getBorndate()) < 0){
            searchClientBorndate(borndate, root.left);
        }
        else if(borndate.compareTo(root.client.getBorndate()) > 0){
            searchClientBorndate(borndate, root.right);
        }
        return;
    }

    public void searchClientApodo(String apodo, TreeNode root){
        if(root == null){
            System.out.println("No se encontro el cliente");
            return;
        }
        else if(apodo.equals(root.client.getApodo())){
            System.out.println("Cliente encontrado");
            System.out.println("Nombre: " + root.client.getNombre());
            System.out.println("Apellido: " + root.client.getApellido());
            System.out.println("Telefono: " + root.client.getTelefono());
            System.out.println("Email: " + root.client.getEmail());
            System.out.println("Direccion: " + root.client.getDireccion());
            System.out.println("Fecha de nacimiento: " + root.client.getBorndate());
            System.out.println("Apodo: " + root.client.getApodo());
            System.out.println("ID: " + root.client.getId());
            return;
        }
        else if(apodo.compareTo(root.client.getApodo()) < 0){
            searchClientApodo(apodo, root.left);
        }
        else if(apodo.compareTo(root.client.getApodo()) > 0){
            searchClientApodo(apodo, root.right);
        }
        return;
    }

    //Imprimir arbol
    public void Preorder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println("Nombre: " + root.client.getNombre());
        System.out.println("Apellido: " + root.client.getApellido());
        System.out.println("Telefono: " + root.client.getTelefono());
        System.out.println("Email: " + root.client.getEmail());
        System.out.println("Direccion: " + root.client.getDireccion());
        System.out.println("Fecha de nacimiento: " + root.client.getBorndate());
        System.out.println("Apodo: " + root.client.getApodo());
        System.out.println("ID: " + root.client.getId());
        Preorder(root.left);
        Preorder(root.right);
    }



}
