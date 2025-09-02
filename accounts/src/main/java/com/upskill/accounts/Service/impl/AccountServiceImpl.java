package com.upskill.accounts.Service.impl;


import com.upskill.accounts.Service.IAccountService;
import com.upskill.accounts.dto.CustomerDto;
import com.upskill.accounts.entity.Customer;
import com.upskill.accounts.mapper.CustomerMapper;
import com.upskill.accounts.repository.AccountsRepository;
import com.upskill.accounts.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl  implements IAccountService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer= CustomerMapper.mapToCustomer(customerDto,new Customer());
        customerRepository.save(customer);

    }

}
