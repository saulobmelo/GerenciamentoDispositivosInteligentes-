package iot.eventos;
import iot.dispositivos.Dispositivo;

public class Evento {
    private final String tipo;
    private final Dispositivo origem;
    private final Object carga;
    private final long timestamp = System.currentTimeMillis();

    public Evento(String tipo, Dispositivo origem, Object carga){
        this.tipo = tipo; this.origem = origem; this.carga = carga;
    }
    public String getTipo(){ return tipo; }
    public Dispositivo getOrigem(){ return origem; }
    public Object getCarga(){ return carga; }
    public long getTimestamp(){ return timestamp; }
}
