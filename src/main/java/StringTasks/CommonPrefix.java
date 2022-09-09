package StringTasks;

public class CommonPrefix {
    /*Написать функцию которая находит самый длинный префикс среди массива строк
    * @return префикс
    * Берем первую строку из массива, и начинаем проходить по каждому символу в цикле, пока строка не закончится
    * Если текущий индекс < длины строки из массива, проверяем на равенство  - если равны - ставим флаг в тру
    * Если нет - в фолс, и останавливаем цикл
    * Если текущий индекс больше длины проверяемой строки - то также ставим фолс - и останавливаем цикл
    * В конце проверяем наш флаг - если он тру - значит есть совпадения, добавляем в СтрингБилдер, и инкрементируем
    * индекс, если нет - то стоп*/
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        String first = strs[0];
        int index=0;
        boolean flag=false;
        while(index<first.length()){
            char ch = first.charAt(index);
            for(String str:strs){
                if(index<str.length()){
                    if(str.charAt(index)==ch){
                        flag=true;
                    }
                    else{flag=false;
                    break;}
                }
                else{
                    flag=false;
                    break;}
                } if(flag){
                    sb.append(ch);
                    index++;}
            else {
                break;
            }
            }
        return sb.toString();
        }
    }
