package com.demo.service;

import com.demo.entity.DotGiamGia;
import com.demo.enums.TrangThai;
import com.demo.repo.DotGiamGiaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class capNhatTrangThai {
    @Autowired
    DotGiamGiaRepo dotGiamGiaRepo;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Scheduled(cron = "0 25 18 * * *")

    public void DoiTrangThai(){

//    List<PhieuGiamGia> phieuGiamGia = phieuGiamGiaRepo.findAll();
//     for (PhieuGiamGia phieuGiamGia1 : phieuGiamGia){
//         phieuGiamGia1.setTrangThai(TrangThai.HOẠTĐỘNG);
//
//     }
//            phieuGiamGiaRepo.saveAll(phieuGiamGia);

        LocalDate now = LocalDate.now();
        List<DotGiamGia> vouchers = dotGiamGiaRepo.findAll();

        for (DotGiamGia voucher : vouchers) {
            LocalDate ngayKetThuc = LocalDate.parse(voucher.getNgayKetThuc().toString(), formatter);
            if (voucher.getTrangThai().equals(TrangThai.DANG_DIEN_RA) && ngayKetThuc.isEqual(now)) {
                voucher.setTrangThai(TrangThai.DA_KETTHUC);
                dotGiamGiaRepo.save(voucher);
            }
        }
//
    }
//        }
}
