package org.skypro.skyshop.Search;
import org.skypro.skyshop.Exceptions.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    private final Set<Searchable> items;

    public SearchEngine() {
        this.items = new HashSet<>();
    }

    public Set<Searchable> search(String searchTerm) {
        Set<Searchable> results = new TreeSet<>(new SearchableComparator());

        for (Searchable item : items) {
            if (item.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(item);
            }
        }
        return results;
    }

    public void addItem(Searchable item) {
        items.add(item);
    }

    public Searchable findMostRelevant(String search) throws BestResultNotFound {
        int maxRepetitions = 0;
        Searchable mostRelevant = null;

        for (Searchable item : items) {
            int repetitions = countOccurrences(item.getSearchTerm().toLowerCase(), search.toLowerCase());
            if (repetitions > maxRepetitions) {
                maxRepetitions = repetitions;
                mostRelevant = item;
            }
        }
        if (mostRelevant == null) {
            throw new BestResultNotFound(search);
        }
        return mostRelevant;
    }

    private int countOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }
}