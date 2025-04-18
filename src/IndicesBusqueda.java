public class IndicesBusqueda {
    //El arbol creado esta hecho por el id del cliente, por lo que se creara arbol de busqeuda por los otros atributos
    //BST POR NOMBRE
    public TreeNode NombreBst(TreeNode rootId, TreeNode rootName) {
        if (rootId == null) {
            return rootName;
        }
        // Inserta el cliente en el árbol por nombre.
        rootName = insertarPorNombre(rootName, rootId.client);
        // Procesa el subárbol izquierdo.
        rootName = NombreBst(rootId.left, rootName);
        // Procesa el subárbol derecho.
        rootName = NombreBst(rootId.right, rootName);

        return rootName;
    }
    // Insertar por nombre
    public TreeNode insertarPorNombre(TreeNode root, Client client) {
        if (root == null) {
            // Si el árbol está vacío, crea un nuevo nodo
            return new TreeNode(client, null, null);
        }
        // Comparar el nombre del cliente con el nombre del nodo actual
        if (client.getNombre().compareTo(root.client.getNombre()) < 0) {
            root.left = insertarPorNombre(root.left, client);  // Insertar en el subárbol izquierdo
        } else {
            root.right = insertarPorNombre(root.right, client);  // Insertar en el subárbol derecho
        }
        return root;
    }

    //BST POR APELLIDO
    public TreeNode ApellidoBst(TreeNode rootId, TreeNode rootApellido) {
        if (rootId == null) {
            return rootApellido;
        }
        rootApellido = insertarPorApellido(rootApellido, rootId.client);
        rootApellido = ApellidoBst(rootId.left, rootApellido);
        rootApellido = ApellidoBst(rootId.right, rootApellido);
        return rootApellido;
    }

    //Insertar por apellido
    public TreeNode insertarPorApellido(TreeNode root, Client client) {
        if (root == null) {
            return new TreeNode(client, null, null);  // Si el árbol está vacío, crear un nuevo nodo.
        }
        if (client.getApellido().compareTo(root.client.getApellido()) < 0) {
            root.left = insertarPorApellido(root.left, client);
        } else {
            root.right = insertarPorApellido(root.right, client);
        }
        return root;
    }

    //BST POR TELEFONO
    public TreeNode TelefonoBst(TreeNode rootId, TreeNode rootTelefono) {
        if (rootId == null) {
            return rootTelefono;
        }
        rootTelefono = TelefonoBst(rootId.left, rootTelefono);
        rootTelefono = insertarPorTelefono(rootTelefono, rootId.client);
        rootTelefono = TelefonoBst(rootId.right, rootTelefono);
        return rootTelefono;
    }

    //Insertar por telefono
    public TreeNode insertarPorTelefono(TreeNode root, Client client) {
        if (root == null) {
            return new TreeNode(client, null, null);
        }
        if (client.getTelefono().compareTo(root.client.getTelefono()) < 0) {
            root.left = insertarPorTelefono(root.left, client);
        } else {
            root.right = insertarPorTelefono(root.right, client);
        }
        return root;
    }

    //BST POR EMAIL
    public TreeNode EmailBst(TreeNode rootId, TreeNode rootEmail) {
        if (rootId == null) {
            return rootEmail;
        }
        rootEmail = EmailBst(rootId.left, rootEmail);
        rootEmail = insertarPorEmail(rootEmail, rootId.client);
        rootEmail = EmailBst(rootId.right, rootEmail);
        return rootEmail;
    }

    //Insertar por email
    public TreeNode insertarPorEmail(TreeNode root, Client client) {
        if (root == null) {
            return new TreeNode(client, null, null);
        }
        if (client.getEmail().compareTo(root.client.getEmail()) < 0) {
            root.left = insertarPorEmail(root.left, client);
        } else {
            root.right = insertarPorEmail(root.right, client);
        }
        return root;
    }

    //BST POR DIRECCION
    public TreeNode DireccionBst(TreeNode rootId, TreeNode rootDireccion) {
        if (rootId == null) {
            return rootDireccion;
        }
        rootDireccion = DireccionBst(rootId.left, rootDireccion);
        rootDireccion = insertarPorDireccion(rootDireccion, rootId.client);
        rootDireccion = DireccionBst(rootId.right, rootDireccion);
        return rootDireccion;
    }

    //Insertar por direccion
    public TreeNode insertarPorDireccion(TreeNode root, Client client) {
        if (root == null) {
            return new TreeNode(client, null, null);
        }
        if (client.getDireccion().compareTo(root.client.getDireccion()) < 0) {
            root.left = insertarPorDireccion(root.left, client);
        } else{
            root.right = insertarPorDireccion(root.right, client);
        }
        return root;
    }

    //BST POR FECHA DE NACIMIENTO
    public TreeNode BorndateBst(TreeNode rootId, TreeNode rootBorndate) {
        if (rootId == null) {
            return rootBorndate;
        }
        rootBorndate = BorndateBst(rootId.left, rootBorndate);
        rootBorndate = insertarPorBorndate(rootBorndate, rootId.client);
        rootBorndate = BorndateBst(rootId.right, rootBorndate);
        return rootBorndate;
    }

    //Insertar por fecha de nacimiento
    public TreeNode insertarPorBorndate(TreeNode root, Client client) {
        if (root == null) {
            return new TreeNode(client, null, null);
        }
        if (client.getBorndate().compareTo(root.client.getBorndate()) < 0) {
            root.left = insertarPorBorndate(root.left, client);
        } else{
            root.right = insertarPorBorndate(root.right, client);
        }
        return root;
    }

    //BST POR APODO
    public TreeNode ApodoBst(TreeNode rootId, TreeNode rootApodo) {
        if (rootId == null) {
            return rootApodo;
        }
        rootApodo = ApodoBst(rootId.left, rootApodo);
        rootApodo = insertarPorApodo(rootApodo, rootId.client);
        rootApodo = ApodoBst(rootId.right, rootApodo);
        return rootApodo;
    }

    //Insertar por apodo
    public TreeNode insertarPorApodo(TreeNode root, Client client) {
        if (root == null) {
            return new TreeNode(client, null, null);
        }
        if (client.getApodo().compareTo(root.client.getApodo()) < 0) {
            root.left = insertarPorApodo(root.left, client);
        } else {
            root.right = insertarPorApodo(root.right, client);
        }
        return root;
    }

    //Balance de arbol
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) return null;
        root.left = balanceBST(root.left);
        root.right = balanceBST(root.right);
        int balanceFactor = FactordeCoreccion(root);

        if (balanceFactor > 1) {
            if (FactordeCoreccion(root.left) >= 0) {
                root = RotacionDerecha(root);
            } else {
                root.left = RotacionIzquierda(root.left);
                root = RotacionDerecha(root);
            }
        } else if (balanceFactor < -1) {
            if (FactordeCoreccion(root.right) <= 0) {
                root = RotacionIzquierda(root);
            } else {
                root.right = RotacionDerecha(root.right);
                root = RotacionIzquierda(root);
            }
        }

        return root;
    }

    private TreeNode RotacionDerecha(TreeNode root) {
        if (root == null || root.left == null) return root;

        TreeNode newRoot = root.left;
        TreeNode Aux = newRoot.right;

        newRoot.right = root;
        root.left = Aux;

        return newRoot;
    }

    private TreeNode RotacionIzquierda(TreeNode root) {
        if (root == null || root.right == null) return root;

        TreeNode newRoot = root.right;
        TreeNode Aux = newRoot.left;

        newRoot.left = root;
        root.right = Aux;

        return newRoot;
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

    private int FactordeCoreccion(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        return Altura(root.left) - Altura(root.right);
    }


}