class Longest {
    public static void main(String[] args){
        String longest;
        if(args.length == 0){
            longest = "";
        }
        longest = args[0];
        for(int i = 0;i<args.length;i++){
            if(args[i].length() > longest.length()){
                longest = args[i];
            }
        }
        System.out.println(longest);
    }
}
