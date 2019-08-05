package array;

import java.util.Stack;

public class Solution2 {
    public static boolean isValid(String s) {

        ArrayStack<Character> stack = new ArrayStack<>();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='{'||c=='['||c=='('){
                stack.push(c);
            }
            if (stack.isEmpty())
                return false;
            else if(c=='}'&&stack.pop()!='{')
                return false;
            else if(c==']'&&stack.pop()!='[')
                return false;
            else if(c==')'&&stack.pop()!='(')
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("dfdf"));
    }
}
