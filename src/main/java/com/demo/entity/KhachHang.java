package com.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.UUID;

@Data


@Entity
@Table(name="khach_hang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "ten_day_du")
    private String tenDayDu;

    @Column(name = "tai_khoan")
    private String taiKhoan;

    @Column(name = "mat_khau")
    private String matKhau;

    @Column(name = "email")
    private String email;


//    @DateTimeFormat(pattern = "yyyy/MM/dd")
//    @Temporal(TemporalType.DATE)
    @Column(name = "ngay_sinh")
    private String ngaySinh;
    @Column(name = "anh")
    private String anh;

    @Column(name = "trang_thai")
    private Integer trangThai;
}
