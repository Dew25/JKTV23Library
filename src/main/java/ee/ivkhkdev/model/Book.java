package ee.ivkhkdev.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Book {
    private static long count;
    private Long id;
    private String title;
    private List<Author> authors = new ArrayList<>();
    private int publishedYear;

    public Book() {
        id = count++;
    }

    public Book(String title, List<Author> authors, int publishedYear) {
        id = count++;
        this.title = title;
        this.authors = authors;
        this.publishedYear = publishedYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return publishedYear == book.publishedYear && Objects.equals(id, book.id) && Objects.equals(title, book.title) && Arrays.equals(authors.toArray(), book.authors.toArray());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, title, publishedYear);
        result = 31 * result + Arrays.hashCode(authors.toArray());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", authors=").append(Arrays.toString(authors.toArray()));
        sb.append(", publishedYear=").append(publishedYear);
        sb.append('}');
        return sb.toString();
    }
}
