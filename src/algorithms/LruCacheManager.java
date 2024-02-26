package algorithms;

import java.util.ArrayList;
import java.util.List;

public class LruCacheManager extends FifoCacheManager {

    private final List<Integer> lastAccessTime;
    private int currentAccessTime;

    public LruCacheManager(int pagesCount) {
        super(pagesCount);
        lastAccessTime = new ArrayList<>(pagesCount);
    }

    @Override
    public void needPage(int pageNumber) {
        if (pages.contains(pageNumber)) {
            lastAccessTime.set(pages.indexOf(pageNumber), currentAccessTime++);
        } else {
            if (pages.size() < pagesCapacity) {
                pages.addLast(pageNumber);
                lastAccessTime.addLast(currentAccessTime++);
            } else {
                pageFaults++;
                int min = lastAccessTime.stream().min(Integer::compare).orElseThrow();
                int index = lastAccessTime.indexOf(min);
                pages.set(index, pageNumber);
                lastAccessTime.set(index, currentAccessTime++);
            }
        }
    }
}
