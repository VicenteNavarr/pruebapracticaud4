package org.iesvdm.reservamesa;

//import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ReservaMesaTest {

    @Test
    void test1ReservaMesas() {

        ReservaMesa reservaMesa = new ReservaMesa();


        int numComensales = 0;
        int tamanioMesa = 4;
        int[] mesas = new int[10];
        int espacioLibre = tamanioMesa * 10;

        reservaMesa.setMesas(mesas);
        assertThat(reservaMesa.getMesas()).isEqualTo(mesas);

        reservaMesa.setTamanioMesa(tamanioMesa);
        assertThat(reservaMesa.getTamanioMesa()).isEqualTo(4);

        assertThat(numComensales).isLessThan(espacioLibre);


    }


    @Test
    void test1RellenarMesas() {

        ReservaMesa reservaMesa = new ReservaMesa();

        int tamanioMesa = 4;
        int[] mesas = {1, 0, 3};


        reservaMesa.setTamanioMesa(tamanioMesa);
        reservaMesa.setMesas(mesas);
        reservaMesa.rellenarMesas();
        assertThat(reservaMesa.getMesas()).isEqualTo(mesas);


    }


    @Test
    void test1BuscarPrimeraMesaVacia() {

        ReservaMesa reservaMesa = new ReservaMesa();

        int tamanioMesa = 4;
        int[] mesas = {1, 0, 3};


        reservaMesa.setTamanioMesa(tamanioMesa);
        reservaMesa.setMesas(mesas);

        reservaMesa.buscarPrimeraMesaVacia();
        assertThat(reservaMesa.buscarPrimeraMesaVacia()).isEqualTo(1);

    }

    @Test
    void test1BuscarMesaCompartir() {

        ReservaMesa reservaMesa = new ReservaMesa();

        int tamanioMesa = 4;
        int[] mesas = {1, 2, 3};


        reservaMesa.setTamanioMesa(tamanioMesa);
        reservaMesa.setMesas(mesas);


        assertThat(reservaMesa.buscarMesaParaCompartir(3)).isEqualTo(0);

    }

    @Test
    void test1ComensalesTotales() {

        ReservaMesa reservaMesa = new ReservaMesa();


        int tamanioMesa = 4;
        int[] mesas = new int[4];


        reservaMesa.setTamanioMesa(tamanioMesa);
        reservaMesa.setMesas(mesas);

        assertThat(reservaMesa.comensalesTotales()).isEqualTo(16);

    }

}