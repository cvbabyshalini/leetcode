class Solution {
    public static boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        else
            return false;
    }
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int left = 0 ;
        int right = s.length() - 1;
        while(left < right){
            while(left < right && isVowel(ch[left]) == false){
                left++;
            }
            while(left < right && isVowel(ch[right]) == false){
                right--;
            }
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
            
            left++;
            right--;
        }
        return String.valueOf(ch);
    }
}