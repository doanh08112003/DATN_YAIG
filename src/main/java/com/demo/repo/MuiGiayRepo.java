package com.demo.repo;

import com.demo.entity.MuiGiay;
import com.demo.entity.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MuiGiayRepo extends JpaRepository<MuiGiay, UUID> {
}
