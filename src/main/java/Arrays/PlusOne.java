package Arrays;

import java.math.BigInteger;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        boolean flag=false;//проверка на то что одни девятки 99999 (для понимания какой будет массив - такой же
        //длины или нет
        for (int digit : digits) {
            if (digit == 9) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        if(flag){//если все девятки, то новый массив велчииной =1, и далее заполнили
            int[] newArr = new int[digits.length+1];
            newArr[0]=1;
            for(int i=1; i< newArr.length;i++){
                newArr[i]=0;
            } return newArr;
        }

        int[] newArr = new int[digits.length];
        if(digits[digits.length-1]==9){//проверили, если последний элемент равен 9
            newArr[digits.length-1]=0;//назначили нулем
            int add=1;// добавка
            for(int i=digits.length-2; i>=0;i--){
                if(digits[i]==9){//пошли по всему массиву, если 9 - и есть в уме единица
                    if(add==1){
                        newArr[i]=0;// обнуляем
                    }else{
                        newArr[i]=digits[i];//оставляем
                    }
                }
                else{
                    newArr[i]=digits[i]+add;//если не девятка, то добавляем нашу добавку, и обнуляем
                    add=0;
                }
            } return newArr;
        }
        for(int i=digits.length-1; i>=0; i--){

                if(i==digits.length-1){
                    digits[digits.length-1]+=1;
                    return digits;
                }
                else{
                    if(newArr[i]==0){
                        newArr[i]=digits[i];
                    }
                }

        } return newArr;
    }

    public int[] plusOneFast(int[] digits) {
        /*собрали массив в строку
        Преобразовали строку в БигИнтежер
        Добавили 1
        Вернули обратно в строку, строку разбили на массив (получился новый массив с цифрами)
        далее записали новый массив с учетом прибавленной единицы
        * */
        StringBuilder sb = new StringBuilder("");
        for (int i : digits) {
            sb.append(i);
        }
        BigInteger i = new BigInteger(sb.toString());
        i = i.add(new BigInteger("1"));
        String[] temp = i.toString().split("");
        int[] result = new int[temp.length];
        int count = 0;
        for (String s : temp) {
            result[count++] = Integer.parseInt(s);
        }
        return result;
    }


}
