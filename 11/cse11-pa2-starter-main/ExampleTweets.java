class Tweet{
User users;
String content;
int likes;
String id;
Tweet(String content, User users, int likes, String id){
    this.users = users;
    this.content = content;8
    this.likes = likes;
    this.id = id;
}
boolean longerThan(Tweet other){
    //performs an if condition to comparing the lengths of tweets of the parameter and value it is compared with
    if(this.content.length() > other.content.length()){
        return true;
    }
    else{
        return false;
    }
}
boolean moreLikes(Tweet other){
    //performs an if condition to comparing the number of likes of tweets of the parameter and value it is compared with
    if(this.likes > other.likes){
        return true;
    }
    else{
        return false;
    }
}

String toText(){
    // returns toText value(all details of tweet) by adding the toText of User class, ":", the content, ":", likes, "likes"
    return  this.users.toText() + " : " + content + " : " + likes + " Likes";
}
String toLink(){
   // returns link by adding "https://twitter.com/", the user's userName,"/status", and the id
   return "https://twitter.com/" + this.users.userName + "/status/" + id;
}
}
class User{
    String userName;
    String displayName;
    int followers;
    String toTextResult;
User(String displayName, String userName, int followers){
    // saves User fields in displayName, userName, and followers order
    this.displayName = displayName;
    this.userName = userName;
    this.followers = followers;
}
String toText(){
    //returns the toText value by adding displayName," @", and userName; 
    toTextResult = displayName + " @" + userName;
    return toTextResult;
}
}
class ExampleTweets{
User ucsdEngineering = new User("UCSD Engineering","UCSDJacobs",13700);
// saves first user
Tweet ucsdEngineeringOne = new Tweet( "Research from the lab of"
+ "@UCSanDiego electrical engineering Prof @FKoushanfar has transformed the "
+ "important fields of hardware-based security, secure AI, and privacy-"
+"preserving computing. In honor of her impact, she's been named a Fellow "
+ "of @TheOfficialACM",ucsdEngineering, 4, "1617654371076165632");
// saves first user's first tweet
//link to actual tweet https://twitter.com/UCSDJacobs/status/1617654371076165632
//couldn't represent date/time, mentions(@__), and an article attached, views
Tweet ucsdEngineeringTwo = new Tweet("Congratulations "
+"to Melio, a startup cofounded by @UCSanDiego @ucsdbefaculty @FraleyLab!"
+" They develop blood tests to ID bacterial, fungal and viral pathogens "
+"in newborns in less than 3 hours. Melio is part of @ige_ucsd."
+" #WomeninScience "
+"#WomenInSTEM #bioengineering",ucsdEngineering,10,"1616495595191152642");
// saves first user's second tweet
//link to actual tweet https://twitter.com/UCSDJacobs/status/1616495595191152642
//couldn't represent date/time,mentions(@_),hashtags(#_),reply to another tweet
User cassidy = new User("Cassidy","cassidoo",185300);
// saves second user
Tweet cassidyOne = new Tweet("Here's the demo I built if you"
+" wanna check it out!! "
+"https://github.com/cassidoo/vscode-astro-stream"
,cassidy,46,"1616123679275991067");
// saves second user's first tweet
// link to actual tweet: https://twitter.com/cassidoo/status/1616123679275991067
//couldn't represent date and time, and a reply to another tweet attached, views
User kimberly = new User("Kimberly Prather, Ph.D.","kprather88",85900);
// saves third user
Tweet kimberlyOne = new Tweet( "An excellent article on gender "
+"equity issues by @meredithwadman in @ScienceMagazine. Impressive that "
+"@UCSanDiego and @Scripps_Ocean have dug into these issues and are working"
+" on positive solutions.",kimberly, 94, "1617672066546937857");
// saves third user's first tweet
//link to actual tweet https://twitter.com/kprather88/status/1617672066546937857
//couldn't represent date/time, mentions(@__), and an article attached, views
String toText1 = ucsdEngineering.toText();
// expected "UCSD Engineering @UCSDJacobs"
String toText2 = cassidy.toText();
// expected "Cassidy @cassidoo"
String toText3 = kimberly.toText();
// expected "Kimberly Prather, Ph.D. @kprather88"
boolean longerThan1 = ucsdEngineeringOne.longerThan(ucsdEngineeringTwo);
// expected false
boolean longerThan2 = ucsdEngineeringTwo.longerThan(ucsdEngineeringOne);
// expected true
boolean longerThan3 = cassidyOne.longerThan(kimberlyOne);
// expected false
boolean moreLikes1 = cassidyOne.moreLikes(kimberlyOne);
// expected false
boolean moreLikes2 = kimberlyOne.moreLikes(ucsdEngineeringTwo);
// expected true
boolean moreLikes3 = ucsdEngineeringOne.moreLikes(cassidyOne);
// expected false
String toText11 = ucsdEngineeringOne.toText();
// expected "UCSD Engineering @UCSDJacobs : Research from the lab of @UCSanDiego electrical engineering Prof @FKoushanfar has transformed the important fields of hardware-based security, secure AI, and privacy-preserving computing. In honor of her impact, she's been named a Fellow of @TheOfficialACM : 4 Likes"
String toText22 = ucsdEngineeringTwo.toText();
// expected "UCSD Engineering @UCSDJacobs : Congratulations to Melio, a startup cofounded by @UCSanDiego @ucsdbefaculty @FraleyLab! They develop blood tests to ID bacterial, fungal and viral pathogens in newborns in less than 3 hours. Melio is part of @ige_ucsd. #WomeninScience #WomenInSTEM #bioengineering : 10 Likes"
String toText33 = cassidyOne.toText();
// expected "Cassidy @cassidoo : Here's the demo I built if you wanna check it out!! https://github.com/cassidoo/vscode-astro-stream : 46 Likes"
String toText44 = kimberlyOne.toText();
// expected "Kimberly Prather, Ph.D. @kprather88 : An excellent article on gender equity issues by @meredithwadman in @ScienceMagazine. Impressive that @UCSanDiego and @Scripps_Ocean have dug into these issues and are working on positive solutions. : 94 Likes"
String toLink1 = ucsdEngineeringOne.toLink();
// expected "https://twitter.com/UCSDJacobs/status/1617654371076165632"
String toLink2 = ucsdEngineeringTwo.toLink();
// expected "https://twitter.com/UCSDJacobs/status/1616495595191152642"
String toLink3 = cassidyOne.toLink();
// expected "https://twitter.com/cassidoo/status/1616123679275991067"
String toLink4 = kimberlyOne.toLink();
// expected "https://twitter.com/kprather88/status/1617672066546937857"
}