import java.math.BigDecimal;

public class Testes {
    public static void main(String[] args) {
        BigDecimal num1 = new BigDecimal(0);
        BigDecimal num2 = new BigDecimal(0.01);
        BigDecimal result = num1.add(num2);
//        System.out.println(result);

        if(num1.compareTo(num1) != 0){
            System.out.println("É diferente de zero");
        }
    }
}
