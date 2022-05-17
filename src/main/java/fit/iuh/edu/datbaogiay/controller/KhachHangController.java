package fit.iuh.edu.datbaogiay.controller;

import java.util.List;

import javax.persistence.Embeddable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import fit.iuh.edu.datbaogiay.dto.KhachHangDto;
import fit.iuh.edu.datbaogiay.entity.KhachHang;
import fit.iuh.edu.datbaogiay.exception.ResourceNotFoundException;
import fit.iuh.edu.datbaogiay.repository.KhachHangRepository;
import fit.iuh.edu.datbaogiay.service.KhachHangService;


@Controller
@RequestMapping("/admin/khachHang")
public class KhachHangController {

	private KhachHangService khachHangService;
 
	public KhachHangController(KhachHangService khachHangService) {
		this.khachHangService = khachHangService;
	}

	@GetMapping("/show")
	public String listKhachHang(Model theModel) {
		List<KhachHangDto> khachHangDtos = khachHangService.layDSKhachHang();
		theModel.addAttribute("khachHang",khachHangDtos);
		return "PageQuanLyKhachHang";
	}
	
	@PostMapping(value = "/addKhachHang", consumes = MediaType.ALL_VALUE)
	public String themKhachHang(@ModelAttribute("khachHang") KhachHangDto khachHangDto) {
		 khachHangService.themKhachHang(khachHangDto);
		 return "redirect:/admin/khachHang/show";
	}

	@GetMapping("/put/{maKhachHang}")
	public String layKhachHangTheoId(@PathVariable int maKhachHang,Model model) {
		KhachHangDto khachHangDto = khachHangService.layKhachHangTheoId(maKhachHang);
		model.addAttribute("khachHang", khachHangDto);
		return "PageThemKhachHang";
	}

//	@DeleteMapping("{maKhachHang}")
	@RequestMapping(value = "/{maKhachHang}")
	public String xoaKhachHangTheoId(@PathVariable int maKhachHang) {
		 khachHangService.xoaKhachHangTheoId(maKhachHang);
		 return "redirect:/admin/khachHang/show";
	}
	

//	@PutMapping("{maKhachHang}")
//	public void suaKhachHang(@PathVariable int id, @RequestBody KhachHangDto khachHangDto) {
//		khachHangService.suaKhachHang(id, khachHangDto);
//		
//	}

//	@Autowired
//	private TacGiaRepository tacGiaRepository;
//
//	// get all
//	@GetMapping
//	public TacGia getAllTacGia() {
//		return (TacGia) this.tacGiaRepository.findAll();
//	}
//
//	// get id
//	public TacGia getTacGiaById(@PathVariable(value = "id") int tacGiaId) {
//		return this.tacGiaRepository.findById(tacGiaId)
//				.orElseThrow(() -> new ResourceNotFoundException("Tac gia khong duoc tim thay voi id: " + tacGiaId));
//
//	}
//
//	// create
//	@PostMapping
//	public TacGia createTacGia(@RequestBody TacGia tacGia) {
//
//		return this.tacGiaRepository.save(tacGia);
//
//	}
//
//	// update
//	@PutMapping("/{id}")
//	public TacGia updateTacGia(@RequestBody TacGia tacGia, @PathVariable("id") int tacGiaId) {
//		TacGia tacGiaExisting = this.tacGiaRepository.findById(tacGiaId)
//				.orElseThrow(() -> new ResourceNotFoundException("Tac gia khong duoc tim thay voi id: " + tacGiaId));
//		tacGiaExisting.setTenTacGia(tacGia.getTenTacGia());
//		return this.tacGiaRepository.save(tacGiaExisting);
//	}
//
//	// delete by id
//	@DeleteMapping("/{id}")
//	public ResponseEntity<TacGia> deleteTacGia(@PathVariable("id") int tacGiaId) {
//		TacGia tacGiaExisting = this.tacGiaRepository.findById(tacGiaId)
//				.orElseThrow(() -> new ResourceNotFoundException("Tac gia khong duoc tim thay voi id: " + tacGiaId));
//		this.tacGiaRepository.delete(tacGiaExisting);
//		return ResponseEntity.ok().build();
//	}

}
