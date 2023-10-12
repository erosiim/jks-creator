import utils.JksCreator;
import utils.Texto;

import java.awt.*;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws GeneralSecurityException, IOException {
        //JksCreator.generateJKS("src/main/resources/medium.crt"); //Recibe la ruta de donde se ubique el certificado a cargar
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
        } catch (InputMismatchException e) {
            System.out.println(Texto.INDICACION_SOLO_NUMEROS);
        } finally {
            for (int i = 0; i < numeroCertificados; i++) {
                System.out.println(Texto.INDICACION_RUTA_CERTIFICADOS.getMensaje() + (i + 1) + ": ");
                certificadosMap.put(Texto.PREFIJO_CERTIFICADOS.getMensaje() + (i + 1), sc.next());
            }
            JksCreator.generateJKS(certificadosMap);
        }
    }
}
