class SameName{
    int numberHere;
    SameName(int numberHere){
        this.numberHere  = numberHere;
    }

}
class StatementATester{
    int numberHere;
    StatementATester(int numberHere){
        this.numberHere  = numberHere;
    }
}
class Open1A{
    StatementATester a = new StatementATester(2);
    SameName b = new SameName(3);
}