public class CharToAscii {
    public static void main(String[] args) {
//        CharToAscii.AscToString();
//        CharToAscii.StringToAsc();
        String ss=CharToAscii.StringToA("0318");
        System.out.println(ss);
        char a = '0';
        int b = 22307;
        //char类型参与四则运算的时候是转化成asciii码的, 字符‘0’的ascii码为48，要转换成int型，只需要（‘0’-48）即可
//        System.out.println(a-48);
//        System.out.println((int)a); //将char型强行转制为int型得到的是Ascii码
//        System.out.println((char)b);//将int型强行转制为char型得到的是字符
//        System.out.println("0318");
    }

    public static void AscToString() {  //ASCII转换为字符串
        String s = "22307 35806 24555 20048";
        String[]  chars = s.split(" ");
        for (int i = 0; i < chars.length; i++){
            System.out.println(chars[i] + " " + (char)Integer.parseInt(chars[i]));
        }
    }

    public static void StringToAsc() { //字符串转换为ASCII码
        String s = "0318";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++){
            System.out.println(" " + chars[i] + " " + (int)chars[i] );
        }
    }

    public static String StringToA(String content){
        String result = "";
        int max = content.length();
        for (int i=0; i<max; i++){
            char c = content.charAt(i);
            int b = (int)c;
            result = result + b;
        }
        return result;
    }
}
