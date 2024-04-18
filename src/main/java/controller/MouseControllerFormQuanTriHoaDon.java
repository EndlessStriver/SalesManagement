package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import view.FormQuanTriHoaDon;
import view.FormTraCuuHoaDon;

public class MouseControllerFormQuanTriHoaDon implements MouseListener{
	
	private FormQuanTriHoaDon formQuanTriHoaDon;

	public MouseControllerFormQuanTriHoaDon(FormQuanTriHoaDon formQuanTriHoaDon) {
		this.formQuanTriHoaDon = formQuanTriHoaDon;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(SwingUtilities.isRightMouseButton(e)) {
			this.formQuanTriHoaDon.showPopupMenu(e);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
