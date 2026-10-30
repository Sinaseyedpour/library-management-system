package ir.maktab.repository;

import ir.maktab.entity.Book;

import java.util.List;

public class BookRepository extends BaseRepository<Book> {

    @Override
    protected Class<Book> getclass() {
        return Book.class;
    }

    @Override
    protected String getTableName() {
        return Book.TABLE_NAME;
    }

    public Book findByIsbn(String isbn) {
        return entityManager.createQuery(
                "SELECT b from Book b where b.ISBN = ?1", Book.class
        ).setParameter(1, isbn).getSingleResult();
    }

    public List<Book> getMostBorrowedBooks() {
        return entityManager.createQuery(
                "select b from Book b " +
                        "join Loan l on l.book = b " +
                        "GROUP BY b" +
                        " order by count(l) desc ",
                Book.class
        ).getResultList();
    }
}