package iot.ui.decoradores;
import iot.ui.ComponenteUI;

public class TemaEscuro extends TemaDecorador {
    public TemaEscuro(ComponenteUI interno){ super(interno); }
    @Override public void renderizar(){
        System.out.println("[Tema: ESCURO]");
        interno.renderizar();
    }
}
