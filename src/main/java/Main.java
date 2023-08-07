import utils.JksCreator;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class Main {
    public static void main(String[] args) throws GeneralSecurityException, IOException {
        JksCreator.generateJKS(args[0], args[1]); //Recibe la ruta de donde se ubique el certificado a cargar
    }
}