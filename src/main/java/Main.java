import utils.JksCreator;
import utils.Texto;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private final static Logger LOGGER = Logger.getLogger("Main");
    public static void main(String[] args) throws GeneralSecurityException, IOException {
       menu();
    }

    static void menu() throws GeneralSecurityException, IOException {
        int numeroCertificados = -1;
        Scanner sc = new Scanner(System.in);
        Map<String, String> certificadosMap = new HashMap<String, String>();
        System.out.println(Texto.APLICATIVO_INICIO.getMensaje());
        try {
            System.out.println(Texto.INDICACION_NUMERO_CERTIFICADOS.getMensaje());
            numeroCertificados = sc.nextInt();
            for (int i = 0; i < numeroCertificados; i++) {
                System.out.println(Texto.INDICACION_RUTA_CERTIFICADOS.getMensaje() + (i + 1) + ": ");
                certificadosMap.put(Texto.PREFIJO_CERTIFICADOS.getMensaje() + (i + 1), sc.next());
            }
            JksCreator.generateJKS(certificadosMap);
        } catch (InputMismatchException e) {
            LOGGER.log(Level.SEVERE, Texto.INDICACION_SOLO_NUMEROS.getMensaje());
            LOGGER.log(Level.SEVERE, Texto.JKS_ERROR.getMensaje());
        }
    }
}
