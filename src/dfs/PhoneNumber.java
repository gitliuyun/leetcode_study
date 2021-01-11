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

    private void comb(String digits, StringBuilder let, int index) {
        if (index == digits.length()) {
            res.add(let.toString());
            return;
        }
        String toCom = letters[digits.charAt(index) - '0'];
        for (int i = 0; i < toCom.length(); i ++) {
            let.append(toCom.charAt(i));
            comb(digits, let, index + 1);
            let.deleteCharAt(let.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "234";
        System.out.println(new PhoneNumber().combinations(digits));
    }
}
