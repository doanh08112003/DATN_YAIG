package com.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Table(name = "dot_giam_gia_chi_tiet")
@AllArgsConstructor
@NoArgsConstructor
public class DotGiamGiaChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

<<<<<<< HEAD

=======
    @Column(name = "muc_giam")
    private Integer mucGiam;
>>>>>>> 170b66d44f9e4ea0f0ca8d987e39b080e75e6e12

    @ManyToOne
    @JoinColumn(name = "id_san_pham_chi_tiet")
    SanPhamChiTiet sanPhamChiTiet;

    @ManyToOne
    @JoinColumn(name = "id_dot_giam_gia")
    DotGiamGia dotGiamGia;
}
