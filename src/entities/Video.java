package entities;

public final class Video extends Lesson {
    private String url;
    private final Integer seconds;

    public Video(String title, String url, Integer seconds) {
        super(title);
        this.url = url;
        this.seconds = seconds;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public Integer duration() {
        return seconds;
    }
}
