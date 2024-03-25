package algorithms;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPageManager implements StatisticsPageManager {
    protected final List<Integer> pages;
    protected final int pagesCapacity;
    protected int pageMisses;

    public AbstractPageManager(int pageCount) {
        pagesCapacity = pageCount;
        pages = new ArrayList<>(pageCount);
    }

    @Override
    public int getPageMisses() {
        return pageMisses;
    }

    @Override
    public String toString() {
        return pages.toString();
    }
}
