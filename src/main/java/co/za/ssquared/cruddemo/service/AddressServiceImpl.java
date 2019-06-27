package co.za.ssquared.cruddemo.service;


import co.za.ssquared.cruddemo.dao.AddressRepository;
import co.za.ssquared.cruddemo.entity.Address;
import co.za.ssquared.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    @Transactional
    public void save(Address theAddress) {
        addressRepository.save(theAddress);
    }

}
