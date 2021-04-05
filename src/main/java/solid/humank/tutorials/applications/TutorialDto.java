package solid.humank.tutorials.applications;

public class TutorialDto {

    private long id;

    private String title;

    private boolean published;

    private String description;

    private String status;

    public TutorialDto(long id, String title, boolean published, String description, String status) {
        this.id = id;
        this.title = title;
        this.published = published;
        this.description = description;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
