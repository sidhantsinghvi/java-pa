import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;
public class inttostring{
    public static void main(String[] args) 
    {
    Scanner input = new Scanner(System.in);
    string i, n, mt, ft, score;
    double pa=0;
    double ab=0;
    double temp=0;
    n= input.nexT.Line();
    for (i=1; i<=n ;i++) 
    {
        temp = input.nextDouble();
        if(temp >= 0 && temp <= 100)
        {   
        pa = pa + temp;
        }
        else
        {
        ab = -1;
        }
    }
    mt = input.nextDouble();
    ft = input.nextDouble();
    score = ((pa/n)/2)+(12.5*(mt/100))+(37.5*(ft/100));
    if(ab == -1 || mt >100 || mt < 0 || ft > 100 || ft < 0)
    {
    System.out.print("invalid output");
    }
    else
    {
    System.out.println(score);
    if(score >= 90 && score <= 100)
    {System.out.print("A");}
    else if(score >= 80)
    {System.out.print("B");}
    else if(score >= 70)
    {System.out.print("C");}
    else if(score >= 60)
    {System.out.print("D");}
    else if(score >= 0 && score < 60)
    {System.out.print("F");}
    else
    {}
    } 
    }
}
