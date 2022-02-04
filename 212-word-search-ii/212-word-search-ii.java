class Solution {
   private static class Node{
    Node[] children;
    boolean isEnd;
    int freq;
    Node(){
        this.children = new Node[26];
        this.isEnd = false;
        this.freq = 0;
    }
  }
  private static void  insert(String word, Node root){
    for(int i = 0 ; i < word.length() ; i++){
        char ch = word.charAt(i);
        if(root.children[ch - 'a'] == null){
            root.children[ch - 'a'] = new Node();
        }
        root = root.children[ch - 'a'];
        root.freq++;
    }
    root.isEnd = true;
  }
  static int xdir[] = {-1, 0, 1, 0};
  static int ydir[] = {0, -1, 0, 1};
  private static int travelAndAdd(char[][] board, int i, int j, boolean[][] vis, Node root, List<String> res, StringBuilder str){
      char ch = board[i][j];
      if(root.children[ch - 'a'] == null)
        return 0;
      root = root.children[ch - 'a'];
      if(root.freq == 0){
          return 0;
      }
      int count = 0;
      str.append(ch);
      vis[i][j] = true;
      if(root.isEnd == true){
          res.add(str.toString());
          root.isEnd = false;
          count = 1;
      }
      for(int d = 0 ; d < 4 ; d++){
          int r = i + xdir[d];
          int c = j + ydir[d];
          if(r >= 0 && r < board.length && c >= 0 && c < board[0].length && vis[r][c] == false){
              count += travelAndAdd(board, r, c, vis, root, res, str);
          }
      }
      str.deleteCharAt(str.length() - 1);
      vis[i][j] = false;
      root.freq -= count;
      return count;
  }
  public static List<String> findWords(char[][] board, String[] words) {
    // make a trie and add word in it
    Node root = new Node();
    for(String word : words){
        insert(word, root);
    }
    // travel in cell and find similar words from dictionary
    List<String> res = new ArrayList<>();
    boolean[][] vis = new boolean[board.length][board[0].length];
    for(int i = 0 ; i < board.length ; i++){
        for(int j = 0 ; j < board[0].length ; j++){
            StringBuilder str = new StringBuilder();
            travelAndAdd(board, i, j, vis, root, res, str);
        }
    }
    return res;
  }

}