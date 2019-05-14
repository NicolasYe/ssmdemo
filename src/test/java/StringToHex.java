public class StringToHex {
    public String convertStringToHex(String str){
        char[] chars = str.toCharArray();
        StringBuffer hex = new StringBuffer();
        for(int i = 0; i < chars.length; i++){
            hex.append(Integer.toHexString((int)chars[i]));
        }
        return hex.toString();
    }
    public String convertHexToString(String hex){
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
//49204c6f7665204a617661 split into two characters 49, 20, 4c...
        for( int i=0; i<hex.length()-1; i+=2 ){
//grab the hex in pairs
            String output = hex.substring(i, (i + 2));
//convert hex to decimal
            int decimal = Integer.parseInt(output, 16);
//convert the decimal to character
            sb.append((char)decimal);
            temp.append(decimal);
        }
        System.out.println("Decimal : " + temp.toString());
        return sb.toString();
    }
    public static void main(String[] args) {
        StringToHex strToHex = new StringToHex();
        System.out.println("\n***** Convert ASCII to Hex *****");
        String str = "03180800662";
        System.out.println("Original input : " + str);
        String hex = strToHex.convertStringToHex(str);
        System.out.println("Hex : " + hex);
        System.out.println("\n***** Convert Hex to ASCII *****");
        System.out.println("Hex : " + "56312e303400960b0f14024400640096012c0075");
        System.out.println("ASCII : " + strToHex.convertHexToString("3033313830333030363935000000000000000000"));
    }
}
