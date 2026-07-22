class Solution {
    public int timeRequiredToBuy(int[] t, int k) {
        int tt=0;
        int i=0;
        while(t[k]>0){
            if(t[i]>0){
                t[i]--;
                tt++;
                
            }
            i++;
            if(i==t.length){
                i%=t.length;
            }
            
        }
        return tt;
    }
}