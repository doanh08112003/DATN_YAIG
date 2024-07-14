package com.demo.repo;

import com.demo.entity.MauSac;
import com.demo.entity.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MauSacRepo extends JpaRepository<MauSac, UUID> {
}
