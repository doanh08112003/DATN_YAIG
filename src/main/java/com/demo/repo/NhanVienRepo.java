package com.demo.repo;

import com.demo.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NhanVienRepo extends JpaRepository<NhanVien, UUID> {
}
