import java.util.Scanner;
public class PasswordSecurity {
    public static void main(String[] args) 
    {
    Scanner input = new Scanner(System.in);
    int a;
    int b=0;
    int f=0;
    int d=0;
    int e=0;
    int g=0;
    double totalu= 0, totall =0, totaln= 0, totals= 0;
    int passlength= 0;

System.out.print("Please enter a password: ");//asks user for password
String password= input.nextLine();//password input by user
passlength = password.length();
if(passlength<8){
    System.out.println("Password is too short");}//displays this if pasword is shorter than 8 characters
else{

  for(a=0; a<passlength; a++)
  {
  char c = password.charAt(a);
    if(Character.isUpperCase(c))
    {totalu++ ;//counts upper case
    b=1;
}
    else if(Character.isLowerCase(c))
    {totall++;//counts lower case
    f=1;}
    else if(Character.isDigit(c))
    {totaln++;//counts numbers
    d=1;}
    else
    {totals++;//counts special characters
    e=1;}
}
if(b+f+d+e==1)//checks if it has one of lower/upper/number/special characters
{System.out.println("Password strength: very weak");}
else if(b+f+d+e==2)//checks if it has two of lower/upper/number/special characters
{System.out.println("Password strength: weak");}
else if(b+f+d+e==3)//checks if it has three of lower/upper/number/special characters
{System.out.println("Password strength: medium");}
else if(b+f+d+e==4)//checks if it has all of lower/upper/number/special characters
{System.out.println("Password strength: strong");}

if(b+f+d+e!=4)//if password isn't strong
{
if(totalu+totall<2){
password="Cse"+password;//cse added if total upper and lower letters is less than 2
g =1;
}
else if(totall == 0){
    for(int aa=0; aa< passlength; aa++){
        char c = password.charAt(aa);
        if(Character.isUpperCase(c))
        {
        password = password.substring(0,aa)+Character.toLowerCase(c)+password.substring(aa+1, passlength);
    //the above line adds letters until the first uppercase, replaces it with a lower case, then places other letters
        break;
        }
        }
        g =2;
}
else if(totalu == 0){
    int cc = 0;

int biggest= 0;
for (int l = 0; l < password.length(); l++)
{
    int valuei = (int)password.charAt(l);
    if(valuei > biggest)
        biggest = valuei;//finds greatest ascii value
}
char valueii = (char)biggest;
int  bb= password.lastIndexOf(valueii);//finds last index of the ascii value
char m = Character.toUpperCase(password.charAt(bb));
password = password.substring(0,bb)+m+password.substring(bb+1,passlength);
//System.out.println(password);
g =3;
}
if(totaln==0){
    int k = passlength%10;
    String new_pass = "";
    int r;
    int p= password.length();
    for(r=0; r<p; r+=1){
        if (r%4 == 0 && r!=0) {//finds modulus and whenever it equals zero, k is added
            new_pass += k;
            
        }
        new_pass += password.charAt(r);
    }
    if (passlength%4 == 0) {
        new_pass += k;//adds k in the last if length is divisible by four
    }
    password = new_pass;
}
if(totals==0){
    password+="@!";
}
System.out.println("Here is a suggested stronger password: "+ password);//prints password
}

}

}
}