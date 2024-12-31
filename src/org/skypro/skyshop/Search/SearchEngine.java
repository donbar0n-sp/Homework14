package org.skypro.skyshop.Search;
import org.skypro.skyshop.Exceptions.BestResultNotFound;

public class SearchEngine {
    private final Searchable[] items;
    private int count;

    public SearchEngine(int size) {
        this.items = new Searchable[size];
        this.count = 0;
    }

    public Searchable[] search(String searchTerm) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;

        for (int i = 0; i < count; i++) {
            if (items[i].getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                results[resultCount] = items[i];
                resultCount++;
                if (resultCount >= 5) {
                    break;
                }
            }
        }
        return results;
    }

    public void addItem(Searchable item) {
        if (count >= items.length) {
            return;
        }
        items[count] = item;
        count++;
    }

    public Searchable findMostRelevant(String search) throws BestResultNotFound {
        int maxRepetitions = 0;
        Searchable mostRelevant = null;

        for (int i = 0; i < count; i++) {
            int repetitions = countOccurrences(items[i].getSearchTerm().toLowerCase(), search.toLowerCase());
            if (repetitions > maxRepetitions) {
                maxRepetitions = repetitions;
                mostRelevant = items[i];
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