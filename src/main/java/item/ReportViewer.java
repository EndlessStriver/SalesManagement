package item;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import model.ChiTietHoaDon;
import model.ChiTietHoaDonReport;
import model.HoaDon;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class ReportViewer {

	public static void showReport(HoaDon hoaDon) {
		try {
			// Compile the report
			JasperReport jasperReport = JasperCompileManager
					.compileReport(ReportViewer.class.getResourceAsStream("/report/hoadon.jrxml"));

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			// Parameters for report
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("maHoaDon", hoaDon.getMaHoaDon() + "");
			parameters.put("tenNhanVien", hoaDon.getNhanVien().getTenNhanVien());
			parameters.put("ngayLapHoaDon", sdf.format(hoaDon.getNgayLap()));
			parameters.put("tongTien", dinhDangTienTe(hoaDon.getTongTien()));
			
			Set<ChiTietHoaDon> dsChiTiet = hoaDon.getDanhSachChiTietHoaDon();
			List<ChiTietHoaDonReport> dsChiTietReport = chuyenChiTietHoaDonReport(dsChiTiet);

			// DataSource
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dsChiTietReport);

			// Fill the report
			JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

			// Create a JasperViewer and add the report to it
			JasperViewer viewer = new JasperViewer(print, false);
			viewer.setVisible(true);
			viewer.setTitle("Hóa đơn");
			viewer.setAlwaysOnTop(true);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	// Định dạng tiền tệ
	public static String dinhDangTienTe(float money) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		String strCurrencyVN = currencyVN.format(money);
		return strCurrencyVN;
	}
	
	// Chuyển danh sách chi tiết hóa đơn sang danh sách chi tiết hóa đơn report
	public static List<ChiTietHoaDonReport> chuyenChiTietHoaDonReport(Set<ChiTietHoaDon> dsChiTiet) {
		
		List<ChiTietHoaDonReport> dsChiTietReport = new ArrayList<ChiTietHoaDonReport>();
		
		for (ChiTietHoaDon ct : dsChiTiet) {
			
			ChiTietHoaDonReport ctReport = new ChiTietHoaDonReport();
			
			ctReport.setTenSanPham(ct.getSanPham().getTenSanPham());
			ctReport.setSoLuong(ct.getSoLuong());
			ctReport.setGiaSanPham(ct.getSanPham().getGiaSanPham());
			ctReport.setTongTien(dinhDangTienTe(ct.getTongTien()));
			
			dsChiTietReport.add(ctReport);
		}
		
		return dsChiTietReport;
	}
}
