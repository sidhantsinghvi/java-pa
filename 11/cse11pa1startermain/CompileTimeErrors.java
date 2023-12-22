
    
class CompileTimeErrors{
   public CompileTimeErrors(){
    }
   
    // calculate the area of a right triangle
    public static double rightTriangleArea(double base, double height){
       return (base * height) / 2;
    }
   
    // square a number
    public static int squareNumber(int myNumber){
       return myNumber * myNumber;
    }
 
    double answer1 = rightTriangleArea(3, 5); // expected 7.5
    int answer2 = squareNumber(5); // expected 25
    
}
