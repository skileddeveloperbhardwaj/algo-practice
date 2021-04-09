import java.util.HashSet;

public class UniqueEmailAddress {

    public static void main(String[] args) {
        String[] emails = new String[]{
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
        };
        System.out.println(new UniqueEmailAddress().numUniqueEmails(emails));
    }
    public int numUniqueEmails(String[] emails) {

        if(emails.length == 0) {
            return 0;
        }
        HashSet<String> set = new HashSet<String>();
        for(int i=0;i<emails.length;i++) {
            String str = prepareString(emails[i]);
            set.add(str);
        }
//        for(String str:set) {
//            System.out.println(str);
//        }
        return set.size();

    }

    private String prepareString(String email) {
        String finalStr = "";
        String[] type = email.split("@");
        String localName = type[0];
        String domainName = type[1];
        StringBuilder local = new StringBuilder(localName);
        for(int i=0;i<local.length();i++) {
            if(local.charAt(i) == '.') {
                local.setCharAt(i,' ');
            }
        }

        String localStr = local.toString().split("\\+",2)[0];
        finalStr =localStr.replaceAll("\\s", "")+"@"+domainName;

        return finalStr;
    }
}
