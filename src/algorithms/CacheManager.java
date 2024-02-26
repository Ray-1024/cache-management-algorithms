package algorithms;

public interface CacheManager {
    void needPage(int pageNumber);

    int getPageFaults();
}
