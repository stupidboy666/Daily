package com.example.ano.daily;


import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.lang.invoke.VolatileCallSite;
import java.util.List;

public class Artical extends LitePalSupport {
    public String title;
    public String authour;
    public List<String> content;

    public Artical(){
    }

    public Artical(String title,String authour,List<String> content)
    {
        this.authour=authour;
        this.content=content;
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getContent() {
        return content;
    }

    public String getAuthour() {
        return authour;
    }

    public void setAuthour(String authour) {
        this.authour = authour;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
