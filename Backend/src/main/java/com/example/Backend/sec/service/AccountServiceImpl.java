package com.example.Backend.sec.service;
import com.example.Backend.sec.entities.AppRole;
import com.example.Backend.sec.entities.AppUser;
import com.example.Backend.sec.repo.AppRoleRepository;
import com.example.Backend.sec.repo.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AppUserRepository appUserRepository ;
    @Autowired
    private AppRoleRepository appRoleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public AppUser saveUser(AppUser u){
        u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
        return appUserRepository.save(u);
    }
    @Override
    public AppRole saveRole(AppRole r){
        return appRoleRepository.save(r);
    }
    @Override
    public AppUser findUserByUsername(String username){
        return appUserRepository.findByUsername(username);
    }
    @Override
    public void addRoleToUser(String username,String roleName){
        AppUser user=appUserRepository.findByUsername(username);
        AppRole role=appRoleRepository.findByName(roleName);
        user.getRoles().add(role);
    }
}