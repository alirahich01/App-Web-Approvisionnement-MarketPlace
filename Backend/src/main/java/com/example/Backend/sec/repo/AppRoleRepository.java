package com.example.Backend.sec.repo;
import com.example.Backend.sec.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    public  AppRole findByName(String roleName);
}


