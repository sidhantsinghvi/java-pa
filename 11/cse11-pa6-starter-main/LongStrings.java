import tester.*;
class LongStrings {
    String[] longStrings(String[] s, int n){
        int count = 0;
        int count1 = 0;
        for(int i = 0;i<s.length;i++){
            if(s[i].length() >= n){
                count += 1;
            }
        }
        String[] longs = new String[count];
            for(int j = 0;j<s.length;j++){
                if(s[j].length() >= n){
                    longs[count1] = s[j];
                    count1+=1;
                }
            }        
    return longs;
    }
    boolean testEach(Tester t){
        return t.checkExpect(longStrings(new String[] {"a","ab","abc","abcd","abcde"},1),new String[] {"a","ab","abc","abcd","abcde"}) &&
         t.checkExpect(longStrings(new String[] {"a","ab","abc","abcd","abcde"},2),new String[] {"ab","abc","abcd","abcde"}) &&
         t.checkExpect(longStrings(new String[] {"a","ab","abc","abcd","abcde"},3),new String[] {"abc","abcd","abcde"}) &&
         t.checkExpect(longStrings(new String[] {"a","ab","abc","abcd","abcde"},4),new String[] {"abcd","abcde"}) &&
         t.checkExpect(longStrings(new String[] {"a","ab","abc","abcd","abcde"},5),new String[] {"abcde"}) &&
         t.checkExpect(longStrings(new String[] {"a","ab","abc","abcd","abcde"},6),new String[] {}) &&
         t.checkExpect(longStrings(new String[] {"a","ab","abc","abcd","abcde"},0),new String[] {"a","ab","abc","abcd","abcde"}) &&
         t.checkExpect(longStrings(new String[] {},3),new String[] {});
    }
}
