class Solution {
    public boolean canFinish(int n, int[][] edges) {
        // prepare graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        
        // make an indegree array from graph
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++) {
            for(int nbr : graph.get(i)) {
                indegree[nbr]++;
            }
        }

        // add element in queue which have 0 indegree
        Queue<Integer> qu = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                qu.add(i);
            }
        }

        int count = 0;
        while(qu.size() > 0) {
            // 1. get + remove
            int rem = qu.remove();
            // 2. print*
            count++;
            // 3. decrease indegree of nbr and if indegree become 0 then add in queue
            for(int nbr : graph.get(rem)) {
                indegree[nbr]--;
                if(indegree[nbr] == 0) {
                    qu.add(nbr);
                }
            }
        }
        return count == n;
    }
}