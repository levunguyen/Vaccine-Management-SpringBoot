package com.project.service.impl;

import com.project.entity.Account;
import com.project.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Nguyen Van Linh made it
 */
@Service
public class AccountDetailServiceImpl implements UserDetailsService {
    /**
     *Nguyen Van Linh
     */
    @Autowired
    AccountRepository accountRepository;
    /**
     * Nguyen Van Linh made it
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)  {
        Account account = accountRepository.findAccountByUserName(username);
        if(account==null){
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        return AccountDetailsImpl.build(account);
    }
}