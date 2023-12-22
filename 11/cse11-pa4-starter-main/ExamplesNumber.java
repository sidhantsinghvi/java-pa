
//import tester.*;
interface Number {
    int numerator();
    int denominator();
    Number add(Number other);
    Number multiply(Number other);
    String toString();
    double toDouble();
}
    class WholeNumber implements Number{
        int n;
        WholeNumber(int n){
            this.n = n;
        }
        public int numerator(){
            return n;
        }
        public int denominator(){
            return 1;
        }
        public Number add(Number other){
            if(other instanceof WholeNumber){
                return new WholeNumber(n+((WholeNumber)other).n);
            }
                else{
                    int numeratorOfAdd = n*other.denominator() + other.numerator();
                    int denominatorOfAdd = other.denominator();
                    return new Fraction(numeratorOfAdd,denominatorOfAdd);
                }
        }
        public Number multiply(Number other){
            if(other instanceof WholeNumber){
                return new WholeNumber(n*((WholeNumber)other).n);
            }
            else{
                int numeratorOfMultiply = n*other.numerator();
                int denominatorOfMultiply = other.denominator();
                return new Fraction(numeratorOfMultiply,denominatorOfMultiply);
            }
        }
        public String toString(){
            return String.valueOf(n);
        }
        public double toDouble(){
            return (double)n;
        }
    }
    class Fraction implements Number{
        int n;
        int d;
        Fraction(int n, int d){
            this.n =n;
            this.d = d;
        }
        public int numerator(){
            return n;
        }
        public int denominator(){
            return d;
        }
        public Number add(Number other){
            int numeratorOfAdd = (other.denominator()*n) + (d*other.numerator());
            int denominatorOfAdd = d*other.denominator();
            return new Fraction(numeratorOfAdd,denominatorOfAdd);
        }
        public Number multiply(Number other){
            int numeratorOfMultiply = n * other.numerator();
            int denominatorOfMultiply = d * other.denominator();
            return new Fraction(numeratorOfMultiply,denominatorOfMultiply);
        }
        public String toString(){
            return String.valueOf(n) + "/" + String.valueOf(d);
        }
        public double toDouble(){
            return (double)n/d;
        }  
    }
    class ExampleNumbers{
        double z = new Fraction(2,5).toDouble();
        // Exploration
        double  y = 0.1 +0.2+0.3;
        double x = 0.1 + (0.2+0.3);
        String w = (new Fraction(1, 10).add(new Fraction(2, 10)).add(new Fraction(3, 10))).toString();
        String v = (new Fraction(1, 10).add((new Fraction(2, 10)).add(new Fraction(3, 10)))).toString();
        }
    