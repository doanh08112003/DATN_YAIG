package com.demo.repo;

import com.demo.entity.LoaiSanPham;
import com.demo.entity.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoaiSanPhamRepo extends JpaRepository<LoaiSanPham, UUID> {
}
