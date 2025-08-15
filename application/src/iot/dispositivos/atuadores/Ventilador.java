package iot.dispositivos.atuadores;
import iot.dispositivos.TipoDispositivo;

public class Ventilador implements Atuador {
    private final String id;
    private final String nome;
    private int velocidade = 0;
    private boolean ligado = false;

    public Ventilador(String id, String nome){ this.id = id; this.nome = nome; }

    @Override public String getId(){ return id; }
    @Override public String getNome(){ return nome; }
    @Override public TipoDispositivo getTipo(){ return TipoDispositivo.ATUADOR; }

    @Override
    public void executar(String acao, Object parametro){
        switch(acao){
            case "LIGAR": ligado = true; System.out.println("[Ventilador] Ligado."); break;
            case "DESLIGAR": ligado = false; System.out.println("[Ventilador] Desligado."); break;
            case "VELOCIDADE": 
                if(parametro instanceof Integer){
                    velocidade = (Integer) parametro;
                    System.out.println("[Ventilador] Velocidade ajustada para " + velocidade + ".");
                }
                break;
            default: System.out.println("[Ventilador] Ação desconhecida: " + acao);
        }
    }

    @Override public String[] acoesSuportadas(){ return new String[]{"LIGAR","DESLIGAR","VELOCIDADE"}; }
    public boolean isLigado(){ return ligado; }
    public int getVelocidade(){ return velocidade; }
}
