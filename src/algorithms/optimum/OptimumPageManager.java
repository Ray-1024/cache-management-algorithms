package algorithms.optimum;

import algorithms.AbstractPageManager;

import java.util.List;

public class OptimumPageManager extends AbstractPageManager {
    private final List<Integer> queries;
    private int currentAccessTime;

    public OptimumPageManager(int pagesCount, List<Integer> queries) {
        super(pagesCount);
        this.queries = queries;
    }

    private int lengthToNext(int pageId) {
        for (int i = currentAccessTime + 1; i < queries.size(); i++) {
            if (queries.get(i) == pageId) return i - currentAccessTime;
        }
        return Integer.MAX_VALUE;
    }

    @Override
    public void needPage(int pageNumber) {
        if (!pages.contains(pageNumber)) {
            if (pages.size() < pagesCapacity) pages.addLast(pageNumber);
            else {
                pageMisses++;
                var distances = pages.stream().map(this::lengthToNext).toList();
                int max = distances.stream().max(Integer::compare).orElseThrow();
                int index = distances.indexOf(max);
                pages.set(index, pageNumber);
            }
        }
        ++currentAccessTime;
    }
}
