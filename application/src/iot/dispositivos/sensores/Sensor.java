package iot.dispositivos.sensores;
import iot.dispositivos.Dispositivo;
import iot.eventos.BarramentoEventos;

public interface Sensor extends Dispositivo {
    // Sensores publicam valores no barramento quando realizam leitura
    void ler(BarramentoEventos barramento);
    String getUnidade();
}
