package iot.dispositivos.sensores;
import iot.dispositivos.TipoDispositivo;
import iot.eventos.Evento;
import iot.eventos.BarramentoEventos;
import java.util.Random;

public class SensorTemperatura implements Sensor {
    private final String id;
    private final String nome;
    private final Random aleatorio = new Random();

    public SensorTemperatura(String id, String nome){
        this.id = id; this.nome = nome;
    }

    @Override public String getId(){ return id; }
    @Override public String getNome(){ return nome; }
    @Override public TipoDispositivo getTipo(){ return TipoDispositivo.SENSOR; }
    @Override public String getUnidade(){ return "°C"; }

    @Override
    public void ler(BarramentoEventos barramento) {
        // simula temperatura entre 20 e 40
        int valor = 20 + aleatorio.nextInt(21);
        barramento.publicar(new Evento("temperatura", this, valor));
    }
}
