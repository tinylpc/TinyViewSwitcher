package tiny.switcherdemo;

/**
 * Created by tiny on 17/2/19.
 */
public class Scenery {
    private String url;
    private String content;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Scenery{" +
                "url='" + url + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
