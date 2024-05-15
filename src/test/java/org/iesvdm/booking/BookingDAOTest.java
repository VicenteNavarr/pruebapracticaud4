package org.iesvdm.booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class BookingDAOTest {

    private BookingDAO bookingDAO;
    private Map<String, BookingRequest> bookings;

    @BeforeEach
    public void setup() {
        bookings = new HashMap<>();
        bookingDAO = new BookingDAO(bookings);
    }

    /**
     * Crea 2 peticiones de reserva (BookingRequest)
     * agrégalas a las reservas (bookings) con la que
     * construyes el objeto BookingDAO bajo testeo.
     * Comprueba que cuando invocas bookingDAO.getAllBookingRequest
     * obtienes las 2 peticiones.
     */
    @Test
    void  getAllBookingRequestsTest() {

        BookingRequest bookingRequest1 = new BookingRequest("1"
                , LocalDate.of(2024,6, 10)
                , LocalDate.of(2024, 6, 16)
                ,4
                ,false
        );

        BookingRequest bookingRequest2 = new BookingRequest("2"
                , LocalDate.of(2024,6, 10)
                , LocalDate.of(2024, 6, 16)
                ,4
                ,false
        );

            bookings.put("1", bookingRequest1);
            bookings.put("2", bookingRequest2);



            assertThat(bookingDAO.getAllBookingRequests()).isEqualTo(2);


    }

    /**
     * Crea 2 peticiones de reserva (BookingRequest)
     * agrégalas a las reservas mediante bookingDAO.save.
     * Comprueba que cuando invocas bookingDAO.getAllUUIDs
     * obtienes las UUIDs de las 2 peticiones guardadas.
     */
    @Test
    void getAllUUIDsTest() {

        BookingRequest bookingRequest1 = new BookingRequest("1"
                , LocalDate.of(2024,6, 10)
                , LocalDate.of(2024, 6, 16)
                ,4
                ,false
        );

        BookingRequest bookingRequest2 = new BookingRequest("2"
                , LocalDate.of(2024,6, 10)
                , LocalDate.of(2024, 6, 16)
                ,4
                ,false
        );


        String uuid1 = bookingDAO.save(bookingRequest1);
        String uuid2 = bookingDAO.save(bookingRequest2);

        assertThat(bookingDAO.getAllUUIDs()).hasSize(2);
        assertThat(bookingDAO.getAllUUIDs()).containsExactly(uuid1.toString(), uuid2.toString());





    }


    /**
     * Crea 2 peticiones de reserva (BookingRequest)
     * agrégalas a las reservas mediante bookingDAO.save.
     * Comprueba que cuando invocas bookingDAO.get con el UUID
     * obtienes las respectivas 2 peticiones guardadas.
     */
    @Test
    void getTest() {

        BookingRequest bookingRequest1 = new BookingRequest("1"
                , LocalDate.of(2024,6, 10)
                , LocalDate.of(2024, 6, 16)
                ,4
                ,false
        );

        BookingRequest bookingRequest2 = new BookingRequest("2"
                , LocalDate.of(2024,6, 10)
                , LocalDate.of(2024, 6, 16)
                ,4
                ,false
        );


        String uuid1 = bookingDAO.save(bookingRequest1);
        String uuid2 = bookingDAO.save(bookingRequest2);


        assertThat(bookingDAO.get(uuid1)).isEqualTo(bookingRequest1);
        assertThat(bookingDAO.get(uuid2)).isEqualTo(bookingRequest2);




    }

    /**
     * Crea 2 peticiones de reserva (BookingRequest)
     * agrégalas a las reservas mediante bookingDAO.save.
     * A continuación, borra la primera y comprueba
     * que se mantiene 1 reserva, la segunda guardada.
     */
    @Test
    void deleteTest() {

        BookingRequest bookingRequest1 = new BookingRequest("1"
                , LocalDate.of(2024,6, 10)
                , LocalDate.of(2024, 6, 16)
                ,4
                ,false
        );

        BookingRequest bookingRequest2 = new BookingRequest("2"
                , LocalDate.of(2024,6, 10)
                , LocalDate.of(2024, 6, 16)
                ,4
                ,false
        );


        String uuid1 = bookingDAO.save(bookingRequest1);
        String uuid2 = bookingDAO.save(bookingRequest2);

        bookingDAO.delete(uuid1);

        assertThat(bookingDAO.get(uuid1)).isNull();
        assertThat(bookingDAO.getAllUUIDs()).hasSize(1);

    }

    /**
     * Guarda 2 veces la misma petición de reserva (BookingRequest)
     * y demuestra que en la colección de bookings están repetidas
     * pero con UUID diferente
     *
     */
    @Test
    void saveTwiceSameBookingRequestTest() {

        BookingRequest bookingRequest1 = new BookingRequest("1"
                , LocalDate.of(2024,6, 10)
                , LocalDate.of(2024, 6, 16)
                ,4
                ,false
        );

        BookingRequest bookingRequest2 = new BookingRequest("1"
                , LocalDate.of(2024,6, 10)
                , LocalDate.of(2024, 6, 16)
                ,4
                ,false
        );

        String uuid1 = bookingDAO.save(bookingRequest1);
        String uuid2 = bookingDAO.save(bookingRequest2);

        assertThat(bookingDAO.get(uuid1.toString())).isNotEqualTo(bookingDAO.get(uuid2.toString()));

    }

}
