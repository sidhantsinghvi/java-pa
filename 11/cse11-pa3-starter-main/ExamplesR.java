class R{
    String aString;
    R RString;
    R(String aString, R RString){
        this.aString = aString;
        this.RString = RString;
    }
}
class ExampleR{
    //these lines are all commented as they run errors
    //R firstR = new R("rrrrr",firstR);
    //I couldn't make an example R object as no R value to give for the constructors second parameter
    R secondR = new R(null,null);
    //ReplyTweet replyToReplyTry = new ReplyTweet(firstReply, "nvejkln", 27);
    //couldn't reply to a reply as the first reply is not a TweetText type, 
    //and therefore can't be placed as the first parameter in the replyTweet format
}
