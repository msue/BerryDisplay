package receiver.models;

/**
 * Created by 1 on 06.02.14.
 */
public class NewsInfo {
    private String title;
    private String description;
    private String image;

    @Override
    public String toString() {
        return "NewsInfo{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public NewsInfo(String title, String description, String image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewsInfo)) return false;

        NewsInfo newsInfo = (NewsInfo) o;

        if (description != null ? !description.equals(newsInfo.description) : newsInfo.description != null)
            return false;
        if (image != null ? !image.equals(newsInfo.image) : newsInfo.image != null) return false;
        if (title != null ? !title.equals(newsInfo.title) : newsInfo.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }
}
