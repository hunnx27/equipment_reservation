package com.twodollar.modules.common.address.infra;

import com.twodollar.modules.common.address.domain.Address;

import java.util.List;

public interface AddressRepositoryExtension {

    public List<Address> findByAddressGroupBySidoCide();

}
