package com.demo.repo;

import com.demo.entity.DeGiay;
import com.demo.entity.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeGiayRepo extends JpaRepository<DeGiay, UUID> {
}
