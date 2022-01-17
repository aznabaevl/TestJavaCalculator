
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input:");
        String inline = sc.nextLine();
        String rez=calc(inline);
        System.out.println(rez);

    }
    public static String calc (String str){
        char mstr[]=new char[str.length()];//Массив для хранения символов строки
        int j=0;//Счетчик
        //-----Записываем строку в массив по символьно-----------------------
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)!= ' ' ) {
                mstr[j]=str.charAt(i);
                j++;
            }
        }
        //--------------------------------------------------------------------

        //-----Обработанный массив с числами без пробелов---------------------
        char rstr[]=new char[j];
        //--------------------------------------------------------------------

        //-----Записываем в наш массив числа и знаки без пробелов-------------
        for (int i=0;i<rstr.length;i++){
            rstr[i]=mstr[i];
            //System.out.println(rstr[i]);
        }
        //--------------------------------------------------------------------

        //-----Проверки корректности операции---------------------------------
        j=0;
        for (int i=0;i<rstr.length;i++){
            if ((rstr[i]=='+')|(rstr[i]=='-')|(rstr[i]=='*')|(rstr[i]=='/')){
            if((i==0)|(i==rstr.length-1)) {
                System.out.println("Output:");
                return "Исключение";}
            j++;
            }
        }
        if (j!=1) {
            System.out.println("Output:");
            return "Исключение";}
        //--------------------------------------------------------------------

        //-----Разделение чисел-----------------------------------------------
        String s1=""; //Первое число в операции
        String s2="";//Второе число в операции
        j=0;
        char znak=' '; //Для хранения знака операции

        for (int i=0;i<rstr.length;i++){ //Поиск знака операции
            if ((rstr[i]=='+')|(rstr[i]=='-')|(rstr[i]=='*')|(rstr[i]=='/')){
                znak=rstr[i];
            }
            }
        //Разделение чисел
        while ((rstr[j]!=znak)){
            s1=s1+Character.toString(rstr[j]) ;
            j++;
        }
        j++;
        while ( j<rstr.length){
            s2=s2+Character.toString(rstr[j]) ;
            j++;
        }
        //--------------------------------------------------------------------

        //-----Проверка чисел и выполнение операции---------------------------
        int a, b;
        int c=0;
        char scha='-';
        char schb='-';
        switch (s1){
            case "I":s1="1";scha='R';break;
            case "II":s1="2";scha='R';break;
            case "III":s1="3";scha='R';break;
            case "IV":s1="4";scha='R';break;
            case "V":s1="5";scha='R';break;
            case "VI":s1="6";scha='R';break;
            case "VII":s1="7";scha='R';break;
            case "VIII":s1="8";scha='R';break;
            case "IX":s1="9";scha='R';break;
            case "X":s1="10";scha='R';break;
        }
        switch (s2){
            case "I":s2="1";schb='R';break;
            case "II":s2="2";schb='R';break;
            case "III":s2="3";schb='R';break;
            case "IV":s2="4";schb='R';break;
            case "V":s2="5";schb='R';break;
            case "VI":s2="6";schb='R';break;
            case "VII":s2="7";schb='R';break;
            case "VIII":s2="8";schb='R';break;
            case "IX":s2="9";schb='R';break;
            case "X":s2="10";schb='R';break;
        }


        try {
            a = Integer.valueOf(s1);
            b = Integer.valueOf(s2);
        } catch (NumberFormatException e){
            System.out.println("Output:");
            return "Исключение";
        }

        switch (znak){
            case '+': c=a+b;break;
            case '-': c=a-b;break;
            case '/': c=a/b;break;
            case '*': c=a*b;break;
        }
        //--------------------------------------------------------------------

        //-----Вывод результатов---------------------------------------------
        if ((a<1)|(b>10)) {
            System.out.println("Output:");
            return "Исключение";
        }

        int num=c;
         int  []A = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
         String []R = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};

        if ((scha=='R')&(schb=='R')&(c>=1)) {
            int i = 12;
            String result = "";
            while (num > 0) {
                while (A[i] > num){
                    i--;
                }
                result += R[i];
                num -= A[i];
            }
            System.out.println("Output:");
            return result;
        } else {
            System.out.println("Output:");
            return Integer.toString(c);
        }
        //--------------------------------------------------------------------
        

        }



}
