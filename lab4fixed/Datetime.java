package lab4fixed;
import java.util.Scanner;
class datetime {
    private int year;
    private int month;
    private int day;
    private static Scanner sc;
    public datetime(String dt) {
        if (!dt.matches("\\d{4}[-./]\\d{1,2}[-./]\\d{1,2}")) {
            throw new IllegalArgumentException("Өгөгдсөн огноо буруу байна. Жишээ: 2026-03-06"); }
        String[] values = dt.split("[-./]");
        year = Integer.parseInt(values[0]);
        month = Integer.parseInt(values[1]);
        day = Integer.parseInt(values[2]);
        if(!isValidDate()){
            throw new IllegalArgumentException("Буруу огноо орууллаа. Сэргээж зөв огноо оруулна уу.");
    } }
    private boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    private boolean isValidDate(){
        if(month < 1 || month > 12){
            return false; }
        int[] daysInMonth = {
            31,
            isLeapYear(year) ? 29 : 28,
            31,30,31,30,
            31,31,
            30,31,30,31 };
        return day >= 1 && day <= daysInMonth[month-1]; }
    private int getyearcode(int year){
        int lastTwo = year % 100;
        return (lastTwo + lastTwo/4) % 7; }
    private int getmonthcode(int month){
        switch(month){
            case 1: return 0;
            case 2: return 3;
            case 3: return 3;
            case 4: return 6;
            case 5: return 1;
            case 6: return 4;
            case 7: return 6;
            case 8: return 2;
            case 9: return 5;
            case 10: return 0;
            case 11: return 3;
            case 12: return 5;
            default: return 0;  } }
    private int getcenturycode(int century){
        switch(century){
            case 17: return 4;
            case 18: return 2;
            case 19: return 0;
            case 20: return 6;
            case 21: return 4;
            case 22: return 2;
            case 23: return 0;
            default: return 0;} }
    private int getleapyearcode(int year, int month){
        if(isLeapYear(year) && (month == 1 || month == 2)){
            return 1; }
        return 0; }
    private int dayofweek(){
        int yearCode = getyearcode(year);
        int monthCode = getmonthcode(month);
        int centuryCode = getcenturycode(year/100);
        int leapCode = getleapyearcode(year, month);
        return (yearCode + monthCode + centuryCode + day - leapCode) % 7;
    }
    public void printdayofweek(){
        int result = dayofweek();
        String dayName = "";
        switch(result){
            case 0: dayName = "Бүтэнсайн"; break;
            case 1: dayName = "Даваа"; break;
            case 2: dayName = "Мягмар"; break;
            case 3: dayName = "Лхагва"; break;
            case 4: dayName = "Пүрэв"; break;
            case 5: dayName = "Баасан"; break;
            case 6: dayName = "Бямба"; break;
        }
        System.out.println(year + " оны " + month + "-р сарын " + day + " бол " + dayName);
    }
    public static void main(String[] args){
        sc = new Scanner(System.in);
        try{
            System.out.print("Огноо оруулна уу (yyyy-mm-dd): ");
            String input = sc.nextLine();
            datetime d = new datetime(input);
            d.printdayofweek();
        }catch(Exception e){
            System.out.println("Алдаа: " + e.getMessage());
        }
    }
}