package utils;

public enum Estatus {

    JKS_GENERADO("Almacén JKS generado satisfactoriamente"),
    JKS_ERROR("Error al generar almacén JKS");

    private String mensaje;

    Estatus(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje(){
        return this.mensaje;
    }
}
