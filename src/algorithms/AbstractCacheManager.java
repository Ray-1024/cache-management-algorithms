package algorithms;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCacheManager implements CacheManager {
    protected final List<Integer> pages;
    protected final int pagesCapacity;

    protected int pageFaults;

    public AbstractCacheManager(int pageCount) {
        pagesCapacity = pageCount;
        pages = new ArrayList<>(pageCount);
    }

    @Override
    public int getPageFaults() {
        return pageFaults;
    }

    @Override
    public String toString() {
        return pages.toString();
    }
}
