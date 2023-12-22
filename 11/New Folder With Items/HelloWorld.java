public class HelloWorld {
    public static void main(String[] args) {
        public static int sum(int n) {
            if (n < 2) { 
            return 1; 
            }
            return (n + sum(n + 1)); 
            }
        }
    }