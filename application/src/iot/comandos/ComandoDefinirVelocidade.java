package iot.comandos;
import iot.dispositivos.atuadores.Atuador;

public class ComandoDefinirVelocidade implements Comando {
    private final Atuador alvo;
    private final int velocidade;
    public ComandoDefinirVelocidade(Atuador alvo, int velocidade){ this.alvo = alvo; this.velocidade = velocidade; }
    @Override public void executar(){ alvo.executar("VELOCIDADE", velocidade); }
    @Override public String nome(){ return "DefinirVelocidade(" + alvo.getNome() + "," + velocidade + ")"; }
}
