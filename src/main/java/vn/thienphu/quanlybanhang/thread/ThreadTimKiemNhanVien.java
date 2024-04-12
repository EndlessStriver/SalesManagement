package vn.thienphu.quanlybanhang.thread;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.thienphu.quanlybanhang.item.FormTimKiemNhanVien;
import vn.thienphu.quanlybanhang.model.NhanVien;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThreadTimKiemNhanVien implements Runnable {
	
	private List<NhanVien> danhSachNhanVien;

	@Override
	public void run() {
		
		FormTimKiemNhanVien formTimKiemNhanVien = new FormTimKiemNhanVien(danhSachNhanVien);
		formTimKiemNhanVien.setVisible(true);
		
	}
	
}
