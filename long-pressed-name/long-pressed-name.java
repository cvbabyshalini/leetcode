class Solution {
    public boolean isLongPressedName(String name, String typed) {
          // if typed string length is less than name string length
        if(typed.length() < name.length()){
            return false;
        }
        int i = 0 ; // name
        int j = 0;  // typed
        while(i < name.length() && j < typed.length()){
            if(name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }
            else if(i - 1 >= 0 && name.charAt(i-1) == typed.charAt(j)){
                j++;
            }
            else{
                return false;
            }
        }
          // if i reached name.length but j doesn't
        while(j < typed.length()){
            if(typed.charAt(j) != name.charAt(i-1)){
                return false;
            }
            j++;
        }
        // if i does not reach name.length
        return i < name.length() ? false : true;
    }
}