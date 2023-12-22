import javax.swing.text.ParagraphView;

import tester.*;
class Pair{
    int a;
    int b;
    Pair(int a, int b){
        this.a = a;
        this.b = b;
    }
}

class ArrayExamples {
    String joinWith(String[] toJoin, String separator){
        String joined ="";
        if(toJoin.length == 0){
            return joined;
        }
        for(int i =0; i<toJoin.length;i++){
            joined = joined.concat(toJoin[i]);
            if(i!=toJoin.length-1){
            joined = joined.concat(separator);
            }
        }
        return joined;
    }
    boolean allTrue(boolean[] booleanValues){
        if(booleanValues.length == 0){
            return true;
        }
        for(int i=0;i<booleanValues.length;i++){
            if(booleanValues[i] != true){
                return false;
            }
        }
        return true;
    }
    boolean allWithinRange(double[] doublesArray, double low, double high){
        if(doublesArray.length == 0){
            return true;
        }
        for(int i = 0;i<doublesArray.length;i++){
            if(!( doublesArray[i] >= low && doublesArray[i] <= high)){
                return false;
            }
        }
        return true;
    }
    Pair maxmin(int[] xy){
        int temp = xy[0];
        int tempo = xy[0];
        for(int i =0;i<xy.length;i++){
            if(xy[i]<temp){
                temp = xy[i];
            }
            if(xy[i]>tempo){
                tempo = xy[i];
            }
        }
        Pair minimaxi = new Pair(temp, tempo);
            return minimaxi;
    }
    String earliest(String[] findEarly){
        String tempor = findEarly[0];
        for(int i = 1;i<findEarly.length;i++){
            if(tempor.compareTo(findEarly[i])>0){
                tempor = findEarly[i];
            }
        }
        return tempor;
    }
    int lookup(String[] keys, int[] values, String key){
        for(int i = 0;i<keys.length;i++){
            if(keys[i].equals(key)){
                return values[i];
            }
        }
        return -1;
    }
 
    boolean testEach(Tester t){

    return t.checkExpect(joinWith(new String[] {"a", "b", "c"}, ":"), "a:b:c") &&
    t.checkExpect(joinWith(new String[] {"abc", "def"}, "-"), "abc-def") &&
    t.checkExpect(joinWith(new String[] {"cajvsn"}, "|"), "cajvsn") &&
    t.checkExpect(allTrue(new boolean[] {true, true, true}), true) &&
    t.checkExpect(allTrue(new boolean[] {false, false, false}), false) &&
    t.checkExpect(allTrue(new boolean[] {false}), false) &&
    t.checkExpect(allTrue(new boolean[] {true}), true) &&
    t.checkExpect(allTrue(new boolean[] {}), true) &&
    t.checkExpect(allWithinRange(new double[] {1.0, 2.0, 7.0}, 0.0, 5.0), false) &&
    t.checkExpect(allWithinRange(new double[] {1.0, 2.0, 3.0}, 0.0, 100.0), true) &&
    t.checkExpect(allWithinRange(new double[] {}, 12, 12.0), true) &&
    t.checkExpect(allWithinRange(new double[] {1.0, 2.0, 3.0}, 4.0, 10.0), false) &&
    t.checkExpect(allWithinRange(new double[] {}, 12, 12.0), true) &&
    t.checkExpect(maxmin(new int[] {1, 1, 7}),new Pair(1,7)) &&
    t.checkExpect(maxmin(new int[] {1, 1, 7}),new Pair(1,7)) &&
    t.checkExpect(maxmin(new int[] {1, 1, 7}),new Pair(1,7)) &&
    t.checkExpect(earliest(new String[] {"a","b","c"}),"a") &&
    t.checkExpect(earliest(new String[] {"aa","ab","ac"}),"aa") &&
    t.checkExpect(earliest(new String[] {"l","dm","dj"}),"dj") &&
    t.checkExpect(lookup(new String[] {"a","b","c"}, new int[] {1,2,3},"b"),2) &&
    t.checkExpect(lookup(new String[] {"a","b","c"}, new int[] {1,2,3},"z"),-1) &&
    t.checkExpect(lookup(new String[] {"a","b","c"}, new int[] {1,2,3},"a"),1);
    }
}







