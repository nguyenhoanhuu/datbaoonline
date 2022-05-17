package fit.iuh.edu.datbaogiay.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChiTietGioHangPk  implements Serializable{
	@Column(name = "bao_id", nullable = false)
	private int  baoId;
	@Column(name = "gio_hang_id", nullable = false)
	private int gioHangId;
	
	
	public ChiTietGioHangPk(int baoId, int gioHangId) {
		super();
		this.baoId = baoId;
		this.gioHangId = gioHangId;
	}
	public ChiTietGioHangPk() {
		super();
	}
	
	public int getBaoId() {
		return baoId;
	}
	public void setBaoId(int baoId) {
		this.baoId = baoId;
	}
	
	public int getGioHangId() {
		return gioHangId;
	}
	public void setGioHangId(int gioHangId) {
		this.gioHangId = gioHangId;
	}
	@Override
	public String toString() {
		return "ChiTietGioHangPk [baoId=" + baoId + ", gioHangId=" + gioHangId + "]";
	}

	
}
