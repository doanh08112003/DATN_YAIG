package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "mui_giay")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MuiGiay {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "ten")
    private String ten;
    @Column(name = "trang_thai")
    private int trangthai;
//    @OneToMany (mappedBy = "mui_giay")
//    @JsonIgnore
//    private List<SanPhamChiTiet> chiTietSanPhams;
}
