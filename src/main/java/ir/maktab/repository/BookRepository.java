package ir.maktab.repository;

import ir.maktab.entity.Book;

public class BookRepository extends BaseRepository<Book> {

    @Override
    protected Class<Book> getclass() {
        return Book.class;
    }
    @Override
    protected String getTableName() {
        return Book.TABLE_NAME;
    }
}
