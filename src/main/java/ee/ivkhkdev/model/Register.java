package ee.ivkhkdev.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Register {
    private UUID id;
    private User user;
    private Book book;
    private LocalDate startDate;
    private LocalDate endDate;

    public Register() {
    }

    public Register(User user, Book book, LocalDate startDate, LocalDate endDate) {
        this.user = user;
        this.book = book;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Register register = (Register) o;
        return Objects.equals(id, register.id) && Objects.equals(user, register.user) && Objects.equals(book, register.book) && Objects.equals(startDate, register.startDate) && Objects.equals(endDate, register.endDate);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(user);
        result = 31 * result + Objects.hashCode(book);
        result = 31 * result + Objects.hashCode(startDate);
        result = 31 * result + Objects.hashCode(endDate);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Register{");
        sb.append("id=").append(id);
        sb.append(", user=").append(user);
        sb.append(", book=").append(book);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append('}');
        return sb.toString();
    }
}
