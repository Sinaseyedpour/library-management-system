package ir.maktab.repository;

import ir.maktab.entity.Loan;
import ir.maktab.entity.LoanStatus;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class LoanRepository extends BaseRepository<Loan> {
    @Override
    protected Class<Loan> getclass() {
        return Loan.class;
    }

    public List<Loan> findLoansByStatus(LoanStatus status) {
        TypedQuery<Loan> query = entityManager.createQuery("select L from Loan L where L.loanStatus = ?1 ", Loan.class);
        query.setParameter(1, status);
        return query.getResultList();
    }

    @Override
    protected String getTableName() {
        return Loan.TABLE_NAME;
    }
}
