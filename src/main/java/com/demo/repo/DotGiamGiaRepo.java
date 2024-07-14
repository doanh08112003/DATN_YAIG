package com.demo.repo;

import com.demo.entity.DotGiamGia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface DotGiamGiaRepo extends JpaRepository<DotGiamGia, UUID> {
    @Query("SELECT dgg FROM DotGiamGia dgg WHERE dgg.ten LIKE ?1")
    Page<DotGiamGia> search(String keyword, Pageable pageable);
}
