import java.nio.file.*;

import java.io.IOException;
class FileHelper {
    static String[] getLines(String path) {
        try {
            return Files.readAllLines(Paths.get(path)).toArray(String[]::new);
        }
        catch(IOException e) {
            System.err.println("Error reading file " + path + ": " + e);
            return new String[]{"Error reading file " + path + ": " + e};
        }
    }
}
class StringSearch{
    public static void main(String[] args){
       
        String[] lines = FileHelper.getLines(args[0]);
        if(args.length == 1){
            for(int i = 0;i<lines.length;i++){
                System.out.println(lines[i]);
            }
        }
        if(args.length == 2){
            for(int j = 0;j<lines.length;j++)
                if(readQuery(args[1]).matches(lines[j])){
                    System.out.println(lines[j]);
                }
            }
            if(args.length ==3){
                for(int k=0;k<lines.length;k++){
                    if(readQuery(args[1]).matches(lines[k])){
                        System.out.println(readTransform(args[2]).transform(lines[k]));
                    }
                }
            }
        }
         static Query readQuery(String q){
            String str = q.substring(0, q.indexOf("=")+1);
            if(str.equals("contains=")){
                return new ContainsQuery(q.split("'")[1]);
            }
            else if(str.equals("length=")){
                if(q.endsWith(")")){
                return new LengthQuery(q.substring(q.indexOf("=")+1,q.length()-1));
                }
                else{
                    return new LengthQuery(q.substring(q.indexOf("=")+1));
                }
            }
            else if(str.equals("greater=")){
                if(q.endsWith(")")){
                    return new GreaterQuery(q.substring(q.indexOf("=")+1,q.length()-1));
                }
                else{
                return new GreaterQuery(q.substring(q.indexOf("=")+1));
                }
            }
            else if(str.equals("less=")){
                if(q.endsWith(")")){
                return new LessQuery(q.substring(q.indexOf("=")+1,q.length()-1));
            }
            else{
                return new LessQuery(q.substring(q.indexOf("=")+1));
            }
        }
            else if(str.equals("starts=")){
                return new StartsQuery(q.split("'")[1]);
            }
            else if(str.equals("ends=")){
                return new EndsQuery(q.split("'")[1]);
            }
            else if (str.startsWith("not")) {
                return new NotQuery(readQuery(q.substring(4)));
            }
            else{
                throw new IllegalArgumentException("query can't be accepted");
            }
}   
static Transform readTransform(String t){
    if(t.equals("upper")){
        return new UpperTransform();
    }
    else if(t.equals("lower")){
        return new LowerTransform();
    }
    else if(t.startsWith("first=")){
        return new FirstTransform(t.substring(t.indexOf("=")+1,t.length()));
    }
    else if(t.startsWith("last=")){
        return new LastTransform(t.substring(t.indexOf("=")+1,t.length()));
    }
    else if(t.startsWith("replace=")){
        return new ReplaceTransform(t); 
    }
    else{
        throw new IllegalArgumentException("transform can't be accepted");
    }
    }
}
class ContainsQuery implements Query{
    String t;
    ContainsQuery(String t){
        this.t = t;
    }
    public boolean matches(String s){
        return s.contains(t);
    }
}
class LengthQuery implements Query{
    String t;
    LengthQuery(String t){
        this.t = t;
    }
    public boolean matches(String s){
        return s.length() == Integer.parseInt(t);
    }
}
class LessQuery implements Query{
    String t;
    LessQuery(String t){
        this.t = t;
    }
    public boolean matches(String s){
        return s.length() < Integer.parseInt(t);
    }
}
class GreaterQuery implements Query{
    String t;
    GreaterQuery(String t){
        this.t = t;
    }
    public boolean matches(String s){
        return s.length() > Integer.parseInt(t);
    }
}
class StartsQuery implements Query{
    String t;
    StartsQuery(String t){
        this.t = t;
    }
    public boolean matches(String s){
        return s.startsWith(t);
    }
}
class EndsQuery implements Query{
    String t;
    EndsQuery(String t){
        this.t = t;
    }
    public boolean matches(String s){
        return s.endsWith(t);
    }
}
class NotQuery implements Query{
    Query t;
    NotQuery(Query t){
        this.t = t;
    }
    public boolean matches(String s){
      if(t.matches(s)){
        return false;
      }
      else{
        return true;
      }
}
}
class UpperTransform implements Transform{
    public String transform(String s){
        return s.toUpperCase();
    }
}
class LowerTransform implements Transform{
    public String transform(String s){
        return s.toLowerCase();
    }
}
class FirstTransform implements Transform{
    String tr;
    FirstTransform(String tr){
        this.tr = tr;
    }
    public String transform(String s){
        if(Integer.parseInt(tr) < s.length()){
            return s.substring(0, Integer.parseInt(tr));
        }
        else{
            return s;
        }
    }
}
class LastTransform implements Transform{
    String tr;
    LastTransform(String tr){
        this.tr = tr;
    }
    public String transform(String s){
        if(Integer.parseInt(tr) < s.length()){
            return s.substring(s.length()-Integer.parseInt(tr));
        }
        else{
            return s;
        }
    }
}
class ReplaceTransform implements Transform{
    String tr;
    ReplaceTransform(String tr){
        this.tr = tr;
    }
    public String transform(String s){
        return s.replaceAll(tr.split("'")[1], tr.split("'")[3]);      
}
}

interface Query{
    boolean matches(String s);
}
interface Transform{
    String transform(String s);
}
