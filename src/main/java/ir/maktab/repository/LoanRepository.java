package ir.maktab.repository;

import ir.maktab.entity.Loan;
import ir.maktab.entity.LoanStatus;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class LoanRepository extends BaseRepository<Loan> {

    @Override
    protected Class<Loan> getclass() {
        return Loan.class;
    }

    public List<Loan> findLoansByStatus(LoanStatus status) {
        TypedQuery<Loan> query = entityManager.createQuery("select l from Loan l where l.loanStatus = ?1 ", Loan.class);
        query.setParameter(1, status);
        return query.getResultList();
    }

    public Loan findActiveLoanByBookId(Long bookId) {

        Query query = entityManager.createQuery(
                "SELECt l FROM Loan l WHERE l.book.id = ?1 AND l.loanStatus = ACTIVE ", Loan.class);

        List<Loan> resultList = query.setParameter(1, bookId)
                .getResultList();

        return resultList.getFirst();
    }

    public List<Loan> findLoansByMemberId(Long memberId) {

        return entityManager.createQuery(
                        "SELECT l FROM Loan l WHERE l.user.id = ?1", Loan.class)
                .setParameter(1, memberId)
                .getResultList();
    }

    public List<Loan> findLoansByBookId(Long bookId) {
        return entityManager.createQuery(
                        "select l FROM Loan l where l.book.id = ?1", Loan.class)
                .setParameter(1, bookId)
                .getResultList();
    }

    public long countActiveLoansByMemberId(Long memberId) {
        return entityManager.createQuery("select COUNT (l) From Loan l where l.loanStatus = ACTIVE AND l.user.id = ?1", Long.class)
                .setParameter(1, memberId)
                .getSingleResult();
    }

    public List<Loan> getOverdueLoans() {
        return entityManager.createQuery("select l FROM Loan l where l.dueDate < ?1 AND l.loanStatus = ACTIVE",Loan.class)
                .setParameter(1, LocalDate.now())
                .getResultList();

    }


    @Override
    protected String getTableName() {
        return Loan.TABLE_NAME;
    }
}
