package org.skypro.skyshop.Search;
import org.skypro.skyshop.Exceptions.BestResultNotFound;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> items;

    public SearchEngine() {
        this.items = new HashSet<>();
    }

    public Set<Searchable> search(String searchTerm) {
            return items.stream()
                    .filter(item -> item.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase()))
                    .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
    }

    public void addItem(Searchable item) {
        items.add(item);
    }

    public Searchable findMostRelevant(String search) throws BestResultNotFound {
        return items.stream()
                .max(Comparator.comparingInt(item -> countOccurrences(item.getSearchTerm().toLowerCase(), search.toLowerCase())))
                .orElseThrow(() -> new BestResultNotFound(search));
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