public class Syst extends Calculate{
    
    private static final String SYSTEM_IN = "Введите систему из которой переводить 2|8|10|16: ";
    private static final String SYSTEM_OUT = "Введите систему в которую переводить 2|8|10|16: ";
    
    public static void main(String[] args) {
        int sysIn = Calculate.checkSys(SYSTEM_IN);
        int sysOut = Calculate.checkSys(SYSTEM_OUT);
        String number = checkNumber(sysIn);
        Calculate.calculate(sysIn, sysOut, number);
    }
}