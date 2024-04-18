package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import controller.MouseControllerFormIndex;
import controller.MouseControllerFormTraCuuHoaDon;
import controller.MouseControllerFormTraCuuThongTin;

import javax.swing.JRadioButton;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormTraCuuHoaDon extends JPanel {

	private static final long serialVersionUID = 1L;
	private MouseControllerFormTraCuuHoaDon mouseControllerFormTraCuuHoaDon;
	private MouseControllerFormTraCuuThongTin controllerFormTraCuuThongTin;
	private JPopupMenu popupMenu;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTable table;
	public JButton btnTimKiemHoaDon;

	/**
	 * Create the panel.
	 */
	public FormTraCuuHoaDon(MouseControllerFormTraCuuThongTin controllerFormTraCuuThongTin) {
		this.controllerFormTraCuuThongTin = controllerFormTraCuuThongTin;
		mouseControllerFormTraCuuHoaDon = new MouseControllerFormTraCuuHoaDon(this);
		setSize(1120, 680);
		setLayout(null);

		JLabel lblTraCuSn = new JLabel("TRA CỨU HÓA ĐƠN");
		lblTraCuSn.setFont(new Font("Segoe UI Black", Font.PLAIN, 28));
		lblTraCuSn.setBounds(412, 11, 291, 55);
		add(lblTraCuSn);
		
		popupMenu = new JPopupMenu();
        JMenuItem menuItem = new JMenuItem("Chi Tiết Hóa Đơn");
        popupMenu.add(menuItem);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 66, 313, 606);
		add(panel);
		
		JLabel lblMaHoan = new JLabel("Mã hóa đơn");
		lblMaHoan.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblMaHoan.setBounds(13, 82, 94, 29);
		panel.add(lblMaHoan);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(117, 82, 186, 29);
		panel.add(textField);
		
		JLabel lblMaNhnVin = new JLabel("Mã nhân viên");
		lblMaNhnVin.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblMaNhnVin.setBounds(13, 122, 94, 29);
		panel.add(lblMaNhnVin);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(117, 122, 186, 29);
		panel.add(textField_1);
		
		JLabel lblNgayLp = new JLabel("Ngày lập");
		lblNgayLp.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNgayLp.setBounds(13, 162, 94, 29);
		panel.add(lblNgayLp);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(117, 202, 186, 29);
		panel.add(textField_3);
		
		JLabel lblTngTin = new JLabel("Tổng tiền");
		lblTngTin.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblTngTin.setBounds(13, 202, 94, 29);
		panel.add(lblTngTin);
		
		JLabel lblThngTinHoa = new JLabel("Thông Tin Hóa Đơn");
		lblThngTinHoa.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblThngTinHoa.setBounds(62, 41, 201, 30);
		panel.add(lblThngTinHoa);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(117, 162, 186, 29);
		panel.add(dateChooser);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(335, 66, 775, 606);
		add(panel_2);
		
		JLabel lblDanhSachHoa = new JLabel("Danh sách hóa đơn");
		lblDanhSachHoa.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblDanhSachHoa.setBounds(10, 0, 168, 30);
		panel_2.add(lblDanhSachHoa);
		
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
				"Mã hóa đơn", "Mã nhân viên", "Ngày lập", "Tổng tiền"
			}
		));
		table.addMouseListener(mouseControllerFormTraCuuHoaDon);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 41, 755, 554);
		panel_2.add(scrollPane);
		
		btnTimKiemHoaDon = new JButton("Tìm kiếm");
		btnTimKiemHoaDon.addMouseListener(controllerFormTraCuuThongTin);
		btnTimKiemHoaDon.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnTimKiemHoaDon.setBounds(676, 6, 89, 23);
		panel_2.add(btnTimKiemHoaDon);
	}
	
	public void showPopupMenu(MouseEvent e) {
        int row = table.rowAtPoint(e.getPoint());
        if (row >= 0 && row < table.getRowCount()) {
            table.setRowSelectionInterval(row, row);
            popupMenu.show(e.getComponent(), e.getX(), e.getY());
        }
    }
}
