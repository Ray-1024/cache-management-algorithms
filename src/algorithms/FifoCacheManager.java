package algorithms;

public class FifoCacheManager extends AbstractCacheManager {

    private int outIndex = 0;

    public FifoCacheManager(int pagesCount) {
        super(pagesCount);
    }

    @Override
    public void needPage(int pageNumber) {
        if (!pages.contains(pageNumber)) {
            if (pages.size() < pagesCapacity) pages.addLast(pageNumber);
            else {
                pageFaults++;
                pages.set(outIndex, pageNumber);
                outIndex = (outIndex + 1) % pagesCapacity;
            }
        }
    }
}
