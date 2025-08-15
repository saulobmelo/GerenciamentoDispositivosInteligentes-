package iot.comandos;
import iot.dispositivos.atuadores.Atuador;

public class ComandoLigar implements Comando {
    private final Atuador alvo;
    public ComandoLigar(Atuador alvo){ this.alvo = alvo; }
    @Override public void executar(){ alvo.executar("LIGAR", null); }
    @Override public String nome(){ return "Ligar(" + alvo.getNome() + ")"; }
}
