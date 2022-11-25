package fr.utbm.dvdstore.domain.entity;

public class Movie implements java.io.Serializable {

    private Integer id;
    private String title;
    private Integer copies;
    private String movieType;
    private Integer mainActorId;

    public Movie() {

    }

    public Movie(String title, Integer copies, String movieType) {
        this.title = title;
        this.copies = copies;
        this.movieType = movieType;
    }

    public Movie(Integer id, String title, int copies, String movieType) {
        this.id = id;
        this.title = title;
        this.copies = copies;
        this.movieType = movieType;
    }

    public Movie(Integer id, String title, int copies, String movieType, Integer mainActorId) {
        this.id = id;
        this.title = title;
        this.copies = copies;
        this.movieType = movieType;
        this.mainActorId = mainActorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMainActorId() {
        return mainActorId;
    }

    public void setMainActorId(Integer mainActorId) {
        this.mainActorId = mainActorId;
    }

    public String getMovieType() {
        return this.movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", title=" + title + ", copies=" + copies + ", movieType=" + movieType
                + ", mainActor=" + mainActorId + '}';
    }
}