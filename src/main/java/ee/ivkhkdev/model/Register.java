package ee.ivkhkdev.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Register implements Serializable {
    private UUID id;
    private User user;
    private Book book;
    private LocalDate BookBorrowDate;
    private LocalDate returnBookDate;

    public Register() {
    }

    public Register(User user, Book book, LocalDate BookBorrowDate, LocalDate returnBookDate) {
        this.user = user;
        this.book = book;
        this.BookBorrowDate = BookBorrowDate;
        this.returnBookDate = returnBookDate;
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

    public LocalDate getBookBorrowDate() {
        return BookBorrowDate;
    }

    public void setBookBorrowDate(LocalDate bookBorrowDate) {
        this.BookBorrowDate = bookBorrowDate;
    }

    public LocalDate getReturnBookDate() {
        return returnBookDate;
    }

    public void setReturnBookDate(LocalDate returnBookDate) {
        this.returnBookDate = returnBookDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Register register = (Register) o;
        return Objects.equals(id, register.id) && Objects.equals(user, register.user) && Objects.equals(book, register.book) && Objects.equals(BookBorrowDate, register.BookBorrowDate) && Objects.equals(returnBookDate, register.returnBookDate);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(user);
        result = 31 * result + Objects.hashCode(book);
        result = 31 * result + Objects.hashCode(BookBorrowDate);
        result = 31 * result + Objects.hashCode(returnBookDate);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Register{");
        sb.append("id=").append(id);
        sb.append(", user=").append(user);
        sb.append(", book=").append(book);
        sb.append(", startDate=").append(BookBorrowDate);
        sb.append(", endDate=").append(returnBookDate);
        sb.append('}');
        return sb.toString();
    }
}
