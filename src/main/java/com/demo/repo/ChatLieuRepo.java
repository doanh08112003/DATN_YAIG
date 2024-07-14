package com.demo.repo;

import com.demo.entity.ChatLieu;
import com.demo.entity.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatLieuRepo extends JpaRepository<ChatLieu, UUID> {
}
