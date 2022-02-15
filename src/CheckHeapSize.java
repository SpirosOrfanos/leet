import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.*;
public class CheckHeapSize {
    public static void main(String[] args) {
       /* long heapSize = Runtime.getRuntime().totalMemory();

        // Get maximum size of heap in bytes. The heap cannot grow beyond this size.// Any attempt will result in an OutOfMemoryException.
        long heapMaxSize = Runtime.getRuntime().maxMemory();

        // Get amount of free memory within the heap in bytes. This size will increase // after garbage collection and decrease as new objects are created.
        long heapFreeSize = Runtime.getRuntime().freeMemory();

        System.out.println("heap size: " + formatSize(heapSize));
        System.out.println("heap max size: " + formatSize(heapMaxSize));
        System.out.println("heap free size: " + formatSize(heapFreeSize));*/
      /*  MemoryMXBean memBean = ManagementFactory.getMemoryMXBean() ;
        MemoryUsage heapMemoryUsage = memBean.getHeapMemoryUsage();

        System.out.println("Xmx : "+ heapMemoryUsage.getMax());
        System.out.println("Xms : "  + heapMemoryUsage.getInit());
        System.out.println("Committed : "+ heapMemoryUsage.getCommitted());
        System.out.println( "Used  : " + heapMemoryUsage.getUsed()); */

        // |------------------ max ------------------------| allowed to be occupied by you from OS (less than xmX due to empty survival space)
        // |------------------ committed -------|          | now taken from OS
        // |------------------ used --|                    | used by your heap

        List<String> l = Arrays.asList(new String[]{"a", "b"});

        l.stream().findFirst().ifPresent(a -> System.out.println(a));

        Map<Integer, Integer> m = new HashMap<>();
        m.put(1,1);
        m.put(2,2);

        m.computeIfAbsent(2 , v -> 5);

        m.putIfAbsent(2, 3);
        m.computeIfAbsent(3, v -> 3);
    System.out.println(m.computeIfAbsent(4, v -> 555));
    m.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " : " +  e.getValue()));
    }
    public static String formatSize(long v) {
        if (v < 1024) return v + " B";
        int z = (63 - Long.numberOfLeadingZeros(v)) / 10;
        return String.format("%.1f %sB", (double)v / (1L << (z*10)), " KMGTPE".charAt(z));
    }
}
