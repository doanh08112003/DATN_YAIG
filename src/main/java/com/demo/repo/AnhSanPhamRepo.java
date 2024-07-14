package com.demo.repo;

import com.demo.entity.AnhSanPham;
import com.demo.entity.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnhSanPhamRepo extends JpaRepository<AnhSanPham, UUID> {
}
