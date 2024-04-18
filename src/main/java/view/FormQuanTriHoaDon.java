package view;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import controller.MouseControllerFormQuanTri;
import controller.MouseControllerFormQuanTriHoaDon;
import controller.MouseControllerFormTraCuuHoaDon;

public class FormQuanTriHoaDon  extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaHD;
	private JTextField txtTenNV;
	private JTextField txtTongTien;
	private JTable table;
	private JPopupMenu popupMenu;
	private MouseControllerFormQuanTriHoaDon controllerFormQuanTriHoaDon;
	private MouseControllerFormQuanTri mouseControllerFormQuanTri;
	public JButton btnTimKiem;

	/**
	 * Create the panel.
	 */
	public FormQuanTriHoaDon (MouseControllerFormQuanTri mouseControllerFormQuanTri) {
		controllerFormQuanTriHoaDon = new MouseControllerFormQuanTriHoaDon(this);
		mouseControllerFormQuanTri = mouseControllerFormQuanTri;
		setSize(1120, 680);
		setLayout(null);
		
		JLabel lblQLHD = new JLabel("QUẢN LÝ HÓA ĐƠN");
		lblQLHD.setFont(new Font("Segoe UI Black", Font.PLAIN, 28));
		lblQLHD.setBounds(431, 11, 313, 55);
		add(lblQLHD);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 63, 313, 606);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblMaHD = new JLabel("Mã hóa đơn");
		lblMaHD.setBounds(13, 105, 94, 29);
		panel.add(lblMaHD);
		lblMaHD.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		txtMaHD = new JTextField();
		txtMaHD.setEditable(false);
		txtMaHD.setBounds(117, 105, 186, 29);
		panel.add(txtMaHD);
		txtMaHD.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		txtMaHD.setColumns(10);
		
		JLabel lblTenNV = new JLabel("Mã nhân viên");
		lblTenNV.setBounds(13, 145, 94, 29);
		panel.add(lblTenNV);
		lblTenNV.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		txtTenNV = new JTextField();
		txtTenNV.setEditable(false);
		txtTenNV.setBounds(117, 145, 186, 29);
		panel.add(txtTenNV);
		txtTenNV.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		txtTenNV.setColumns(10);
		
		JLabel lblNgayLap = new JLabel("Ngày Lập");
		lblNgayLap.setBounds(13, 185, 94, 29);
		panel.add(lblNgayLap);
		lblNgayLap.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		txtTongTien = new JTextField();
		txtTongTien.setEditable(false);
		txtTongTien.setBounds(117, 225, 186, 29);
		panel.add(txtTongTien);
		txtTongTien.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		txtTongTien.setColumns(10);
		
		JLabel lblTongTien = new JLabel("Tổng Tiền");
		lblTongTien.setBounds(13, 225, 94, 29);
		panel.add(lblTongTien);
		lblTongTien.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		JLabel lblChcNng = new JLabel("Chức năng");
		lblChcNng.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblChcNng.setBounds(13, 497, 94, 29);
		panel.add(lblChcNng);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 537, 293, 39);
		panel.add(panel_3);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Cập nhật");
		panel_3.add(rdbtnNewRadioButton_1_1);
		rdbtnNewRadioButton_1_1.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		JRadioButton rdbtnNewRadioButton_1_1_1 = new JRadioButton("Xóa");
		panel_3.add(rdbtnNewRadioButton_1_1_1);
		rdbtnNewRadioButton_1_1_1.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(116, 185, 187, 29);
		panel.add(dateChooser);
		
		JLabel lblThngTinHoa = new JLabel("Thông Tin Hóa Đơn");
		lblThngTinHoa.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblThngTinHoa.setBounds(55, 40, 201, 30);
		panel.add(lblThngTinHoa);
		
		JButton btnXacNhn = new JButton("Xác nhận");
		btnXacNhn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnXacNhn.setBounds(117, 265, 100, 29);
		panel.add(btnXacNhn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(333, 63, 775, 606);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblDanhSachHD = new JLabel("Danh sách hóa đơn");
		lblDanhSachHD.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblDanhSachHD.setBounds(10, 0, 168, 30);
		panel_2.add(lblDanhSachHD);
		
		popupMenu = new JPopupMenu();
        JMenuItem menuItem1 = new JMenuItem("Chi Tiết Hóa Đơn");
        JMenuItem menuItem2 = new JMenuItem("In Hóa Đơn");
        popupMenu.add(menuItem1);
        popupMenu.add(menuItem2);
		
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
				"Mã hóa đơn", "Mã nhân viên", "Tổng tiền", "Ngày lập hóa đơn"
			}
		));
		table.addMouseListener(controllerFormQuanTriHoaDon);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 41, 755, 554);
		panel_2.add(scrollPane);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnTimKiem.setBounds(676, 6, 89, 23);
		btnTimKiem.addMouseListener(mouseControllerFormQuanTri);
		panel_2.add(btnTimKiem);
		
	}
	
	public void showPopupMenu(MouseEvent e) {
        int row = table.rowAtPoint(e.getPoint());
        if (row >= 0 && row < table.getRowCount()) {
            table.setRowSelectionInterval(row, row);
            popupMenu.show(e.getComponent(), e.getX(), e.getY());
        }
    }
}
