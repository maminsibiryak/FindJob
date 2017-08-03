package com.classforparse;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class HeadHunter {
    private static String result;


    public static Document getPage(int a) throws IOException {
        String url = "https://m.hh.ru/vacancies?text=java+Programmer&page="+a+"&area=1";//получить несколько страниц; переделать метод
        Document page = Jsoup.parse(new URL(url), 3000);

        return page;
    }



    public static String setResult() throws Exception {
        StringBuilder stringBuilder = new StringBuilder();


        for (int count = 0; ; count++) {

            Document page = getPage(count);
            Elements test = page.select("ul[class=vacancy-list]");

            try {
                for (int i = 0; ; i++) {
                    String divPremium = test.select("li[class=vacancy-short vacancy-short_premium HH-VacancyContacts-Item]").get(i).text();
                    stringBuilder.append(count + " page||" + i + " ||" + divPremium + "\n");

                }
            } catch (Exception e) {
                e.getStackTrace();

                try {
                    for (int j = 0; ; j++) {
                        String divStandart = test.select("li[class=vacancy-short vacancy-short_standard HH-VacancyContacts-Item]").get(j).text();
                        stringBuilder.append(count + " page||" + j + " ||" + divStandart + "\n");

                    }
                } catch (Exception e1) {
                    e1.getStackTrace();
                    try {


                        for (int k = 0; ; k++) {


                            String divStandartPlus = test.select("li[class=vacancy-short vacancy-short_standard_plus HH-VacancyContacts-Item]").get(k).text();
                            stringBuilder.append(count + " page||" + k + " ||" + divStandartPlus + "\n");

                        }
                    } catch (Exception e2) {
                        e2.getStackTrace();
                    }

                    result = stringBuilder.toString();


                }


            }

        }
    }
    public static void setResult(String result) {
        HeadHunter.result = result;
    }

    public static String getResult() {
        return result;
    }




    /*public static void getVacansies throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        for (int count = 0; ; count++) {


            Document page = getPage(count);

            Elements test = page.select("ul[class=vacancy-list]");

            //Elements count = page.select("span[class=searchbox-hint__number]");
           stringBuilder.append(test.text());
            try {
                for (int i = 0; ; i++) {

                    String divPremium = test.select("li[class=vacancy-short vacancy-short_premium HH-VacancyContacts-Item]").get(i).text();

                    stringBuilder.append(count+" page||"+i + " ||" + divPremium + "\n");
                }

            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();

            }
            try {
                for (int j = 0; ; j++) {


                    String divStandart = test.select("li[class=vacancy-short vacancy-short_standard HH-VacancyContacts-Item]").get(j).text();
                    stringBuilder.append(count+" page||"+j + " ||" + divStandart + "\n");
                }
            } catch (IndexOutOfBoundsException e1) {
                e1.printStackTrace();

            }
            try {
                for (int z = 0; ; z++) {


                    String divStandartPlus = test.select("li[class=vacancy-short vacancy-short_standard_plus HH-VacancyContacts-Item]").get(z).text();
                    stringBuilder.append(count+" page||"+z + " ||" + divStandartPlus + "\n");
                }
            } catch (IndexOutOfBoundsException e2) {
                e2.printStackTrace();
            }
            System.out.println(stringBuilder);

        }

    }
*/
}


