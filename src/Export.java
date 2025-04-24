import com.sun.source.tree.Tree;

public class Export {
    public void exportarArbolTxt(String path, TreeNode IdAvl ,TreeNode IdBst, TreeNode NameBst,TreeNode LastNameBst,TreeNode PhoneBst,TreeNode EmailBst,TreeNode AddressBst,TreeNode BorndateBst,TreeNode ApodoBst, TreeNode NameAvl,TreeNode LastNameAvl,TreeNode PhoneAvl,TreeNode EmailAvl,TreeNode AddressAvl,TreeNode BorndateAvl,TreeNode ApodoAvl, boolean id_Bst, boolean name_Bst, boolean lastName_Bst, boolean phone_Bst, boolean email_Bst, boolean address_Bst, boolean borndate_Bst, boolean apodo_Bst,boolean id_Avl,boolean name_Avl,boolean lastName_Avl,boolean phone_Avl,boolean email_Avl,boolean address_Avl,boolean borndate_Avl,boolean apodo_Avl){
        String Namefile;
        ToTXT ObjToTXT = new ToTXT();
        //Creamos el txt de bst id
        if(id_Bst == true) {
            Namefile = "id-bst.txt";
            ObjToTXT.convertTxt(IdBst, path, Namefile);
        }
        //Creamos el txt de id avl
        if(id_Avl == true) {
            Namefile = "id-avl.txt";
            ObjToTXT.convertTxt(IdAvl, path, Namefile);
        }
        //Creamos el txt de nombre bst
        if(name_Bst == true) {
            Namefile = "name-bst.txt";
            ObjToTXT.convertTxt(NameBst, path, Namefile);
        }
        //Creamos el txt de apellido bst
        if(lastName_Bst == true) {
            Namefile = "lastName-bst.txt";
            ObjToTXT.convertTxt(LastNameBst, path, Namefile);
        }
        //Creamos el txt de telefono bst
        if(phone_Bst == true) {
            Namefile = "phone-bst.txt";
            ObjToTXT.convertTxt(PhoneBst, path, Namefile);
        }
        //Creamos el txt de email bst
        if(email_Bst == true) {
            Namefile = "email-bst.txt";
            ObjToTXT.convertTxt(EmailBst, path, Namefile);
        }
        //Creamos el txt de direccion bst
        if(address_Bst == true) {
            Namefile = "address-bst.txt";
            ObjToTXT.convertTxt(AddressBst, path, Namefile);
        }
        //Creamos el txt de fecha de nacimiento bst
        if(borndate_Bst == true) {
            Namefile = "borndate-bst.txt";
            ObjToTXT.convertTxt(BorndateBst, path, Namefile);
        }
        //Creamos el txt de apodo bst
        if(apodo_Bst == true) {
            Namefile = "apodo-bst.txt";
            ObjToTXT.convertTxt(ApodoBst, path, Namefile);
        }
        //Creamos el txt de nombre avl
        if(name_Avl == true) {
            Namefile = "name-avl.txt";
            ObjToTXT.convertTxt(NameAvl, path, Namefile);
        }
        //Creamos el txt de apellido avl
        if(lastName_Avl == true) {
            Namefile = "lastName-avl.txt";
            ObjToTXT.convertTxt(LastNameAvl, path, Namefile);
        }
        //Creamos el txt de telefono avl
        if(phone_Avl == true) {
            Namefile = "phone-avl.txt";
            ObjToTXT.convertTxt(PhoneAvl, path, Namefile);
        }
        //Creamos el txt de email avl
        if(email_Avl == true) {
            Namefile = "email-avl.txt";
            ObjToTXT.convertTxt(EmailAvl, path, Namefile);
        }
        //Creamos el txt de direccion avl
        if(address_Avl == true) {
            Namefile = "address-avl.txt";
            ObjToTXT.convertTxt(AddressAvl, path, Namefile);
        }
        //Creamos el txt de fecha de nacimiento avl
        if(borndate_Avl == true) {
            Namefile = "borndate-avl.txt";
            ObjToTXT.convertTxt(BorndateAvl, path, Namefile);
        }
        //Creamos el txt de apodo avl
        if(apodo_Avl == true) {
            Namefile = "apodo-avl.txt";
            ObjToTXT.convertTxt(ApodoAvl, path, Namefile);
        }

    }


    public void exportarArbolCSV(String path, TreeNode root) {
        CSVFuctions ObjCSV = new CSVFuctions();
        ObjCSV.GenerarCSV(root, path);
    }
}
