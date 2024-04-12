package vn.thienphu.quanlybanhang.thread;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.thienphu.quanlybanhang.item.FormTimKiemHoaDon;
import vn.thienphu.quanlybanhang.model.HoaDon;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThreadTimKiemHoaDon implements Runnable{
	private List<HoaDon> danhSachHoaDon;
	
	@Override
	public void run() {
		FormTimKiemHoaDon formTimKiemHoaDon = new FormTimKiemHoaDon(danhSachHoaDon);
		formTimKiemHoaDon.setVisible(true);
		
	}

}
