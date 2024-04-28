package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import item.FormTimKiemSanPham;
import model.ChiTietHoaDon;
import model.HoaDon;
import model.NhanVien;
import model.SanPham;
import util.ConnectServer;

import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class FormThanhToan extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableChiTietHoaDon;
	public JLabel lblThanhTien;
	private JLabel txtMaNhanVien;
	private JLabel txtNgayLap;
	private JLabel txtTenNhanVien;

	/**
	 * Create the panel.
	 */
	public FormThanhToan() {
		setBackground(new Color(123, 104, 238));
		setBounds(0, 0, 1120, 709);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("THANH TOÁN");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30)); // Bold font
		lblNewLabel.setBounds(10, 10, 223, 43);
		add(lblNewLabel);

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		// Panel for displaying product information
		JPanel panelTable = new JPanel();
		panelTable.setBounds(10, 64, 780, 624);
		add(panelTable);
		panelTable.setLayout(null);

		JLabel lblChiTitHa_1 = new JLabel("CHI TIẾT HÓA ĐƠN");
		lblChiTitHa_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		lblChiTitHa_1.setBounds(603, 8, 167, 23);
		panelTable.add(lblChiTitHa_1);

		DefaultTableModel model = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Số lượng", "Đơn giá", "Tổng tiền" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// chỉ có thể sủa cột số lượng
				return column == 3;
			}
		};

		tableChiTietHoaDon = new JTable(model);
		tableChiTietHoaDon.setRowHeight(25);
		tableChiTietHoaDon.setForeground(new Color(0, 0, 0));

		JScrollPane scrollPane = new JScrollPane(tableChiTietHoaDon);
		scrollPane.setBounds(10, 42, 760, 571);
		panelTable.add(scrollPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(800, 10, 310, 614);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblChiTitHa = new JLabel("THÔNG TIN HÓA ĐƠN");
		lblChiTitHa.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
		lblChiTitHa.setBounds(20, 11, 280, 33);
		panel_1.add(lblChiTitHa);

		JLabel lblMaSP = new JLabel("Mã nhân viên:");
		lblMaSP.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblMaSP.setBounds(10, 55, 108, 27);
		panel_1.add(lblMaSP);

		txtMaNhanVien = new JLabel("__________");
		txtMaNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtMaNhanVien.setBounds(160, 55, 96, 26);
		panel_1.add(txtMaNhanVien);

		txtNgayLap = new JLabel("__________");
		txtNgayLap.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtNgayLap.setBounds(160, 133, 96, 26);
		panel_1.add(txtNgayLap);

		JLabel lblTnSanPhm = new JLabel("Ngày lập");
		lblTnSanPhm.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblTnSanPhm.setBounds(10, 133, 108, 27);
		panel_1.add(lblTnSanPhm);

		JLabel lblThnhTin = new JLabel("THÀNH TIỀN:");
		lblThnhTin.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
		lblThnhTin.setBounds(10, 526, 251, 33);
		panel_1.add(lblThnhTin);

		lblThanhTien = new JLabel("______________________VND");
		lblThanhTien.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
		lblThanhTien.setBounds(10, 570, 290, 33);
		panel_1.add(lblThanhTien);
		
		JLabel lblTenNhanVien = new JLabel("Tên nhân viên");
		lblTenNhanVien.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblTenNhanVien.setBounds(10, 95, 108, 27);
		panel_1.add(lblTenNhanVien);
		
		txtTenNhanVien = new JLabel("");
		txtTenNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtTenNhanVien.setBounds(160, 95, 96, 26);
		panel_1.add(txtTenNhanVien);

		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lamMoi();
			}
		});
		btnLamMoi.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnLamMoi.setBounds(469, 26, 83, 26);
		add(btnLamMoi);

		JButton btnThemSanPham = new JButton("Thêm sản phẩm");
		btnThemSanPham.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					FormTimKiemSanPham formTimKiemSanPham = new FormTimKiemSanPham(FormThanhToan.this);
					formTimKiemSanPham.setVisible(true);
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}

		});
		btnThemSanPham.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnThemSanPham.setBounds(562, 26, 135, 26);
		add(btnThemSanPham);

		JButton btnThanhToan = new JButton("THANH TOÁN");
		btnThanhToan.setForeground(new Color(0, 0, 0));
		btnThanhToan.setBackground(new Color(255, 255, 255));
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<ChiTietHoaDon> dsChiTietHoaDon = new ArrayList<ChiTietHoaDon>();

				DefaultTableModel model = (DefaultTableModel) tableChiTietHoaDon.getModel();

				int rowCount = model.getRowCount();

				if (rowCount == 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần thanh toán", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				int response = JOptionPane.showConfirmDialog(null, "Bạn có muốn thanh toán?", "Xác nhận thanh toán",
						JOptionPane.YES_NO_OPTION);

				if (response == JOptionPane.YES_OPTION) {
					for (int i = 0; i < model.getRowCount(); i++) {
						SanPham sanPham = (SanPham) model.getValueAt(i, 0);
						int soLuong = Integer.parseInt(model.getValueAt(i, 3).toString());

						ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(soLuong, sanPham);
						dsChiTietHoaDon.add(chiTietHoaDon);
					}

					try {

						ConnectServer.hoaDonInf.taoHoaDon(dsChiTietHoaDon, Long.parseLong(txtMaNhanVien.getText()));
						lamMoi();

					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		btnThanhToan.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnThanhToan.setBounds(800, 635, 310, 53);
		add(btnThanhToan);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tableChiTietHoaDon.getModel();
				int selectedRow = tableChiTietHoaDon.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần xóa", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				model.removeRow(selectedRow);
				capNhatThanhTien();
			}
		});
		btnXoa.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnXoa.setBounds(707, 26, 83, 26);
		add(btnXoa);

		lamMoi();
		capNhatMaNhanVien();
	}

	// thêm chi tiết hóa đơn
	public void themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		SanPham sanPham = chiTietHoaDon.getSanPham();
		DefaultTableModel model = (DefaultTableModel) tableChiTietHoaDon.getModel();
		int rowCount = model.getRowCount();

		// kiểm tra sản phẩm đã tồn tại trong bảng chưa
		for (int i = 0; i < rowCount; i++) {
			// nếu sản phẩm đã tồn tại trong bảng thì cập nhật số lượng và tổng tiền
			if (model.getValueAt(i, 0).equals(sanPham)) {
				int soLuong = Integer.parseInt(model.getValueAt(i, 3).toString());
				model.setValueAt(soLuong + chiTietHoaDon.getSoLuong(), i, 3);
				model.setValueAt((float) model.getValueAt(i, 4) * (soLuong + chiTietHoaDon.getSoLuong()), i, 5);
				capNhatThanhTien();
				return;
			}
		}

		model.addRow(new Object[] { chiTietHoaDon.getSanPham(), chiTietHoaDon.getSanPham().getTenSanPham(),
				chiTietHoaDon.getSanPham().getLoaiSanPham(), chiTietHoaDon.getSoLuong(),
				chiTietHoaDon.getSanPham().getGiaSanPham(), chiTietHoaDon.getTongTien() });
	}

	// cập nhật tổng tiền
	public void capNhatThanhTien() {
		DefaultTableModel model = (DefaultTableModel) tableChiTietHoaDon.getModel();
		float tongTien = 0;
		for (int i = 0; i < model.getRowCount(); i++) {
			tongTien += (float) model.getValueAt(i, 5);
		}
		lblThanhTien.setText(tongTien + " VND");
	}

	// làm mới
	public void lamMoi() {
		DefaultTableModel model = (DefaultTableModel) tableChiTietHoaDon.getModel();

		model.setRowCount(0);
		capNhatThanhTien();
		txtMaNhanVien.setText(1 + "");

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		txtNgayLap.setText(dateFormat.format(new Date()));
	}
	
	// cập nhật mã nhân viên
	public void capNhatMaNhanVien() {
		txtMaNhanVien.setText(FormIndex.nhanVien.getIdNhanVien() + "");
		txtTenNhanVien.setText(FormIndex.nhanVien.getTenNhanVien());
	}
}
