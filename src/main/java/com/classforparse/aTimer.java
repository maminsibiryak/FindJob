package com.classforparse;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class aTimer {


    public String getFinal(String data){
        String dataEnd = data;
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String result="";
        long timeUp = 0;
        int count = 0;
        try {
            timeUp = format.parse(dataEnd).getTime();

            while (count<1) {

            long diff = System.currentTimeMillis() - timeUp;

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

                StringBuilder sb = new StringBuilder();
                sb.append(diffDays + " дн, ");
                sb.append(diffHours + " чс, ");
                sb.append(diffMinutes + " мн, ");
                sb.append(diffSeconds + " сек");
                result = sb.toString();
                System.out.println((result));
                Thread.sleep(1000);
                count++;
            }
        }


        catch (ParseException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

return result;

    }

   /* public static void main(String[] args) {
        aTimer aTimer = new aTimer();
        aTimer.getFinal();
    }*/
}
