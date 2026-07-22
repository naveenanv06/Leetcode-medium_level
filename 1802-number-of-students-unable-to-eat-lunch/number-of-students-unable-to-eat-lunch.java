class Solution {
    public int countStudents(int[] stu, int[] sand) {
        Stack<Integer> st=new Stack<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<stu.length;i++){
            st.push(sand[stu.length-i-1]);
            q.offer(stu[i]);
        }
        int mis=0;
        boolean f=true;
        while(!q.isEmpty()){
            if(st.peek()==q.peek()){
                st.pop();
                q.poll();
                mis=0;
               
                
            }
            else{
                q.offer(q.poll());
                mis++;
                if(mis==q.size()) break;
            }

        }
        return q.size();
    }
}