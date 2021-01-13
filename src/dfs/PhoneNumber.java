package dfs;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {
    private String[] letters = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private List<String> res = new ArrayList<>();
    private List<String> combinations(String digits) {
        comb(digits, new StringBuilder(), 0);
        return res;
    }

    private void comb(String digits, StringBuilder sb, int index) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String toCom = letters[digits.charAt(index) - '0'];
        for (int i = 0; i < toCom.length(); i ++) {
            sb.append(toCom.charAt(i));
            comb(digits, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "234";
        System.out.println(new PhoneNumber().combinations(digits));
    }
}
