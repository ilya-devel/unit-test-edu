package seminars.fourth.message;


import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class NotificationServiceTest {
    @Test
    void messageServiceTest() {
        MessageService msgServ = mock(MessageService.class);
        NotificationService notifServ = new NotificationService(msgServ);

        String msg = "Hello!";
        String name = "Ilya";

        msgServ.sendMessage(msg, name);

        verify(msgServ, times(1)).sendMessage(msg, name);
    }
}