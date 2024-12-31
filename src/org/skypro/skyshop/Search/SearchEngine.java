package org.skypro.skyshop.Search;

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
}