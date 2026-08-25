import java.util.*;

class RecentCounter {

    Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }

    public int ping(int t) {

        // Add current request
        q.offer(t);

        // Remove requests older than 3000 ms
        while (q.peek() < t - 3000) {
            q.poll();
        }

        // Number of requests in [t - 3000, t]
        return q.size();
    }
}