package ir.maktab.repository;

import ir.maktab.entity.Loan;
import ir.maktab.entity.LoanStatus;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

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

    public List<Loan> findLoansByMemberId(Long memberId){

        return entityManager.createQuery(
                        "SELECT l FROM Loan l WHERE l.user.id = ?1", Loan.class)
                .setParameter(1, memberId)
                .getResultList();
    }


    @Override
    protected String getTableName() {
        return Loan.TABLE_NAME;
    }
}
