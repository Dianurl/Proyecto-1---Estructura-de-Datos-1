import java.util.Scanner;
public class Main {
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Variables globales
    static public boolean Id_avl = false;
    static public boolean Nombre_avl = false;
    static public boolean Apellido_avl = false;
    static public boolean Telefono_avl = false;
    static public boolean Email_avl = false;
    static public boolean Direccion_avl = false;
    static public boolean Borndate_avl = false;
    static public boolean Apodo_avl = false;
    static public boolean Id_bst = false;
    static public boolean Nombre_bst = false;
    static public boolean Apellido_bst = false;
    static public boolean Telefono_bst = false;
    static public boolean Email_bst = false;
    static public boolean Direccion_bst = false;
    static public boolean Borndate_bst = false;
    static public boolean Apodo_bst = false;
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Variables de arboles\
    public static TreeNode IdBst  = null;
    public static TreeNode ApellidoBst  = null;
    public static TreeNode TelefonoBst  = null;
    public static TreeNode EmailBst  = null;
    public static TreeNode DireccionBst  = null;
    public static TreeNode BorndateBst  = null;
    public static TreeNode ApodoBst  = null;
    public static TreeNode NombreBst  = null;
    public static TreeNode ApellidoAvl  = null;
    public static TreeNode TelefonoAvl  = null;
    public static TreeNode EmailAvl  = null;
    public static TreeNode DireccionAvl  = null;
    public static TreeNode BorndateAvl  = null;
    public static TreeNode ApodoAvl  = null;
    public static TreeNode NombreAvl  = null;
    public static TreeNode IdAvl  = null;
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Variables de arbol
    public static TreeFuctions ObjTreeFunctions = new TreeFuctions();
    public static IndicesBusqueda ObjIndicesBusqueda = new IndicesBusqueda();
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//Funciona para imprimir en consola con intelliji ya que que generalmente si se usa el de java retorna null
        //Directorios
        String Pathtxt = "C:\\Users\\conra\\OneDrive\\Documentos\\Poryecto Estructura de datos\\";
        String Pathcsv = "C:\\Users\\conra\\OneDrive\\Documentos\\Poryecto Estructura de datos\\";

        //Objetos de exportacion e importacion
        Export ObjExport = new Export();
        Import ObjImport = new Import();

        //Agregamos clientes
        int idGenerados = 0;
        int OpcionesGeneral = 0;
        int OpcionesContactos = 0;

