package at.ac.fhcampuswien.fhmdb.models;

import javafx.scene.control.Button;

@FunctionalInterface
public interface ClickEventHandler<T> {
    void onClick(T t, boolean isWatchlistCell, Button watchBtn);

}
