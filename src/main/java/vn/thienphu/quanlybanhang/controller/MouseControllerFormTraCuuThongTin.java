package vn.thienphu.quanlybanhang.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import vn.thienphu.quanlybanhang.model.HoaDon;
import vn.thienphu.quanlybanhang.model.NhanVien;
import vn.thienphu.quanlybanhang.model.SanPham;
import vn.thienphu.quanlybanhang.thread.ThreadTimKiemHoaDon;
import vn.thienphu.quanlybanhang.thread.ThreadTimKiemNhanVien;
import vn.thienphu.quanlybanhang.thread.ThreadTimKiemSanPham;
import vn.thienphu.quanlybanhang.view.FormTraCuuThongTin;

public class MouseControllerFormTraCuuThongTin implements MouseListener {
	
	private FormTraCuuThongTin formTraCuuThongTin;

	public MouseControllerFormTraCuuThongTin(FormTraCuuThongTin formTraCuuThongTin) {
		this.formTraCuuThongTin = formTraCuuThongTin;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object object = e.getSource();
		
		if(object.equals(formTraCuuThongTin.formTraCuuNhanVien.btnTimKiemNhanVien)){
			List<NhanVien> danhSachNhanVien = new ArrayList<NhanVien>();
			Runnable runnable = new ThreadTimKiemNhanVien(danhSachNhanVien);
			Thread thread = new Thread(runnable);
			thread.run();
		}
		
		if(object.equals(formTraCuuThongTin.formTraCuuSanPham.btnTimKiemSanPham)) {
			List<SanPham> danhSachSanPham = new ArrayList<SanPham>();
			Runnable runnable = new ThreadTimKiemSanPham(danhSachSanPham);
			Thread thread = new Thread(runnable);
			thread.run();
		}
		
		if(object.equals(formTraCuuThongTin.formTraCuuHoaDon.btnTimKiemHoaDon)) {
			List<HoaDon> danhSachHoaDon = new ArrayList<HoaDon>();
			Runnable runnable = new ThreadTimKiemHoaDon(danhSachHoaDon);
			Thread thread = new Thread(runnable);
			thread.run();
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
