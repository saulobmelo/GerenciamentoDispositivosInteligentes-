package iot.ui;
import java.util.ArrayList;
import java.util.List;

// Composite - Painel contém vários componentes
public class Painel implements ComponenteUI {
    private final String titulo;
    private final List<ComponenteUI> filhos = new ArrayList<>();

    public Painel(String titulo){ this.titulo = titulo; }
    public Painel adicionar(ComponenteUI c){ filhos.add(c); return this; }

    @Override public void renderizar(){
        System.out.println("[Painel] " + titulo);
        for(ComponenteUI c: filhos) c.renderizar();
    }
}
