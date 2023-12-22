class Stats {
    public static void main(String[] args){
        if(args[0].equals("--product")){
            double product = 1.0;
            for(int i =1;i<args.length;i++){
                product = product * Double.parseDouble(args[i]);
            }
            System.out.println(product);
        }
        else if(args[0].equals("--mean")){
            double mean = 0.0;
            for(int i = 1;i<args.length;i++){
                mean = mean + Double.parseDouble(args[i]);
            }
            System.out.println(mean/(args.length-1));
        }
        else if(args[0].equals("--total")){
            double total = 0.0;
            for(int i = 1;i<args.length;i++){
                total = total + Double.parseDouble(args[i]);
            }
            System.out.println(total);
        }
        else if(args[0].equals("--max")){
            double max = Double.parseDouble(args[1]);
            for(int i =1;i<args.length;i++){
                if(Double.parseDouble(args[i])>max){
                    max = Double.parseDouble(args[i]);
                }
            }
            System.out.println(max);
        }
        else if(args[0].equals("--min")){
            double min = Double.parseDouble(args[1]);
            for(int i =1;i<args.length;i++){
                if(Double.parseDouble(args[i])<min){
                    min = Double.parseDouble(args[i]);
                }
            }
            System.out.println(min);
        }
        else{
            System.out.println("Bad option " + args[0]);
        }
    }
}
