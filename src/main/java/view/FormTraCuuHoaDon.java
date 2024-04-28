package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;

import com.toedter.calendar.JDateChooser;

import controller.MouseControllerFormIndex;
import controller.MouseControllerFormTraCuuHoaDon;
import controller.MouseControllerFormTraCuuThongTin;
import item.FormThongTinHoaDon;
import model.HoaDon;
import util.ConnectServer;

import javax.swing.JRadioButton;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormTraCuuHoaDon extends JPanel {

	private static final long serialVersionUID = 1L;
	private MouseControllerFormTraCuuThongTin controllerFormTraCuuThongTin;
	private JPopupMenu popupMenu;
	private JTextField textFieldMaHoaDon;
	private JTextField textFieldMaNhanVien;
	private JTextField textFieldTongTien;
	private JTable tableHoaDon;
	public JButton btnTimKiemHoaDon;

	/**
	 * Create the panel.
	 * 
	 * @throws RemoteException
	 */
	public FormTraCuuHoaDon() throws RemoteException {
		controllerFormTraCuuThongTin = new MouseControllerFormTraCuuThongTin(this);
		setSize(1120, 680);
		setLayout(null);

		JLabel lblTraCuSn = new JLabel("TRA CỨU HÓA ĐƠN");
		lblTraCuSn.setFont(new Font("Segoe UI Black", Font.PLAIN, 28));
		lblTraCuSn.setBounds(412, 11, 291, 55);
		add(lblTraCuSn);

		popupMenu = new JPopupMenu();
		JMenuItem menuItem = new JMenuItem("Chi Tiết Hóa Đơn");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = tableHoaDon.getSelectedRow();
				String maHoaDon = tableHoaDon.getValueAt(row, 0).toString();
				HoaDon hoaDon;
				
				try {
					hoaDon = ConnectServer.hoaDonInf.layHoaDonTheoMa(maHoaDon);
					FormThongTinHoaDon formThongTinHoaDon = new FormThongTinHoaDon(hoaDon);
					formThongTinHoaDon.setVisible(true);
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				
			}
		});
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

		textFieldMaHoaDon = new JTextField();
		textFieldMaHoaDon.setEditable(false);
		textFieldMaHoaDon.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		textFieldMaHoaDon.setColumns(10);
		textFieldMaHoaDon.setBounds(117, 82, 186, 29);
		panel.add(textFieldMaHoaDon);

		JLabel lblMaNhnVin = new JLabel("Mã nhân viên");
		lblMaNhnVin.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblMaNhnVin.setBounds(13, 122, 94, 29);
		panel.add(lblMaNhnVin);

		textFieldMaNhanVien = new JTextField();
		textFieldMaNhanVien.setEditable(false);
		textFieldMaNhanVien.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		textFieldMaNhanVien.setColumns(10);
		textFieldMaNhanVien.setBounds(117, 122, 186, 29);
		panel.add(textFieldMaNhanVien);

		JLabel lblNgayLp = new JLabel("Ngày lập");
		lblNgayLp.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNgayLp.setBounds(13, 162, 94, 29);
		panel.add(lblNgayLp);

		textFieldTongTien = new JTextField();
		textFieldTongTien.setEditable(false);
		textFieldTongTien.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		textFieldTongTien.setColumns(10);
		textFieldTongTien.setBounds(117, 202, 186, 29);
		panel.add(textFieldTongTien);

		JLabel lblTngTin = new JLabel("Tổng tiền");
		lblTngTin.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblTngTin.setBounds(13, 202, 94, 29);
		panel.add(lblTngTin);

		JLabel lblThngTinHoa = new JLabel("Thông Tin Hóa Đơn");
		lblThngTinHoa.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblThngTinHoa.setBounds(62, 41, 201, 30);
		panel.add(lblThngTinHoa);

		JDateChooser dateChooserNgayLap = new JDateChooser();
		dateChooserNgayLap.setDateFormatString("dd/MM/yyyy");
		dateChooserNgayLap.setBounds(117, 162, 186, 29);
		panel.add(dateChooserNgayLap);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(335, 66, 775, 606);
		add(panel_2);

		JLabel lblDanhSachHoa = new JLabel("Danh sách hóa đơn");
		lblDanhSachHoa.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblDanhSachHoa.setBounds(10, 0, 168, 30);
		panel_2.add(lblDanhSachHoa);

		tableHoaDon = new JTable();
		tableHoaDon.setRowHeight(25);
		tableHoaDon.setForeground(new Color(0, 0, 0));
		tableHoaDon.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã hóa đơn", "Mã nhân viên", "Ngày lập", "Tổng tiền" }));
		tableHoaDon.addMouseListener(controllerFormTraCuuThongTin);

		ListSelectionModel selectionListener = tableHoaDon.getSelectionModel();
		selectionListener.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!selectionListener.isSelectionEmpty()) {

					int row = tableHoaDon.getSelectedRow();

					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

					try {
						textFieldMaHoaDon.setText(tableHoaDon.getValueAt(row, 0).toString());
						textFieldMaNhanVien.setText(tableHoaDon.getValueAt(row, 1).toString());
						dateChooserNgayLap.setDate(formatter.parse(tableHoaDon.getValueAt(row, 2).toString()));
						textFieldTongTien.setText(tableHoaDon.getValueAt(row, 3).toString());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}

				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(tableHoaDon);
		scrollPane.setBounds(10, 41, 755, 554);
		panel_2.add(scrollPane);

		btnTimKiemHoaDon = new JButton("Tìm kiếm");
		btnTimKiemHoaDon.addMouseListener(controllerFormTraCuuThongTin);
		btnTimKiemHoaDon.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnTimKiemHoaDon.setBounds(676, 6, 89, 23);
		panel_2.add(btnTimKiemHoaDon);

		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					layDanhSachHoaDon();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLamMoi.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnLamMoi.setBounds(577, 6, 89, 23);
		panel_2.add(btnLamMoi);

		layDanhSachHoaDon();
	}

	// Hiển thị menu khi click chuột phải vào table
	public void showPopupMenu(MouseEvent e) {
		int row = tableHoaDon.rowAtPoint(e.getPoint());
		if (row >= 0 && row < tableHoaDon.getRowCount()) {
			tableHoaDon.setRowSelectionInterval(row, row);
			popupMenu.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	// Lấy danh sách hóa đơn từ server
	public void layDanhSachHoaDon() throws RemoteException {
		List<HoaDon> dsHoaDon = ConnectServer.hoaDonInf.layDanhSachHoaDon();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();
		model.setRowCount(0);
		for (HoaDon hoaDon : dsHoaDon) {
			model.addRow(new Object[] { hoaDon.getMaHoaDon(), hoaDon.getNhanVien(),
					formatter.format(hoaDon.getNgayLap()), dinhDangTienTe(hoaDon.getTongTien()) });
		}
	}

	// Định dạng tiền tệ
	public String dinhDangTienTe(float money) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		String strCurrencyVN = currencyVN.format(money);
		return strCurrencyVN;
	}
	
	// Hiển thị danh sách hóa đơn tìm kiếm
	public void hienThiDanhSachTimKiemHoaDon(List<HoaDon> dsHoaDon) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();
		model.setRowCount(0);
		for (HoaDon hoaDon : dsHoaDon) {
			model.addRow(new Object[] { hoaDon.getMaHoaDon(), hoaDon.getNhanVien(),
					formatter.format(hoaDon.getNgayLap()), dinhDangTienTe(hoaDon.getTongTien()) });
		}
	}
}
