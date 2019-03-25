

public class practice {
    public static void main(String[] args){
        StringBuffer s = new StringBuffer("We are happy!");
        String s2 = replaceSpace(s);
        System.out.println(s2);
        byte a = 127;
        byte b = 127;
        a += b;
        System.out.println(b);


    }

    public static String replaceSpace(StringBuffer str) {
        int i = 0,j = 0;
        String s = str.toString();
        while(j < s.length()){
            if(s.charAt(j) == ' '){
                str.deleteCharAt(i);
                str.insert(i,"%20");
                i += 2;
            }
            j++;
            i++;
        }
        return str.toString();
    }

}
