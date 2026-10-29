package ir.maktab.repository;

import ir.maktab.entity.Wallet;

public class WalletRepository extends BaseRepository<Wallet>{

    @Override
    protected Class<Wallet> getclass() {
        return Wallet.class;
    }

    @Override
    protected String getTableName() {
        return Wallet.TABLE_NAME;
    }
}
