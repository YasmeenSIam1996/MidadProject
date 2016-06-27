package Model;

/**
 * Created by Yasmeen Siam on 26/06/2016.
 */
public class News {
    private String ImageNews;
    private String NewsDate;
    private String NewsDepartment;
    private String NewsTitel;
    private int id;

    public News(String imageNews, String newsDate, String newsDepartment, String newsTitel, int id) {
        ImageNews = imageNews;
        NewsDate = newsDate;
        NewsDepartment = newsDepartment;
        NewsTitel = newsTitel;
        this.id = id;
    }

    public String getImageNews() {
        return ImageNews;
    }

    public String getNewsDate() {
        return NewsDate;
    }

    public String getNewsDepartment() {
        return NewsDepartment;
    }

    public String getNewsTitel() {
        return NewsTitel;
    }
}
