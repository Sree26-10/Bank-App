package com.upskill.accounts.Service;

import com.upskill.accounts.dto.CustomerDto;

public interface IAccountService {

/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
    /**
     * This method is used to create a new account.
     *
     * @param customerDto
     *            Customer details
     */
/* <<<<<<<<<<  de485613-d107-4536-86ad-3fc772688855  >>>>>>>>>>> */
    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);

}
