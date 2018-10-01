package com.example.ano.daily;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseWeb {

    static Artical http_getnovel() {
        final Artical at = new Artical();
        final List<String> con = new ArrayList<>();
        try {
            Connection connect = Jsoup.connect("http://www.meiriyiwen.com");
            connect.timeout(10000);
            Document document = connect.get();
            Elements read_con = document.select("div#article_show");
            String title = read_con.first().getElementsByTag("h1").text();
            at.setTitle(title);
            Elements select1=read_con.select("p.article_author");
            String author = select1.first().text();
            at.setAuthour(author);
            Elements select = read_con.select("div.article_text");
            for (Element ele : select) {
                String p = ele.getElementsByTag("p").text();
                con.add(p);
            }
            at.setContent(con);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return at;
    }
}
