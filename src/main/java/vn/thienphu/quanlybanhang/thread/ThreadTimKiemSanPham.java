package vn.thienphu.quanlybanhang.thread;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.thienphu.quanlybanhang.item.FormTimKiemSanPham;
import vn.thienphu.quanlybanhang.model.SanPham;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThreadTimKiemSanPham implements Runnable  {
	
	private List<SanPham> danhSachSanPham;

	@Override
	public void run() {
		FormTimKiemSanPham formTimKiemSanPham = new FormTimKiemSanPham(danhSachSanPham);
		formTimKiemSanPham.setVisible(true);
	}
	
	
}
