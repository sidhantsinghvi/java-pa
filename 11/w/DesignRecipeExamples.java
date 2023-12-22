public class DesignRecipeExamples{
    public DesignRecipeExamples(){

    }
   double length = 0;
   double width = 0;
   double widthOuter, heightOuter, widthInner, heightInner;
   double fahrenheitValue;
    public double perimeter(double length, double width){
        this.length = length;
        this.width = width;
        double perimeter = 2*(length + width);
        System.out.println(perimeter);
        return perimeter;
    }
    public double borderArea(double widthOuter, double heightOuter, double widthInner, double heightInner){
      this.widthOuter = widthOuter;
      this.heightOuter = heightOuter;
      this.widthInner = widthInner;
      this.heightInner = heightInner;  
      double outerArea = widthOuter * heightOuter;
      double innerArea = widthInner * heightInner;
      double areaBetween = outerArea - innerArea;
      System.out.println(areaBetween);
      return areaBetween;
    }
    public double fToC(double fahrenheitValue){
        this.fahrenheitValue = fahrenheitValue;
        double celsiusValue = (fahrenheitValue - 32) *5/9;
        System.out.println(celsiusValue);
        return celsiusValue;
    }
    public static void main(String[] args){
        DesignRecipeExamples p1 = new DesignRecipeExamples();
        DesignRecipeExamples p2 = new DesignRecipeExamples();
        DesignRecipeExamples p3 = new DesignRecipeExamples();
        DesignRecipeExamples p4 = new DesignRecipeExamples();
        DesignRecipeExamples p5 = new DesignRecipeExamples();
        DesignRecipeExamples p6 = new DesignRecipeExamples();
        p1.perimeter(2.34,3.0);
        p2.perimeter(120,495);
        p3.borderArea(123,485,29,39);
        p4.borderArea(12.34,23,21,9.20);
        p5.fToC(75);
        p6.fToC(19.55);
    }
}
