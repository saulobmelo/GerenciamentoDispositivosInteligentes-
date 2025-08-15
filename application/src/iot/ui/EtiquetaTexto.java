package iot.ui;
public class EtiquetaTexto implements ComponenteUI {
    private final String texto;
    public EtiquetaTexto(String texto){ this.texto = texto; }
    @Override public void renderizar(){ System.out.println("  - " + texto); }
}
