package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import item.FormTimKiemHoaDon;
import item.FormTimKiemNhanVien;
import item.FormTimKiemSanPham;
import model.HoaDon;
import model.NhanVien;
import model.SanPham;
import view.FormTraCuuThongTin;

public class MouseControllerFormTraCuuThongTin implements MouseListener {

	private FormTraCuuThongTin formTraCuuThongTin;

	public MouseControllerFormTraCuuThongTin(FormTraCuuThongTin formTraCuuThongTin) {
		this.formTraCuuThongTin = formTraCuuThongTin;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object object = e.getSource();

		if (object.equals(formTraCuuThongTin.formTraCuuNhanVien.btnTimKiemNhanVien)) {

			List<NhanVien> danhSachNhanVien = new ArrayList<NhanVien>();
			FormTimKiemNhanVien formTimKiemNhanVien = new FormTimKiemNhanVien(formTraCuuThongTin.formTraCuuNhanVien);
			formTimKiemNhanVien.setVisible(true);

		}

		if (object.equals(formTraCuuThongTin.formTraCuuSanPham.btnTimKiemSanPham)) {

			List<SanPham> danhSachSanPham = new ArrayList<SanPham>();
			FormTimKiemSanPham formTimKiemSanPham = new FormTimKiemSanPham();
			formTimKiemSanPham.setVisible(true);

		}

		if (object.equals(formTraCuuThongTin.formTraCuuHoaDon.btnTimKiemHoaDon)) {

			List<HoaDon> danhSachHoaDon = new ArrayList<HoaDon>();
			FormTimKiemHoaDon formTimKiemHoaDon = new FormTimKiemHoaDon();
			formTimKiemHoaDon.setVisible(true);
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
