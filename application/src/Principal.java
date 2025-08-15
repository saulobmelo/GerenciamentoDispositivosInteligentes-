import iot.configuracao.GerenciadorConfiguracao;
import iot.fabricas.FabricaDispositivos;
import iot.fabricas.FabricaPadrao;
import iot.dispositivos.sensores.Sensor;
import iot.dispositivos.atuadores.Atuador;
import iot.eventos.BarramentoEventos;
import iot.registro.*;
import iot.estrategias.*;
import iot.aplicacao.MotorRegras;
import iot.ui.*;
import iot.ui.decoradores.*;

public class Principal {
    public static void main(String[] args) {
        // Singleton de configuração
        GerenciadorConfiguracao cfg = GerenciadorConfiguracao.getInstancia();
        System.out.println("== Sistema Modular de Dispositivos Inteligentes ==");

        // Abstract Factory
        FabricaDispositivos fabrica = new FabricaPadrao();
        Sensor temp = fabrica.criarSensorTemperatura("s1", "Temperatura da Sala");
        Atuador vent = fabrica.criarVentilador("a1", "Ventilador da Sala");

        // Strategy (seleção via configuração)
        int limite = cfg.getInteiro("temp.limite", 30);
        String estrategiaCfg = cfg.get("evento.estrategia");
        EstrategiaTratamentoEventos estrategia;
        switch (estrategiaCfg) {
            case "ATRASADA": estrategia = new EstrategiaAtrasada(vent, limite, cfg.getInteiro("atraso.ms", 1000)); break;
            case "VALIDADA": estrategia = new EstrategiaValidada(vent, limite); break;
            default: estrategia = new EstrategiaImediata(vent, limite);
        }

        // Strategy para formatação de log
        FormatadorLog fmt;
        switch (cfg.get("log.formato")) {
            case "JSON": fmt = new FormatadorLogJSON(); break;
            case "TEXTO": fmt = new FormatadorLogTexto(); break;
            default: fmt = new FormatadorLogCSV();
        }
        ServicoRegistro logger = new ServicoRegistro(fmt);

        // Observer
        BarramentoEventos barramento = new BarramentoEventos();
        MotorRegras motor = new MotorRegras(estrategia, logger);
        barramento.assinar(motor);

        // Composite + Decorator (UI)
        ComponenteUI ui = new Painel("Painel de Controle")
                .adicionar(new EtiquetaTexto("Sensor: " + temp.getNome()))
                .adicionar(new EtiquetaTexto("Atuador: " + vent.getNome()));
        String tema = cfg.get("ui.tema");
        if("claro".equalsIgnoreCase(tema)) ui = new TemaClaro(ui);
        else ui = new TemaEscuro(ui);
        ui.renderizar();

        // Simulação
        for(int i=0;i<5;i++){
            temp.ler(barramento);
            try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }

        // Troca de estratégia em tempo de execução (OCP)
        System.out.println("\n-- Alterando para estratégia VALIDADA --");
        motor.setEstrategia(new EstrategiaValidada(vent, limite));
        for(int i=0;i<5;i++){
            temp.ler(barramento);
            try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
    }
}