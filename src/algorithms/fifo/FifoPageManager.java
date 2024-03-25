package algorithms.fifo;

import algorithms.AbstractPageManager;

public class FifoPageManager extends AbstractPageManager {

    private int outIndex = 0;

    public FifoPageManager(int pagesCount) {
        super(pagesCount);
    }

    @Override
    public void needPage(int pageNumber) {
        if (!pages.contains(pageNumber)) {
            if (pages.size() < pagesCapacity) pages.addLast(pageNumber);
            else {
                pageMisses++;
                pages.set(outIndex, pageNumber);
                outIndex = (outIndex + 1) % pagesCapacity;
            }
        }
    }
}
