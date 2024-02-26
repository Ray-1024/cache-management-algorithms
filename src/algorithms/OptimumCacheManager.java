package algorithms;

import java.util.List;

public class OptimumCacheManager implements CacheManager {
    protected List<Integer> queries;
    protected int currentQueryIndex;

    public OptimumCacheManager(int pagesCount, List<Integer> queries) {
        this.queries = queries;
    }

    @Override
    public void needPage(int pageNumber) {

    }

    @Override
    public int getPageFaults() {
        return 0;
    }
}
