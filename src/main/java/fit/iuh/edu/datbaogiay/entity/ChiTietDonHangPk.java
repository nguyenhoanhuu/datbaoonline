package fit.iuh.edu.datbaogiay.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class ChiTietDonHangPk implements Serializable {
	private DonHang donHang;
	private Bao bao;

	public ChiTietDonHangPk(DonHang donHang, Bao bao) {
		this.donHang = donHang;
		this.bao = bao;
	}
	
	public ChiTietDonHangPk() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(bao, donHang);
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
		return Objects.equals(bao, other.bao) && Objects.equals(donHang, other.donHang);
	}
	
}
