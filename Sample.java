class Sample{
    /****************PROBLEM-2***************/
    //TC:0(N*M log (m*n))
//SC:0(N*M)
    class Solution {
        public int[] assignBikes(int[][] workers, int[][] bikes) {
            if(workers.length==0 || bikes.length==0 || workers==null || bikes==null){
                return new int[]{};
            }
            TreeMap<Integer,List<int[]>> distance=new TreeMap<>();
            int n=workers.length,m=bikes.length;
            int[] result=new int[n];
            boolean[] assignedBikes=new boolean[m];
            boolean[] assignedWorkers=new boolean[n];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    int dist=Math.abs(workers[i][0]-bikes[j][0])+Math.abs(workers[i][1]-bikes[j][1]);
                    if(!distance.containsKey(dist)){
                        distance.put(dist,new ArrayList<>());
                    }
                    distance.get(dist).add(new int[]{i,j});
                }

            }
            int count=n;
            for(int key:distance.keySet()){
                List<int[]> workerBikes=distance.get(key);
                for(int[] each:workerBikes){
                    int worker=each[0];
                    int bike=each[1];
                    if(assignedWorkers[worker]==false){
                        if(assignedBikes[bike]==false){
                            result[worker]=bike;
                            count--;
                            assignedWorkers[worker]=true;
                            assignedBikes[bike]=true;
                            if(count==0){
                                break;
                            }
                        }
                    }
                }
            }

            return result;
        }
    }


    //TC:0(N*M)
//SC:0(N*M)
    class Solution {
        public int[] assignBikes(int[][] workers, int[][] bikes) {
            if(workers.length==0 || bikes.length==0 || workers==null || bikes==null){
                return new int[]{};
            }
            HashMap<Integer,List<int[]>> distance=new HashMap<>();
            int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
            int n=workers.length,m=bikes.length;
            int[] result=new int[n];
            boolean[] assignedBikes=new boolean[m];
            boolean[] assignedWorkers=new boolean[n];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    int dist=Math.abs(workers[i][0]-bikes[j][0])+Math.abs(workers[i][1]-bikes[j][1]);
                    min=Math.min(min,dist);
                    max=Math.max(max,dist);
                    if(!distance.containsKey(dist)){
                        distance.put(dist,new ArrayList<>());
                    }
                    distance.get(dist).add(new int[]{i,j});
                }

            }
            int count=n;
            for(int i=min;i<=max;i++){
                List<int[]> workerBikes=distance.get(i);
                if(workerBikes==null){
                    continue;
                }
                for(int[] each:workerBikes){
                    int worker=each[0];
                    int bike=each[1];
                    if(assignedWorkers[worker]==false){
                        if(assignedBikes[bike]==false){
                            result[worker]=bike;
                            count--;
                            assignedWorkers[worker]=true;
                            assignedBikes[bike]=true;
                            if(count==0){
                                break;
                            }
                        }
                    }
                }
            }

            return result;
        }
    }
    /*******************PROBLEM-1*********************/
}