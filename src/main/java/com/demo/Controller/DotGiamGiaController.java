package com.demo.Controller;

import com.demo.entity.DotGiamGia;
import com.demo.entity.NhanVien;
import com.demo.enums.LoaiGiam;
import com.demo.enums.TrangThai;
import com.demo.repo.DotGiamGiaRepo;
import com.demo.repo.NhanVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

//@Controller
@RestController
@CrossOrigin("*")
public class DotGiamGiaController {
    @Autowired
    DotGiamGiaRepo dotGiamGiaRepo;
    @Autowired
    NhanVienRepo nhanVienRepo;

    @ModelAttribute("nhanVienList")
    public List<NhanVien> getNhanVienList() {
        return nhanVienRepo.findAll();
    }

    @RequestMapping(value = "/dot-giam-gia/hien-thi", method = RequestMethod.GET)
    public ResponseEntity<?> laydanhsach() throws IOException {
        return ResponseEntity.ok(dotGiamGiaRepo.findAll());
    }

    @PostMapping("/dot-giam-gia/add")
    public DotGiamGia add(@RequestBody DotGiamGia dotGiamGia) {
        dotGiamGia.setTrangThai(TrangThai.HOAT_DONG);
        if (dotGiamGia.getLoaiGiam() == LoaiGiam.PHAN_TRAM) {
            dotGiamGia.setLoaiGiam(LoaiGiam.PHAN_TRAM);
        } else if (dotGiamGia.getLoaiGiam() == LoaiGiam.TIEN_MAT) {
            dotGiamGia.setLoaiGiam(LoaiGiam.TIEN_MAT);
        }

        return dotGiamGiaRepo.save(dotGiamGia);
    }

    @PatchMapping("/dot-giam-gia/delete/{id}")
    public DotGiamGia doiTrangThai(@PathVariable UUID id) {
        DotGiamGia dgg = dotGiamGiaRepo.findById(id).orElse(null);
//        dgg.setTrangThai(0);
//        if (pgg.getTrangThai() == TrangThai.HOAT_DONG){ pgg.setTrangThai(TrangThai.NGUNG_HOAT_DONG);
//        }
//        else if(pgg.getTrangThai() == TrangThai.NGUNG_HOAT_DONG){ pgg.setTrangThai(TrangThai.HOAT_DONG);
//        }
        dgg.setTrangThai(TrangThai.NGUNG_HOAT_DONG);
        return dotGiamGiaRepo.save(dgg);
    }

    @GetMapping("/view-update/{id}")
    public DotGiamGia viewUpdate(@PathVariable UUID id) {

        return dotGiamGiaRepo.findById(id).orElse(null);
    }

    @PutMapping("/dot-giam-gia/update/{id}")
    public DotGiamGia update(@RequestBody DotGiamGia dotGiamGia, @PathVariable UUID id) {
        DotGiamGia pgg = dotGiamGiaRepo.findById(id).orElse(null);
        pgg.setAnh(dotGiamGia.getAnh());
        ;
        pgg.setTen(dotGiamGia.getTen());
        pgg.setMoTa(dotGiamGia.getMoTa());
        ;
        pgg.setNgayBatDau(dotGiamGia.getNgayBatDau());
        pgg.setNgayKetThuc(dotGiamGia.getNgayKetThuc());
        pgg.setTrangThai(dotGiamGia.getTrangThai());
        pgg.setLoaiGiam(dotGiamGia.getLoaiGiam());

        return dotGiamGiaRepo.save(pgg);

    }

}
