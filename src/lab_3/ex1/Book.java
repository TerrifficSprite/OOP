package lab_3.ex1;


public final class Book implements Comparable<Book> {

    private final String author;
    private final String name;
    private final String publisher;
    private final int publishYear;

    public Book(String author, String name, String publisher, int publishYear) {
        this.author = author;
        this.name = name;
        this.publisher = publisher;
        this.publishYear = publishYear;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPublishYear() {
        return publishYear;
    }

    @Override
    public String toString() {
        return String.format("Книга: %s, автор: %s, видавництво: %s, рік: %d",
                getName(), getAuthor(), getPublisher(), getPublishYear());
    }

    @Override
    public int compareTo(Book o) {
        return o.getPublishYear() - this.getPublishYear();
    }
}
