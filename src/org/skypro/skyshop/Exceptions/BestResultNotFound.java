package org.skypro.skyshop.Exceptions;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String searchQuery) {
        super("No suitable result found for the search query: " + searchQuery);
    }
}
