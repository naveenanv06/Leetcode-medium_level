class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1 || numRows >= s.length())
            return s;

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        boolean goingDown = true;

        for (char ch : s.toCharArray()) {

            rows[row].append(ch);

            if (row == 0) {
                goingDown = true;
            } else if (row == numRows - 1) {
                goingDown = false;
            }

            if (goingDown)
                row++;
            else
                row--;
        }

        StringBuilder ans = new StringBuilder();

        for (StringBuilder sb : rows) {
            ans.append(sb);
        }

        return ans.toString();
    }
}