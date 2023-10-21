package seminars.fourth.myHttp;

public class WebService {

    HttpClient client;

    public WebService (HttpClient client) {
        this.client = client;
    }

    public String getHtmlPage (String url) {
        return client.get(url);
    }
}
