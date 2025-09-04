package com.upskill.accounts.controller;

import com.upskill.accounts.Service.IAccountService;
import com.upskill.accounts.constants.AccountsConstants;
import com.upskill.accounts.dto.CustomerDto;
import com.upskill.accounts.dto.ResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountsController {

    private IAccountService accountService;

    @PostMapping(path="/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
        accountService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @GetMapping(path="/fetch")
    public ResponseEntity<ResponseDto> fetchAccountDetails(@RequestParam String mobileNumber){
    CustomerDto customerDto=accountService.fetchAccount(mobileNumber);
    return ResponseEntity.status(HttpStatus.OK)
    }
}
