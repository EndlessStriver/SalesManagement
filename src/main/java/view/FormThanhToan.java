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

		tableChiTietHoaDon = new JTable();
		tableChiTietHoaDon.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Số lượng", "Đơn giá", "Tổng tiền" }));

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
		txtNgayLap.setBounds(160, 93, 96, 26);
		panel_1.add(txtNgayLap);

		JLabel lblTnSanPhm = new JLabel("Ngày lập");
		lblTnSanPhm.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblTnSanPhm.setBounds(10, 93, 108, 27);
		panel_1.add(lblTnSanPhm);

		JLabel lblThnhTin = new JLabel("THÀNH TIỀN:");
		lblThnhTin.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
		lblThnhTin.setBounds(10, 526, 251, 33);
		panel_1.add(lblThnhTin);

		lblThanhTien = new JLabel("______________________VND");
		lblThanhTien.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
		lblThanhTien.setBounds(10, 570, 290, 33);
		panel_1.add(lblThanhTien);

		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tableChiTietHoaDon.getModel();
				model.setRowCount(0);
				capNhatThanhTien();
			}
		});
		btnLamMoi.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnLamMoi.setBounds(485, 27, 83, 26);
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
		btnThemSanPham.setBounds(578, 27, 119, 26);
		add(btnThemSanPham);

		JButton btnThanhToan_1 = new JButton("THANH TOÁN");
		btnThanhToan_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<ChiTietHoaDon> dsChiTietHoaDon = new ArrayList<ChiTietHoaDon>();
				
				DefaultTableModel model = (DefaultTableModel) tableChiTietHoaDon.getModel();
				
				for (int i = 0; i < model.getRowCount(); i++) {
					SanPham sanPham = (SanPham) model.getValueAt(i, 0);
					int soLuong = (int) model.getValueAt(i, 3);
					float tongTien = (float) model.getValueAt(i, 5);
					
					ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(soLuong, sanPham);
					dsChiTietHoaDon.add(chiTietHoaDon);
				}
				
				try {
					
					ConnectServer.hoaDonInf.taoHoaDon(dsChiTietHoaDon, Long.parseLong(txtMaNhanVien.getText()));
					DefaultTableModel model1 = (DefaultTableModel) tableChiTietHoaDon.getModel();
					lamMoi();
					
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnThanhToan_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnThanhToan_1.setBounds(800, 635, 310, 53);
		add(btnThanhToan_1);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tableChiTietHoaDon.getModel();
				int selectedRow = tableChiTietHoaDon.getSelectedRow();
				if (selectedRow != -1) {
					model.removeRow(selectedRow);
					capNhatThanhTien();
				}
			}
		});
		btnXoa.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnXoa.setBounds(707, 26, 83, 26);
		add(btnXoa);
		
		lamMoi();
	}

	public void themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		DefaultTableModel model = (DefaultTableModel) tableChiTietHoaDon.getModel();

		model.addRow(new Object[] { chiTietHoaDon.getSanPham(),
				chiTietHoaDon.getSanPham().getTenSanPham(), chiTietHoaDon.getSanPham().getLoaiSanPham(),
				chiTietHoaDon.getSoLuong(), chiTietHoaDon.getSanPham().getGiaSanPham(), chiTietHoaDon.getTongTien() });
	}
	
	public void capNhatThanhTien() {
		DefaultTableModel model = (DefaultTableModel) tableChiTietHoaDon.getModel();
		float tongTien = 0;
		for (int i = 0; i < model.getRowCount(); i++) {
			tongTien += (float) model.getValueAt(i, 5);
		}
		lblThanhTien.setText(tongTien + " VND");
	}
	
	public void lamMoi() {
		DefaultTableModel model = (DefaultTableModel) tableChiTietHoaDon.getModel();
		
		model.setRowCount(0);
		capNhatThanhTien();
		txtMaNhanVien.setText(1+"");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		txtNgayLap.setText(dateFormat.format(new Date()));
	}
}
