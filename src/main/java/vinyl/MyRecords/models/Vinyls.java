package vinyl.MyRecords.models;


public class Vinyls {

    private int id;

    private String artist;

    private String album;

    private String datarecording;

    private String datareliase;

    private String publhouse;

    private String country;

    private String genry;

    private String numberoftracks;

    private String numberofdisk;

    private String conditions;

    public Vinyls() {
    }

    public Vinyls(int id, String artist, String album, String datarecording, String datareliase, String publhouse, String country, String genry, String numberoftracks, String numberofdisk, String conditions) {
        this.id = id;
        this.artist = artist;
        this.album = album;
        this.datarecording = datarecording;
        this.datareliase = datareliase;
        this.publhouse = publhouse;
        this.country = country;
        this.genry = genry;
        this.numberoftracks = numberoftracks;
        this.numberofdisk = numberofdisk;
        this.conditions = conditions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getDatarecording() {
        return datarecording;
    }

    public void setDatarecording(String datarecording) {
        this.datarecording = datarecording;
    }

    public String getDatareliase() {
        return datareliase;
    }

    public void setDatareliase(String datareliase) {
        this.datareliase = datareliase;
    }

    public String getPublhouse() {
        return publhouse;
    }

    public void setPublhouse(String publhouse) {
        this.publhouse = publhouse;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGenry() {
        return genry;
    }

    public void setGenry(String genry) {
        this.genry = genry;
    }

    public String getNumberoftracks() {
        return numberoftracks;
    }

    public void setNumberoftracks(String numberoftracks) {
        this.numberoftracks = numberoftracks;
    }

    public String getNumberofdisk() {
        return numberofdisk;
    }

    public void setNumberofdisk(String numberofdisk) {
        this.numberofdisk = numberofdisk;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }
}
