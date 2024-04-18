package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.MouseControllerFormQuanTri;

import javax.swing.JButton;

public class FormQuanTriSanPham  extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField txtGiaSP;
	private JTextField txtLoaiSP;
	private JTable table;
	private MouseControllerFormQuanTri mouseControllerFormQuanTri;
	public JButton btnTimKiem;

	/**
	 * Create the panel.
	 */
	public FormQuanTriSanPham (MouseControllerFormQuanTri controllerFormQuanTri) {
		this.mouseControllerFormQuanTri = controllerFormQuanTri;
		setSize(1120, 680);
		setLayout(null);
		
		JLabel lblQuanLySP = new JLabel("QUẢN LÝ SẢN PHẨM");
		lblQuanLySP.setFont(new Font("Segoe UI Black", Font.PLAIN, 28));
		lblQuanLySP.setBounds(431, 11, 313, 55);
		add(lblQuanLySP);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 63, 313, 606);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblMaSP = new JLabel("Mã Sản Phẩm");
		lblMaSP.setBounds(10, 198, 94, 29);
		panel.add(lblMaSP);
		lblMaSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		txtMaSP = new JTextField();
		txtMaSP.setBounds(114, 198, 186, 29);
		panel.add(txtMaSP);
		txtMaSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		txtMaSP.setColumns(10);
		
		JLabel lblTenSP = new JLabel("Tên Sản Phẩm");
		lblTenSP.setBounds(10, 238, 94, 29);
		panel.add(lblTenSP);
		lblTenSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		txtTenSP = new JTextField();
		txtTenSP.setBounds(114, 238, 186, 29);
		panel.add(txtTenSP);
		txtTenSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		txtTenSP.setColumns(10);
		
		JLabel lblGiaSP = new JLabel("Giá Sản Phẩm");
		lblGiaSP.setBounds(10, 278, 94, 29);
		panel.add(lblGiaSP);
		lblGiaSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		txtGiaSP = new JTextField();
		txtGiaSP.setBounds(114, 278, 186, 29);
		panel.add(txtGiaSP);
		txtGiaSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		txtGiaSP.setColumns(10);
		
		txtLoaiSP = new JTextField();
		txtLoaiSP.setBounds(114, 318, 186, 29);
		panel.add(txtLoaiSP);
		txtLoaiSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		txtLoaiSP.setColumns(10);
		
		JLabel lblLoaiSP = new JLabel("Loại Sản Phẩm");
		lblLoaiSP.setBounds(10, 318, 94, 29);
		panel.add(lblLoaiSP);
		lblLoaiSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(114, 11, 186, 176);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 186, 176);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblAnhSP = new JLabel("Ảnh Sản Phẩm");
		lblAnhSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblAnhSP.setBounds(10, 158, 94, 29);
		panel.add(lblAnhSP);
		
		JLabel lblChcNng = new JLabel("Chức năng");
		lblChcNng.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblChcNng.setBounds(10, 497, 94, 29);
		panel.add(lblChcNng);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 537, 293, 39);
		panel.add(panel_3);
		
		JRadioButton rdbtnThm = new JRadioButton("Thêm");
		panel_3.add(rdbtnThm);
		rdbtnThm.setBackground(new Color(255, 255, 255));
		rdbtnThm.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Cập nhật");
		panel_3.add(rdbtnNewRadioButton_1_1);
		rdbtnNewRadioButton_1_1.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		JRadioButton rdbtnNewRadioButton_1_1_1 = new JRadioButton("Xóa");
		panel_3.add(rdbtnNewRadioButton_1_1_1);
		rdbtnNewRadioButton_1_1_1.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		JButton btnXacNhn = new JButton("Xác nhận");
		btnXacNhn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnXacNhn.setBounds(114, 358, 100, 29);
		panel.add(btnXacNhn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(333, 63, 775, 606);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblDanhSachSP = new JLabel("Danh sách sản phẩm");
		lblDanhSachSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblDanhSachSP.setBounds(10, 0, 168, 30);
		panel_2.add(lblDanhSachSP);
		
		table = new JTable();
		table.setRowHeight(25);
		table.getTableHeader().setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		table.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		table.setForeground(new Color(0, 0, 0));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Mã sản phẩm", "Tên sản phẩm", "Giá", "Loại","Ảnh sản phẩm"
			}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 41, 755, 554);
		panel_2.add(scrollPane);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnTimKiem.setBounds(676, 6, 89, 23);
		btnTimKiem.addMouseListener(controllerFormQuanTri);
		panel_2.add(btnTimKiem);
		
	}
}
