package utils;

public enum Estatus {

    JKS_GENERADO("JKS generado satisfactoriamente"),
    JKS_ERROR("Error al generar JKS");

    private String mensaje;

    Estatus(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje(){
        return this.mensaje;
    }
}
