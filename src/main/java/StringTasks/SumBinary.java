package StringTasks;

public class SumBinary {
    /*Сложить две строки представленные в двоичном виде, строки без лидирующих нулей;
    * Сложение происходит по следующим принципам - 1+1=0 (1 добавляется в следующий разряд) 0+0=0, 0+1=1;
    * Сначала находим короткую и длинную строку, и добавляем нули слева в короткую;
    * Далее идем справа налево, проверяя крайние значения символов и проверяем флаг hasAdd для понимания,
    * нужно ли добавлять 1 в следующий разряд или нет;
    * В конце проверяем - если hadAdd=true, значит осталась недобавленная единица, подставляем ее справа.
    * Переворачиваем StringBuilder, и возвращаем строку
    * */
    public String addBinary(String a, String b){
        String max;
        String min;
        if(a.length()>b.length()){
            max=a;
            min=b;
        }
        else{
            max=b;
            min=a;
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder withZeroes = new StringBuilder(min);
        for(int i=0;i<(max.length()-min.length());i++){
            withZeroes.insert(0,"0");
        }

        min = withZeroes.toString();
        boolean hasAdd = false;
        for(int i=max.length()-1; i>=0; i--){
                    char charMax = max.charAt(i);
                    char charMin = min.charAt(i);
                    if(charMax=='0'&&charMin=='0'){
                            if(hasAdd){
                                sb.append(1);
                                hasAdd=false;
                            }
                            else{
                                sb.append(0);
                            }
                        }
                    else if(charMax=='1'&&charMin=='1'){
                        if(hasAdd){
                            sb.append(1);
                        }
                        else{
                            sb.append(0);
                            hasAdd=true;
                        }
                    }
                    else{
                        if(hasAdd){
                            sb.append(0);
                        }
                        else{
                            sb.append(1);
                        }
                    }
            }
        if(hasAdd){
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
