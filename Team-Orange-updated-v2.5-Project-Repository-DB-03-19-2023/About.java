/**
 * About Class - Forked from JD git, edited out static methods
 * @Version Michael Tuskan
 */
public class About {
    private String[] names;
    private String comment;
    private String[] emails;
    private String version;

    public About() {
        names = new String[]{"JD Sawyer", "Michael Tuksan", "Ian Liston", "Matthew Kim", "Gregory Yi"};
        comment =", I can be reached at: ";
        emails = new String[]{"jds1223@uw.edu", "", "IanList@uw.edu", "", ""};
        version = "1.0";
    }

    public String displayUser(User user){
        String ret  = "This app is registered to: ";
        ret += user;
        return ret;
    }

    public String getVersion() {
        return "";
    }

    public String displayString(){
        String ret  = "This app is provided by Team Orange and is in version" + version + "\n";
        for(int i = 0 ; i < names.length ; i++){
            if(names.length != emails.length){
                ret = "The list of names and emails is not equal.";
            }else{
                ret += names[i] + comment + emails[i] + "\n";
            }
        }
        return ret;
    }
}