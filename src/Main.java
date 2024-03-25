import algorithms.StatisticsPageManager;
import algorithms.fifo.FifoPageManager;
import algorithms.lru.LruPageManager;
import algorithms.optimum.OptimumPageManager;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;

public class Main {

    private static final List<Integer> pages = List.of(
            9, 1, 20, 10, 7, 10, 3, 11, 12, 6, 15, 8, 13, 15, 14, 18, 1, 5, 15, 16, 13, 4, 8, 5, 17,
            16, 6, 8, 4, 8, 9, 17, 2, 6, 5, 2, 4, 9, 7, 10, 20, 11, 12, 14, 15, 12);

    private static void lab(StatisticsPageManager statisticsPageManager, PrintWriter writer) {
        for (int i = 0; i < pages.size(); i++) {
            int page = pages.get(i);
            statisticsPageManager.needPage(page);
            writer.printf("%d: page №%d => %s\n", i, page, statisticsPageManager);
        }
        writer.printf("Page Faults: %d", statisticsPageManager.getPageMisses());
        writer.close();
    }


    public static void main(String[] args) throws FileNotFoundException {
        Path.of("./report/").toFile().mkdirs();
        int pageFrames = 5;
        lab(new FifoPageManager(pageFrames), new PrintWriter(Path.of("./report/fifo.txt").toFile()));
        lab(new LruPageManager(pageFrames), new PrintWriter(Path.of("./report/lru.txt").toFile()));
        lab(new OptimumPageManager(pageFrames, pages), new PrintWriter(Path.of("./report/optimum.txt").toFile()));
    }
}