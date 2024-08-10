package com.demo.repo;

import com.demo.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KhachHangRepo extends JpaRepository<KhachHang, UUID> {
}
