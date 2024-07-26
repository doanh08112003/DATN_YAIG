package com.demo.repo;

import com.demo.entity.DotGiamGia;
<<<<<<< HEAD
import com.demo.enums.TrangThai;
import com.demo.enums.TrangThaiSanPham;
=======
>>>>>>> 170b66d44f9e4ea0f0ca8d987e39b080e75e6e12
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
<<<<<<< HEAD
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
//    Page<DotGiamGia> search(String keyword, Pageable pageable);
=======

import java.util.UUID;

public interface DotGiamGiaRepo extends JpaRepository<DotGiamGia, UUID> {
    @Query("SELECT dgg FROM DotGiamGia dgg WHERE dgg.ten LIKE ?1")
    Page<DotGiamGia> search(String keyword, Pageable pageable);
>>>>>>> 170b66d44f9e4ea0f0ca8d987e39b080e75e6e12
}
