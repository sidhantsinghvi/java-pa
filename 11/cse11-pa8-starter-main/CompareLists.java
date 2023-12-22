import tester.*;
import java.util.List;

import static java.lang.System.*;
import java.util.*;
import java.util.Arrays;
//import java.util.Comparator;
import java.util.ArrayList;

class Point {
  int x, y;
  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  double distance(Point other) {
    return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
  }
}
interface Comparator<E>{
int compare(E one, E two);
}
class PointCompare implements Comparator<Point>{
public int compare(Point a, Point b){
  if(a.y<b.y){
    return -1;
  }
  else if(a.y>b.y){
    return 1;
  }
  else{
    if(a.x<b.x){
      return -1;
    }

    else if(a.x>b.x){
      return 1;
    }
    else{
      return 0;
    }
  }
}
}
class PointDistanceCompare implements Comparator<Point>{
  public int compare(Point a, Point b){
    if(a.distance(new Point(0,0))<b.distance(new Point(0, 0))){
      return -1;
    }
    else if(a.distance(new Point(0, 0))>b.distance(new Point(0, 0))){
      return 1;
    }    
    else{
      return 0;
    }
  }
}
class StringCompare implements Comparator<String>{
  public int compare(String a, String b){
    return a.compareTo(b);
  }
}
class StringLengthCompare implements Comparator<String>{
  public int compare(String a, String b){
    if(a.length()<b.length()){
      return -1;
    }
    else if(a.length()>b.length()){
      return 1;
    }
    else{
      return 0;
    }
  }
}
class BooleanCompare implements Comparator<Boolean>{
  public int compare(Boolean a, Boolean b){
    if(a == true && b == false){
      return 1;
    }
    else if(a == false && b == true){
      return -1;
    }
    else{
      return 0;
    }
  }
}
class Tests{
  boolean testEach(Tester t){
    return t.checkExpect(new PointCompare().compare(new Point(2,3), new Point(4,5)),-1) &&
           t.checkExpect(new PointCompare().compare(new Point(2,3), new Point(4,2)),1) &&
           t.checkExpect(new PointCompare().compare(new Point(2,3), new Point(2,3)),0) &&
           t.checkExpect(new PointCompare().compare(new Point(2,3), new Point(4,3)),-1) &&
           t.checkExpect(new PointCompare().compare(new Point(6,3), new Point(4,3)),1) &&
           t.checkExpect(new PointCompare().compare(new Point(2,-3), new Point(4,5)),-1) &&
           t.checkExpect(new PointDistanceCompare().compare(new Point(2,3), new Point(4,5)),-1) &&
           t.checkExpect(new PointDistanceCompare().compare(new Point(2,3), new Point(4,2)),-1) &&
           t.checkExpect(new PointDistanceCompare().compare(new Point(2,3), new Point(2,3)),0) &&
           t.checkExpect(new PointDistanceCompare().compare(new Point(2,3), new Point(4,3)),-1) &&
           t.checkExpect(new PointDistanceCompare().compare(new Point(6,3), new Point(4,3)),1) &&
           t.checkExpect(new PointDistanceCompare().compare(new Point(-22,-3), new Point(4,5)),1) &&
           t.checkExpect(new StringCompare().compare("abcd", "zyxy"),-25) &&
           t.checkExpect(new StringCompare().compare("zyxw", "abcd"),25) &&
           t.checkExpect(new StringCompare().compare("abcd", "abcd"),0) &&
           t.checkExpect(new StringCompare().compare("2ab2cd", "1zyxy2"),1) &&
           t.checkExpect(new StringCompare().compare("abcd", "ABCD"),32) &&
           t.checkExpect(new StringCompare().compare("ZYXW", "zyxy"),-32) &&
           //I checked values sperately to be as mentioned
           t.checkExpect(new StringLengthCompare().compare("a", "ab"),-1) &&
           t.checkExpect(new StringLengthCompare().compare("ab", "a"),1) &&
           t.checkExpect(new StringLengthCompare().compare("ab", "ab"),0) &&
           t.checkExpect(new StringLengthCompare().compare("acjn", "abjefn"),-1) &&
           t.checkExpect(new BooleanCompare().compare(true, false),1) &&
           t.checkExpect(new BooleanCompare().compare(false, true),-1) &&
           t.checkExpect(new BooleanCompare().compare(true, true),0) &&
           t.checkExpect(new BooleanCompare().compare(false, false),0) ;
}
}
class CompareLists{
static <E> E minimum(List<E> list, Comparator<E> comparator){
    if(list.isEmpty()){
      return null;
    }
    E E0 = list.get(0);
    for(int i =1;i<list.size();i++){
      if(comparator.compare(list.get(i),E0)<0){
        E0 = list.get(i);
      }
    }
    return E0;
  }
  <E> E minimum(E[] Es, Comparator<E> comparator){
    if(Es.length == 0){
      return null;
    }
    E E0 = Es[0];
    for(int i = 1;i<Es.length;i++){
      if(comparator.compare(Es[i],E0)<=0){
        E0 = Es[i];
      }
    }
    return E0;
  }
  <E> List<E> greaterThan(List<E> list, Comparator<E> comparator, E E){
    List<E> theList= new ArrayList<>();
    for(int i = 0;i<list.size();i++){
        if(comparator.compare(list.get(i),E)>0){
            theList.add(list.get(i));
        }
    }
    return theList;
  }
  <E> boolean inOrder(List<E> list, Comparator<E> comparator){
    if(list.contains(null)){
      throw new IllegalArgumentException("null value in list", null);
    }
    for(int i =0;i<list.size()-1;i++){
      if(comparator.compare(list.get(i),list.get(i+1))<=0){
        return false;
      }
    }
    return true;
  }
  <E> boolean inOrder(E[] Es, Comparator<E> comparator){
    for(int i=0;i<Es.length;i++){
    if(Es[i]==null){
      throw new IllegalArgumentException("null value in array", null);
    }
  }
    for(int i =0;i<Es.length-1;i++){
        if(comparator.compare(Es[i],Es[i+1])<=0){
          return false;
        }
    }
    return true;
  }
  <E> List<E> merge(Comparator<E> comparator, List<E> list1, List<E> list2){
    if(list1.contains(null)){
      throw new IllegalArgumentException("null value in first list", null);
    }
    if(list2.contains(null)){
      throw new IllegalArgumentException("null value in second list", null);
    }
    List<E> theList = new ArrayList<>(list1.size()+list2.size());
    int i=0,j = 0;
    while(i<list1.size() && j<list2.size()){
      if(comparator.compare(list1.get(i),list2.get(j))<1){
        theList.add(list1.get(i));
        i++;
      }
      else{
        theList.add(list2.get(j));
        j++;
      }
    }
    while(i<list1.size()){
      theList.add(list1.get(i));
      i++;
    }
    while(j<list2.size()){
      theList.add(list2.get(j));
      j++;
    }
    return theList;
  }

  // List<Integer> list = new List();
  
  // Comparator<Integer> comparator = new Comparator();
  // Integer something = new inOrder(list, comparator);
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    Comparator<Integer> comparator = Comparator.StringCompare();

    Integer something = minimum(list, comparator);
    System.out.println(something); 
    // Output: null
}
}
