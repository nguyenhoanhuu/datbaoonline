package fit.iuh.edu.datbaogiay.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChiTietDonHangPk implements Serializable {
	@Column(name = "don_hang_id", nullable = false)
	private int donHangId;
	@Column(name = "bao_id", nullable = false)
	private int baoId;
	public ChiTietDonHangPk(int donHangId, int baoId) {
		super();
		this.donHangId = donHangId;
		this.baoId = baoId;
	}
	public ChiTietDonHangPk() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(baoId, donHangId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietDonHangPk other = (ChiTietDonHangPk) obj;
		return baoId == other.baoId && donHangId == other.donHangId;
	}



}
