package com.upskill.accounts.Service.impl;


import com.upskill.accounts.Service.IAccountService;
import com.upskill.accounts.constants.AccountsConstants;
import com.upskill.accounts.dto.CustomerDto;
import com.upskill.accounts.entity.Accounts;
import com.upskill.accounts.entity.Customer;
import com.upskill.accounts.mapper.CustomerMapper;
import com.upskill.accounts.repository.AccountsRepository;
import com.upskill.accounts.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl  implements IAccountService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer= CustomerMapper.mapToCustomer(customerDto,new Customer());
        Optional<Customer> customerOptional=customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(customerOptional.isPresent()){
            throw new RuntimeException("Customer already exists"+customerDto.getMobileNumber());
        }
        Customer savedCustomer=customerRepository.save(customer);
        accountsRepository.save(createAccount(savedCustomer));

    }

    private Accounts createAccount(Customer customer){
        Accounts newAccount=new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccountNumber=1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccountNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }



}
