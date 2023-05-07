package at.ac.fhcampuswien.fhmdb.datalayer;

import at.ac.fhcampuswien.fhmdb.api.MovieAPI;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

//EXTRA LAYER TO ACCESS DAO FROM DATABASE
public class WatchlistRepository {
    Dao<WatchlistEntity, Long> dao;
    public WatchlistRepository(){ //exception von Database
        try {
            this.dao = Database.getDatabase().getWatchlistDao();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //angabe hat WatchlistEntity als parameter, im video wird das objekt in die entity umgewandelt
    public void addToWatchList(Movie movie) throws SQLException {
        dao.create(movieToWatchlistEntity(movie));
    }
    public void removeFromWatchList(Movie movie) throws SQLException {
        dao.delete(movieToWatchlistEntity(movie));

    }
    public List<WatchlistEntity> getAll() throws SQLException {
        return dao.queryForAll();
    }


    private WatchlistEntity movieToWatchlistEntity(Movie movie){
        return new WatchlistEntity(movie.getTitle(),movie.getDescription(),WatchlistEntity.genresToString(movie.getGenres()),movie.getApiId(),movie.getReleaseYear(),movie.getImgUrl(),movie.getLengthInMinutes(), movie.getRating());
    }

}
