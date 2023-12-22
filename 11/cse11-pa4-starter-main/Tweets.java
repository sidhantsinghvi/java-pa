import tester.*;
interface Tweet{
    public boolean isStartOfThreadBy(String author);
    public int totalLikes();
    public String unrollThread();
}
class TextTweet implements Tweet{
    String contents;
    int likes;
    String author;
    TextTweet(String contents, int likes, String author){
        this.contents = contents;
        this.likes = likes;
        this.author = author;
    }
    public boolean isStartOfThreadBy(String otherAuthor){
        return this.author.equals(otherAuthor);
    }
    public int totalLikes(){
        return this.likes;
    }
    public String unrollThread(){
        return this.author + "\n" + this.likes + " likes" + "\n" + this.contents + "\n";
    }
}
class ReplyTweet implements Tweet{
    String contents;
    int likes;
    String author;
    Tweet replyTo;
    ReplyTweet(String contents, int likes, String author, Tweet replyTo){
        this.contents = contents;
        this.likes = likes;
        this.author = author;
        this.replyTo = replyTo;
    }
    public boolean isStartOfThreadBy(String otherAuthor){
        return this.author.equals(otherAuthor) &&  replyTo.isStartOfThreadBy(otherAuthor);
    }    
    public int totalLikes(){
        return this.likes + replyTo.totalLikes();
    }
    public String unrollThread(){
        return replyTo.unrollThread() + this.author + "\n" + this.likes + " likes" + "\n" + this.contents + "\n";
    } 
}
class Tweets{
    TextTweet tweet1 = new TextTweet("Hello",10,"Mark");
    ReplyTweet tweet2 = new ReplyTweet("Hello this is my second tweet",110,"Mark",tweet1);
    TextTweet tweet3 = new TextTweet("Hi There I'm Paul!",17,"Paul");
    ReplyTweet tweet4 = new ReplyTweet("Hello this is my third tweet",1000,"Paul",tweet2);
         boolean testIsStartOfThreadBy(Tester t){
            return t.checkExpect(tweet1.isStartOfThreadBy("Mark"), true) &&
                   t.checkExpect(tweet1.isStartOfThreadBy("John"), false) &&
                   t.checkExpect(tweet1.totalLikes(),10) &&
                   t.checkExpect(tweet3.totalLikes(),17) &&
                   t.checkExpect(tweet1.unrollThread(),"Mark\n" + 10 + " likes\n"+ "Hello\n") &&
                   t.checkExpect(tweet3.unrollThread(),"Paul\n" + 17 + " likes\n"+ "Hi There I'm Paul!\n") &&
                   t.checkExpect(tweet2.isStartOfThreadBy("Mar"),false) &&
                   t.checkExpect(tweet2.isStartOfThreadBy("Mark"), true) &&
                   t.checkExpect(tweet2.totalLikes(),120) &&
                   t.checkExpect(tweet4.totalLikes(),1120) &&
                   t.checkExpect(tweet4.isStartOfThreadBy("Mark"),false) &&
                   t.checkExpect(tweet4.isStartOfThreadBy("Paul"),false) &&
                   t.checkExpect(tweet2.unrollThread(),"Mark\n" + 10 + " likes\n"+ "Hello\n" + "Mark\n" + 110 + " likes\n" + "Hello this is my second tweet\n") &&
                   t.checkExpect(tweet4.unrollThread(),"Mark\n" + 10 + " likes\n"+ "Hello\n" + "Mark\n" + 110 + " likes\n" + "Hello this is my second tweet\n" + "Paul\n" + 1000 + " likes\n" + "Hello this is my third tweet\n");
    }
}


