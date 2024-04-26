package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
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
import model.SanPham;

import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class FormThanhToan extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableChiTietHoaDon;
	public JLabel lblThanhTien;

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

		JLabel txtMaSP_1_1_2 = new JLabel("__________");
		txtMaSP_1_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtMaSP_1_1_2.setBounds(160, 55, 96, 26);
		panel_1.add(txtMaSP_1_1_2);

		JLabel txtMaSP_1_1_1 = new JLabel("__________");
		txtMaSP_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtMaSP_1_1_1.setBounds(160, 93, 96, 26);
		panel_1.add(txtMaSP_1_1_1);

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
}
