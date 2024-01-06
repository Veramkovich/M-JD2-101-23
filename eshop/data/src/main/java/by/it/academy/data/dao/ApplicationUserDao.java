package by.it.academy.data.dao;

import by.it.academy.data.pojo.ApplicationUser;

import java.util.List;

public interface ApplicationUserDao {

    List<ApplicationUser> findByUserName(String username);

}
