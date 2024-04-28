package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import item.FormTimKiemHoaDon;
import item.FormTimKiemNhanVien;
import item.FormTimKiemSanPham;
import model.HoaDon;
import model.NhanVien;
import model.SanPham;
import view.FormTraCuuHoaDon;
import view.FormTraCuuNhanVien;
import view.FormTraCuuSanPham;
import view.FormTraCuuThongTin;

public class MouseControllerFormTraCuuThongTin implements MouseListener {

	private JPanel formTraCuuThongTin;

	public MouseControllerFormTraCuuThongTin(JPanel formTraCuuThongTin) {
		this.formTraCuuThongTin = formTraCuuThongTin;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object object = e.getSource();
		
		if(formTraCuuThongTin instanceof FormTraCuuNhanVien) {
			
			if (object.equals(((FormTraCuuNhanVien) formTraCuuThongTin).btnTimKiemNhanVien)) {
				
				FormTimKiemNhanVien formTimKiemNhanVien = new FormTimKiemNhanVien(formTraCuuThongTin);
				formTimKiemNhanVien.setVisible(true);
				
			}
			
		}
		
		if(formTraCuuThongTin instanceof FormTraCuuSanPham) {
			
			if (object.equals(((FormTraCuuSanPham) formTraCuuThongTin).btnTimKiemSanPham)) {
				
				FormTimKiemSanPham formTimKiemSanPham;
				try {
					formTimKiemSanPham = new FormTimKiemSanPham(formTraCuuThongTin);
					formTimKiemSanPham.setVisible(true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
		
		if(formTraCuuThongTin instanceof FormTraCuuHoaDon) {
			
			FormTraCuuHoaDon formTraCuuHoaDon = (FormTraCuuHoaDon) formTraCuuThongTin;
			
			if (object.equals(formTraCuuHoaDon.btnTimKiemHoaDon)) {
				FormTimKiemHoaDon formTimKiemHoaDon = new FormTimKiemHoaDon(formTraCuuThongTin);
				formTimKiemHoaDon.setVisible(true);
			}
			
			if(SwingUtilities.isRightMouseButton(e)) {
				formTraCuuHoaDon.showPopupMenu(e);
			}
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
