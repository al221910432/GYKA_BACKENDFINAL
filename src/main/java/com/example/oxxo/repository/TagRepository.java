package com.example.oxxo.repository;

import com.example.oxxo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.oxxo.entity.Tag;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long> {
    @Query("Select c from Tag c where c.enable = true")
    List<Tag> findALLByEnabled();
}
