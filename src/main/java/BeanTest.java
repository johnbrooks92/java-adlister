import models.Album;
import models.Author;
import models.Quote;

import java.util.ArrayList;
import java.util.Date;

public class BeanTest {
    public static void main(String[] args) {

        Album kendrick = new Album();
        kendrick.setId(1L);
        kendrick.setArtist("Kendrick Lamar");
        kendrick.setName("DAMN");
        kendrick.setReleaseDate(new Date());
        kendrick.setSales(100);
        kendrick.setGenre("Rap");

        Album cole = new Album();
        cole.setId(2L);
        cole.setArtist("J. Cole");
        cole.setName("2014 Forest Hills Drive");
        cole.setReleaseDate(new Date());
        cole.setSales(100);
        cole.setGenre("Rap");

        System.out.println(kendrick.getArtist());
        System.out.println(cole.getGenre());

        Author j = new Author();
        j.setFirstName("John");
        j.setId(1L);
        j.setLastName("Brooks");

        ArrayList<Quote> quotes = new ArrayList<>();
        Quote first = new Quote();
        Quote second = new Quote();

        first.setAuthor(j);
        first.setId(1L);
        first.setContent("I am the author");

        second.setAuthor(j);
        second.setId(2L);
        second.setContent("CooCooCachoo");

        quotes.add(first);
        quotes.add(second);

        for (Quote q : quotes) {
            System.out.println(q.getContent() + " I like to make things fun : " + q.getAuthor().getFirstName() + " " + q.getAuthor().getLastName());
        }


    }
}