package org.moshun.webscraper;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookScraperService {
    private static final String BASE_URL = "https://books.toscrape.com/catalogue/";
    private final BookRepository bookRepository;
    private final BookParser bookParser;

    public void scrapeBooks() {
        String nextPageUrl = BASE_URL + "page-1.html";

        while (nextPageUrl != null) {
            try {
                Document document = Jsoup.connect(nextPageUrl).get();
                List<Book> books = bookParser.parseBooksFromDocument(document);
                bookRepository.saveAll(books);

                Element nextPageElement = document.selectFirst(".pager .next a");
                if (nextPageElement != null) {
                    nextPageUrl = BASE_URL + nextPageElement.attr("href");
                } else {
                    nextPageUrl = null;
                }
            } catch (IOException e) {
                throw new RuntimeException("Error scraping page: " + nextPageUrl, e);
            }
        }
    }
}

