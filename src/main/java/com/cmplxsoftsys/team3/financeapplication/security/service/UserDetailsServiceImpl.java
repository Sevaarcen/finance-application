package com.cmplxsoftsys.team3.financeapplication.security.service;

import com.cmplxsoftsys.team3.financeapplication.model.User;
import com.cmplxsoftsys.team3.financeapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is an interface for UserDetails services to be implemented. It builds an implementation by parsing users by username from our Mongo repository.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * Created a new UserRespoitory object
     */
    @Autowired
    UserRepository userRepository;

    /**
     * Loads a UserDetails object by the provided username
     *
     * @param username username to search for
     * @return UserDetails object built from the UserDetailsImpl object which is built from the found User object
     * @throws UsernameNotFoundException if Username does not exist
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }
}
