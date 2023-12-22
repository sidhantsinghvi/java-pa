class TextTweet{
    String contents;
    int likes;
    TextTweet(String contents, int likes){
        this.contents = contents;
        this.likes = likes;
    }
    boolean hasMention(String username){
        if(this.contents.contains("@"+username+" ")){
            return true;
        }
        else if(this.contents.endsWith("@"+username)){
            return true;
        }
        else{
        return false;
        }
    }
    boolean hasLike(){
       return this.likes>0;
    }
    String firstMention(){
        if(this.contents.endsWith(" ") && this.contents.contains("@")){
            return this.contents.substring(this.contents.indexOf("@")+1,this.contents.indexOf(" ",this.contents.indexOf("@")));
        }
        else if(!this.contents.contains("@")){
            return "";
        }
        else if(this.contents.lastIndexOf("@") == this.contents.indexOf("@") && this.contents.substring(this.contents.indexOf("@")).indexOf(" ") == -1){
            return "";
        }
        else{
            return this.contents.substring(this.contents.indexOf("@")+1,this.contents.indexOf(" ",this.contents.indexOf("@")));
        }
    }
}
class ReplyTweet{
    TextTweet replyTo;
    String contents;
    int likes;
    ReplyTweet(TextTweet replyTo, String contents, int likes){
        this.replyTo = replyTo;
        this.contents = contents;
        this.likes = likes;
    }
    boolean morePopularReply(){
        return this.likes>this.replyTo.likes;
    }
    int allLikes(){
        return this.likes + this.replyTo.likes;
    }
    boolean hasMention(String username){
        if(this.contents.contains("@"+username+" ")){
            return true;
        }
        else if(this.contents.endsWith("@"+username)){
            return true;
        }
        if(this.replyTo.contents.contains("@"+username+" ")){
            return true;
        }
        else if(this.replyTo.contents.endsWith("@"+username)){
            return true;
        }
        else{
        return false;
        }
    }
}
class ExamplesDrill3{
    TextTweet firstTweet = new TextTweet("bcjeb iebvjbre @f djk", 72);
    TextTweet secondTweet = new TextTweet("bcjeb iebvjbre @fdj", 0);
    TextTweet thirdTweet = new TextTweet("bcjeb iebvjbre @fdjk ", 74);
    TextTweet fourthTweet = new TextTweet("bcjeb @iebvjbre @f djk", 77);
    TextTweet fifthTweet = new TextTweet("bcjeb iebvjbre f djk", 79);
    Boolean hasMentionTest1 = firstTweet.hasMention("f");
    Boolean hasMentionTest2 = firstTweet.hasMention("fd");
    Boolean hasMentionTest3 = fifthTweet.hasMention("f");
    Boolean likeTest1 = fourthTweet.hasLike();
    String firstMentionTest1 = firstTweet.firstMention();
    String secondMentionTest2 = secondTweet.firstMention();
    String thirdMentionTest1 = thirdTweet.firstMention();
    String fourthMentionTest1 = fourthTweet.firstMention();
    String fifthMentionTest1 = fifthTweet.firstMention();
    ReplyTweet firstReply = new ReplyTweet(firstTweet, "NKJEB @NFK ", 171);
    Boolean firstReplyTest1 = firstReply.morePopularReply();
    int allLikesTest1 = firstReply.allLikes();
    Boolean replyHasMentionTest1 = firstReply.hasMention("f");
    Boolean replyHasMentionTest2 = firstReply.hasMention("NFK");
    Boolean replyHasMentionTest3 = firstReply.hasMention("fdn");
    //ReplyTweet replyToReplyTry = new ReplyTweet(firstReply, "nvejkln", 27);
}