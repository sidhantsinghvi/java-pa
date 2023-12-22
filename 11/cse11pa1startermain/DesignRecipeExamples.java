public class DesignRecipeExamples{
    
    //perimeter method
    public int perimeter(int length, int width){
        int perimeter = 2*(length + width); 
        //stores perimeter value by adding length and width and then multiplying it by two.
        return perimeter; //returns perimeter value
    }
    //borderArea method
    public int borderArea(int widthOuter, int heightOuter, int widthInner, int heightInner){
        int outerArea = widthOuter * heightOuter; //calculates area of the outer/bigger rectangle
        int innerArea = widthInner * heightInner; //calculates area of the inner/smaller rectangle
        int areaBetween = outerArea - innerArea;  //calculates difference in areas and stores it as areaBetween
        return areaBetween;  //returns the areaBetween value
    }
    //convertor method(converts fahrenheit to celsius)
    public int fToC(int fahrenheitValue){
        //takes fahrenheit value(parameter) and converts it to celsius by subtracting 32 and then multiplying by 5.0/9
        int celsiusValue = (fahrenheitValue - 32) *5/9; 
        return celsiusValue;  // returns value in celsius
    }
    //combiner method(feet and inches to inches)
    public int inInches(int feet, int inch){
        int totalInches = (12 * feet) + inch; 
        //parameter takes in feet and inch values seperately
        //multiplies number of feet by 12 and adds inch number to get result in just inches
        return totalInches;  //returns equivalent inch value to the mix of feet and inch
    }
        int answer1 = perimeter(2,3); //expected 10
        int answer2 = perimeter(120,495); //expected 1230
        int answer3 = borderArea(123,45,29,39); //expected 4404
        int answer4 = borderArea(12,23,21,9); //expected 90
        int answer5 = fToC(68); //expected 20
        int answer6 = fToC(69); //expected 20.555
        int answer7 = fToC(21); //expected -6.1111
        //in the previous two examples the answer isn't accurate as the values are being rounded DOWN to nearest integer as data type is integer, not double.
        int answer8 = inInches(10,4); //expected 124
        int answer9 = inInches(12,7); //expected 151
        int answer10 = inInches(-5,7); 
        //negative values will produce incorrect output as although the value is double, the input is not possible.
        //feet can never be negative
 
}
