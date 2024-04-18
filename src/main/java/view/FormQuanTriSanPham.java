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

import javax.swing.ButtonGroup;
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
		lblMaSP.setBounds(13, 73, 94, 29);
		panel.add(lblMaSP);
		lblMaSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		txtMaSP = new JTextField();
		txtMaSP.setBounds(117, 73, 186, 29);
		panel.add(txtMaSP);
		txtMaSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		txtMaSP.setColumns(10);
		
		JLabel lblTenSP = new JLabel("Tên Sản Phẩm");
		lblTenSP.setBounds(13, 113, 94, 29);
		panel.add(lblTenSP);
		lblTenSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		txtTenSP = new JTextField();
		txtTenSP.setBounds(117, 113, 186, 29);
		panel.add(txtTenSP);
		txtTenSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		txtTenSP.setColumns(10);
		
		JLabel lblGiaSP = new JLabel("Giá Sản Phẩm");
		lblGiaSP.setBounds(13, 153, 94, 29);
		panel.add(lblGiaSP);
		lblGiaSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		txtGiaSP = new JTextField();
		txtGiaSP.setBounds(117, 153, 186, 29);
		panel.add(txtGiaSP);
		txtGiaSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		txtGiaSP.setColumns(10);
		
		txtLoaiSP = new JTextField();
		txtLoaiSP.setBounds(117, 193, 186, 29);
		panel.add(txtLoaiSP);
		txtLoaiSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		txtLoaiSP.setColumns(10);
		
		JLabel lblLoaiSP = new JLabel("Loại Sản Phẩm");
		lblLoaiSP.setBounds(13, 193, 94, 29);
		panel.add(lblLoaiSP);
		lblLoaiSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		JLabel lblChcNng = new JLabel("Chức năng");
		lblChcNng.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblChcNng.setBounds(10, 497, 94, 29);
		panel.add(lblChcNng);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 537, 293, 39);
		panel.add(panel_3);
		
		JRadioButton rdbtnThem = new JRadioButton("Thêm");
		panel_3.add(rdbtnThem);
		rdbtnThem.setBackground(new Color(255, 255, 255));
		rdbtnThem.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		JRadioButton rdbtnCapNhat = new JRadioButton("Cập nhật");
		panel_3.add(rdbtnCapNhat);
		rdbtnCapNhat.setBackground(new Color(255, 255, 255));
		rdbtnCapNhat.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		JRadioButton rdbtnXoa = new JRadioButton("Xóa");
		panel_3.add(rdbtnXoa);
		rdbtnXoa.setBackground(new Color(255, 255, 255));
		rdbtnXoa.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		ButtonGroup buttonGroupFunction = new ButtonGroup();
		buttonGroupFunction.add(rdbtnXoa);
		buttonGroupFunction.add(rdbtnCapNhat);
		buttonGroupFunction.add(rdbtnThem);
		
		JButton btnXacNhn = new JButton("Xác nhận");
		btnXacNhn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnXacNhn.setBounds(117, 233, 100, 29);
		panel.add(btnXacNhn);
		
		JLabel lblThngTinSn = new JLabel("Thông Tin Sản Phẩm");
		lblThngTinSn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblThngTinSn.setBounds(59, 25, 201, 30);
		panel.add(lblThngTinSn);
		
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
