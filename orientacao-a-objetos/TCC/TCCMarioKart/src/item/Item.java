package item;

import corredores.Corredor;

public interface Item {
    void vincularAoCorredor(Corredor corredor);
    void desvincularDoCorredor();
}
