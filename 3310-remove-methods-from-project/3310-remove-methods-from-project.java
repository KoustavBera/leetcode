class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int inv[] : invocations){
            adj.get(inv[0]).add(inv[1]);
        }
        boolean[] vis = new boolean[n];
        dfs(k, adj, vis);
        int[] sus = new int[n];
        boolean canRemove = true;
        for(int inv[] : invocations){
            int u = inv[0];
            int v = inv[1];
            if(vis[u] == false && vis[v] == true){
                canRemove = false;
                break;
            }
        }
        if(!canRemove) {
            List<Integer> ans = new ArrayList<>();
            for(int i=0; i<n; i++) ans.add(i);
            return ans;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(!vis[i]) ans.add(i);
        }
        return ans;

    }
    static void dfs(int node, List<List<Integer>> adj, boolean[] vis){
        if(vis[node]) return;
        vis[node] = true;
        for(int neigh : adj.get(node)){
            dfs(neigh, adj, vis);
        }
    }
}