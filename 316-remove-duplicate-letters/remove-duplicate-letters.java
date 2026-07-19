class Solution {
    public String removeDuplicateLetters(String s) {
       Stack<Character> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        int[] c=new int[26];
        boolean[] v=new boolean[26];
        for(int i=0;i<s.length();i++){
                c[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
                c[s.charAt(i)-'a']--;
                if(v[s.charAt(i)-'a']){
                    continue;
                }
                while(!st.isEmpty()&&st.peek()>s.charAt(i)&&c[st.peek()-'a']>0){
                    v[st.pop()-'a']=false;
                }
                st.push(s.charAt(i));
                v[s.charAt(i)-'a']=true;

        }
        for(char ch:st){
            sb.append(ch);
        }
        return sb.toString(); 
    }
}