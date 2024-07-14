package com.demo.Controller;

import com.demo.dto.DPDto;
import com.demo.entity.DotGiamGia;
import com.demo.entity.DotGiamGiaChiTiet;
import com.demo.entity.NhanVien;
import com.demo.entity.SanPhamChiTiet;
import com.demo.enums.LoaiGiam;
import com.demo.enums.TrangThai;
import com.demo.repo.DotGiamGiaCTRepo;
import com.demo.repo.DotGiamGiaRepo;
import com.demo.repo.NhanVienRepo;
import com.demo.repo.SanPhamChiTietRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

//@Controller
@RestController
@CrossOrigin("*")
public class DotGiamGiaController {
    @Autowired
    DotGiamGiaRepo dotGiamGiaRepo;
    @Autowired
    NhanVienRepo nhanVienRepo;
    @Autowired
    DotGiamGiaCTRepo dotGiamGiaChiTietRepo;
    @Autowired
    SanPhamChiTietRepo sanPhamChiTietRepo;



//    @ModelAttribute("nhanVienList")
//    public List<NhanVien> getNhanVienList() {
//        return nhanVienRepo.findAll();
//    }
@GetMapping("/timkiem")
public ResponseEntity<List<DotGiamGia>> searchProducts(
        @RequestParam(value = "keyword", required = false) String keyword,
        @RequestParam(value = "status", required = false) TrangThai status) {
    List<DotGiamGia> result = dotGiamGiaRepo.searchByKeywordAndStatus(keyword, status);
    return ResponseEntity.ok(result);
}
private static List<UUID> selectedIds = new ArrayList<>();
    @PostMapping
    public ResponseEntity<String> saveProductDetailIds(@RequestBody DPDto dto) {
        selectedIds.clear();
        System.out.println("hi");
        selectedIds.addAll(dto.getSelectedIds());
        System.out.println(selectedIds);
        return ResponseEntity.ok("Saved product detail IDs: " + selectedIds);
    }

    @RequestMapping(value = "/dot-giam-gia/hien-thi", method = RequestMethod.GET)
    public ResponseEntity<?> laydanhsach() throws IOException {
        return ResponseEntity.ok(dotGiamGiaRepo.findAll());
    }

//    @PostMapping("/dot-giam-gia/add")
//    public DotGiamGia add(@RequestBody DotGiamGia dotGiamGia) {
//        dotGiamGia.setTrangThai(TrangThai.HOẠTĐỘNG);
//        if (dotGiamGia.getLoaiGiam() == LoaiGiam.PHAN_TRAM) {
//            dotGiamGia.setLoaiGiam(LoaiGiam.PHAN_TRAM);
//        } else if (dotGiamGia.getLoaiGiam() == LoaiGiam.TIEN_MAT) {
//            dotGiamGia.setLoaiGiam(LoaiGiam.TIEN_MAT);
//        }
//
//        return dotGiamGiaRepo.save(dotGiamGia);
//    }
    @PostMapping("/dot-giam-gia/add")
    public ResponseEntity<String> add(@RequestBody DotGiamGia dotGiamGia) {
//        System.out.println(dotGiamGia.setNgayKetThuc());
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomPart = new StringBuilder();
        Random random = new Random();
        int length = 8 + random.nextInt(3);  // Độ dài từ 8 đến 10 ký tự
        for (int i = 0; i < length; i++) {
            randomPart.append(characters.charAt(random.nextInt(characters.length())));
        }
        LocalDate now = LocalDate.now();
        LocalDate ngayBatDau = dotGiamGia.getNgayBatDau();
        if (ngayBatDau.isEqual(now)){ dotGiamGia.setTrangThai(TrangThai.DANG_DIEN_RA);
        }
        else if(ngayBatDau.isAfter(now)){ dotGiamGia.setTrangThai(TrangThai.SAP_DIEN_RA);
        }
//        dotGiamGia.setTen("DGG"+ randomPart);
//        dotGiamGia.setTrangThai(TrangThai.DANG_DIEN_RA);

        if (dotGiamGia.getLoaiGiam() == LoaiGiam.PHAN_TRAM) {
            dotGiamGia.setLoaiGiam(LoaiGiam.PHAN_TRAM);
        } else if (dotGiamGia.getLoaiGiam() == LoaiGiam.TIEN_MAT) {
            dotGiamGia.setLoaiGiam(LoaiGiam.TIEN_MAT);
        }
        System.out.println(selectedIds+"ids");
        dotGiamGiaRepo.save(dotGiamGia);
        List<SanPhamChiTiet> DSs = sanPhamChiTietRepo.findAllById(selectedIds);
        System.out.println(DSs+"sp");
        DotGiamGia d = dotGiamGiaRepo.findById(dotGiamGia.getId()).get();
        for(SanPhamChiTiet c : DSs){
            DotGiamGiaChiTiet c1 = new DotGiamGiaChiTiet();
            c1.setDotGiamGia(d);
            c1.setSanPhamChiTiet(c);
            dotGiamGiaChiTietRepo.save(c1);
        }
        return ResponseEntity.ok("Saved ");
    }
//    @PatchMapping("/dot-giam-gia/delete/{id}")
//    public DotGiamGia doiTrangThai(@PathVariable Long id) {
//        DotGiamGia dgg = dotGiamGiaRepo.findById(id).orElse(null);
//        dgg.setTrangThai(TrangThaiDGG.DA_KETTHUC);
//        return dotGiamGiaRepo.save(dgg);
//    }

    @PatchMapping("/dot-giam-gia/delete/{id}")
    public DotGiamGia doiTrangThai(@PathVariable UUID id) {
        DotGiamGia dgg = dotGiamGiaRepo.findById(id).orElse(null);
//        dgg.setTrangThai(TrangThai.DA_KETTHUC);
//        dgg.setTrangThai(0);
        if (dgg.getTrangThai() == TrangThai.DANG_DIEN_RA){ dgg.setTrangThai(TrangThai.DA_KETTHUC);
        }
        else if(dgg.getTrangThai() == TrangThai.DA_KETTHUC){ dgg.setTrangThai(TrangThai.DANG_DIEN_RA);
        }
//        dgg.setTrangThai(TrangThai.DA_KETTHUC);
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
        pgg.setTen(dotGiamGia.getTen());
        pgg.setMoTa(dotGiamGia.getMoTa());
        pgg.setNgayBatDau(dotGiamGia.getNgayBatDau());
        pgg.setNgayKetThuc(dotGiamGia.getNgayKetThuc());
        pgg.setTrangThai(dotGiamGia.getTrangThai());
        pgg.setLoaiGiam(dotGiamGia.getLoaiGiam());

        return dotGiamGiaRepo.save(pgg);

    }
    @GetMapping("/csp/{id_dot_giam_gia}")
    public List<DotGiamGiaChiTiet> getChiTietSanPhamBySanPhamId(@PathVariable UUID id_dot_giam_gia) {
        return dotGiamGiaChiTietRepo.findAll().stream()
                .filter(chiTiet -> chiTiet.getDotGiamGia() != null && chiTiet.getDotGiamGia().getId().equals(id_dot_giam_gia))
                .collect(Collectors.toList());
    }
    @DeleteMapping("chitietdotgiam/delete/{id}")
    public ResponseEntity<String> deleteDotGiamGiaChiTiet(@PathVariable UUID id) {
        try {
            dotGiamGiaChiTietRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted DotGiamGiaChiTiet with ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete DotGiamGiaChiTiet with ID: " + id);
        }
    }

}
