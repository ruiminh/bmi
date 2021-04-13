package business.services;

public class BmiUtil {
    public static Double calcBMI(Double height,Double weight){
       return weight/((height/100)*(height/100));
    }
    public static String getCategory(Double bmi){
        String category="";
        if(bmi>30){
            category="big fatty";
        }else if (bmi<18.5){
            category="too thin";
        }else if(bmi<25){
            category="Okay weight";
        }else {
            category="fat";
        }
        return category;
    }
}
