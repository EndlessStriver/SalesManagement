package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;

import javax.swing.JPanel;

import dao.NhanVienInf;
import item.FormTimKiemHoaDon;
import item.FormTimKiemNhanVien;
import item.FormTimKiemSanPham;
import model.LoaiSanPham;
import model.NhanVien;
import model.Quyen;
import model.SanPham;
import model.TaiKhoan;
import util.ConnectServer;
import view.FormQuanTriHoaDon;
import view.FormQuanTriNhanVien;
import view.FormQuanTriSanPham;
import view.FormQuanTriTaiKhoan;

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
		
		if (formQuanTri instanceof FormQuanTriTaiKhoan) {

			if (object.equals(((FormQuanTriTaiKhoan) formQuanTri).btnChucNang)) {
				FormQuanTriTaiKhoan formQuanTriTaiKhoan = (FormQuanTriTaiKhoan) formQuanTri;
				
				// chức năng cập nhật tài khoản
				if(formQuanTriTaiKhoan.rdbtnCapNhat.isSelected()) {
					
					String maTaiKhoan = formQuanTriTaiKhoan.textFieldMaTaiKhoan.getText();
					String tenTaiKhoan = formQuanTriTaiKhoan.textFieldTenTaiKhoan.getText();
					String matKhau = new String(formQuanTriTaiKhoan.passwordField.getPassword());
					Quyen quyen = (Quyen) formQuanTriTaiKhoan.comboBoxQuyenHan.getSelectedItem();
					Boolean trangThai = formQuanTriTaiKhoan.rdbtnKichHoat.isSelected() ? true : false;

					TaiKhoan taiKhoan = new TaiKhoan(Long.parseLong(maTaiKhoan), tenTaiKhoan, matKhau, trangThai);

					try {
						ConnectServer.taiKhoanInf.capNhatTaiKhoan(taiKhoan, quyen.getIdQuyen());
						formQuanTriTaiKhoan.layDanhSachTaiKhoan();
						formQuanTriTaiKhoan.lamMoiForm();
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}
				
			}

		}

		if (formQuanTri instanceof FormQuanTriSanPham) {
			
			// chức năng tìm kiếm sản phẩm
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
			
			if(object.equals(((FormQuanTriSanPham) formQuanTri).btnChucNang)) {
				FormQuanTriSanPham formQuanTriSanPham = (FormQuanTriSanPham) formQuanTri;
				
				// chức năng thêm sản phẩm
				if (formQuanTriSanPham.rdbtnThem.isSelected()) {
					String tenSanPham = formQuanTriSanPham.txtTenSP.getText();
					String giaSanPham = formQuanTriSanPham.txtGiaSP.getText();
					LoaiSanPham loaiSanPham = (LoaiSanPham) formQuanTriSanPham.comboBoxLoaiSanPham.getSelectedItem();
					SanPham sanPham = new SanPham(tenSanPham, Float.parseFloat(giaSanPham));
					
					try {
						ConnectServer.sanPhamInf.taoSanPham(sanPham, loaiSanPham.getMaLoai());
						formQuanTriSanPham.layDanhSachSanPham();
						formQuanTriSanPham.lamMoiForm();
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}

				}
				
				// chức năng cập nhật sản phẩm
				if (formQuanTriSanPham.rdbtnCapNhat.isSelected()) {
					String maSanPham = formQuanTriSanPham.txtMaSP.getText();
					String tenSanPham = formQuanTriSanPham.txtTenSP.getText();
					String giaSanPham = formQuanTriSanPham.txtGiaSP.getText();
					LoaiSanPham loaiSanPham = (LoaiSanPham) formQuanTriSanPham.comboBoxLoaiSanPham.getSelectedItem();
					SanPham sanPham = new SanPham(Long.parseLong(maSanPham), tenSanPham, Float.parseFloat(giaSanPham));

					try {
						ConnectServer.sanPhamInf.capNhatSanPham(sanPham, loaiSanPham.getMaLoai());
						formQuanTriSanPham.layDanhSachSanPham();
						formQuanTriSanPham.lamMoiForm();
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}
				
				// chức năng xóa sản phẩm
				if (formQuanTriSanPham.rdbtnXoa.isSelected()) {
					String maSanPham = formQuanTriSanPham.txtMaSP.getText();
					try {
						ConnectServer.sanPhamInf.xoaSanPham(Long.parseLong(maSanPham));
						formQuanTriSanPham.layDanhSachSanPham();
						formQuanTriSanPham.lamMoiForm();
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}
			}

		}

		if (formQuanTri instanceof FormQuanTriNhanVien) {
			
			// chức năng tìm kiếm nhân viên
			if (object.equals(((FormQuanTriNhanVien) formQuanTri).btnTimKiem)) {
				FormTimKiemNhanVien formTimKiemNhanVien = new FormTimKiemNhanVien((FormQuanTriNhanVien) formQuanTri);
				formTimKiemNhanVien.setVisible(true);
			}
			
			
			if (object.equals(((FormQuanTriNhanVien) formQuanTri).btnChucNang)) {
				FormQuanTriNhanVien formQuanTriNhanVien = (FormQuanTriNhanVien) formQuanTri;
				// chức năng thêm nhân viên
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
				// chức năng cập nhật nhân viên
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
				// chức năng xóa nhân viên
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
