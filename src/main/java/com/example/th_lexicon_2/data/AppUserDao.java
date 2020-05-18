package com.example.th_lexicon_2.data;

import com.example.th_lexicon_2.model.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserDao {
    boolean create (AppUser appUser);
    AppUser findById(int appUserId);
    Optional<AppUser> findByEmail(String email);
    boolean delete(int appUserId);
    List<AppUser> findAll();
}