        while(OpcionesGeneral != 4)
        {
            //desplegamos menu
            System.out.println("1. Gestion de contactos");
            System.out.println("2. Indices y busqueda");
            System.out.println("3. Exportacion e importacion de contactos");
            System.out.println("4. Salir");
            System.out.println("Ingrese una opcion: ");
            try {
                OpcionesGeneral = Integer.parseInt(sc.nextLine());
                if (OpcionesGeneral != 1 && OpcionesGeneral != 2 && OpcionesGeneral != 3 && OpcionesGeneral != 4) {
                    System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 4.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 4.");
            }

            switch(OpcionesGeneral) {
                case 1:
                    System.out.println("1. Agregar cliente");
                    System.out.println("2. Eliminar cliente");
                    System.out.println("3. Modificar cliente");
                    System.out.println("4. Buscar contacto");
                    System.out.println("5. Ver todos los contactos");
                    System.out.println("6. Salir");
                    System.out.println("Ingrese una opcion: ");
                    try {
                        OpcionesContactos = Integer.parseInt(sc.nextLine());
                        if (OpcionesContactos != 1 && OpcionesContactos != 2 && OpcionesContactos != 3 && OpcionesContactos != 4 && OpcionesContactos != 5 && OpcionesContactos != 6) {
                            System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 6.");
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 6.");
                    }

                    switch (OpcionesContactos) {
                        case 1:
                            idGenerados = idGenerados+1;
                            System.out.println("Ingrese nombre: ");
                            String nombre = sc.nextLine();
                            System.out.println("Ingrese apellido: ");
                            String apellido = sc.nextLine();
                            String telefono;
                            while (true) {
                                System.out.println("Ingrese telefono: ");
                                telefono = sc.nextLine();
                                if (telefono.matches("\\d+")) {
                                    break;
                                } else {
                                    System.out.println("Error: el teléfono debe contener solo números.");
                                }
                            }
                            System.out.println("Ingrese email: ");
                            String email = sc.nextLine();
                            System.out.println("Ingrese direccion: ");
                            String direccion = sc.nextLine();
                            String fechaNacimiento;
                            while (true) {
                                System.out.println("Ingrese fecha de nacimiento: ");
                                fechaNacimiento = sc.nextLine();
                                if (fechaNacimiento.matches("\\d+")) {
                                    break;
                                } else {
                                    System.out.println("Error: la fecha de nacimiento debe contener solo números.");
                                }
                            }
                            System.out.println("Ingrese apodo: ");
                            String apodo =sc.nextLine();
                            Client objClient = new Client(nombre, apellido, telefono, email, direccion, fechaNacimiento, apodo, idGenerados);
                            IdBst = ObjTreeFunctions.addClient(objClient, IdBst);

                            break;
                        case 2:
                            System.out.println("Ingrese id del cliente a eliminar: ");
                            int idEliminar = Integer.parseInt(sc.nextLine());
                            IdBst = ObjTreeFunctions.deleteClient(IdBst, idEliminar);

                            break;
                        case 3:
                            System.out.println("Ingrese id del cliente a modificar: ");
                            int idModificar = Integer.parseInt(sc.nextLine());
                            IdBst = ObjTreeFunctions.updateClient(IdBst, idModificar);
                            break;
                        case 4:
                            //Actualizamos indices
                            ActualizarIndices();
                            //Preguntar por que indice desea buscar
                            System.out.println("Por que indice desea bsucar: ");
                            System.out.println("1. Id");
                            System.out.println("2. Nombre");
                            System.out.println("3. Apellido");
                            System.out.println("4. Telefono");
                            System.out.println("5. Email");
                            System.out.println("6. Direccion");
                            System.out.println("7. Fecha de nacimiento");
                            System.out.println("8. Apodo");
                            System.out.println("9. Salir");
                            System.out.println("Ingrese una opcion: ");
                            int OpcionesBusqueda = Integer.parseInt(sc.nextLine());
                            try {
                                if (OpcionesBusqueda != 1 && OpcionesBusqueda != 2 && OpcionesBusqueda != 3 && OpcionesBusqueda != 4 && OpcionesBusqueda != 5 && OpcionesBusqueda != 6 && OpcionesBusqueda != 7 && OpcionesBusqueda != 8 && OpcionesBusqueda != 9) {
                                    System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 9.");
                                    continue;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 9.");
                            }
                            switch (OpcionesBusqueda) {
                                case 1:
                                    if(Id_bst == false && Id_avl == false)
                                    {
                                        System.out.println("No se ha creado el indice de id");
                                        break;
                                    }
                                    System.out.println("Ingrese el Id a buscar");
                                    int idBuscar = Integer.parseInt(sc.nextLine());
                                    if(Id_bst == true && Id_avl == true)
                                    {
                                        System.out.println("Por que indice desea buscar: ");
                                        System.out.println("1. bst");
                                        System.out.println("2. avl");
                                        System.out.println("Ingrese una opcion: ");
                                        int OpcionesBusquedaIndice = Integer.parseInt(sc.nextLine());
                                        try {
                                            if (OpcionesBusquedaIndice != 1 && OpcionesBusquedaIndice != 2) {
                                                System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 2.");
                                                continue;
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 2.");
                                        }
                                        switch (OpcionesBusquedaIndice) {
                                            case 1:
                                                System.out.println("Buscando por indice id Bst");
                                                ObjTreeFunctions.searchClientId(idBuscar, IdBst);
                                                break;
                                            case 2:
                                                System.out.println("Buscando por indice id Avl");
                                                ObjTreeFunctions.searchClientId(idBuscar, IdAvl);
                                                break;
                                        }
                                        break;
                                    }
                                    if(Id_bst==true)
                                    {
                                        System.out.println("Buscando por indice id Bst");
                                        ObjTreeFunctions.searchClientId(idBuscar, IdBst);
                                    }
                                    if(Id_avl==true)
                                    {
                                        System.out.println("Buscando por indice id Avl");
                                        ObjTreeFunctions.searchClientId(idBuscar, IdAvl);
                                    }


                                    break;
                                case 2:
                                    if(Nombre_bst == false && Nombre_avl == false)
                                    {
                                        System.out.println("No se ha creado el indice de nombre");
                                        break;
                                    }
                                    System.out.println("Ingrese nombre del cliente a buscar: ");
                                    String nombreBuscar = sc.nextLine();
                                    if(Nombre_bst==true && Nombre_avl==true)
                                    {
                                        System.out.println("Por que indice desea buscar: ");
                                        System.out.println("1. bst");
                                        System.out.println("2. avl");
                                        System.out.println("Ingrese una opcion: ");
                                        int OpcionesBusquedaIndice = Integer.parseInt(sc.nextLine());
                                        try {
                                            if (OpcionesBusquedaIndice != 1 && OpcionesBusquedaIndice != 2) {
                                                System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 2.");
                                                continue;
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 2.");
                                        }
                                        switch (OpcionesBusquedaIndice) {
                                            case 1:
                                                System.out.println("Buscando por indice nombre Bst");
                                                ObjTreeFunctions.searchClientNombre(nombreBuscar, NombreBst);
                                                break;
                                            case 2:
                                                System.out.println("Buscando por indice nombre Avl");
                                                ObjTreeFunctions.searchClientNombre(nombreBuscar, NombreAvl);
                                                break;
                                        }
                                        break;
                                    }
                                    if(Nombre_bst==true)
                                    {
                                        System.out.println("Buscando por indice nombre Bst");
                                        ObjTreeFunctions.searchClientNombre(nombreBuscar, NombreBst);
                                    }
                                    if(Nombre_avl==true)
                                    {
                                        System.out.println("Buscando por indice nombre Avl");
                                        ObjTreeFunctions.searchClientNombre(nombreBuscar, NombreAvl);
                                    }
                                    break;
                                case 3:
                                    if(Apellido_bst == false && Apellido_avl == false)
                                    {
                                        System.out.println("No se ha creado el indice de apellido");
                                        break;
                                    }
                                    System.out.println("Ingrese apellido del cliente a buscar: ");
                                    String apellidoBuscar = sc.nextLine();
                                    if(Apellido_bst==true && Apellido_avl==true)
                                    {
                                        System.out.println("Por que indice desea buscar: ");
                                        System.out.println("1. bst");
                                        System.out.println("2. avl");
                                        System.out.println("Ingrese una opcion: ");
                                        int OpcionesBusquedaIndice = Integer.parseInt(sc.nextLine());
                                        try {
                                            if (OpcionesBusquedaIndice != 1 && OpcionesBusquedaIndice != 2) {
                                                System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 2.");
                                                continue;
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 2.");
                                        }
                                        switch (OpcionesBusquedaIndice) {
                                            case 1:
                                                System.out.println("Buscando por indice apellido Bst");
                                                ObjTreeFunctions.searchClientApellido(apellidoBuscar, ApellidoBst);
                                                break;
                                            case 2:
                                                System.out.println("Buscando por indice apellido Avl");
                                                ObjTreeFunctions.searchClientApellido(apellidoBuscar, ApellidoAvl);
                                                break;
                                        }
                                        break;
                                    }
                                    if(Apellido_bst==true)
                                    {
                                        System.out.println("Buscando por indice apellido Bst");
                                        ObjTreeFunctions.searchClientApellido(apellidoBuscar, ApellidoBst);
                                    }
                                    if(Apellido_avl==true)
                                    {
                                        System.out.println("Buscando por indice apellido Avl");
                                        ObjTreeFunctions.searchClientApellido(apellidoBuscar, ApellidoAvl);
                                    }
                                    break;
                                case 4:
                                    if(Telefono_bst == false && Telefono_avl == false)
                                    {
                                        System.out.println("No se ha creado el indice de telefono");
                                        break;
                                    }
                                    System.out.println("Ingrese telefono del cliente a buscar: ");
                                    String telefonoBuscar = sc.nextLine();
                                    if(Telefono_bst==true && Telefono_avl==true)
                                    {
                                        System.out.println("Por que indice desea buscar: ");
                                        System.out.println("1. bst");
                                        System.out.println("2. avl");
                                        System.out.println("Ingrese una opcion: ");
                                        int OpcionesBusquedaIndice = Integer.parseInt(sc.nextLine());
                                        try {
                                            if (OpcionesBusquedaIndice != 1 && OpcionesBusquedaIndice != 2) {
                                                System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 2.");
                                                continue;
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 2.");
                                        }
                                        switch (OpcionesBusquedaIndice) {
                                            case 1:
                                                System.out.println("Buscando por indice telefono Bst");
                                                ObjTreeFunctions.searchClientTelefono(telefonoBuscar, TelefonoBst);
                                                break;
                                            case 2:
                                                System.out.println("Buscando por indice telefono Avl");
                                                ObjTreeFunctions.searchClientTelefono(telefonoBuscar, TelefonoAvl);
                                                break;
                                        }
                                        break;
                                    }
                                    if(Telefono_bst==true)
                                    {
                                        System.out.println("Buscando por indice telefono Bst");
                                        ObjTreeFunctions.searchClientTelefono(telefonoBuscar, TelefonoBst);
                                    }
                                    if(Telefono_avl==true)
                                    {
                                        System.out.println("Buscando por indice telefono Avl");
                                        ObjTreeFunctions.searchClientTelefono(telefonoBuscar, TelefonoAvl);
                                    }
                                    break;
                                case 5:
                                    if(Email_bst == false && Email_avl == false)
                                    {
                                        System.out.println("No se ha creado el indice de email");
                                        break;
                                    }
                                    System.out.println("Ingrese email del cliente a buscar: ");
                                    String emailBuscar = sc.nextLine();
                                    if(Email_bst==true && Email_avl==true)
                                    {
                                        System.out.println("Por que indice desea buscar: ");
                                        System.out.println("1. bst");
                                        System.out.println("2. avl");
                                        System.out.println("Ingrese una opcion: ");
                                        int OpcionesBusquedaIndice = Integer.parseInt(sc.nextLine());
                                        try {
                                            if (OpcionesBusquedaIndice != 1 && OpcionesBusquedaIndice != 2) {
                                                System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 2.");
                                                continue;
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 2.");
                                        }
                                        switch (OpcionesBusquedaIndice) {
                                            case 1:
                                                System.out.println("Buscando por indice email Bst");
                                                ObjTreeFunctions.searchClientEmail(emailBuscar, EmailBst);
                                                break;
                                            case 2:
                                                System.out.println("Buscando por indice email Avl");
                                                ObjTreeFunctions.searchClientEmail(emailBuscar, EmailAvl);
                                                break;
                                        }
                                        break;
                                    }
                                    if(Email_bst==true)
                                    {
                                        System.out.println("Buscando por indice email Bst");
                                        ObjTreeFunctions.searchClientEmail(emailBuscar, EmailBst);
                                    }
                                    if(Email_avl==true)
                                    {
                                        System.out.println("Buscando por indice email Avl");
                                        ObjTreeFunctions.searchClientEmail(emailBuscar, EmailAvl);
                                    }
                                    break;
                                case 6:
                                    if(Direccion_bst == false && Direccion_avl == false)
                                    {
                                        System.out.println("No se ha creado el indice de direccion");
                                        break;
                                    }
                                    System.out.println("Ingrese direccion del cliente a buscar: ");
                                    String direccionBuscar = sc.nextLine();
                                    if(Direccion_bst==true && Direccion_avl==true)
                                    {
                                        System.out.println("Por que indice desea buscar: ");
                                        System.out.println("1. bst");
                                        System.out.println("2. avl");
                                        System.out.println("Ingrese una opcion: ");
                                        int OpcionesBusquedaIndice = Integer.parseInt(sc.nextLine());
                                        try {
                                            if (OpcionesBusquedaIndice != 1 && OpcionesBusquedaIndice != 2) {
                                                System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 2.");
                                                continue;
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 2.");
                                        }
                                        switch (OpcionesBusquedaIndice) {
                                            case 1:
                                                System.out.println("Buscando por indice direccion Bst");
                                                ObjTreeFunctions.searchClientDireccion(direccionBuscar, DireccionBst);
                                                break;
                                            case 2:
                                                System.out.println("Buscando por indice direccion Avl");
                                                ObjTreeFunctions.searchClientDireccion(direccionBuscar, DireccionAvl);
                                                break;
                                        }
                                        break;
                                    }
                                    if(Direccion_bst==true)
                                    {
                                        System.out.println("Buscando por indice direccion Bst");
                                        ObjTreeFunctions.searchClientDireccion(direccionBuscar, DireccionBst);
                                    }
                                    if(Direccion_avl==true)
                                    {
                                        System.out.println("Buscando por indice direccion Avl");
                                        ObjTreeFunctions.searchClientDireccion(direccionBuscar, DireccionAvl);
                                    }
                                    break;
                                case 7:
                                    if(Borndate_bst == false && Borndate_avl == false)
                                    {
                                        System.out.println("No se ha creado el indice de fecha de nacimiento");
                                        break;
                                    }
                                    System.out.println("Ingrese fecha de nacimiento del cliente a buscar: ");
                                    String fechaNacimientoBuscar = sc.nextLine();
                                    if(Borndate_bst==true && Borndate_avl==true)
                                    {
                                        System.out.println("Por que indice desea buscar: ");
                                        System.out.println("1. bst");
                                        System.out.println("2. avl");
                                        System.out.println("Ingrese una opcion: ");
                                        int OpcionesBusquedaIndice = Integer.parseInt(sc.nextLine());
                                        try {
                                            if (OpcionesBusquedaIndice != 1 && OpcionesBusquedaIndice != 2) {
                                                System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 2.");
                                                continue;
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 2.");
                                        }
                                        switch (OpcionesBusquedaIndice) {
                                            case 1:
                                                System.out.println("Buscando por indice fecha de nacimiento Bst");
                                                ObjTreeFunctions.searchClientBorndate(fechaNacimientoBuscar, BorndateBst);
                                                break;
                                            case 2:
                                                System.out.println("Buscando por indice fecha de nacimiento Avl");
                                                ObjTreeFunctions.searchClientBorndate(fechaNacimientoBuscar, BorndateAvl);
                                                break;
                                        }
                                        break;
                                    }
                                    if(Borndate_bst==true)
                                    {
                                        System.out.println("Buscando por indice fecha de nacimiento Bst");
                                        ObjTreeFunctions.searchClientBorndate(fechaNacimientoBuscar, BorndateBst);
                                    }
                                    if(Borndate_avl==true)
                                    {
                                        System.out.println("Buscando por indice fecha de nacimiento Avl");
                                        ObjTreeFunctions.searchClientBorndate(fechaNacimientoBuscar, BorndateAvl);
                                    }
                                    break;
                                case 8:
                                    if(Apodo_bst == false && Apodo_avl == false)
                                    {
                                        System.out.println("No se ha creado el indice de apodo");
                                        break;
                                    }
                                    System.out.println("Ingrese apodo del cliente a buscar: ");
                                    String apodoBuscar = sc.nextLine();
                                    if(Apodo_bst==true && Apodo_avl==true)
                                    {
                                        System.out.println("Por que indice desea buscar: ");
                                        System.out.println("1. bst");
                                        System.out.println("2. avl");
                                        System.out.println("Ingrese una opcion: ");
                                        int OpcionesBusquedaIndice = Integer.parseInt(sc.nextLine());
                                        try {
                                            if (OpcionesBusquedaIndice != 1 && OpcionesBusquedaIndice != 2) {
                                                System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 2.");
                                                continue;
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 2.");
                                        }
                                        switch (OpcionesBusquedaIndice) {
                                            case 1:
                                                System.out.println("Buscando por indice apodo Bst");
                                                ObjTreeFunctions.searchClientApodo(apodoBuscar, ApodoBst);
                                                break;
                                            case 2:
                                                System.out.println("Buscando por indice apodo Avl");
                                                ObjTreeFunctions.searchClientApodo(apodoBuscar, ApodoAvl);
                                                break;
                                        }
                                        break;
                                    }
                                    if(Apodo_bst==true)
                                    {
                                        System.out.println("Buscando por indice apodo Bst");
                                        ObjTreeFunctions.searchClientApodo(apodoBuscar, ApodoBst);
                                    }
                                    if(Apodo_avl==true)
                                    {
                                        System.out.println("Buscando por indice apodo Avl");
                                        ObjTreeFunctions.searchClientApodo(apodoBuscar, ApodoAvl);
                                    }
                                    break;
                                case 9:
                                    break;
                            }
                            break;
                        case 5:
                            ObjTreeFunctions.Preorder(IdBst);
                            break;
                        case 6:
                            break;
                    }
                    break;
                case 2:
                    //Menu de que tipo de indexacion necesita
                    System.out.println("Elija el indice que necesita");
                    System.out.println("1. Indice de id Bst");
                    System.out.println("2. Indice de id Avl");
                    System.out.println("3. Indice de nombre Bst");
                    System.out.println("4. Indice de nombre Avl");
                    System.out.println("5. Indice de apellido Bst");
                    System.out.println("6. Indice de apellido Avl");
                    System.out.println("7. Indice de telefono Bst");
                    System.out.println("8. Indice de telefono Avl");
                    System.out.println("9. Indice de email Bst");
                    System.out.println("10. Indice de email Avl");
                    System.out.println("11. Indice de direccion Bst");
                    System.out.println("12. Indice de direccion Avl");
                    System.out.println("13. Indice de fecha de nacimiento Bst");
                    System.out.println("14. Indice de fecha de nacimiento Avl");
                    System.out.println("15. Indice de apodo Bst");
                    System.out.println("16. Indice de apodo Avl");
                    System.out.println("17. Salir");
                    System.out.println("Ingrese una opcion: ");
                    int OpcionesIndexacion = 0;
                    try {
                        OpcionesIndexacion = Integer.parseInt(sc.nextLine());
                        if (OpcionesIndexacion != 1 && OpcionesIndexacion != 2 && OpcionesIndexacion != 3 && OpcionesIndexacion != 4 && OpcionesIndexacion != 5 && OpcionesIndexacion != 6 && OpcionesIndexacion != 7 && OpcionesIndexacion != 8 && OpcionesIndexacion != 9 && OpcionesIndexacion != 10 && OpcionesIndexacion != 11 && OpcionesIndexacion != 12 && OpcionesIndexacion != 13 && OpcionesIndexacion != 14 && OpcionesIndexacion != 15 && OpcionesIndexacion != 16 && OpcionesIndexacion != 17) {
                            System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 17.");
                            continue;
                        }


                    switch (OpcionesIndexacion) {
                        case 1:
                                Id_bst = true;
                                System.out.println("Se creo un indice bst para este parametro");
                            break;
                        case 2:
                                Id_avl = true;
                                System.out.println("Se creo un indice avl para este parametro");
                            break;
                        case 3:
                                Nombre_bst = true;
                                System.out.println("Se creo un indice bst para este parametro");
                            break;
                        case 4:
                                Nombre_avl = true;
                                System.out.println("Se creo un indice avl para este parametro");
                            break;
                        case 5:
                                Apellido_bst = true;
                                System.out.println("Se creo un indice bst para este parametro");
                            break;
                        case 6:
                                Apellido_avl = true;
                                System.out.println("Se creo un indice avl para este parametro");
                            break;
                        case 7:
                                Telefono_bst = true;
                                System.out.println("Se creo un indice bst para este parametro");
                            break;
                        case 8:
                                Telefono_avl = true;
                                System.out.println("Se creo un indice avl para este parametro");
                            break;
                        case 9:
                                Email_bst = true;
                                System.out.println("Se creo un indice bst para este parametro");
                            break;
                        case 10:
                                Email_avl = true;
                                System.out.println("Se creo un indice avl para este parametro");
                            break;
                        case 11:
                                Direccion_bst = true;
                                System.out.println("Se creo un indice bst para este parametro");
                            break;
                        case 12:
                                Direccion_avl = true;
                                System.out.println("Se creo un indice avl para este parametro");
                            break;
                        case 13:
                                Borndate_bst = true;
                                System.out.println("Se creo un indice bst para este parametro");
                            break;
                        case 14:
                                Borndate_avl = true;
                                System.out.println("Se creo un indice avl para este parametro");
                            break;
                        case 15:
                                Apodo_bst = true;
                                System.out.println("Se creo un indice bst para este parametro");
                            break;
                        case 16:
                                Apodo_avl = true;
                                System.out.println("Se creo un indice avl para este parametro");
                            break;
                        case 17:
                            break;
                    }
                    } catch (NumberFormatException e) {
                        System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 17.");
                    }
                    break;
            case 3:
                //Creamos las opciones para exportar o importar
                System.out.println("Elija la opcion que necesita");
                System.out.println("1. Exportar");
                System.out.println("2. Importar");
                System.out.println("3. Salir");
                System.out.println("Ingrese una opcion: ");
                int OpcionesExportarImportar = 0;
                try {
                    OpcionesExportarImportar = Integer.parseInt(sc.nextLine());
                    if (OpcionesExportarImportar != 1 && OpcionesExportarImportar != 2 && OpcionesExportarImportar != 3) {
                        System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 3.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Respuesta incorrecta, debe seleccionar un número del 1 al 3.");
                }
                switch (OpcionesExportarImportar) {
                    case 1:
                        //Actualizamos Indices
                        ActualizarIndices();
                        //Exportamos los archivos txt
                        ObjExport.exportarArbolTxt(Pathtxt, IdAvl, IdBst, NombreBst, ApellidoBst, TelefonoBst, EmailBst, DireccionBst, BorndateBst, ApodoBst, NombreAvl, ApellidoAvl, TelefonoAvl, EmailAvl, DireccionAvl, BorndateAvl, ApodoAvl, Id_bst, Nombre_bst, Apellido_bst, Telefono_bst, Email_bst, Direccion_bst, Borndate_bst, Apodo_bst, Id_avl, Nombre_avl, Apellido_avl, Telefono_avl, Email_avl, Direccion_avl, Borndate_avl, Apodo_avl);
                        ObjExport.exportarArbolCSV(Pathcsv+ "contactos.csv", IdBst);

                        break;
                    case 2:
                        //Pedimos al ususario qeu agregue la direccion del archivo csv
                        System.out.println("Ingrese la direccion del archivo csv: ");
                        String PathImport = sc.nextLine();
                        int CantidadClients = ObjImport.contarLineasSinEncabezado(PathImport);
                        for(int i = 1; i <= CantidadClients; i++) {
                            idGenerados = idGenerados+1;
                            IdBst =ObjTreeFunctions.addClient(ObjImport.ImportarCSV(PathImport, idGenerados, i), IdBst);
                        }
                        break;
                }

            }

        }
    }
    public static void ActualizarIndices()
    {
        //Creamos los indices que nos pidan y lo vamos actualizando.
        if(Nombre_bst == true)
            NombreBst = ObjIndicesBusqueda.NombreBst(ObjTreeFunctions.copyTree(IdBst), null);

        if(Id_avl==true)
            IdAvl = ObjIndicesBusqueda.IdAvl(ObjTreeFunctions.copyTree(IdBst), null);

        if(Apellido_bst == true)
            ApellidoBst = ObjIndicesBusqueda.ApellidoBst(ObjTreeFunctions.copyTree(IdBst), null);

        if(Telefono_bst == true)
            TelefonoBst = ObjIndicesBusqueda.TelefonoBst(ObjTreeFunctions.copyTree(IdBst), null);

        if(Email_bst == true)
            EmailBst = ObjIndicesBusqueda.EmailBst(ObjTreeFunctions.copyTree(IdBst), null);

        if(Direccion_bst == true)
            DireccionBst = ObjIndicesBusqueda.DireccionBst(ObjTreeFunctions.copyTree(IdBst), null);

        if(Borndate_bst == true)
            BorndateBst = ObjIndicesBusqueda.BorndateBst(ObjTreeFunctions.copyTree(IdBst), null);

        if(Apodo_bst == true)
            ApodoBst = ObjIndicesBusqueda.ApodoBst(ObjTreeFunctions.copyTree(IdBst), null);

        if(Nombre_avl == true)
            NombreAvl = ObjIndicesBusqueda.NombreAvl(ObjTreeFunctions.copyTree(IdBst), null);

        if(Apellido_avl == true)
            ApellidoAvl = ObjIndicesBusqueda.ApellidoAvl(ObjTreeFunctions.copyTree(IdBst), null);

        if(Telefono_avl == true)
            TelefonoAvl = ObjIndicesBusqueda.TelefonoAvl(ObjTreeFunctions.copyTree(IdBst), null);

        if(Email_avl == true)
            EmailAvl = ObjIndicesBusqueda.EmailAvl(ObjTreeFunctions.copyTree(IdBst), null);

        if(Direccion_avl == true)
            DireccionAvl = ObjIndicesBusqueda.DireccionAvl(ObjTreeFunctions.copyTree(IdBst), null);

        if(Borndate_avl == true)
            BorndateAvl = ObjIndicesBusqueda.BorndateAvl(ObjTreeFunctions.copyTree(IdBst), null);

        if(Apodo_avl == true)
            ApodoAvl = ObjIndicesBusqueda.ApodoAvl(ObjTreeFunctions.copyTree(IdBst), null);

    }
}