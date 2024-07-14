package com.demo.repo;

import com.demo.entity.DotGiamGiaChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DotGiamGiaCTRepo extends JpaRepository<DotGiamGiaChiTiet, UUID> {
}
