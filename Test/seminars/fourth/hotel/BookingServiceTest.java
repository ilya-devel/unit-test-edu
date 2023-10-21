package seminars.fourth.hotel;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class BookingServiceTest {

    @Test
    void testBookingService() {
        HotelService service = mock(HotelService.class);
        BookingService booking = new BookingService(service);

        when(service.isRoomAvailable(10)).thenReturn(true);
        when(service.isRoomAvailable(990)).thenReturn(true);
        when(service.isRoomAvailable(11)).thenReturn(false);

        assertThat(booking.bookRoom(10)).isTrue();
        assertThat(booking.bookRoom(11)).isFalse();
        assertThat(booking.bookRoom(990)).isTrue();

        verify(service, times(1)).isRoomAvailable(10);
        verify(service, times(1)).isRoomAvailable(990);
        verify(service, times(1)).isRoomAvailable(11);

    }

}