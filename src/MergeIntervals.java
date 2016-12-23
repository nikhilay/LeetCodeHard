/**
 * Created by Nikhil on 12/22/16.
 */

import java.util.*;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        List<Interval> result = new LinkedList<>();
        Interval buffer = null;
        for (Interval i : intervals) {
            if (buffer == null) {
                buffer = i;
            } else {
                if (i.start <= buffer.end) {
                    buffer.end = Math.max(buffer.end,i.end);
                } else {
                    result.add(buffer);
                    buffer = i;

                }
            }
        }
        result.add(buffer);
        return result;

    }
}
