package guemes.carlos.practica_mongo.jpa;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

@Document("movies")
public class Movies {
    private String id;
    private String plot;
    private List<String> genres;
    private Integer runtime;
    private List<String> cast;
    @JsonProperty("num_mflix_comments")
    private Integer numMflixComments;
    private String title;
    @JsonProperty("fullplot")
    private String fullPlot;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    //1893-05-09T00:00:00.000+00:00
    private Date released;
    private Imdb imdb;
    private String type;
    private Tomatoes tomatoes;
    private String rated;
    private List<String> languages;
    private List<String> writers;
    private List<String> directors;
    private String poster;
    private Awards awards;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSSSSS")
    //"2015-04-30 02:13:27.863000000"
    private String lastUpdated;
    private Integer year;
    private List<String> countries;

    // Getters and Setters

    //Este constructor es obligatorio para que MongoDB pueda crear un Document de este tipo y asignarle
    //valor a sus atributos
    public Movies() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public Integer getNumMflixComments() {
        return numMflixComments;
    }

    public void setNumMflixComments(Integer numMflixComments) {
        this.numMflixComments = numMflixComments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullPlot() {
        return fullPlot;
    }

    public void setFullPlot(String fullPlot) {
        this.fullPlot = fullPlot;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public Awards getAwards() {
        return awards;
    }

    public void setAwards(Awards awards) {
        this.awards = awards;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Imdb getImdb() {
        return imdb;
    }

    public void setImdb(Imdb imdb) {
        this.imdb = imdb;
    }

    public Tomatoes getTomatoes() {
        return tomatoes;
    }

    public void setTomatoes(Tomatoes tomatoes) {
        this.tomatoes = tomatoes;
    }

    // Nested classes for awards, imdb, and tomatoes

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    @Override
    public String toString() {
        return "Película{\n\t" +
                "id='" + id + '\'' +
                ", \n\tplot='" + plot + '\'' +
                ", \n\tgenres=" + genres +
                ", \n\truntime=" + runtime +
                ", \n\tcast=" + cast +
                ", \n\tnumMflixComments=" + numMflixComments +
                ", \n\ttitle='" + title + '\'' +
                ", \n\tfullPlot='" + fullPlot + '\'' +
                ", \n\treleased=" + released +
                ", \n\timdb=" + imdb +
                ", \n\ttype='" + type + '\'' +
                ", \n\trated='" + rated + '\'' +
                ", \n\tlanguages=" + languages +
                ", \n\twriters=" + writers +
                ", \n\tdirectors=" + directors +
                ", \n\tposter='" + poster + '\'' +
                ", \n\tawards=" + awards +
                ", \n\tlastUpdated='" + lastUpdated + '\'' +
                ", \n\tyear=" + year +
                ", \n\tcountries=" + countries + "\n" +
                '}';
    }

    public static class Awards {
        private Integer wins;
        private Integer nominations;
        private String text;
        public Integer getWins() {
            return wins;
        }
        public void setWins(Integer wins) {
            this.wins = wins;
        }
        public Integer getNominations() {
            return nominations;
        }
        public void setNominations(Integer nominations) {
            this.nominations = nominations;
        }
        public String getText() {
            return text;
        }
        public void setText(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return "Awards{" +
                    "wins=" + wins +
                    ", nominations=" + nominations +
                    ", text='" + text + '\'' +
                    '}';
        }

        // Getters and Setters
    }

    public static class Imdb {
        private Double rating;
        private Integer votes;
        private Integer id;
        private String type;
        public Double getRating() {
            return rating;
        }
        public void setRating(Double rating) {
            this.rating = rating;
        }
        public Integer getVotes() {
            return votes;
        }
        public void setVotes(Integer votes) {
            this.votes = votes;
        }
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Imdb{" +
                    "rating=" + rating +
                    ", votes=" + votes +
                    ", id=" + id +
                    ", type='" + type + '\'' +
                    '}';
        }

        // Getters and Setters
    }

    public static class Tomatoes {
        private Viewer viewer;

        // Getters and Setters

        public Viewer getViewer() {
            return viewer;
        }

        public void setViewer(Viewer viewer) {
            this.viewer = viewer;
        }

        public static class Viewer {
            private Double rating;
            private Integer numReviews;
            private Integer meter;
            @JsonFormat(pattern = "yyyy-MMdd'T'HH:mm:ss.SSS'Z'")
            private Date lastUpdated;
            public Double getRating() {
                return rating;
            }
            public void setRating(Double rating) {
                this.rating = rating;
            }
            public Integer getNumReviews() {
                return numReviews;
            }
            public void setNumReviews(Integer numReviews) {
                this.numReviews = numReviews;
            }
            public Integer getMeter() {
                return meter;
            }
            public void setMeter(Integer meter) {
                this.meter = meter;
            }
            public Date getLastUpdated() {
                return lastUpdated;
            }
            public void setLastUpdated(Date lastUpdated) {
                this.lastUpdated = lastUpdated;
            }

            @Override
            public String toString() {
                return "Viewer{" +
                        "rating=" + rating +
                        ", numReviews=" + numReviews +
                        ", meter=" + meter +
                        ", lastUpdated=" + lastUpdated +
                        '}';
            }

            // Getters and Setters
        }
    }
}