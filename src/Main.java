
    import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//Funciona para imprimir en consola con intelliji ya que que generalmente si se usa el de java retorna null
        //Variables globales
        boolean Id_avl = false;
        boolean Id_bst = false;
        boolean Nombre_avl = false;
        boolean Nombre_bst = false;
        boolean Apellido_avl = false;
        boolean Apellido_bst = false;
        boolean Telefono_avl = false;
        boolean Telefono_bst = false;
        boolean Email_avl = false;
        boolean Email_bst = false;
        boolean Direccion_avl = false;
        boolean Direccion_bst = false;
        boolean Borndate_avl = false;
        boolean Borndate_bst = false;
        boolean Apodo_avl = false;
        boolean Apodo_bst = false;

        //Variables de arboles\
        TreeNode IdBst  = null;
        TreeNode IdAvl = null;
        TreeNode NombreAvl = null;
        TreeNode ApellidoAvl = null;
        TreeNode TelefonoAvl = null;
        TreeNode EmailAvl = null;
        TreeNode DireccionAvl = null;
        TreeNode BorndateAvl = null;
        TreeNode ApodoAvl = null;
        TreeNode NombreBst = null;
        TreeNode ApellidoBst = null;
        TreeNode TelefonoBst = null;
        TreeNode EmailBst = null;
        TreeNode DireccionBst = null;
        TreeNode BorndateBst = null;
        TreeNode ApodoBst = null;

        //Directorios
        String Pathtxt = "C:\\Users\\conra\\OneDrive\\Documentos\\Poryecto Estructura de datos\\";
        String Pathcsv = "C:\\Users\\conra\\OneDrive\\Documentos\\Poryecto Estructura de datos\\";

        //Variables de arbol
        TreeFuctions ObjTreeFunctions = new TreeFuctions();
        IndicesBusqueda ObjIndicesBusqueda = new IndicesBusqueda();

        //Objeto de exportacion
        Export ObjExport = new Export();

        //Agregamos clientes
        int idGenerados = 0;
        int OpcionesGeneral = 0;
        while(OpcionesGeneral != 4)
        {
            //desplegamos menu
            System.out.println("1. Gestion de contactos");
            System.out.println("2. Indices y busqueda");
            System.out.println("3. Exportacion e importacion de contactos");
            System.out.println("4. Salir");
            System.out.println("Ingrese una opcion: ");
            OpcionesGeneral = Integer.parseInt(sc.nextLine());
            switch(OpcionesGeneral) {
                case 1:
                    int OpcionesContactos = 0;
                    System.out.println("1. Agregar cliente");
                    System.out.println("2. Eliminar cliente");
                    System.out.println("3. Modificar cliente");
                    System.out.println("4. Buscar contacto");
                    System.out.println("5. Ver todos los contactos");
                    System.out.println("6. Salir");
                    System.out.println("Ingrese una opcion: ");
                    OpcionesContactos = Integer.parseInt(sc.nextLine());
                    switch (OpcionesContactos) {
                        case 1:
                            idGenerados = idGenerados+1;
                            System.out.println("Ingrese nombre: ");
                            String nombre = sc.nextLine();
                            System.out.println("Ingrese apellido: ");
                            String apellido = sc.nextLine();
                            System.out.println("Ingrese telefono: ");
                            String telefono = sc.nextLine();
                            System.out.println("Ingrese email: ");
                            String email = sc.nextLine();
                            System.out.println("Ingrese direccion: ");
                            String direccion = sc.nextLine();
                            System.out.println("Ingrese fecha de nacimiento: ");
                            String fechaNacimiento = sc.nextLine();
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
                            //Actualizamos los arboles
                            IdAvl = null;
                            IdAvl = ObjTreeFunctions.copyTree(IdBst);
                            IdAvl = ObjIndicesBusqueda.balanceBST(IdAvl);
                            //Actualizamos arboles de Nombre
                            NombreBst = null;
                            NombreBst = ObjIndicesBusqueda.NombreBst(ObjTreeFunctions.copyTree(IdBst), NombreBst);
                            NombreAvl = null;
                            NombreAvl = ObjTreeFunctions.copyTree(NombreBst);
                            NombreAvl = ObjIndicesBusqueda.balanceBST(NombreAvl);
                            //Actualizamos arboles de Apellido
                            ApellidoBst = null;
                            ApellidoBst = ObjIndicesBusqueda.ApellidoBst(ObjTreeFunctions.copyTree(IdBst), ApellidoBst);
                            ApellidoAvl = null;
                            ApellidoAvl = ObjTreeFunctions.copyTree(ApellidoBst);
                            ApellidoAvl = ObjIndicesBusqueda.balanceBST(ApellidoAvl);
                            //Actualizamos arboles de Telefono
                            TelefonoBst = null;
                            TelefonoBst = ObjIndicesBusqueda.TelefonoBst(ObjTreeFunctions.copyTree(IdBst), TelefonoBst);
                            TelefonoAvl = null;
                            TelefonoAvl = ObjTreeFunctions.copyTree(TelefonoBst);
                            TelefonoAvl = ObjIndicesBusqueda.balanceBST(TelefonoAvl);
                            //Actualizamos arboles de Email
                            EmailBst = null;
                            EmailBst = ObjIndicesBusqueda.EmailBst(ObjTreeFunctions.copyTree(IdBst), EmailBst);
                            EmailAvl = null;
                            EmailAvl = ObjTreeFunctions.copyTree(EmailBst);
                            EmailAvl = ObjIndicesBusqueda.balanceBST(EmailAvl);
                            //Actualizamos arboles de Direccion
                            DireccionBst = null;
                            DireccionBst = ObjIndicesBusqueda.DireccionBst(ObjTreeFunctions.copyTree(IdBst), DireccionBst);
                            DireccionAvl = null;
                            DireccionAvl = ObjTreeFunctions.copyTree(DireccionBst);
                            DireccionAvl = ObjIndicesBusqueda.balanceBST(DireccionAvl);
                            //Actualizamos arboles de Borndate
                            BorndateBst = null;
                            BorndateBst = ObjIndicesBusqueda.BorndateBst(ObjTreeFunctions.copyTree(IdBst), BorndateBst);
                            BorndateAvl = null;
                            BorndateAvl = ObjTreeFunctions.copyTree(BorndateBst);
                            BorndateAvl = ObjIndicesBusqueda.balanceBST(BorndateAvl);
                            //Actualizamos arboles de Apodo
                            ApodoBst = null;
                            ApodoBst = ObjIndicesBusqueda.ApodoBst(ObjTreeFunctions.copyTree(IdBst), ApodoBst);
                            ApodoAvl = null;
                            ApodoAvl = ObjTreeFunctions.copyTree(ApodoBst);
                            ApodoAvl = ObjIndicesBusqueda.balanceBST(ApodoAvl);

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
                            switch (OpcionesBusqueda) {
                                case 1:
                                    System.out.println("Ingrese id del cliente a buscar: ");
                                    int idBuscar = Integer.parseInt(sc.nextLine());
                                    ObjTreeFunctions.searchClientId(idBuscar, IdBst);
                                    break;
                                case 2:
                                    System.out.println("Ingrese nombre del cliente a buscar: ");
                                    String nombreBuscar = sc.nextLine();
                                    ObjTreeFunctions.searchClientNombre(nombreBuscar,NombreBst);
                                    break;
                                case 3:
                                    System.out.println("Ingrese apellido del cliente a buscar: ");
                                    String apellidoBuscar = sc.nextLine();
                                    ObjTreeFunctions.searchClientApellido(apellidoBuscar, ApellidoBst);
                                    break;
                                case 4:
                                    System.out.println("Ingrese telefono del cliente a buscar: ");
                                    String telefonoBuscar = sc.nextLine();
                                    ObjTreeFunctions.searchClientTelefono(telefonoBuscar, TelefonoBst);
                                    break;
                                case 5:
                                    System.out.println("Ingrese email del cliente a buscar: ");
                                    String emailBuscar = sc.nextLine();
                                    ObjTreeFunctions.searchClientEmail(emailBuscar, EmailBst);
                                    break;
                                case 6:
                                    System.out.println("Ingrese direccion del cliente a buscar: ");
                                    String direccionBuscar = sc.nextLine();
                                    ObjTreeFunctions.searchClientDireccion(direccionBuscar, DireccionBst);
                                    break;
                                case 7:
                                    System.out.println("Ingrese fecha de nacimiento del cliente a buscar: ");
                                    String fechaNacimientoBuscar = sc.nextLine();
                                    ObjTreeFunctions.searchClientBorndate(fechaNacimientoBuscar, BorndateBst);
                                    break;
                                case 8:
                                    System.out.println("Ingrese apodo del cliente a buscar: ");
                                    String apodoBuscar = sc.nextLine();
                                    ObjTreeFunctions.searchClientApodo(apodoBuscar, ApodoBst);
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
                    //Actualizamos arboles de id
                    IdAvl = null;
                    IdAvl = ObjTreeFunctions.copyTree(IdBst);
                    IdAvl = ObjIndicesBusqueda.balanceBST(IdAvl);
                    //Actualizamos arboles de Nombre
                    NombreBst = null;
                    NombreBst = ObjIndicesBusqueda.NombreBst(ObjTreeFunctions.copyTree(IdBst), NombreBst);
                    NombreAvl = null;
                    NombreAvl = ObjTreeFunctions.copyTree(NombreBst);
                    NombreAvl = ObjIndicesBusqueda.balanceBST(NombreAvl);
                    //Actualizamos arboles de Apellido
                    ApellidoBst = null;
                    ApellidoBst = ObjIndicesBusqueda.ApellidoBst(ObjTreeFunctions.copyTree(IdBst), ApellidoBst);
                    ApellidoAvl = null;
                    ApellidoAvl = ObjTreeFunctions.copyTree(ApellidoBst);
                    ApellidoAvl = ObjIndicesBusqueda.balanceBST(ApellidoAvl);
                    //Actualizamos arboles de Telefono
                    TelefonoBst = null;
                    TelefonoBst = ObjIndicesBusqueda.TelefonoBst(ObjTreeFunctions.copyTree(IdBst), TelefonoBst);
                    TelefonoAvl = null;
                    TelefonoAvl = ObjTreeFunctions.copyTree(TelefonoBst);
                    TelefonoAvl = ObjIndicesBusqueda.balanceBST(TelefonoAvl);
                    //Actualizamos arboles de Email
                    EmailBst = null;
                    EmailBst = ObjIndicesBusqueda.EmailBst(ObjTreeFunctions.copyTree(IdBst), EmailBst);
                    EmailAvl = null;
                    EmailAvl = ObjTreeFunctions.copyTree(EmailBst);
                    EmailAvl = ObjIndicesBusqueda.balanceBST(EmailAvl);
                    //Actualizamos arboles de Direccion
                    DireccionBst = null;
                    DireccionBst = ObjIndicesBusqueda.DireccionBst(ObjTreeFunctions.copyTree(IdBst), DireccionBst);
                    DireccionAvl = null;
                    DireccionAvl = ObjTreeFunctions.copyTree(DireccionBst);
                    DireccionAvl = ObjIndicesBusqueda.balanceBST(DireccionAvl);
                    //Actualizamos arboles de Borndate
                    BorndateBst = null;
                    BorndateBst = ObjIndicesBusqueda.BorndateBst(ObjTreeFunctions.copyTree(IdBst), BorndateBst);
                    BorndateAvl = null;
                    BorndateAvl = ObjTreeFunctions.copyTree(BorndateBst);
                    BorndateAvl = ObjIndicesBusqueda.balanceBST(BorndateAvl);
                    //Actualizamos arboles de Apodo
                    ApodoBst = null;
                    ApodoBst = ObjIndicesBusqueda.ApodoBst(ObjTreeFunctions.copyTree(IdBst), ApodoBst);
                    ApodoAvl = null;
                    ApodoAvl = ObjTreeFunctions.copyTree(ApodoBst);
                    ApodoAvl = ObjIndicesBusqueda.balanceBST(ApodoAvl);

                    //Menu de que tipo ded indexacion necesita
                    System.out.println("Elija el indice qeu necesita");
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
                    int OpcionesIndexacion = Integer.parseInt(sc.nextLine());
                    switch (OpcionesIndexacion) {
                        case 1:
                            Id_bst = true;
                            break;
                        case 2:
                            Id_avl = true;
                            break;
                        case 3:
                            Nombre_bst = true;
                            break;
                        case 4:
                            Nombre_avl = true;
                            break;
                        case 5:
                            Apellido_bst = true;
                            break;
                        case 6:
                            Apellido_avl = true;
                            break;
                        case 7:
                            Telefono_bst = true;
                            break;
                        case 8:
                            Telefono_avl = true;
                            break;
                        case 9:
                            Email_bst = true;
                            break;
                        case 10:
                            Email_avl = true;
                            break;
                        case 11:
                            Direccion_bst = true;
                            break;
                        case 12:
                            Direccion_avl = true;
                            break;
                        case 13:
                            Borndate_bst = true;
                            break;
                        case 14:
                            Borndate_avl = true;
                            break;
                        case 15:
                            Apodo_bst = true;
                            break;
                        case 16:
                            Apodo_avl = true;
                            break;
                        case 17:
                            break;
                    }
                    break;
            case 3:
                //Creamos las opciones para exportar o importar
                System.out.println("Elija la opcion que necesita");
                System.out.println("1. Exportar");
                System.out.println("2. Importar");
                System.out.println("3. Salir");
                System.out.println("Ingrese una opcion: ");
                int OpcionesExportarImportar = Integer.parseInt(sc.nextLine());
                switch (OpcionesExportarImportar) {
                    case 1:
                        //Actualizamos los arboles
                        IdAvl = null;
                        IdAvl = ObjTreeFunctions.copyTree(IdBst);
                        IdAvl = ObjIndicesBusqueda.balanceBST(IdAvl);
                        //Actualizamos arboles de Nombre
                        NombreBst = null;
                        NombreBst = ObjIndicesBusqueda.NombreBst(ObjTreeFunctions.copyTree(IdBst), NombreBst);
                        NombreAvl = null;
                        NombreAvl = ObjTreeFunctions.copyTree(NombreBst);
                        NombreAvl = ObjIndicesBusqueda.balanceBST(NombreAvl);
                        //Actualizamos arboles de Apellido
                        ApellidoBst = null;
                        ApellidoBst = ObjIndicesBusqueda.ApellidoBst(ObjTreeFunctions.copyTree(IdBst), ApellidoBst);
                        ApellidoAvl = null;
                        ApellidoAvl = ObjTreeFunctions.copyTree(ApellidoBst);
                        ApellidoAvl = ObjIndicesBusqueda.balanceBST(ApellidoAvl);
                        //Actualizamos arboles de Telefono
                        TelefonoBst = null;
                        TelefonoBst = ObjIndicesBusqueda.TelefonoBst(ObjTreeFunctions.copyTree(IdBst), TelefonoBst);
                        TelefonoAvl = null;
                        TelefonoAvl = ObjTreeFunctions.copyTree(TelefonoBst);
                        TelefonoAvl = ObjIndicesBusqueda.balanceBST(TelefonoAvl);
                        //Actualizamos arboles de Email
                        EmailBst = null;
                        EmailBst = ObjIndicesBusqueda.EmailBst(ObjTreeFunctions.copyTree(IdBst), EmailBst);
                        EmailAvl = null;
                        EmailAvl = ObjTreeFunctions.copyTree(EmailBst);
                        EmailAvl = ObjIndicesBusqueda.balanceBST(EmailAvl);
                        //Actualizamos arboles de Direccion
                        DireccionBst = null;
                        DireccionBst = ObjIndicesBusqueda.DireccionBst(ObjTreeFunctions.copyTree(IdBst), DireccionBst);
                        DireccionAvl = null;
                        DireccionAvl = ObjTreeFunctions.copyTree(DireccionBst);
                        DireccionAvl = ObjIndicesBusqueda.balanceBST(DireccionAvl);
                        //Actualizamos arboles de Borndate
                        BorndateBst = null;
                        BorndateBst = ObjIndicesBusqueda.BorndateBst(ObjTreeFunctions.copyTree(IdBst), BorndateBst);
                        BorndateAvl = null;
                        BorndateAvl = ObjTreeFunctions.copyTree(BorndateBst);
                        BorndateAvl = ObjIndicesBusqueda.balanceBST(BorndateAvl);
                        //Actualizamos arboles de Apodo
                        ApodoBst = null;
                        ApodoBst = ObjIndicesBusqueda.ApodoBst(ObjTreeFunctions.copyTree(IdBst), ApodoBst);
                        ApodoAvl = null;
                        ApodoAvl = ObjTreeFunctions.copyTree(ApodoBst);
                        ApodoAvl = ObjIndicesBusqueda.balanceBST(ApodoAvl);

                        //Exportamos los archivos txt
                        ObjExport.exportarArbolTxt(Pathtxt, IdAvl, IdBst, NombreBst, ApellidoBst, TelefonoBst, EmailBst, DireccionBst, BorndateBst, ApodoBst, Id_avl, Id_bst, Nombre_avl, Nombre_bst, Apellido_avl, Apellido_bst, Telefono_avl, Telefono_bst, Email_avl, Email_bst, Direccion_avl, Direccion_bst, Borndate_avl, Borndate_bst, Apodo_avl, Apodo_bst);
                        //Exportamos el archivo CSV
                        ObjExport.exportarArbolCSV(Pathcsv+ "contactos.csv", IdBst);

                        break;
                }
                break;
                }

        }
    }
}