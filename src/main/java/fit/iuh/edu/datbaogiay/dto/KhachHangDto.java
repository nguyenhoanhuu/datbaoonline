package fit.iuh.edu.datbaogiay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KhachHangDto extends AbstractDTO{

	private String tenKhachHang;
	private String SDT;
	private String email;
	private String matKhau;
	
}
