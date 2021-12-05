class Solution {
   public HashMap<String, PriorityQueue<String>> graph;
    public LinkedList<String> ans;
    public List<String> findItinerary(List<List<String>> tickets) {
        graph = new HashMap<>();
        ans = new LinkedList<>();

        for(List<String> edge : tickets) {
            String u = edge.get(0);
            String v = edge.get(1);

            if(graph.containsKey(u)) {
                graph.get(u).add(v);
            } else {
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.add(v);
                graph.put(u, pq);
            }
        }

        dfs("JFK");
        return ans;
    }

    public void dfs(String src) {
        PriorityQueue<String> nbrs = graph.get(src);
        while(nbrs != null && nbrs.size() > 0) {
            String nbr = nbrs.remove();
            dfs(nbr);
        }
        ans.addFirst(src);
    }
}