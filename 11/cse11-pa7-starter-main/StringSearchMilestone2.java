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
            for(int j = 0;j<lines.length;j++){
               // System.out.println(args[1].split("'")[1]);
               ContainsQuery CQ = new ContainsQuery(args[1].split("'")[1]);
                if(CQ.matches(lines[j])){
                    System.out.println(lines[j]);
                }
            }
        }
    }
}
class ContainsQuery{
    String t;
    ContainsQuery(String t){
        this.t = t;
    }
    boolean matches(String s){
        return s.contains(t);
    }
}