class statementCTester{
    int addToFive(int num){
        return 5+num;
    }
    int addToFour(int num){
        return 4+num;
    }
}
class Open1C{
    public static void main(String[] args) {
statementCTester testerC = new statementCTester();
testerC.addToFive(6);
}
}
