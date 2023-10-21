package seminars.fourth.myHttp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class WebServiceTest {

    @Test
    void webServiceTest () {
        HttpClient http = mock(HttpClient.class);
        WebService web = new WebService(http);

        String request = "www.e1.ru";

        when(http.get(request)).thenReturn("request " + request);

        assertThat(web.getHtmlPage(request)).isEqualTo("request " + request);

        verify(http, times(1)).get(request);
    }
}
