package com.example.th_lexicon_2.data;

import com.example.th_lexicon_2.model.AppUser;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AppUserDaoImpl implements AppUserDao{

    private List<AppUser> appUserList = new ArrayList<>();


    @Override
    public boolean create(AppUser appUser) {
        return appUserList.add(appUser);
    }

    @Override
    public AppUser findById(int appUserId) {
        AppUser foundUser = null;
        for (AppUser appUser:appUserList) {
            if (appUser.getAppUserId() == appUserId){
                foundUser = appUser;
            }
        }
        return foundUser;
    }

    @Override
    public Optional<AppUser> findByEmail(String email) {
        return appUserList.stream()
                .filter(appUser -> appUser.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public boolean delete(int appUserId) {
        return appUserList.remove(findById(appUserId));
    }

    @Override
    public List<AppUser> findAll() {
        return new ArrayList<>(appUserList);
    }
}
