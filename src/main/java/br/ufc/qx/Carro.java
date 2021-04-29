package br.ufc.qx;

public class Carro {

    public int getPassageiros() {
        return -1;
    }

    public int getCombustivel() {
        return -1;
    }

    public int getQuilometragem() {
        return -1;
    }

    public boolean embarcar() {
        return false;
    }

    public boolean desembarcar() {
        return false;
    }

    public boolean dirigir(int distancia) {
        return false;
    }

    public boolean abastecer(int quantidade) {
        return false;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "passageiros=" + -1 +
                ", combustivel=" + -1 +
                ", quilometragem=" + -1 +
                '}';
    }
}
