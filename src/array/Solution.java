package array;

public class Solution {

     public static boolean isValid(String s) {
         ArrayStack<Character> stack = new ArrayStack<>();
         for (int i = 0; i < s.length(); i++) {
             char c = s.charAt(i);
             if (c == '{' || c == '[' || c == '(')
                 stack.push(c);
             else {
                 if (stack.isEmpty())
                     return false;

                 char topChar = stack.pop();
                 if (c == ')' && topChar != '(') {
                     return false;
                 }
                 if (c == ']' && topChar != '[') {
                     return false;
                 }
                 if (c == '}' && topChar != '{') {
                     return false;
                 }
             }
         }
             return stack.isEmpty();
     }
         public static void main(String[] args){
             System.out.println(isVaild("([]{})"));
             System.out.println(isVaild("{[){} "));
         }

         public static  boolean isVaild(String s){
           ArrayStack<Character> arrayStack=new ArrayStack<>();
           for(int i=0;i<s.length();i++){
               char c=s.charAt(i);

               if(c=='{'||c=='['||c=='(')
                  arrayStack.push(c);

               else {
                   Character  q=arrayStack.pop();
                   if(q=='{'&&c!='}')
                       return false;
                   if(q=='['&&c!=']')
                       return false;
                   if(q=='('&&c!=')')
                       return false;
               }
           }
             return arrayStack.isEmpty();
         }
}
