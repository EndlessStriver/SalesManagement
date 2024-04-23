package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;

import javax.swing.JPanel;

import dao.NhanVienInf;
import item.FormTimKiemHoaDon;
import item.FormTimKiemNhanVien;
import item.FormTimKiemSanPham;
import model.NhanVien;
import util.ConnectServer;
import view.FormQuanTriHoaDon;
import view.FormQuanTriNhanVien;
import view.FormQuanTriSanPham;

public class MouseControllerFormQuanTri implements MouseListener {

	private JPanel formQuanTri;

	public MouseControllerFormQuanTri(JPanel formQuanTri) {
		this.formQuanTri = formQuanTri;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object object = e.getSource();

		if (formQuanTri instanceof FormQuanTriHoaDon) {

			if (object.equals(((FormQuanTriHoaDon) formQuanTri).btnTimKiem)) {
				FormTimKiemHoaDon formTimKiemHoaDon = new FormTimKiemHoaDon();
				formTimKiemHoaDon.setVisible(true);
			}

		}

		if (formQuanTri instanceof FormQuanTriSanPham) {

			if (object.equals(((FormQuanTriSanPham) formQuanTri).btnTimKiem)) {
				FormTimKiemSanPham formTimKiemSanPham;
				try {
					formTimKiemSanPham = new FormTimKiemSanPham(formQuanTri);
					formTimKiemSanPham.setVisible(true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

		if (formQuanTri instanceof FormQuanTriNhanVien) {
			
			if (object.equals(((FormQuanTriNhanVien) formQuanTri).btnTimKiem)) {
				FormTimKiemNhanVien formTimKiemNhanVien = new FormTimKiemNhanVien((FormQuanTriNhanVien) formQuanTri);
				formTimKiemNhanVien.setVisible(true);
			}
			
			if (object.equals(((FormQuanTriNhanVien) formQuanTri).btnChucNang)) {
				FormQuanTriNhanVien formQuanTriNhanVien = (FormQuanTriNhanVien) formQuanTri;
				
				if (formQuanTriNhanVien.rdbtnThem.isSelected()) {
					String hoVaTen = formQuanTriNhanVien.textFieldHoVaTen.getText();
					String soDienThoai = formQuanTriNhanVien.textFieldSoDienThoai.getText();
					String email = formQuanTriNhanVien.textFieldEmail.getText();
					String diaChi = formQuanTriNhanVien.textFieldDiaChi.getText();
					boolean gioiTinh = formQuanTriNhanVien.rdbtnNam.isSelected() ? true : false;
					
					NhanVien nhanVien = new NhanVien(hoVaTen, soDienThoai, email, diaChi, gioiTinh);
					
					NhanVienInf nhanVienInf = ConnectServer.nhanVienInf;
					
					try {
						nhanVienInf.taoNhanVien(nhanVien);
						formQuanTriNhanVien.layDanhSachNhanVien();
						formQuanTriNhanVien.lamMoiForm();
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}
				
				if (formQuanTriNhanVien.rdbtnCapNhat.isSelected()) {
					String maNhanVien = formQuanTriNhanVien.textFieldMaNhanVien.getText();
					String hoVaTen = formQuanTriNhanVien.textFieldHoVaTen.getText();
					String soDienThoai = formQuanTriNhanVien.textFieldSoDienThoai.getText();
					String email = formQuanTriNhanVien.textFieldEmail.getText();
					String diaChi = formQuanTriNhanVien.textFieldDiaChi.getText();
					boolean gioiTinh = formQuanTriNhanVien.rdbtnNam.isSelected() ? true : false;

					NhanVien nhanVien = new NhanVien(Long.parseLong(maNhanVien), hoVaTen, soDienThoai, email, diaChi, gioiTinh);

					NhanVienInf nhanVienInf = ConnectServer.nhanVienInf;

					try {
						nhanVienInf.capNhatNhanVien(nhanVien);
						formQuanTriNhanVien.layDanhSachNhanVien();
						formQuanTriNhanVien.lamMoiForm();
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}
				
				if (formQuanTriNhanVien.rdbtnXoa.isSelected()) {
					String maNhanVien = formQuanTriNhanVien.textFieldMaNhanVien.getText();

					NhanVienInf nhanVienInf = ConnectServer.nhanVienInf;

					try {
						nhanVienInf.xoaNhanVien(maNhanVien);
						formQuanTriNhanVien.layDanhSachNhanVien();
						formQuanTriNhanVien.lamMoiForm();
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}
				
				
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
