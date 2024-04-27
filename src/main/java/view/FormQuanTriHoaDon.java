package view;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import controller.MouseControllerFormQuanTri;
import controller.MouseControllerFormQuanTriHoaDon;
import controller.MouseControllerFormTraCuuHoaDon;
import model.HoaDon;
import util.ConnectServer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormQuanTriHoaDon extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaHoaDon;
	private JTextField txtTenNhanVien;
	private JTextField txtTongTien;
	private JTable tableHoaDon;
	private JPopupMenu popupMenu;
	private MouseControllerFormQuanTriHoaDon controllerFormQuanTriHoaDon;
	private MouseControllerFormQuanTri mouseControllerFormQuanTri;
	public JButton btnTimKiem;

	/**
	 * Create the panel.
	 * 
	 * @throws RemoteException
	 */
	public FormQuanTriHoaDon() throws RemoteException {
		controllerFormQuanTriHoaDon = new MouseControllerFormQuanTriHoaDon(this);
		mouseControllerFormQuanTri = new MouseControllerFormQuanTri(this);
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
		lblMaHD.setBounds(13, 82, 94, 29);
		panel.add(lblMaHD);
		lblMaHD.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setEditable(false);
		txtMaHoaDon.setBounds(117, 82, 186, 29);
		panel.add(txtMaHoaDon);
		txtMaHoaDon.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		txtMaHoaDon.setColumns(10);

		JLabel lblTenNV = new JLabel("Mã nhân viên");
		lblTenNV.setBounds(13, 122, 94, 29);
		panel.add(lblTenNV);
		lblTenNV.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setEditable(false);
		txtTenNhanVien.setBounds(117, 122, 186, 29);
		panel.add(txtTenNhanVien);
		txtTenNhanVien.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		txtTenNhanVien.setColumns(10);

		JLabel lblNgayLap = new JLabel("Ngày Lập");
		lblNgayLap.setBounds(13, 162, 94, 29);
		panel.add(lblNgayLap);
		lblNgayLap.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		txtTongTien = new JTextField();
		txtTongTien.setEditable(false);
		txtTongTien.setBounds(117, 202, 186, 29);
		panel.add(txtTongTien);
		txtTongTien.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		txtTongTien.setColumns(10);

		JLabel lblTongTien = new JLabel("Tổng Tiền");
		lblTongTien.setBounds(13, 202, 94, 29);
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

		JDateChooser dateChooserNgayLap = new JDateChooser();
		dateChooserNgayLap.setDateFormatString("dd/MM/yyyy");
		dateChooserNgayLap.setBounds(116, 162, 187, 29);
		panel.add(dateChooserNgayLap);

		JLabel lblThngTinHoa = new JLabel("Thông Tin Hóa Đơn");
		lblThngTinHoa.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblThngTinHoa.setBounds(57, 31, 201, 30);
		panel.add(lblThngTinHoa);

		JButton btnXacNhn = new JButton("Xác nhận");
		btnXacNhn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnXacNhn.setBounds(117, 242, 100, 29);
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

		tableHoaDon = new JTable();
		tableHoaDon.setRowHeight(25);
		tableHoaDon.setForeground(new Color(0, 0, 0));
		tableHoaDon.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã hóa đơn", "Mã nhân viên", "Ngày lập", "Tổng tiền" }));
		tableHoaDon.addMouseListener(controllerFormQuanTriHoaDon);

		ListSelectionModel selectionListener = tableHoaDon.getSelectionModel();
		selectionListener.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!selectionListener.isSelectionEmpty()) {

					int row = tableHoaDon.getSelectedRow();

					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

					try {
						txtMaHoaDon.setText(tableHoaDon.getValueAt(row, 0).toString());
						txtTenNhanVien.setText(tableHoaDon.getValueAt(row, 1).toString());
						dateChooserNgayLap.setDate(formatter.parse(tableHoaDon.getValueAt(row, 2).toString()));
						txtTongTien.setText(tableHoaDon.getValueAt(row, 3).toString());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}

				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(tableHoaDon);
		scrollPane.setBounds(10, 41, 755, 554);
		panel_2.add(scrollPane);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnTimKiem.setBounds(676, 6, 89, 23);
		btnTimKiem.addMouseListener(mouseControllerFormQuanTri);
		panel_2.add(btnTimKiem);

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

	// hien thi popup menu khi click chuot phai
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
