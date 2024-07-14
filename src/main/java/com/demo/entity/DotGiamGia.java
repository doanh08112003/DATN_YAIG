package com.demo.entity;

import com.demo.enums.LoaiGiam;
import com.demo.enums.TrangThai;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Table(name = "dot_giam_gia")
@NoArgsConstructor
@AllArgsConstructor
public class DotGiamGia {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;


    @Column(name = "anh")
    private String anh;


    @Column(name = "ten")
    private String ten;


    @Column(name = "mota")
    private String moTa;

    //    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    @Temporal(TemporalType.DATE)
    @Column(name = "ngay_bat_dau")
    private String ngayBatDau;

    //    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    @Temporal(TemporalType.DATE)
    @Column(name = "ngay_ket_thuc")
    private String ngayKetThuc;

    @Column(name = "trang_thai")
    private TrangThai trangThai;


    @ManyToOne
    @JoinColumn(name = "nguoi_tao")
    NhanVien nhanVien;

    @Column(name = "loai_giam")
    private LoaiGiam loaiGiam;

}
