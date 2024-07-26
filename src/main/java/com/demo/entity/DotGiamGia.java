package com.demo.entity;

import com.demo.enums.LoaiGiam;
import com.demo.enums.TrangThai;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
import java.time.LocalDate;
=======
>>>>>>> 170b66d44f9e4ea0f0ca8d987e39b080e75e6e12
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
<<<<<<< HEAD
    private LocalDate ngayBatDau;
=======
    private String ngayBatDau;
>>>>>>> 170b66d44f9e4ea0f0ca8d987e39b080e75e6e12

    //    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    @Temporal(TemporalType.DATE)
    @Column(name = "ngay_ket_thuc")
<<<<<<< HEAD
    private LocalDate ngayKetThuc;
=======
    private String ngayKetThuc;
>>>>>>> 170b66d44f9e4ea0f0ca8d987e39b080e75e6e12

    @Column(name = "trang_thai")
    private TrangThai trangThai;


    @ManyToOne
    @JoinColumn(name = "nguoi_tao")
    NhanVien nhanVien;

    @Column(name = "loai_giam")
    private LoaiGiam loaiGiam;

<<<<<<< HEAD
    @Column(name = "muc_giam")
    private Integer mucGiam;

=======
>>>>>>> 170b66d44f9e4ea0f0ca8d987e39b080e75e6e12
}
