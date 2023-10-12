package utils;

public enum Texto {

    APLICATIVO_INICIO("### GENERADOR DE JKS ###"),
    INDICACION_NUMERO_CERTIFICADOS("Ingrese la cantidad de certificados a incluir en este JKS: "),
    INDICACION_RUTA_CERTIFICADOS("Ingrese la ruta completa de donde se ubica el certificado "),
    PREFIJO_CERTIFICADOS("cert "),
    INDICACION_SOLO_NUMEROS("Debe ingresar sólo números"),
    JKS_GENERADO("JKS generado satisfactoriamente"),
    JKS_ERROR("Error al generar JKS");

    private String mensaje;

    Texto(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje(){
        return this.mensaje;
    }
}
