class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        boolean[] isVisit = new boolean[intervals.length];

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        for(int i =0 ; i< intervals.length ; i++){
            if(isVisit[i] == false){
                result.add(mergeArray(intervals[i],intervals,i,isVisit));
            }
        }

        return result.toArray(new int[result.size()][]);

    }

    private int[] mergeArray(int[] cur, int[][] intervals, int idx, boolean[] isVisit){
        int [] newInterval = {cur[0],cur[1]};
        for(int i = idx +1 ; i< intervals.length; i++){
            if( isVisit[i] == false){
                if( newInterval[1] >= intervals[i][0] && newInterval[1] <= intervals[i][1]){
                    isVisit[i] = true;
                    newInterval[1] = intervals[i][1];
                }
                else if(newInterval[1] >= intervals[i][1]){
                    isVisit[i] = true;
                }
            }
        }
        return newInterval;
    }
}
