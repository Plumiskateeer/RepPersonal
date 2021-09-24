package factorial;
import java.math.BigInteger;
import java.util.Arrays;

public class Factorial {
    public static BigInteger factorial(int i){
        BigInteger res = BigInteger.ONE;
        for (int p = 1; p <= i; p++){
            res = res.multiply(new BigInteger(Integer.toString(p)));
        }
        return res;
    }

    public static void main(String[] args) {
        BigInteger f = factorial(100);
        System.out.println(f);
        System.out.println(nCeros(f));
    }

    public static int nCeros(BigInteger b){
        String s = b.toString();
        int pos = s.length()-1;
        int ceros = 0;
        while (pos >= 0 && s.charAt(pos) == '0'){
            ceros++;
            pos--;
        }
        return ceros;
    }
}
