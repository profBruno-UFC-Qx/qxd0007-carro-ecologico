import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class TestCarro {

    private Carro carro;

    @BeforeEach
    public void criaCar() {
        carro = new Carro();
    }

    @Test
    public void testInicializacao() {
        assertEquals(0, carro.getPassageiros(),
                "Ao inicializar um carro o numero de passageiros deve ser zero");
        assertEquals(0, carro.getCombustivel(),
                "Ao inicializar um carro a quantidade de combustivel deve ser zero");
    }

    @Test
    public void testEmbarque() {
        assertTrue(carro.embarcar(), "Como o carro estava vazio, deve ser possivel embarcar");
        assertEquals(1, carro.getPassageiros());

    }

    @Test
    public void testEmbarqueEmCarroLotado() {
        carro.embarcar();
        carro.embarcar();
        assertFalse(carro.embarcar(), "Como o carro estava cheio (2 passageiros), nao deve ser possivel embarcar");
        assertEquals(2, carro.getPassageiros());
    }

    @Test
    public void testDesembarqueEmCarroVazio() {
        assertFalse(carro.desembarcar(), "Como o carro estava vazio, nao deve ser possivel desembarcar");
        assertEquals(0, carro.getPassageiros());
    }

    @Test
    public void testDesembarque() {
        carro.embarcar();
        assertTrue(carro.desembarcar(), "Como o carro nao estava vazio, deve ser possivel desembarcar");
        carro.embarcar();
        carro.embarcar();
        assertTrue(carro.desembarcar(), "Como o carro nao estava vazio, deve ser possivel desembarcar");
        assertTrue(carro.desembarcar(), "Como o carro nao estava vazio, deve ser possivel desembarcar");
    }

    @Test
    public void testAbastecerComValorInvalido() {
        assertFalse(carro.abastecer(-30), "A quantidade de combustivel deve ser uma valor positivo");
        assertEquals(0, carro.getCombustivel());
    }

    @Test
    public void testAbastecerSemCompletarTanque() {
        assertTrue(carro.abastecer(86));
        assertEquals(86, carro.getCombustivel(),
                "O carro foi abastecido com 86 litros e estava com tanque vazio");
    }

    @Test
    public void testAbastecerEstragandoCombustivel() {
        assertTrue(carro.abastecer(186));
        assertEquals(100, carro.getCombustivel(),
                "O valor de combustivel desejado excede o tamanho do tanque. Logo o tanque fica cheio");
    }

    @Test
    public void testDirigirCarroVazio() {
        assertFalse(carro.dirigir(10), "O carro está vazio, logo nao e possivel dirigi-lo");
    }

    @Test
    public void testDirigirCurtaDistancia() {
        carro.embarcar();
        carro.abastecer(32);
        assertTrue(carro.dirigir(10));
        assertEquals(22, carro.getCombustivel(),
                "O carro tinha 32 litros e percorreu uma distancia de 10 km");
        assertEquals(10, carro.getQuilometragem(), "O carro percorreu 10 km");
    }

    @Test
    public void testDirigirLongaDistancia() {
        carro.embarcar();
        carro.abastecer(32);
        assertTrue(carro.dirigir(10));
        carro.embarcar();
        carro.abastecer(80);
        assertFalse(carro.dirigir(120));
        assertEquals(0, carro.getCombustivel(),
                "A distancia percorrida consumiu todo o combustivel");
        assertEquals(110, carro.getQuilometragem(), "O carro percorreu 112 km");
    }


}