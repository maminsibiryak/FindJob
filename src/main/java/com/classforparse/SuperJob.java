package com.classforparse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import java.net.URL;

public class SuperJob {
    public static Document getPage(int a) throws IOException {
        String url = "https://www.superjob.ru/vakansii/programmist-java.html?geo%5Bt%5D%5B0%5D=4&search_hesh=1926103506135192&search_origin=mainpage_suggest&page=" + a;
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public static Document getPage() throws IOException {
        String url = "https://www.superjob.ru/vakansii/programmist-java.html?geo%5Bt%5D%5B0%5D=4&search_hesh=1926103506135192&search_origin=mainpage_suggest&page=1";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public static String getResult() throws IOException, IndexOutOfBoundsException {
        StringBuilder result = new StringBuilder();
        Document page = getPage();
        Elements div = page.select("div[class=sj_panel VacancyItem-item-zB4LB]");
        for (Element el : div
                ) {
            result.append(el.text() + "\n");

        }
        return result.toString();

    }


}
