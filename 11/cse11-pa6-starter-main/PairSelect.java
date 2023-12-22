import tester.*;
class PairSelect {
    int[] getAs(Pair[] p){
    int[] aResult = new int[p.length];
    for(int i = 0;i<p.length;i++){
        aResult[i] = p[i].a;
    }
    return aResult;
}
 boolean testEach(Tester t){

     return t.checkExpect(getAs(new Pair[] {new Pair(2,3),new Pair(3,4),new Pair(5,6)}),new int[] {2,3,5}) &&
      t.checkExpect(getAs(new Pair[] {}),new int[] {}) &&
      t.checkExpect(getAs(new Pair[] {new Pair(0, 0)}), new int[] {0}) &&
      t.checkExpect(getAs(new Pair[] {new Pair(-2,3),new Pair(3,-4),new Pair(-5,6)}),new int[] {-2,3,-5}) &&
      t.checkExpect(getAs(new Pair[] {new Pair(0, 0), new Pair(0,0)}), new int[] {0,0});
 }
}
class Pair{
int a;
int b;
Pair(int a, int b){
    this.a = a;
    this.b = b;
}

}    
