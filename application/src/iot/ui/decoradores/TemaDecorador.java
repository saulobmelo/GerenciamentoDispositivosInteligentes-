package iot.ui.decoradores;
import iot.ui.ComponenteUI;

// Decorator - adiciona comportamento de tema durante a renderização
public abstract class TemaDecorador implements ComponenteUI {
    protected final ComponenteUI interno;
    protected TemaDecorador(ComponenteUI interno){ this.interno = interno; }
}
