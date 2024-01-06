package by.it.academy.service.security;

import by.it.academy.data.dao.ApplicationUserDao;
import by.it.academy.data.pojo.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings({"unused"})
@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    ApplicationUserDao applicationUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            List<ApplicationUser> appUsers = applicationUserDao.findByUserName(username);
            if (appUsers.size() != 1) {
                throw new UsernameNotFoundException("User not found: " + username);
            }
            ApplicationUser appUser = appUsers.get(0);
            return new User(
                    appUser.getUsername(),
                    appUser.getPassword(),
                    true, true, true, true,
                    List.of(new SimpleGrantedAuthority(appUser.getRole()))
            );

        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found: " + username, e);
        }
    }
}
