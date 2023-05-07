package at.ac.fhcampuswien.fhmdb.controller;

import at.ac.fhcampuswien.fhmdb.FhmdbApplication;
import at.ac.fhcampuswien.fhmdb.datalayer.WatchlistEntity;
import at.ac.fhcampuswien.fhmdb.datalayer.WatchlistRepository;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class WatchlistViewController {
    @FXML
    public Button watchlistBtn;
    @FXML
    public VBox mainVBox;
    @FXML
    public JFXListView movieWatchlistView;
    @FXML
    public JFXButton mainPageBtn;
    public JFXListView movieWatchListView;
    WatchlistRepository repo;

   public void initialize() {
        System.out.println("WatchlistViewController initialized");

        repo = new WatchlistRepository();
        List<WatchlistEntity> watchList = new ArrayList<>();

        try {
            watchList = repo.getAll();
        }catch (SQLException e){
            throw new RuntimeException();
        }
       /* ObservableList<Movie> movies = FXCollections.observableArrayList(watchList.stream()
                .map(WatchlistEntity:: toMovie)
                .collect(Collectors.toList())
        );*/

      //  movieWatchlistView.setItems(movies);
     // SPÄTER FIXEN    movieWatchlistView.setCellFactory(movieListView -> new MovieCell(true));
    }

        // SWITCH SCENE:
    public void switchToMainPage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FhmdbApplication.class.getResource("home-view.fxml"));
        try{
            Scene scene = new Scene(fxmlLoader.load(), 890, 620);
            Stage stage = (Stage)mainVBox.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            System.err.println("Error while loading main page.");
        }
    }
}
