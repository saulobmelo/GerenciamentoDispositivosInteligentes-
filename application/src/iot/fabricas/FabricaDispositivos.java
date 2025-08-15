package iot.fabricas;
import iot.dispositivos.atuadores.Atuador;
import iot.dispositivos.sensores.Sensor;

// Abstract Factory - famílias de objetos relacionados (sensores, atuadores)
public interface FabricaDispositivos {
    Sensor criarSensorTemperatura(String id, String nome);
    Atuador criarVentilador(String id, String nome);
}
