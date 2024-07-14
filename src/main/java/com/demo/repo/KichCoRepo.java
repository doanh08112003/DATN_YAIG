package com.demo.repo;

import com.demo.entity.KichCo;
import com.demo.entity.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KichCoRepo extends JpaRepository<KichCo, UUID> {
}
