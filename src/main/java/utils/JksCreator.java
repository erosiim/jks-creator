package utils;

import java.io.*;
import java.security.*;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JksCreator {
    private final static Logger LOGGER = Logger.getLogger("utils.JksCreator");

    public static void generateJKS(Map<String, String> certificadosMap) throws GeneralSecurityException, IOException {
        KeyStore ks = createEmptyKeyStore();
        certificadosMap.forEach((key, value) -> {
            try {
                var cert = loadCertificate(new FileInputStream(value));//Carga el certificado de la ruta especificada, puede cargarse más de uno
                ks.setCertificateEntry(key, cert);//Agrega el certificado al keystore creado y se le asigna un alias, puede agregarse más de uno
            } catch (GeneralSecurityException | FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        try (FileOutputStream fos = new FileOutputStream("certificado.jks")) { //Asigna nombre al archivo generado, este contendrá los certificados cargados y agregados
            ks.store(fos, "".toCharArray()); //Genera el archivo jks y asigna una contraseña
            LOGGER.log(Level.INFO, Texto.JKS_GENERADO.getMensaje());
        }catch (Exception e){
            LOGGER.log(Level.SEVERE, Texto.JKS_ERROR.getMensaje());
        }
    }
    private static void generateJKS(String certPath) throws GeneralSecurityException, IOException {
        KeyStore ks = createEmptyKeyStore();
        var cert = loadCertificate(new FileInputStream(certPath));//Carga el certificado de la ruta especificada, puede cargarse más de uno
        ks.setCertificateEntry("mi-cer-1", cert);//Agrega el certificado al keystore creado y se le asigna un alias, puede agregarse más de uno
        try (FileOutputStream fos = new FileOutputStream("certificado.jks")) { //Asigna nombre al archivo generado, este contendrá los certificados cargados y agregados
            ks.store(fos, "".toCharArray()); //Genera el archivo jks y asigna una contraseña
            LOGGER.log(Level.INFO, Texto.JKS_GENERADO.getMensaje());
        }catch (Exception e){
            LOGGER.log(Level.SEVERE, Texto.JKS_ERROR.getMensaje());
        }
    }



    private static KeyStore createEmptyKeyStore() throws IOException, GeneralSecurityException {
        KeyStore keyStore = KeyStore.getInstance("JKS");//Genera un keystore de tipo JKS
        keyStore.load(null,null);
        return keyStore;
    }

    private static X509Certificate loadCertificate(InputStream publicCertIn) throws GeneralSecurityException {
        CertificateFactory factory = CertificateFactory.getInstance("X.509");
        return (X509Certificate)factory.generateCertificate(publicCertIn);
    }

}