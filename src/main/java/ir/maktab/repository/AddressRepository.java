package ir.maktab.repository;

import ir.maktab.entity.Address;

public class AddressRepository extends BaseRepository<Address>{

    @Override
    protected Class<Address> getclass() {
        return Address.class;
    }

    @Override
    protected String getTableName() {
        return Address.TABLE_NAME;
    }
}
