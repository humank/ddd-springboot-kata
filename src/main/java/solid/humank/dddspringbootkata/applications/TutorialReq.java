package solid.humank.dddspringbootkata.applications;

public class TutorialReq {

    private long id;

    private String title;

    private boolean published;

    private String description;

    public TutorialReq() {

    }

    private String status;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPublished(boolean isPublished) {
        this.published = isPublished;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}