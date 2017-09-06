import java.util.Scanner;

public class Calculate{
    
    private static final String SYS_SYMBOL = "0123456789ABCDEF";
    
    private static final int MAX_BIN = 29;
    private static final int MAX_OCT = 10;
    private static final int MAX_DEC = 9;
    private static final int MAX_HEX = 6;
        
    private static final String NUMBER = "Введите число: ";
    private static final String ERROR = "Неверное значение!";
    
    //Input system check
    protected static int checkSys(String mesg){
        int tempInt = 0;
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println(mesg);
            if(input.hasNextInt()) tempInt = input.nextInt();
            if(tempInt != 2 && tempInt != 8 && tempInt != 10 && tempInt != 16){
                System.out.println(ERROR);
                input.next();
                continue;
            }
            break;
        }
        return tempInt;
    }
    
    //Checking for a number from the system and length String for number
    protected static String checkNumber(int sysIn){
        String num;
        int max = 0;
        if(sysIn == 2) max = MAX_BIN;
        if(sysIn == 8) max = MAX_OCT;
        if(sysIn == 10) max = MAX_DEC;
        if(sysIn == 16) max = MAX_HEX;
        while(true){
            System.out.println(NUMBER);
            Scanner input = new Scanner(System.in);
            num = input.nextLine();
            if(num.length() > max || !checkSymbol(num, sysIn)){
                System.out.println(ERROR);
                continue;
            }            
            break;
        }
        return num;
    } 
    
    //Calculation method
    protected static void calculate(int sysIn, int sysOut, String number) {
        if(sysIn == sysOut) {
            System.out.println("Системы ввода и вывода совпадают, число = " + number);
        }
        else{
            System.out.println("Число в " + sysOut + "-ой системе = " + toOther(sysIn, sysOut, number));
        }    
    }
    
    //Decimal conversion
    private static String toDec(int sysIn, String number) {
        String result = "";
        int temp = 0;
        for(int i = number.length() - 1, pow = 0; i >= 0; i--, pow++){
            temp += SYS_SYMBOL.indexOf(number.charAt(i))*Math.pow(sysIn, pow);
        } 
        return String.valueOf(temp);
    }
    
    //Transfer to other systems
    private static String toOther(int sysIn, int sysOut, String number) {
        String result = "";
        int temp;
        
        if(sysIn != 10) number = toDec(sysIn, number);
        if(sysOut == 10) return number;
        temp = Integer.parseInt(number);
        
        while(temp != 0) {  
            int temp_num = temp % sysOut;  
            result = SYS_SYMBOL.charAt(temp_num) + result;
            temp = temp/sysOut;
        }
        return result;
    }
    
    //Checking for a number from the system
    private static boolean checkSymbol(String num, int sysIn) {
        for(int i = 0; i < num.length(); i++){
            if(SYS_SYMBOL.indexOf(num.charAt(i)) > sysIn-1 || SYS_SYMBOL.indexOf(num.charAt(i)) == -1) return false;
        }
        return true;
    }
}