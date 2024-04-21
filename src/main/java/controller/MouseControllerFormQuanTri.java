package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import item.FormTimKiemHoaDon;
import item.FormTimKiemNhanVien;
import item.FormTimKiemSanPham;
import item.FormTimKiemTaiKhoan;
import view.FormQuanTri;
import view.FormQuanTriSanPham;

public class MouseControllerFormQuanTri implements MouseListener {
	
	private FormQuanTri formQuanTri;
	
	public MouseControllerFormQuanTri(FormQuanTri formQuanTri) {
		this.formQuanTri = formQuanTri;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object object = e.getSource();
		
		if(object.equals(formQuanTri.formQuanTriHoaDon.btnTimKiem)) {
			FormTimKiemHoaDon formTimKiemHoaDon = new FormTimKiemHoaDon();
			formTimKiemHoaDon.setVisible(true);
		}
		
		if(object.equals(formQuanTri.formQuanTriNhanVien.btnTimKiem)) {
			FormTimKiemNhanVien formTimKiemNhanVien = new FormTimKiemNhanVien(formQuanTri.formQuanTriNhanVien);
			formTimKiemNhanVien.setVisible(true);
		}
		
		if(object.equals(formQuanTri.formQuanTriSanPham.btnTimKiem)) {
			FormTimKiemSanPham formTimKiemSanPham = new FormTimKiemSanPham();
			formTimKiemSanPham.setVisible(true);
		}
		
		if(object.equals(formQuanTri.formQuanTriTaiKhoan.btnTimKiem)) {
			FormTimKiemTaiKhoan formTimKiemTaiKhoan = new FormTimKiemTaiKhoan();
			formTimKiemTaiKhoan.setVisible(true);
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
