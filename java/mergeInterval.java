/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval>res = new ArrayList<Interval>();
        if (intervals == null || intervals.isEmpty()) return res;
    
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;// Sort ascendingly by interval's start
            }
        });
    
        Interval last = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) { 
            Interval cur = intervals.get(i);
            if (cur.start <= last.end) {
                last.end = Math.max(cur.end, last.end);
            } else {
                res.add(last);
                last = cur; 
            }
        }
    
        res.add(last);// Add the last interval
        return res;
    }
}
