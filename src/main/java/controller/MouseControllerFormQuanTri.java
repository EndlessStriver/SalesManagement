package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dao.NhanVienInf;
import item.FormTimKiemHoaDon;
import item.FormTimKiemNhanVien;
import item.FormTimKiemSanPham;
import item.FormTimKiemTaiKhoan;
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
			
			FormQuanTriHoaDon formQuanTriHoaDon = (FormQuanTriHoaDon) formQuanTri;
			
			// tim kiem hoa don
			if (object.equals(formQuanTriHoaDon.btnTimKiem)) {
				FormTimKiemHoaDon formTimKiemHoaDon = new FormTimKiemHoaDon(formQuanTri);
				formTimKiemHoaDon.setVisible(true);
			}
			
			// chức năng cập nhật ngày tạo hoá đơn
			if(object.equals(formQuanTriHoaDon.btnChucNang)) {
				

				// chức năng cập nhật ngày tạo hoá đơn
				if (formQuanTriHoaDon.rdbtnCapNhat.isSelected()) {
					
					int result = JOptionPane.showConfirmDialog(null,
							"Bạn có chắc chắn muốn cập nhật hóa đơn này ?", "Xác nhận",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					
					if (result == JOptionPane.YES_OPTION) {
						String maHoaDon = formQuanTriHoaDon.txtMaHoaDon.getText();
						Date ngayTaoHoaDon = formQuanTriHoaDon.dateChooserNgayLap.getDate();
						
						try {
							ConnectServer.hoaDonInf.capNhatNgayLapHoaDon(maHoaDon, ngayTaoHoaDon);
							formQuanTriHoaDon.layDanhSachHoaDon();
							formQuanTriHoaDon.lamMoiForm();
							JOptionPane.showMessageDialog(null, "Cập nhật hóa đơn thành công !", "Thông báo",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (RemoteException e1) {
							JOptionPane.showMessageDialog(null, "Cập nhật hóa đơn thất bại !", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
						}
					}
					
				}
				
				// chức năng xóa hoá đơn
				if (formQuanTriHoaDon.rdbtnXoa.isSelected()) {
					
					int result = JOptionPane.showConfirmDialog(null,
							"Bạn có chắc chắn muốn xóa hóa đơn này ?", "Xác nhận",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (result == JOptionPane.YES_OPTION) {
						String maHoaDon = formQuanTriHoaDon.txtMaHoaDon.getText();

						try {
							ConnectServer.hoaDonInf.xoaHoaDon(maHoaDon);
							formQuanTriHoaDon.layDanhSachHoaDon();
							formQuanTriHoaDon.lamMoiForm();
							JOptionPane.showMessageDialog(null, "Xóa hóa đơn thành công !", "Thông báo",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (RemoteException e1) {
							JOptionPane.showMessageDialog(null, "Xóa hóa đơn thất bại !", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
						}
					}

				}
			}

		}

		if (formQuanTri instanceof FormQuanTriTaiKhoan) {
			
			FormQuanTriTaiKhoan formQuanTriTaiKhoan = (FormQuanTriTaiKhoan) formQuanTri;
			
			// các chức năng crud tài khoản
			if (object.equals(((FormQuanTriTaiKhoan) formQuanTri).btnChucNang)) {

				String maTaiKhoan = formQuanTriTaiKhoan.textFieldMaTaiKhoan.getText();
				String tenTaiKhoan = formQuanTriTaiKhoan.textFieldTenTaiKhoan.getText();
				String matKhau = new String(formQuanTriTaiKhoan.passwordField.getPassword());
				Quyen quyen = (Quyen) formQuanTriTaiKhoan.comboBoxQuyenHan.getSelectedItem();
				Boolean trangThai = formQuanTriTaiKhoan.rdbtnKichHoat.isSelected() ? true : false;

				// chức năng cập nhật tài khoản
				if (formQuanTriTaiKhoan.rdbtnCapNhat.isSelected()) {
					
					int result = JOptionPane.showConfirmDialog(null,
							"Bạn có chắc chắn muốn cập nhật tài khoản này ?", "Xác nhận",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (result == JOptionPane.YES_OPTION) {
						// kiểm tra ràng buộc nhập liệu
						List<String> thongBaoLoi = formQuanTriTaiKhoan.kiemTraRangBuocFormNhapLieu();

						// nếu có lỗi thì hiển thị thông báo lỗi
						if (thongBaoLoi.size() > 0) {
							formQuanTriTaiKhoan.thongBaoLoiNhapLieu(thongBaoLoi);
							return;
						}

						TaiKhoan taiKhoan = new TaiKhoan(Long.parseLong(maTaiKhoan), tenTaiKhoan, matKhau, trangThai);

						try {
							ConnectServer.taiKhoanInf.capNhatTaiKhoan(taiKhoan, quyen.getIdQuyen());
							formQuanTriTaiKhoan.layDanhSachTaiKhoan();
							formQuanTriTaiKhoan.lamMoiForm();
							JOptionPane.showMessageDialog(null, "Cập nhât tài khoản thành công !", "Thông báo",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (RemoteException e1) {
							JOptionPane.showMessageDialog(null, "Cập nhật tài khoản thất bại !", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
						}
					}

				}

			}
			
			// chức năng tìm kiếm tài khoản
			if (object.equals(((FormQuanTriTaiKhoan) formQuanTri).btnTimKiem)) {
				
				FormTimKiemTaiKhoan formTimKiemTaiKhoan;
				try {
					formTimKiemTaiKhoan = new FormTimKiemTaiKhoan(formQuanTriTaiKhoan);
					formTimKiemTaiKhoan.setVisible(true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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

			if (object.equals(((FormQuanTriSanPham) formQuanTri).btnChucNang)) {
				FormQuanTriSanPham formQuanTriSanPham = (FormQuanTriSanPham) formQuanTri;

				String maSanPham = formQuanTriSanPham.txtMaSP.getText();
				String tenSanPham = formQuanTriSanPham.txtTenSP.getText();
				String giaSanPham = formQuanTriSanPham.txtGiaSP.getText();
				LoaiSanPham loaiSanPham = (LoaiSanPham) formQuanTriSanPham.comboBoxLoaiSanPham.getSelectedItem();

				// chức năng thêm sản phẩm
				if (formQuanTriSanPham.rdbtnThem.isSelected()) {
					
					int result = JOptionPane.showConfirmDialog(null,
							"Bạn có chắc chắn muốn thêm sản phẩm này ?", "Xác nhận",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (result == JOptionPane.YES_OPTION) {
						List<String> thongBaoLoi = formQuanTriSanPham.rangBuocFormNhapLieu();

						if (thongBaoLoi.size() > 0) {
							formQuanTriSanPham.thongBaoLoiNhapLieu(thongBaoLoi);
							return;
						}

						SanPham sanPham = new SanPham(tenSanPham, Float.parseFloat(giaSanPham));

						try {
							ConnectServer.sanPhamInf.taoSanPham(sanPham, loaiSanPham.getMaLoai());
							formQuanTriSanPham.layDanhSachSanPham();
							formQuanTriSanPham.lamMoiForm();
							JOptionPane.showMessageDialog(null, "Thêm sản phẩm thành công !", "Thông báo",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (RemoteException e1) {
							JOptionPane.showMessageDialog(null, "Thêm sản phẩm thất bại !", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
						}
					}

				}

				// chức năng cập nhật sản phẩm
				if (formQuanTriSanPham.rdbtnCapNhat.isSelected()) {
					
					int result = JOptionPane.showConfirmDialog(null,
							"Bạn có chắc chắn muốn cập nhật sản phẩm này ?", "Xác nhận",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (result == JOptionPane.YES_OPTION) {
						List<String> thongBaoLoi = formQuanTriSanPham.rangBuocFormNhapLieu();
						
						if(maSanPham.equals("")) {
							thongBaoLoi.add(0 ,"Vui lòng chọn sản phẩm cần cập nhật");
						}
						
						if (thongBaoLoi.size() > 0) {
							formQuanTriSanPham.thongBaoLoiNhapLieu(thongBaoLoi);
							return;
						}

						SanPham sanPham = new SanPham(Long.parseLong(maSanPham), tenSanPham, Float.parseFloat(giaSanPham));

						try {
							ConnectServer.sanPhamInf.capNhatSanPham(sanPham, loaiSanPham.getMaLoai());
							formQuanTriSanPham.layDanhSachSanPham();
							formQuanTriSanPham.lamMoiForm();
							JOptionPane.showMessageDialog(null, "Cập nhật sản phẩm thành công !", "Thông báo",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (RemoteException e1) {
							JOptionPane.showMessageDialog(null, "Cập nhật sản phẩm thất bại !", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}

				// chức năng xóa sản phẩm
				if (formQuanTriSanPham.rdbtnXoa.isSelected()) {
					
					int result = JOptionPane.showConfirmDialog(null,
							"Bạn có chắc chắn muốn xóa sản phẩm này ?", "Xác nhận",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (result == JOptionPane.YES_OPTION) {
						List<String> thongBaoLoi = new ArrayList<String>();
						
						if(maSanPham.equals("")) {
							thongBaoLoi.add(0 ,"Vui lòng chọn sản phẩm cần xóa");
						}
						
						if (thongBaoLoi.size() > 0) {
							formQuanTriSanPham.thongBaoLoiNhapLieu(thongBaoLoi);
							return;
						}

						try {
							ConnectServer.sanPhamInf.xoaSanPham(Long.parseLong(maSanPham));
							formQuanTriSanPham.layDanhSachSanPham();
							formQuanTriSanPham.lamMoiForm();
							JOptionPane.showMessageDialog(null, "Xóa sản phẩm thành công !", "Thông báo",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (RemoteException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage(), "Lỗi",
									JOptionPane.ERROR_MESSAGE);
						}
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

				// lấy thông tin nhập liệu
				String hoVaTen = formQuanTriNhanVien.textFieldHoVaTen.getText();
				String soDienThoai = formQuanTriNhanVien.textFieldSoDienThoai.getText();
				String email = formQuanTriNhanVien.textFieldEmail.getText();
				String diaChi = formQuanTriNhanVien.textFieldDiaChi.getText();
				boolean gioiTinh = formQuanTriNhanVien.rdbtnNam.isSelected() ? true : false;

				// chức năng thêm nhân viên
				if (formQuanTriNhanVien.rdbtnThem.isSelected()) {
					
					int result = JOptionPane.showConfirmDialog(null,
							"Bạn có chắc chắn muốn thêm nhân viên này ?", "Xác nhận",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (result == JOptionPane.YES_OPTION) {
						try {
							// kiểm tra thông tin nhập liệu
							List<String> thongBaoLoi = formQuanTriNhanVien.kienTraThongTinNhapLieu(1);

							// nếu có lỗi thì hiển thị thông báo lỗi
							if (thongBaoLoi.size() > 0) {
								formQuanTriNhanVien.thongBaoLoiNhapLieu(thongBaoLoi);
								return;
							}

							NhanVien nhanVien = new NhanVien(hoVaTen, soDienThoai, email, diaChi, gioiTinh);

							NhanVienInf nhanVienInf = ConnectServer.nhanVienInf;

							nhanVienInf.taoNhanVien(nhanVien);
							formQuanTriNhanVien.layDanhSachNhanVien();
							formQuanTriNhanVien.lamMoiForm();
							JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công !", "Thông báo",
									JOptionPane.INFORMATION_MESSAGE);

						} catch (RemoteException e1) {
							JOptionPane.showMessageDialog(null, "Thêm nhân viên thất bại !", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
						}
					}
					
				}
				// chức năng cập nhật nhân viên
				if (formQuanTriNhanVien.rdbtnCapNhat.isSelected()) {
					
					int result = JOptionPane.showConfirmDialog(null,
							"Bạn có chắc chắn muốn cập nhật nhân viên này ?", "Xác nhận",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (result == JOptionPane.YES_OPTION) {
						String maNhanVien = formQuanTriNhanVien.textFieldMaNhanVien.getText();

						try {
							// kiểm tra thông tin nhập liệu
							List<String> thongBaoLoi = formQuanTriNhanVien.kienTraThongTinNhapLieu(2);

							// nếu không chọn nhân viên cần cập nhật thì thông báo lỗi
							if (maNhanVien.equals("")) {
								thongBaoLoi.add(0, "Vui lòng chọn nhân viên cần cập nhật");
							}

							// nếu có lỗi thì hiển thị thông báo lỗi
							if (thongBaoLoi.size() > 0) {
								formQuanTriNhanVien.thongBaoLoiNhapLieu(thongBaoLoi);
								return;
							}

							NhanVien nhanVien = new NhanVien(Long.parseLong(maNhanVien), hoVaTen, soDienThoai, email,
									diaChi, gioiTinh);

							NhanVienInf nhanVienInf = ConnectServer.nhanVienInf;

							nhanVienInf.capNhatNhanVien(nhanVien);
							formQuanTriNhanVien.layDanhSachNhanVien();
							formQuanTriNhanVien.lamMoiForm();
							JOptionPane.showMessageDialog(null, "Cập nhật viên thành công !", "Thông báo",
									JOptionPane.INFORMATION_MESSAGE);

						} catch (RemoteException e1) {
							JOptionPane.showMessageDialog(null, "Cập nhật viên thất bại !", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
						}
					}

				}

				// chức năng xóa nhân viên
				if (formQuanTriNhanVien.rdbtnXoa.isSelected()) {
					
					int result = JOptionPane.showConfirmDialog(null,
							"Bạn có chắc chắn muốn xóa nhân viên này ?", "Xác nhận",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (result == JOptionPane.YES_OPTION) {
						String maNhanVien = formQuanTriNhanVien.textFieldMaNhanVien.getText();

						List<String> thongBaoLoi = new ArrayList<String>();

						// nếu không chọn nhân viên cần cập nhật thì thông báo lỗi
						if (maNhanVien.equals("")) {
							thongBaoLoi.add(0, "Vui lòng chọn nhân viên cần xóa");
						}

						// nếu có lỗi thì hiển thị thông báo lỗi
						if (thongBaoLoi.size() > 0) {
							formQuanTriNhanVien.thongBaoLoiNhapLieu(thongBaoLoi);
							return;
						}

						NhanVienInf nhanVienInf = ConnectServer.nhanVienInf;

						try {
							nhanVienInf.xoaNhanVien(maNhanVien);
							formQuanTriNhanVien.layDanhSachNhanVien();
							formQuanTriNhanVien.lamMoiForm();
							JOptionPane.showMessageDialog(null, "Xóa nhân viên thành công !", "Thông báo",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (RemoteException e1) {
							JOptionPane.showMessageDialog(null, "Xóa nhân viên thất bại !", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
						}
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
