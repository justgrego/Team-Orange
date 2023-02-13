public class About {
    final static String[] names = {"JD Sawyer", "Michael Tuksan","Ian Liston", "Matthew Kim", "Gregory Yi"};
    final static String comment =", I can be reached at: ";
    final static String[] emails = {"jds1223@uw.edu","","","",""};

    public static String displayUser(User user){
        String ret  = "This app is registered to: ";
        ret += user.getUsername();
        return ret;
    }
    public static String displayString(){
        String ret  = "This app is provided by Team Orange: \n";
        for(int i = 0 ; i < names.length ; i++){
            if(names.length != emails.length){
                ret = "The list of names and emails is not equal.";
            }else{
                ret += names[i] + comment + emails[i] + "\n";
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        User temp = new User("tempUser","lolhaha");
        System.out.println(displayUser(temp));
        System.out.println(displayString());
    }
}
