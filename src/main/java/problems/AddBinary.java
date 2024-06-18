package problems;

/**
 * @author VeselovND <br>
 * created at 18.06.2024 <br>
 * <a href="https://leetcode.com/problems/add-binary/description/">Add Binary</a>
 */
public class AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        //По правилу: 1+1 =10, 1+0 =1, 0+0=0
        //уравниваем строки лидирующими нулями, далее начинаем складывать справа налево, учитывая добавку к левому разряду
        //когда строка собрана - проверяем остался ли доп. разряд, если да - то ставим единичку слева
        String left;
        String right;
        if (a.length() > b.length()) {
            left = a;
            int diff = a.length() - b.length();
            right = addLeadingZeros(b, diff);
        } else if (b.length() > a.length()) {
            left = b;
            int diff = b.length() - a.length();
            right = addLeadingZeros(a, diff);
        } else {
            left = a;
            right = b;
        }
        StringBuilder sb = sum(left, right);
        return sb.toString();
    }

    private static StringBuilder sum(String left, String right) {
        boolean add = false;
        StringBuilder sb = new StringBuilder();
        for (int i = left.length() - 1; i >= 0; i--) {
            char firstValue = left.charAt(i);
            char secondValue = right.charAt(i);
            if ((firstValue == '1' && secondValue == '0') || (secondValue == '1' && firstValue == '0')) {
                if (add) {
                    sb.insert(0, '0');
                } else {
                    sb.insert(0, '1');
                }
            } else if (firstValue == '0' && secondValue == '0') {
                if (add) {
                    sb.insert(0, '1');
                    add = false;
                } else {
                    sb.insert(0, '0');
                }
            } else {
                if (add) {
                    sb.insert(0, '1');
                } else {
                    sb.insert(0, '0');
                    add = true;
                }
            }
        }
        if (add) {
            sb.insert(0, '1');
        }
        return sb;
    }

    private static String addLeadingZeros(String str, int qnt) {
        StringBuilder stringBuilder = new StringBuilder(str);
        while (qnt > 0) {
            stringBuilder.insert(0, "0");
            qnt--;
        }
        return stringBuilder.toString();
    }
}
