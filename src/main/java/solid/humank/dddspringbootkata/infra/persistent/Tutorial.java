package solid.humank.dddspringbootkata.infra.persistent;

import javax.persistence.*;

@Entity
@Table(name = "tutorials")
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "published")
    private boolean published;


    @Column(name = "description")
    private String description;

    public Tutorial() {

    }

    private String status = "NOT_COMPLETED";

    public Tutorial(String title, String description, boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }

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

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean isPublished) {
        this.published = isPublished;
    }

    public TutorialPublished publish() throws TutorialNotCompletedException {
        if (this.status.equals("COMPLETED")){
            this.published = true;
            return new TutorialPublished(this.title);
        }else{
            throw new TutorialNotCompletedException(this.title,this.published);
        }
    }
    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
    }

    public void setStatus(String status) {
        this.status = status;
    }
}