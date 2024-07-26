package com.demo.Controller;

import com.demo.entity.DotGiamGia;
import com.demo.entity.DotGiamGiaChiTiet;
import com.demo.entity.SanPham;
import com.demo.entity.SanPhamChiTiet;
import com.demo.repo.DotGiamGiaCTRepo;
import com.demo.repo.DotGiamGiaRepo;
import com.demo.repo.SanPhamChiTietRepo;
import com.demo.repo.SanPhamRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class DotGiamGiaCTController {
<<<<<<< HEAD
//    @Autowired
//    DotGiamGiaCTRepo dotGiamGiaCTRepo;
//    @Autowired
//    DotGiamGiaRepo dotGiamGiaRepo;
//    @Autowired
//    SanPhamChiTietRepo sanPhamChiTietRepo;
//    @Autowired
//    SanPhamRepo sanPhamRepo;
//
//
//    @ModelAttribute("dggList")
//    public List<DotGiamGia> getCategoryList() {
//        return dotGiamGiaRepo.findAll();
//    }
//
//    @ModelAttribute("sanPhamCTList")
//    public List<SanPhamChiTiet> getSanPhamCTList() {
//        return sanPhamChiTietRepo.findAll();
//    }
//
//    @ModelAttribute("sanPhamList")
//    public List<SanPham> getSanPhamList() {
//        return sanPhamRepo.findAll();
//    }
//
//    @GetMapping("/dot-giam-gia-ct/hien-thi")
//    public String hienThi(Model model) {
//        List<DotGiamGiaChiTiet> list = dotGiamGiaCTRepo.findAll();
//        System.out.println("list:" + list);
//        model.addAttribute("list", list);
//        model.addAttribute("dggCT", new DotGiamGiaChiTiet());
//        return "dot-giam-gia-ct/hien-thi";
//    }
//
//    @PostMapping("/dot-giam-gia-ct/add")
//    public String add(@ModelAttribute("dggCT") DotGiamGiaChiTiet dotGiamGiaChiTiet) {
//        dotGiamGiaCTRepo.save(dotGiamGiaChiTiet);
//        return "redirect:/dot-giam-gia-ct/hien-thi";
//    }
//
//    @GetMapping("dot-giam-gia-ct/delete/{id}")
//    public String delete(@PathVariable UUID id) {
//        dotGiamGiaCTRepo.deleteById(id);
//        return "redirect:/dot-giam-gia-ct/hien-thi";
//    }
//
//    @GetMapping("/update/{id}")
//    public String viewUpdate(@PathVariable UUID id, Model model) {
//        DotGiamGiaChiTiet dgg = dotGiamGiaCTRepo.findById(id).orElse(null);
//        model.addAttribute("dggCT", dgg);
//        model.addAttribute("list", dotGiamGiaCTRepo.findAll());
//        return "/dot-giam-gia-ct/form";
//    }
//
//    @PostMapping("/dot-giam-gia-ct/update/{id}")
//    public String update(@PathVariable UUID id,
//                         @Valid @ModelAttribute("dggCT") DotGiamGiaChiTiet dgg,
//                         BindingResult rs) {
//        if (rs.hasErrors()) {
//            return "dot-giam-gia-ct/hien-thi";
//        }
//        dgg.setId(id);
//        dotGiamGiaCTRepo.save(dgg);
//        return "redirect:/dot-giam-gia-ct/hien-thi";
//    }
=======
    @Autowired
    DotGiamGiaCTRepo dotGiamGiaCTRepo;
    @Autowired
    DotGiamGiaRepo dotGiamGiaRepo;
    @Autowired
    SanPhamChiTietRepo sanPhamChiTietRepo;
    @Autowired
    SanPhamRepo sanPhamRepo;


    @ModelAttribute("dggList")
    public List<DotGiamGia> getCategoryList() {
        return dotGiamGiaRepo.findAll();
    }

    @ModelAttribute("sanPhamCTList")
    public List<SanPhamChiTiet> getSanPhamCTList() {
        return sanPhamChiTietRepo.findAll();
    }

    @ModelAttribute("sanPhamList")
    public List<SanPham> getSanPhamList() {
        return sanPhamRepo.findAll();
    }

    @GetMapping("/dot-giam-gia-ct/hien-thi")
    public String hienThi(Model model) {
        List<DotGiamGiaChiTiet> list = dotGiamGiaCTRepo.findAll();
        System.out.println("list:" + list);
        model.addAttribute("list", list);
        model.addAttribute("dggCT", new DotGiamGiaChiTiet());
        return "dot-giam-gia-ct/hien-thi";
    }

    @PostMapping("/dot-giam-gia-ct/add")
    public String add(@ModelAttribute("dggCT") DotGiamGiaChiTiet dotGiamGiaChiTiet) {
        dotGiamGiaCTRepo.save(dotGiamGiaChiTiet);
        return "redirect:/dot-giam-gia-ct/hien-thi";
    }

    @GetMapping("dot-giam-gia-ct/delete/{id}")
    public String delete(@PathVariable UUID id) {
        dotGiamGiaCTRepo.deleteById(id);
        return "redirect:/dot-giam-gia-ct/hien-thi";
    }

    @GetMapping("/update/{id}")
    public String viewUpdate(@PathVariable UUID id, Model model) {
        DotGiamGiaChiTiet dgg = dotGiamGiaCTRepo.findById(id).orElse(null);
        model.addAttribute("dggCT", dgg);
        model.addAttribute("list", dotGiamGiaCTRepo.findAll());
        return "/dot-giam-gia-ct/form";
    }

    @PostMapping("/dot-giam-gia-ct/update/{id}")
    public String update(@PathVariable UUID id,
                         @Valid @ModelAttribute("dggCT") DotGiamGiaChiTiet dgg,
                         BindingResult rs) {
        if (rs.hasErrors()) {
            return "dot-giam-gia-ct/hien-thi";
        }
        dgg.setId(id);
        dotGiamGiaCTRepo.save(dgg);
        return "redirect:/dot-giam-gia-ct/hien-thi";
    }
>>>>>>> 170b66d44f9e4ea0f0ca8d987e39b080e75e6e12

}
