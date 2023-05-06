package at.ac.fhcampuswien.fhmdb.datalayer;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;
import java.util.stream.Collectors;

@DatabaseTable(tableName = "watchlist")
public class WatchlistEntity {
    @DatabaseField(generatedId = true)
    long id;
    @DatabaseField()
    String apiId;
    @DatabaseField()
    String title;
    @DatabaseField()
    String description;
    @DatabaseField()
    String genres;
    @DatabaseField()
    int releaseYear;
    @DatabaseField()
    String imgUrl;
    @DatabaseField()
    int lengthInMinutes;
    @DatabaseField()
    double rating;

    public WatchlistEntity(){} //no-argument constructor required by DAO(?)

    public WatchlistEntity(String apiId){ /*als test, damit man nur einen parameter von movie abgibt
                                           (kann man löschen, dann auch in WatchlistRepository ändern)*/
        this.apiId = apiId;
    }

    public WatchlistEntity(String apiId, String title, String description, String genres, int releaseYear, String imgUrl, int lengthInMinutes, double rating) {
        this.apiId = apiId;
        this.title = title;
        this.description = description;
        this.genres = genres;
        this.releaseYear = releaseYear;
        this.imgUrl = imgUrl;
        this.lengthInMinutes = lengthInMinutes;
        this.rating = rating;
    }

    public static String genresToString(List<Genre> genres) {
        List<String> genresStrings = genres.stream()  //create stream of genre objects
                .map(Genre::toString)                 //map each genre object to its string representation (genres -> genres.toString)
                .collect(Collectors.toList());        //collect the strings into list
        return String.join(", ", genresStrings);  //separate with comma
    }
}
