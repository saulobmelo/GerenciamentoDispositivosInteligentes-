package iot.configuracao;
import java.util.Properties;

// Singleton - global configuration manager (mantemos o nome do padrão em inglês)
public class GerenciadorConfiguracao {
    private static final GerenciadorConfiguracao INSTANCIA = new GerenciadorConfiguracao();
    private final Properties propriedades = new Properties();

    private GerenciadorConfiguracao() {
        // valores padrão
        propriedades.setProperty("ui.tema", "escuro");
        propriedades.setProperty("log.formato", "CSV"); // CSV | JSON | TEXTO
        propriedades.setProperty("evento.estrategia", "IMEDIATA"); // IMEDIATA | ATRASADA | VALIDADA
        propriedades.setProperty("atraso.ms", "1000");
        propriedades.setProperty("temp.limite", "30");
    }

    public static GerenciadorConfiguracao getInstancia() { return INSTANCIA; }
    public String get(String chave) { return propriedades.getProperty(chave); }
    public void set(String chave, String valor) { propriedades.setProperty(chave, valor); }

    public int getInteiro(String chave, int padrao) {
        try { return Integer.parseInt(propriedades.getProperty(chave)); }
        catch(Exception e){ return padrao; }
    }
}
