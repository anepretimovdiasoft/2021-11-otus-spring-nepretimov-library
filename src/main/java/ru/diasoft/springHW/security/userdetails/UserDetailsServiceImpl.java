package ru.diasoft.springHW.security.userdetails;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.diasoft.springHW.dao.UserDao;
import ru.diasoft.springHW.domain.User;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) {

        Optional<User> userOptional = userDao.findByUsername(s);
        if (userOptional.isEmpty()){

            throw new UsernameNotFoundException(s);
        }

        return new UserDetailsImpl(userOptional.get());
    }
}
