package com.Shrishti.chatApplication.Dao;

import com.Shrishti.chatApplication.Model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusRepository extends JpaRepository<Status, Integer> {
}
