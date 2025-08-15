package iot.ui.decoradores;
import iot.ui.ComponenteUI;

public class TemaClaro extends TemaDecorador {
    public TemaClaro(ComponenteUI interno){ super(interno); }
    @Override public void renderizar(){
        System.out.println("[Tema: CLARO]");
        interno.renderizar();
    }
}
