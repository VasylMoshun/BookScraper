package org.moshun.webscraper;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookParser {
    public List<Book> parseBooksFromDocument(Document document) {
        Elements books = document.select(".product_pod");
        List<Book> result = new ArrayList<>();

        for (Element bk : books) {
            String title = bk.select("h3 > a").attr("title");
            String price = bk.select(".price_color").text();
            String availability = bk.select(".availability").text();
            String rating = bk.select(".star-rating").attr("class").replace("star-rating", "").trim();

            Book book = new Book();
            book.setTitle(title);
            book.setPrice(price);
            book.setRating(rating);
            book.setAvailability(availability);
            result.add(book);
        }
        return result;
    }
}
