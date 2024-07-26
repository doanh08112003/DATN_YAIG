package com.demo.repo;

import com.demo.entity.DotGiamGia;
import com.demo.enums.TrangThai;
import com.demo.enums.TrangThaiSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface DotGiamGiaRepo extends JpaRepository<DotGiamGia, UUID> {

//    @Query("SELECT dgg FROM DotGiamGia dgg WHERE dgg.ten LIKE ?1")
    @Query("SELECT sp FROM DotGiamGia sp WHERE " +
            "(:keyword IS NULL OR LOWER(sp.ten) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "CAST(sp.moTa AS string) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "CAST(sp.ngayBatDau AS string) LIKE LOWER(CONCAT('%', :keyword, '%'))) " +
            "AND (:status IS NULL OR sp.trangThai = :status)")
    List<DotGiamGia> searchByKeywordAndStatus(
            @Param("keyword") String keyword,
            @Param("status") TrangThai status);

}
