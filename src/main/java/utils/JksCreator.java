package utils;

import java.io.*;
import java.security.*;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JksCreator {
    private final static Logger LOGGER = Logger.getLogger("utils.JksCreator");

    public static void generateJKS(String certPath) throws GeneralSecurityException, IOException {
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(null, null);
        var cert = loadCertificate(new FileInputStream(certPath));//Carga el certificado de la ruta especificada, puede cargarse más de uno
        ks.setCertificateEntry("agente-cer-1", cert);//Agrega el certificado al keystore creado, puede agregarse más de uno
        try (FileOutputStream fos = new FileOutputStream("certificado.jks")) { //Asigna nombre al archivo generado, este contendrá los certificados cargados y agregados
            ks.store(fos, "".toCharArray()); //Genera el archivo jks y asigna una contraseña
            LOGGER.log(Level.INFO, Estatus.JKS_GENERADO.getMensaje());
        }catch (Exception e){
            LOGGER.log(Level.SEVERE, Estatus.JKS_ERROR.getMensaje());
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