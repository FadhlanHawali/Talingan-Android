package id.fadhlanhawali.talingan;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class ConvertDate {

    public String convertTime(long time){

        Date date = new Date(time*1000);

        SimpleDateFormat sdf = new SimpleDateFormat("HH.mm");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));


        return sdf.format(date).toString();
    }

    public String convertHari(long time){
        Date date = new Date(time*1000);

        SimpleDateFormat hari = new SimpleDateFormat("EE");
        hari.setTimeZone(TimeZone.getTimeZone("GMT+7"));

        return hari.format(date).toString();
    }

    public String convertBulan(long time){
        Date date = new Date(time);

        SimpleDateFormat bulan = new SimpleDateFormat("MMM");
        bulan.setTimeZone(TimeZone.getTimeZone("GMT+7"));

        return bulan.format(date).toString();
    }

    public String convertBulanComplete(long time){
        Date date = new Date(time);

        SimpleDateFormat bulan = new SimpleDateFormat("MMMM");
        bulan.setTimeZone(TimeZone.getTimeZone("GMT+7"));

        return bulan.format(date).toString();
    }


    public String convertBulanDate(Date date){

        SimpleDateFormat bulan = new SimpleDateFormat("MMM");
        bulan.setTimeZone(TimeZone.getTimeZone("GMT+7"));

        return bulan.format(date);
    }

    public String convertCompleteDate (Date date){
        SimpleDateFormat dates = new SimpleDateFormat("EEE, d MMM yyyy");
        dates.setTimeZone(TimeZone.getTimeZone("GMT+7"));

        return dates.format(date);
    }

    public String convertComplete(long time){
        Date date = new Date(time*1000);
        Locale locale = new Locale("id", "ID");
        SimpleDateFormat complete = new SimpleDateFormat("d MMM yyyy", locale);
        complete.setTimeZone(TimeZone.getTimeZone("GMT+7"));

        return complete.format(date).toString();
    }

    public String convertCompleteItalic(long time){
        Date date = new Date(time*1000);
        Locale locale = new Locale("id", "ID");
        SimpleDateFormat complete = new SimpleDateFormat("d/MM/yyyy", locale);
        complete.setTimeZone(TimeZone.getTimeZone("GMT+7"));

        return complete.format(date).toString();
    }

    public String convertCompleteAndJam(long time){
        Date date = new Date(time*1000);
        Locale locale = new Locale("id", "ID");
        SimpleDateFormat complete = new SimpleDateFormat("d MMM yyyy, HH:mm", locale);
        complete.setTimeZone(TimeZone.getTimeZone("GMT+7"));

        return complete.format(date).toString();
    }

    public String converRangeDate (long time){
        long range;
        range = System.currentTimeMillis() - time;

        //kurang dari 1 menit
        if (range <= 60){
            return TimeUnit.SECONDS.convert(range, TimeUnit.MILLISECONDS)+ " detik yang lalu";
        }else if (range > 60 && range <= 3600){
            //kurang dari 1 jam
            return TimeUnit.MINUTES.convert(range, TimeUnit.MILLISECONDS)+ " menit yang lalu";
        }else if (range > 3600 && range <= 86400){
            //kurang dari 24 jam
            return TimeUnit.HOURS.convert(range, TimeUnit.MILLISECONDS)+ " jam yang lalu";
        }else {
            //hitungan hari
            return TimeUnit.DAYS .convert(range, TimeUnit.MILLISECONDS)+ " hari yang lalu";
        }

    }

}
