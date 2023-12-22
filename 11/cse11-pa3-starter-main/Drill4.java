import java.lang.Math;
class Drill4{
    String phaseOfWater(int temperature){
        if(temperature >= 100){
        return "vapor";
        }
        else if(temperature <= 0){
        return "solid";
        }
        else{
            return "liquid";
        }
    }
    int maxDifference(int a, int b, int c){
        return Math.subtractExact(Math.max(Math.max(a,b),c),Math.min(Math.min(a,b),c));
    }
    double ringArea(double r1, double r2){
        return Math.PI*(Math.pow(r2,2)-Math.pow(r1,2));
    }
    String waterAt90 = phaseOfWater(90); //liquid
    String waterAt100 = phaseOfWater(100); //vapor
    String waterAt101 = phaseOfWater(101); //vapor
    String waterAt0 = phaseOfWater(0); //solid
    String waterAtN2 = phaseOfWater(-2); //solid
    int maxDifference1 = maxDifference(2, 0, 4); //4
    int maxDifference2 = maxDifference(-2, 0, -4);//4
    int maxDifference3 = maxDifference(-2, -1, -4);//3
    int maxDifference4 = maxDifference(2, 2, 2);//0
    double ringArea1 = ringArea(12, 14);//163.3628
    double ringArea2 = ringArea(2, 4);//37.69911
    double ringArea3 = ringArea(3, 100);//31387.6522
    double ringArea4 = ringArea(0, 1);//3.14159
    double ringArea5 = ringArea(0, 10);//314.159265
}