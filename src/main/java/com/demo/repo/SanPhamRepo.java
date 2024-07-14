package com.demo.repo;

import com.demo.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SanPhamRepo extends JpaRepository<SanPham, UUID> {
}
