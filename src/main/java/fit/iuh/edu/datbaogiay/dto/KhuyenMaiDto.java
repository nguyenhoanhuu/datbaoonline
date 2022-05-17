package fit.iuh.edu.datbaogiay.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KhuyenMaiDto extends AbstractDTO{

	private String tenKhuyenMai;
	private double giaTriGiam;
	private Date ngayBatDau;
	private Date ngayHetHan;
	private int maNhanVien;
	private String tenNhanVien;
	
}
