import java.util.HashMap;
import java.util.Map;

public class ChamadaDosAlunos {

    private Map<Integer, String> listaDeChamada;

    public ChamadaDosAlunos() {
        this.listaDeChamada = new HashMap<>();

        this.listaDeChamada.put(1, "Kakaroto");
        this.listaDeChamada.put(2, "Vegetta");
    }

    public Map<Integer, String> getListaDeChamada() {
        return listaDeChamada;
    }
}










